/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treeImplementation;
import utilities.BSTreeADT;
import utilities.Iterator;
import treeImplementation.BSTreeNode;
/**
 *
 * @author izalu
 * Implements BSTreeADT in utilities package
 */
public class BSTree<E> implements BSTreeADT<E>{
    
    private int height;
    private BSTreeNode<E> root;
    
    /**
     * BSTree Constructor; creates an empty binary search tree
     */
    public BSTree(){
        // constructs an empty BST
        this.root = null;
    }
    
    /**
     * BSTree Constructor; creates a binary search tree with the given element
     * as the root node.
     * @param element
     */
    public BSTree(E element){
        this.root = new BSTreeNode<E>(element);
    }
    
    /**
     * The node at the root of the Binary Search Tree will be returned.
     * @return node stored at the root of tree is returned or null if
     * the tree is empty
     */
    @Override 
    public BSTreeNode<E> getRoot(){
        return this.root;
    }

    /**
     * Determines the row height of the tree and returns that value as an
     * integer value.
     * @return the height of the tree.
     */
    @Override
    public int getHeight(){
        return this.height;
    }
    
    /**
     * The number of elements currently stored in the tree is counted and
     * the value is returned.
     * @return number of elements currently stored in tree.
     */
    @Override
    public int size(){
        // add how to get the num of nodes in this tree
        return 0;
    }
        
    /**
     * Checks if the tree is currently empty.
     * @return returns boolean true if the tree is empty otherwise false.
     */
    @Override
    public boolean isEmpty(){
        return (this.root.getElement() == null);
    }

    /**
     * Clears all elements currently stored in tree and makes the tree empty.
     */
    @Override
    public void clear(){
        //add logic
    }

    /**
     * Checks the current tree to see if the element passed in is stored in
     * the tree. If the element is found in the tree the method returns true
     * and if the element is not in the tree the method returns false.
     * @param entry the element to find in the tree
     * @return returns boolean true if element is currently in the tree and
     * false if the element is not found in the tree
     * @throws NullPointerException if the element being passed in is null
     */
    @Override
    public boolean contains(E entry) throws NullPointerException{
        if (entry == null){
            throw new NullPointerException("Given element 'entry' is null.");
        }
        // add logic to traversing the tree and searching the node if in the tree
        
        return false;
    }
    
    

    /**
     * Retrieves a node from the tree given the object to search for.
     * @param entry element object being searched
     * @return the node with the element located in tree, null if not found
     * @throws NullPointerException if the element being passed in is null
     */
    @Override
    public BSTreeNode<E> search(E entry) throws NullPointerException{
        if (entry == null){
            throw new NullPointerException("Given element 'entry' is null.");
        }
        BSTreeNode node = new BSTreeNode(1); // change this node to finding the given in the tree
        return node;
        
    }
    /**
     * Adds a new element to the tree according to the natural ordering
     * established by the Comparable implementation.
     * @param newEntry the element being added to the tree
     * @return a boolean true if the element is added successfully else false
     * @throws NullPointerException if the element being passed in is null
     */
    @Override
    public boolean add(E newEntry) throws NullPointerException{
        if (newEntry == null){
            throw new NullPointerException("The given newEntry is null.");
        }
        // add the process of adding a new data in the tree:
        // 1. create new node with the given data newEntry
        // assign node's parent to the latest node in the tree?
        return false;
    }

    /**
     * Removes the smallest element in the tree according to the natural 
     * ordering established by the Comparable implementation.
     * @return the removed element or null if the tree is empty
     */
    public BSTreeNode<E> removeMin(){
        //
        System.out.println("Replace with logic");
        
        return new BSTreeNode("E");
    }

    /**
     * Removes the largest element in the tree according to the natural 
     * ordering established by the Comparable implementation.
     * @return the removed element or null if the tree is empty
     */
    public BSTreeNode<E> removeMax(){
        //
        System.out.println("Replace with logic");
        
        return new BSTreeNode("E");
    }

    /**
     * Generates an in-order iteration over the contents of the tree. Elements
     * are in their natural order.
     * @return an iterator with the elements in the natural order
     */
    public Iterator<E> inorderIterator();

    /**
     * Generates a pre-order iteration over the contents of the tree. Elements
     * are order in such a way as the root element is first.
     * @return an iterator with the elements in a root element first order
     */
    public Iterator<E> preorderIterator();

    /**
     * Generates a post-order iteration over the contents of the tree. Elements
     * are order in such a way as the root element is last.
     * @return an iterator with the elements in a root element last order
     */
    public Iterator<E> postorderIterator();
    
}
