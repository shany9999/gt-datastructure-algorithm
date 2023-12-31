package I;

import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null){throw new IllegalArgumentException("Error"); }

        if (size == 0){
            head = new SinglyLinkedListNode(data);
            tail = head;
        }else{
            SinglyLinkedListNode cur = new SinglyLinkedListNode(data);
            cur.setNext(head);
            head = cur;
        }
        size += 1;

    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null){throw new IllegalArgumentException("Error");}

        if (size == 0){
            head = new SinglyLinkedListNode(data);
            tail = head;
        }else{
            SinglyLinkedListNode cur = new SinglyLinkedListNode(data);
            tail.setNext(cur);
            tail = cur;
        }
        size += 1;

    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0){
            throw new NoSuchElementException("Error");
        }else if (size == 1){
            T node = head.getData();
            head = null;
            tail = null;
            size -= 1;
            return node;
        }

        T node = head.getData();
        head = head.getNext();

        size -= 1;
        return node;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0){
            throw new NoSuchElementException("Error");
        }else if (size == 1){
            T node = head.getData();
            head = null;
            tail = null;
            size -= 1;
            return node;
        }


        SinglyLinkedListNode cur = head;
        T node = tail.getData();


        for (int i=0; i<size-1; i++ ){
            if (i == size-2){
                cur.setNext(null);
                tail = cur;

            }else{
                cur = cur.getNext();
            }

        }


        size -= 1;
        return node;
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
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