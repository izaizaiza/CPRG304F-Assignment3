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
 *
 * @author izalu
 * Implements BSTreeADT in utilities package
 */
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
    private BSTreeNode<E> root;
    private int size;

    public BSTree() {
        root = null;
        size = 0;
    }

    @Override
    public BSTreeNode<E> getRoot() {
        return root;
    }

    @Override
    public int getHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(BSTreeNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = calculateHeight(node.getLeftChild());
            int rightHeight = calculateHeight(node.getRightChild());
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean contains(E entry) throws NullPointerException {
        return search(entry) != null;
    }

    @Override
    public BSTreeNode<E> search(E entry) throws NullPointerException {
        return searchNode(root, entry);
    }

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

    @Override
    public Iterator<E> inorderIterator() {
        List<E> elements = new ArrayList<>();
        inorderTraversal(root, elements);
        return new TreeIterator<>(elements);
    }

    private void inorderTraversal(BSTreeNode<E> node, List<E> elements) {
        if (node != null) {
            inorderTraversal(node.getLeftChild(), elements);
            elements.add(node.getElement());
            inorderTraversal(node.getRightChild(), elements);
        }
    }

    @Override
    public Iterator<E> preorderIterator() {
        List<E> elements = new ArrayList<>();
        preorderTraversal(root, elements);
        return new TreeIterator<>(elements);
    }

    private void preorderTraversal(BSTreeNode<E> node, List<E> elements) {
        if (node != null) {
            elements.add(node.getElement());
            preorderTraversal(node.getLeftChild(), elements);
            preorderTraversal(node.getRightChild(), elements);
        }
    }

    @Override
    public Iterator<E> postorderIterator() {
        List<E> elements = new ArrayList<>();
        postorderTraversal(root, elements);
        return new TreeIterator<>(elements);
    }
    private void postorderTraversal(BSTreeNode<E> node, List<E> elements) {
        if (node != null) {
            postorderTraversal(node.getLeftChild(), elements);
            postorderTraversal(node.getRightChild(), elements);
            elements.add(node.getElement());
        }
    }
    
    // Assume that TreeIterator implements utilities.Iterator
    private class TreeIterator<E> implements Iterator<E> {
        private List<E> elements;
        private int currentIndex;

        public TreeIterator(List<E> elements) {
            this.elements = elements;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < elements.size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("No more elements in the iterator.");
            }
            return elements.get(currentIndex++);
        }
    }
}





