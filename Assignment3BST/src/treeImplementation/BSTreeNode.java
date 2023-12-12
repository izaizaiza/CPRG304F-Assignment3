/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treeImplementation;

/**
 *
 * @author izalu
 */
public class BSTreeNode<E> {
    /**
     * data is the data of this node
     * leftChild is the child of this node to its left
     * rightChild is the child of this node to its right
     */
    private E element;
    private BSTreeNode<E> leftChild;
    private BSTreeNode<E> rightChild;
    
    
    /**
     * constructor
     * creates a BSTreeNode where its element is null as well as its leftChild and
     * rightChild node
     */
    public BSTreeNode(){
        this.element = null;
    }
    
    /**
     * constructor
     * @param element the data to be placed in the node 
     */
    public BSTreeNode(E element){
        this.element = element;
    }
    
    
    /**
     * Constructs a BSTreeNode with element as the data inside it, left as its left
     * child node and right as its right child node.
     * @param element the data stored in the node, of type E
     * @param left left child of this node
     * @param right  right child of this node
     */
    public BSTreeNode(E element, BSTreeNode<E> left, BSTreeNode<E> right){
        this.element = element;
        this.leftChild = left;
        this.rightChild = right;
    }
    
    /**
     * Gets the element that the node holds
     * @return the element in the node, has datatype of E.
     */
    public E getElement(){
        return this.element;
    }
    
    
    
    /**
     * Sets the element of this node to the given element
     * @param element the element to set this node to have as its element
     */
    public void setElement(E element){
        this.element = element;
    }
    
    /**
     * Gets the left child node of this node
     * @return left child node of type BSTreeNode
     */
    public BSTreeNode<E> getLeftChild(){
        return leftChild;
    }
    
    /**
     * Sets the parameter, newLeft, as the new left child of this node
     * @param newLeft the new left child element of this node
     */
    public void setLeftChild(BSTreeNode<E> newLeft){
        this.leftChild = newLeft;
    }
    
    /**
     * Gets the right child node of this node
     * @return right child node of type BSTreeNode
     */
    public BSTreeNode<E> getRightChild(){
        return rightChild;
    }
    
    
    /**
     * Sets the parameter, newRight, as the new right child of this node
     * @param newRight the new right child of this node
     */
    public void setRightChild(BSTreeNode<E> newRight){
        this.rightChild = newRight;
    }
    
    
    /**
     * @return true if this node has a left child that is not null,
     * false otherwise
     */
    public boolean hasLeftChild(){
        return (this.leftChild != null);
    }
    
    /**
     * 
     * @return true if this node has a right child that is not null,
     * false otherwise
     */
    public boolean hasRightChild(){
        return (this.rightChild != null);
    }
    

    
    
    
    
    
    
    
    
    
}
