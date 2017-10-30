import java.util.Random;

public class QSNormal implements QSSort {

    /*
    main method do the sorting
     */
    public  void sort(int[] input){
        System.out.println("This is unsorted array :");
        for (int ints:input) {
            System.out.print(" "+ints+" ");
        }
        System.out.println();

        long l1 = System.currentTimeMillis();//start sorting
        quickSort(input,0,(input.length - 1));
        long l2 = System.currentTimeMillis();//end sorting

        System.out.println("This is sorted array :");
        for (int ints:input) {
            System.out.print(" "+ints+" ");
        }
        System.out.println();
        System.out.println("Run-time is "+(l2-l1)*1000 +" μs");//output the run-time
    }

    public void quickSort(int[] input, int startIndex, int endIndex){

        int leftIndex = startIndex;//left pointer
        int rightIndex = endIndex;//right pointer
        int pivot = input[startIndex];//sorting from the left

        while (rightIndex > leftIndex) {
            while (rightIndex > leftIndex && input[rightIndex] >= pivot)//case that moves right pointer
                rightIndex--;
            if (input[rightIndex] <= pivot) {
                swap(input,leftIndex ,rightIndex);
            }
            while (rightIndex > leftIndex && input[leftIndex] <= pivot)//case that moves left pointer
                leftIndex++;
            if (input[leftIndex] >= pivot) {
                swap(input,leftIndex ,rightIndex);
            }
        }

        if(leftIndex > startIndex) {// prevent Index out of bounds situation
            quickSort(input, startIndex, leftIndex - 1);//do the left of pivot
        }
        if(rightIndex < endIndex) {// prevent Index out of bounds situation
            quickSort(input, rightIndex + 1, endIndex);//do the right of pivot
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
