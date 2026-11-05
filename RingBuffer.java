
public class RingBuffer 
{
    double[] values;
    int head;
    int tail;
    int size;

    public RingBuffer(int capacity)
    {
        head = 0;
        tail = 0;
        size = 0;
        values = new double[capacity];
    }

    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public boolean isFull()
    {
        return size == values.length;
    }
    
    public void add(double value) throws ExceptionOverflow
    {
        if (isFull())
        {
            throw new ExceptionOverflow("You are over the capacity");
        }

        values[tail] = value;
        tail = (tail + 1) % values.length;
        size++;
    }
    
    public double peek() throws UnderflowException
    {
        if (isEmpty())
        {
            throw new UnderflowException("Empty buffer");
        }

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
        size--;

        return val;
    }

    public int getCapacity()
    {
        return values.length;
    }
}
