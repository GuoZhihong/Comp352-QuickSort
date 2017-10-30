import java.util.Random;
/*
     Part2:
     From the test results, we can see with small amount of integers(10 to 10000),
     two selections will not make any differences.But when the amount of integers grows to a big number,
     the Median of Three pivot selection will be more efficient.
     This is due to trivial Quicksort has a worst case of O(n^2),and has a good chance to pick a bad pivot(not evenly divided to two).
     The Median of Three pivot selection has a better chance to have a good pivot in the array,
     because it was pre-selected to find the median of three point(first,middle and last point),
     then do the partition,so it has a good chance to divide the array evenly.
*/

/*
    Part3:
    Already sorted arrays as input will cause a stack overflow,
    when I was inputting a 1000000 size array.
    10,100 and 10000 are alright with my computer,but comparing to the median of three pivot selection,
    the run time difference is quite larger.
    Because in the sorted array,first point will be either the smallest or largest in the array,
    which is a bad pivot(not evenly do the partition) to cause the worst case O(n^2).
*/

/*
    Part4:
    Median of Three Quicksort will always get to the best case O(nlogn),when the array is sorted,whether
    it is ascending or descending.This is due to median of three quicksort always finds the median of the array.
    The median of a sorted array will always be the best pivot comparing its left side or right side.
    Then do the partition and find the median again and again,which will also be the best pivots.
    My data :
    Median of Three Quicksort:The length of is 10000 and seed is 1000000 and Run-time is 23000 μs
    Trivial Quicksort:The length of is 10000 and seed is 1000000 and Run-time is 31000 μs
    From this result we can observe Median of Three Quicksort is faster for sorted array.
    For input of 1000000,both selections were failed due to stack over flow.
    The reason of this maybe due to other parts(not relevant to the sorting) like generating the array.etc.
 */

public class QSDriver {
    public static void main(String[] args) {

        /*
        menu for the different sorting method
         */
        QSSort qsSort = null;
        if (args[0].equals("QSNormal")) {
            System.out.println("Do the Quicksort by a trivial pivot selection.");
            qsSort = new QSNormal();
        } else if (args[0].equals("QSMedian")) {
            System.out.println("Do the Quicksort by a Median of Three pivot selection.");
            qsSort = new QSMedian();
        } else {
            System.out.println("Error input of <quickSort>");
            System.exit(0);
        }

        /*
        menu for the different sequences of array
         */
        Gen gen = null;
        if (args[1].equals("RandomGen")) {
            System.out.println("Used RandomGen");
            gen = new RandomGen();

        } else if (args[1].equals("FixedGen")) {
            System.out.println("Used FixedGen");
            gen = new FixedGen();
        } else {
            System.out.println("Error input of <gen>");
            System.exit(0);
        }

        /*
        menu for the length of passing array and the number of seeds
         */
        int n = Integer.parseInt(args[2]);
        long m = 0;
        if(args.length == 4){
            m = Long.parseLong(args[3]);
        }
        if (n == 10 || n == 100 || n == 10000|| n == 1000000) {
            System.out.println("The length of is "+ n +" and seed is "+ m);
            qsSort.sort(gen.gen(n,m));
        } else{
            System.out.println("Error input of <length>");
            System.exit(0);
        }
    }
}
