/**
 * This GuitarSimulator object . . .
 * 
 * @author  
 * @version 
 */
public class GuitarSimulator
{
    public static void main(String[] args) throws ExceptionOverflow, UnderflowException
    {
        GuitarString[] strings = new GuitarString[37];
        for(int i = 0; i < 37; i++) {
            strings[i] = new GuitarString(440 * Math.pow(1.05956, i-24));
        }
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; 

        while (true) 
        {
            if (StdDraw.hasNextKeyTyped()) 
            {
                char key = StdDraw.nextKeyTyped();

                if(keyboard.indexOf(key) != -1) {
                    int index = keyboard.indexOf(key);
                    strings[index].pluck();
                }
            }

            double sample = 0;
            for(GuitarString g : strings) {
                sample += g.sample();
            }

            StdAudio.play(sample);

            for(GuitarString meow : strings) {
                meow.tic();
            }
        }
    }
}
