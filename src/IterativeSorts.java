import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class IterativeSorts {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int stopIdx = arr.length-1;
        while (stopIdx != 0){
            int idx = 0;
            int lastSwapped = 0;
            while (idx < stopIdx){
                if (comparator.compare(arr[idx], arr[idx+1]) >0 ){
                    T temp = arr[idx];
                    arr[idx] = arr[idx+1];
                    arr[idx+1] = temp;
                    lastSwapped = idx;
                }
                idx += 1;
            }
            stopIdx = lastSwapped;
        }

    }

    /**
     * Implement selection sort.
     *
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        for (int i=arr.length-1; i>=1; i--){
            int maxIdx = 0;
            for (int j=1; j<=i; j++){
                if (comparator.compare(arr[j], arr[maxIdx]) > 0){
                    maxIdx = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }


    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
//        for (int i=1; i< arr.length; i++){
//            int idx = i;
//            while (idx-1>=0){
//                if (comparator.compare(arr[idx], arr[idx-1])<0) {
//                    T temp = arr[idx];
//                    arr[idx] = arr[idx - 1];
//                    arr[idx - 1] = temp;
//                    idx -= 1;
//                }else{
//                    break;
//                }
//            }
//        }

        for (int i=1; i< arr.length; i++){
            int idx = i;
            while ((idx-1>=0) && (comparator.compare(arr[idx], arr[idx-1])<0)){
                T temp = arr[idx];
                arr[idx] = arr[idx-1];
                arr[idx-1] = temp;
                idx -= 1;
            }
        }


    }
}