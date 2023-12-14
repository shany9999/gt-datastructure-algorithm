package I;

import java.util.NoSuchElementException;

/**
 * Your implementation of an I.ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the I.ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new I.ArrayList.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        // check if the data is null, exception
        if (data == null){
            throw new IllegalArgumentException("Error");
        }


        // check the size, if size not enough, make it twice
        if (size == backingArray.length) {
            int capacity = 2*backingArray.length;
            T[] backingArray1 = (T[]) new Object[capacity];
            for (int i=1; i <= size; i++){
                backingArray1[i] = backingArray[i-1];
            }
            backingArray1[0] = data;
            backingArray = backingArray1;
        } else {

            for (int i=size; i >= 1; i--){
                backingArray[i] = backingArray[i-1];
            }
            backingArray[0] = data;
        }

        size = size+1;

    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        // check if the data is null, exception
        if (data == null){
            throw new IllegalArgumentException("Error");
        }


        // check the size
        if (size == backingArray.length) {
            int capacity= 2*size;
            T[] backingArray2 = (T[]) new Object[capacity];
            for (int i=0; i < size; i++){
                backingArray2[i] = backingArray[i];
            }
            backingArray2[size] = data;
            backingArray = backingArray2;
        } else {
            backingArray[size] = data;

        }


        size = size+1;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        // if the list is empty
        if (size == 0 || backingArray == null){
            throw new NoSuchElementException("Error");
        }


        T[] backingArray3 = (T[]) new Object[backingArray.length];
        T rdata1 = backingArray[0];
        for (int i=0; i<size-1; i++){
            backingArray3[i] = backingArray[i+1];
        }
        backingArray = backingArray3;

        size = size-1;
        return rdata1;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        // if the list is empty
        if (size == 0 || backingArray == null){
            throw new NoSuchElementException("Error");
        }

        T[] backingArray4 = (T[]) new Object[backingArray.length];
        T rdata2 = backingArray[size-1];
        for (int i=0; i<size-1; i++){
            backingArray4[i] = backingArray[i];
        }
        backingArray = backingArray4;

        size = size-1;
        return rdata2;
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}