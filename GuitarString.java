/*
    * To change this license header, choose License Headers in Project Properties.
 */
public class GuitarString 
{
    RingBuffer buffer;
    int SampleRate;
    int count = 0;
    public GuitarString(double frequency) 
    {
        SampleRate = (int)(44100/frequency);
        buffer = new RingBuffer(SampleRate);
        try
        {
            for(int i = 0; i < buffer.getCapacity(); i++)
            {
                buffer.add(0.0);
            }
        }
        catch(ExceptionOverflow e)
        {
            System.out.println("Overflow Exception");
        }
        // create a guitar string of the given frequency
    }

    public GuitarString(double[] array) 
    {
        SampleRate = array.length;
        buffer = new RingBuffer(SampleRate);
        try
        {
            for(int i = 0; i < array.length; i++)
            {
                buffer.add(array[i]);
            }
        }
        catch(ExceptionOverflow e)
        {
            System.out.println("Overflow Exception");
        }
        // create a guitar string whose size and initial values are given by the array
    }

    public void pluck() throws ExceptionOverflow, UnderflowException
    {
        for(int i = 0; i < buffer.getCapacity(); i++)
        {
        buffer.remove();
        double addition = Math.random() - 0.5;
        buffer.add(addition);
        }
    }

    // advance the simulation one time step
    public void tic() throws UnderflowException, ExceptionOverflow
    {
        double ticval = buffer.remove() + buffer.peek();
        ticval = ticval*0.5;
        ticval = ticval * 0.994;
        buffer.add(ticval);
        count++;
    }

    // return the current sample
    public double sample() throws UnderflowException
    {
        return buffer.peek();
    }

    // return number of times tic was called
    public int time() 
    {
        return count;
    }

    public static void main(String[] args) throws UnderflowException, ExceptionOverflow
    {
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < 25; i++) 
        {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }
}
