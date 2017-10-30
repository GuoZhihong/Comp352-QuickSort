public class QSMedian implements QSSort{

    public  void sort(int[] input){
        int firstPoint,lastPoint;
        firstPoint = 0;
        lastPoint = input.length - 1;

        System.out.println("This is unsorted array :");
        for (int ints:input) {
            System.out.print(" "+ints+" ");
        }
        System.out.println();

        long l1 = System.currentTimeMillis();//start sorting
        partition(input,firstPoint,lastPoint);
        long l2 = System.currentTimeMillis();//end sorting

        System.out.println("This is sorted array :");
        for (int ints:input) {
            System.out.print(" "+ints+" ");
        }
        System.out.println();

        System.out.println("Run-time is "+(l2-l1)*1000 +" μs");//output the run-time
    }

    private void partition(int[] input, int startIndex, int endIndex){
        if(endIndex > startIndex) {// case for finding the median of three point
            findMedianPoint(input, startIndex, endIndex);//find the median of three points then move median point to starting point
        }
        int leftIndex = startIndex;//left pointer
        int rightIndex = endIndex;//right pointer
        int pivot = input[startIndex];//sorting from the left
        while (rightIndex > leftIndex) {//make sure two pointers wont overlap
            while (rightIndex > leftIndex && input[rightIndex] >= pivot)
                rightIndex--;
            if (input[rightIndex] <= pivot) {
                swap(input, leftIndex, rightIndex);
            }
            while (rightIndex > leftIndex && input[leftIndex] <= pivot)
                leftIndex++;
            if (input[leftIndex] >= pivot) {
                swap(input, leftIndex, rightIndex);
            }
        }

        if (leftIndex > startIndex) {// prevent Index out of bounds situation
            partition(input, startIndex, leftIndex - 1);//do the left of pivot
        }
        if (rightIndex < endIndex) {// prevent Index out of bounds situation
            partition(input, rightIndex + 1, endIndex);//do the right of pivot
        }
    }


    private void findMedianPoint(int[] input,int startIndex,int endIndex){
        int middlePointIndex = (endIndex - startIndex) / 2 + 1;//middle point in the array
        /*
        find the median from first,last and middle points
         */
        if (input[middlePointIndex] > input[endIndex]) {
            swap(input, middlePointIndex, endIndex);
        }
        if (input[startIndex] > input[endIndex]) {
            swap(input, startIndex, endIndex);
        }
        if (input[middlePointIndex] > input[startIndex]) {//swap first point with middle point
            swap(input, middlePointIndex, startIndex);
        }
    }

    /*
    private method to swap two elements
     */
    private void swap(int[] input,int a ,int b){
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}