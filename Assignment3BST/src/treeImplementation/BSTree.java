/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treeImplementation;
import utilities.BSTreeADT;
import utilities.Iterator;
import treeImplementation.BSTreeNode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author dlg12
 * @author izalu
 * Implements BSTreeADT in utilities package
 * @param <E> The type of element that the tree holds, must extend Comparable.
 */
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
    private BSTreeNode<E> root;
    private int size;

    /**
     * Constructs an empty BSTree.
     */
    public BSTree() {
        root = null;
        size = 0;
    }
    
    
    /**
     * Gets the root of the tree.
     * @return The root of the tree.
     */
    @Override
    public BSTreeNode<E> getRoot() {
        return root;
    }

    
    /**
     * Gets the height of the tree.
     *
     * @return The height of the tree.
     */
    @Override
    public int getHeight() {
        return calculateHeight(root);
    }

    /**
     * Recursively calculates the height of the tree.
     *
     * @param node The current node.
     * @return The height of the tree.
     */
    private int calculateHeight(BSTreeNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = calculateHeight(node.getLeftChild());
            int rightHeight = calculateHeight(node.getRightChild());
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    /**
     * Gets the size of the tree.
     *
     * @return The size of the tree.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the tree is empty.
     *
     * @return True if the tree is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the tree, removing all elements.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Checks if the tree contains a specific element.
     *
     * @param entry The element to check for.
     * @return True if the tree contains the element, false otherwise.
     * @throws NullPointerException If the provided entry is null.
     */
    @Override
    public boolean contains(E entry) throws NullPointerException {
        return search(entry) != null;
    }

    /**
     * Searches for a specific element in the tree.
     *
     * @param entry The element to search for.
     * @return The node containing the element, or null if not found.
     * @throws NullPointerException If the provided entry is null.
     */
    @Override
    public BSTreeNode<E> search(E entry) throws NullPointerException {
        return searchNode(root, entry);
    }

    /**
     * Recursively searches for a specific element in the tree.
     *
     * @param node  The current node.
     * @param entry The element to search for.
     * @return The node containing the element, or null if not found.
     * @throws NullPointerException If the provided entry is null.
     */
    private BSTreeNode<E> searchNode(BSTreeNode<E> node, E entry) {
        if (node == null || entry == null) {
            return null;
        }

        int comparison = entry.compareTo(node.getElement());
        if (comparison == 0) {
            return node;
        } else if (comparison < 0) {
            return searchNode(node.getLeftChild(), entry);
        } else {
            return searchNode(node.getRightChild(), entry);
        }
    }

    
    /**
     * Adds a new element to the tree.
     *
     * @param newEntry The element to add.
     * @return True if the element is successfully added, false otherwise.
     * @throws NullPointerException If the provided entry is null.
     */
    @Override
    public boolean add(E newEntry) throws NullPointerException {
        if (newEntry == null) {
            throw new NullPointerException("Cannot add null entry to the tree");
        }

        if (root == null) {
            root = new BSTreeNode<>(newEntry);
        } else {
            addNode(root, newEntry);
        }

        size++;
        return true;
    }

    
    /**
     * Recursively adds a new element to the tree.
     *
     * @param node      The current node.
     * @param newEntry  The element to add.
     */
    private void addNode(BSTreeNode<E> node, E newEntry) {
        int comparison = newEntry.compareTo(node.getElement());
        if (comparison < 0) {
            if (node.hasLeftChild()) {
                addNode(node.getLeftChild(), newEntry);
            } else {
                node.setLeftChild(new BSTreeNode<>(newEntry));
            }
        } else {
            if (node.hasRightChild()) {
                addNode(node.getRightChild(), newEntry);
            } else {
                node.setRightChild(new BSTreeNode<>(newEntry));
            }
        }
    }
    
    

    /**
    * Removes the node with the minimum value in the tree.
    *
    * @return The removed node, or null if the tree is empty.
    */
    @Override
    public BSTreeNode<E> removeMin() {
        if (isEmpty()) {
            return null;
        }

        BSTreeNode<E> parent = null;
        BSTreeNode<E> current = root;

        while (current.hasLeftChild()) {
            parent = current;
            current = current.getLeftChild();
        }

        if (parent != null) {
            parent.setLeftChild(current.getRightChild());
        } else {
            root = current.getRightChild();
        }

        size--;
        return current;
    }
    
    

    /**
    * Removes the node with the maximum value in the tree.
    *
    * @return The removed node, or null if the tree is empty.
    */
    @Override
    public BSTreeNode<E> removeMax() {
        if (isEmpty()) {
            return null;
        }

        BSTreeNode<E> parent = null;
        BSTreeNode<E> current = root;

        while (current.hasRightChild()) {
            parent = current;
            current = current.getRightChild();
        }

        if (parent != null) {
            parent.setRightChild(current.getLeftChild());
        } else {
            root = current.getLeftChild();
        }

        size--;
        return current;
    }

    /**
    * Returns an iterator for an inorder traversal of the tree.
    *
    * @return Iterator for inorder traversal.
    */
    @Override
    public Iterator<E> inorderIterator() {
        List<E> elements = new ArrayList<>();
        inorderTraversal(root, elements);
        return new TreeIterator<>(elements);
    }

    /**
    * Recursively performs an inorder traversal of the tree.
    *
    * @param node     The current node.
    * @param elements List to store elements during traversal.
    */
    private void inorderTraversal(BSTreeNode<E> node, List<E> elements) {
        if (node != null) {
            inorderTraversal(node.getLeftChild(), elements);
            elements.add(node.getElement());
            inorderTraversal(node.getRightChild(), elements);
        }
    }

    /**
    * Returns an iterator for a preorder traversal of the tree.
    *
    * @return Iterator for preorder traversal.
    */
    @Override
    public Iterator<E> preorderIterator() {
        List<E> elements = new ArrayList<>();
        preorderTraversal(root, elements);
        return new TreeIterator<>(elements);
    }

    /**
    * Recursively performs a preorder traversal of the tree.
    *
    * @param node     The current node.
    * @param elements List to store elements during traversal.
    */
    private void preorderTraversal(BSTreeNode<E> node, List<E> elements) {
        if (node != null) {
            elements.add(node.getElement());
            preorderTraversal(node.getLeftChild(), elements);
            preorderTraversal(node.getRightChild(), elements);
        }
    }

    /**
    * Returns an iterator for a postorder traversal of the tree.
    *
    * @return Iterator for postorder traversal.
    */

    @Override
    public Iterator<E> postorderIterator() {
        List<E> elements = new ArrayList<>();
        postorderTraversal(root, elements);
        return new TreeIterator<>(elements);
    }
    
    /**
    * Recursively performs a postorder traversal of the tree.
    *
    * @param node     The current node.
    * @param elements List to store elements during traversal.
    */
    private void postorderTraversal(BSTreeNode<E> node, List<E> elements) {
        if (node != null) {
            postorderTraversal(node.getLeftChild(), elements);
            postorderTraversal(node.getRightChild(), elements);
            elements.add(node.getElement());
        }
    }
    
    /**
    * Iterator implementation for tree traversal.
    *
    * @param <E> The type of element in the iterator.
    */
    private class TreeIterator<E> implements Iterator<E> {
        private List<E> elements;
        private int currentIndex;

        /**
        * Constructs a TreeIterator with the given elements list.
        *
        * @param elements List of elements to iterate over.
        */
        public TreeIterator(List<E> elements) {
            this.elements = elements;
            this.currentIndex = 0;
        }

        
        /**
        * Checks if there are more elements in the iterator.
        *
        * @return True if there are more elements, false otherwise.
        */
        @Override
        public boolean hasNext() {
            return currentIndex < elements.size();
        }

        /**
        * Returns the next element in the iterator.
        *
        * @return The next element.
        * @throws java.util.NoSuchElementException If there are no more elements.
        */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("No more elements in the iterator.");
            }
            return elements.get(currentIndex++);
        }
    }
}





