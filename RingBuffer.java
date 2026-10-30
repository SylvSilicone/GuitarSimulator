import java.util.Queue;
public class RingBuffer 
{
    double[] values;
    int head;
    int tail;
    public RingBuffer(int capacity)
    {
        values = new double[(capacity)];
    }

    public int size()
    {
        return values.length;
    }
    
    public boolean isEmpty()
    {
        return head == tail;
    }
    
    public boolean isFull()
    {
        return false;
    }
    
    public void add(double value)
    {

    }
    
    public double peek()
    {
        return 0.0;
    }
    
    public double remove()
    {
        return 0.0;
    }
    
    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) 
    {
        int capacity = 100;
        RingBuffer buffer = new RingBuffer(capacity);  
        for (int i = 1; i <= capacity; i++) 
            buffer.add(i);
      
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
