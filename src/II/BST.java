package II;

import java.util.NoSuchElementException;

/**
 * Your implementation of a II.BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null){
            throw new IllegalArgumentException("Error");
        }

        root = helper(data, root);

    }

    private BSTNode<T> helper(T data, BSTNode<T> root){
        if (root == null){
            size ++;
            return new BSTNode<T>(data);
        }


        if (data.compareTo(root.getData()) < 0){
            root.setLeft(helper(data, root.getLeft()));
        }else if (data.compareTo(root.getData()) > 0){
            root.setRight(helper(data, root.getRight()));
        }
        return root;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null){
            throw new IllegalArgumentException("Error");
        }
        BSTNode<T> dummy = new BSTNode<>(null);
        root = recur(data, root, dummy);
        return dummy.getData();
    }

    private BSTNode<T> recur(T data, BSTNode<T> root, BSTNode<T> dummy){
        if (root == null){
            throw new NoSuchElementException("Error");
        }else if (data.compareTo(root.getData()) < 0){
            root.setLeft(recur(data, root.getLeft(), dummy));
        }else if (data.compareTo(root.getData()) > 0){
            root.setRight(recur(data, root.getRight(), dummy));
        }else{
            dummy.setData(data);
            size --;
            if(root.getLeft() == null && root.getRight() == null){
                return null;
            }else if(root.getLeft() == null){
                return root.getRight();
            }else if (root.getRight() == null){
                return root.getLeft();
            }else{
                BSTNode<T> dummy1 = new BSTNode<>(null);
                root.setRight(succes(root.getRight(), dummy1));
                root.setData(dummy1.getData());
            }
        }
        return root;
    }


    private BSTNode<T> succes(BSTNode<T> root, BSTNode<T> dummy){
        if (root.getLeft() == null){
            dummy.setData(root.getData());
            if (root.getRight() == null){
                return null;
            }else{
                return root.getRight();
            }

        }else{
            root.setLeft(succes(root.getLeft(), dummy));
            return root;

        }
    }



    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}