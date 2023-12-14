import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (arr.length <= 1){
            return ;
        }
        int l = arr.length;
        int midIndex = l /2;
        T[] left = (T[]) new Object[midIndex];
        T[] right = (T[]) new Object[l-midIndex];
        for (int n=0; n<=midIndex-1; n++){
            left[n] = arr[n];
        }
        for (int m=0; m<l-midIndex; m++){
            right[m] = arr[midIndex+m];
        }

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        int i = 0;
        int j = 0;
        while ((i < left.length) && (j < right.length)){
            if (comparator.compare(left[i], right[j])<=0){
                arr[i+j] = left[i];
                i++;
            }else{
                arr[i+j] = right[j];
                j++;
            }
        }
        while (i < left.length){
            arr[i+j] = left[i];
            i++;
        }
        while (j < right.length){
            arr[i+j] = right[j];
            j++;
        }

    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        LinkedList<Integer>[] buckets = (LinkedList<Integer>[]) new LinkedList[19];

        for (int n=0; n<buckets.length; n++){
            buckets[n] = new LinkedList<Integer>();
        }

        int base = 10;
        int divisor = 1;
        int ct = 0;
        for (int t=0; t<arr.length; t++){
            int cur = Math.abs(arr[t]);
            int tmp = String.valueOf(cur).length();

            if (tmp > ct){
                ct = tmp;
            }
        }

        for (int i=0; i<=ct; i++){
            for (int j=0; j<arr.length; j++){
                int digit = (arr[j]/divisor) % base;
                buckets[digit+9].add(arr[j]);
            }

            for (int i1 = 0; i1 < buckets.length; i1++) {
                System.out.println(buckets[i1]);
            }
            System.out.println("=============");

            int idx = 0 ;
            for (int k=0; k<buckets.length; k++){
                while (buckets[k].size() >0){
                    arr[idx] = buckets[k].remove();
                    idx++;
                }
            }
            System.out.println(buckets);

            divisor *= base;

        }

    }
}