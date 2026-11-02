public class RingBuffer 
{
    double[] values;
    int head;
    int tail;
    public RingBuffer(int capacity)
    {
        head = -1;
        tail = 0;
        values = new double[(capacity)];
    }

    public int size()
    {
        if (head == -1)
            return 0;

        if (tail > head)
            return tail - head;

        return values.length - head + tail;
    }
    
    public boolean isEmpty()
    {
        return head == tail -1;
    }
    
    public boolean isFull()
    {
        return (tail + 1) % values.length == head;
    }
    
    public void add(double value) throws ExceptionOverflow
    {
        if (isFull())
        {
            throw new ExceptionOverflow("You are over the capacity");
        }

    if (isEmpty())
    {
        head = tail;
    }
        values[tail] = value;
        tail = (tail + 1) % values.length;
    }
    
    public double peek()
    {
        return values[head];
    }
    
    public double remove() throws UnderflowException
    {
        if (isEmpty())
        {
            throw new UnderflowException("Empty buffer");
        }

    double val = values[head];
    head = (head + 1) % values.length;

        if (head == tail)
        {
            head = -1;
        }

        return val;
    }
    public int getCapacity()
    {
        return values.length;
    }
    
    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) throws ExceptionOverflow, UnderflowException
    {
        int capacity = 100;
        RingBuffer buffer = new RingBuffer(capacity);  
        for (int i = 1; i <= capacity; i++) 
        {
            buffer.add(i);
        }
      
        double t = buffer.remove();
        buffer.add(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) 
        {
            double x = buffer.remove();
            double y = buffer.remove();
            buffer.add(x + y);
        }
        System.out.println(buffer.peek());
    }

}
