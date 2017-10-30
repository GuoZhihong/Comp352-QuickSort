import java.util.ArrayList;
import java.util.Random;

/**
 * Worst case of the trivial Quicksort
 */
public class FixedGen implements Gen {
    public  int[] gen( int n,long m){//although the seed m is passed in ,but it will be always ignored
        int [] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        return ints;
    }
}
