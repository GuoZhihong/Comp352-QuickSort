import java.util.Random;

/**
 * This class will allow user to pass a seed (long type) to generate an array of uniformly random integers
 */
public class RandomGen implements Gen {
    public  int[] gen( int n,long l){
        int [] ints = new int[n];
        int m;
        Random random = new Random(l);
        for (int i = 0; i < n; i++) {
            /*
            if this Random in the loop is activated,and above duplicate one gets removed,
            then this class will produce an array with a same number.Ex:{0,0,0,0,0...}
             */
//            Random random = new Random(l);
            m = random.nextInt();//consider from -2^32 to 2^32-1
            ints[i] = m;
        }
        return ints;
    }
}
