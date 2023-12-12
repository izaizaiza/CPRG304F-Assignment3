/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment3bst;

import treeImplementation.BSTreeNode;
/**
 * @author dlg12
 * @author izalu
 */
public class Assignment3BST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //
        BSTreeNode<Object> objectBSTreeNode = new BSTreeNode<>();
        objectBSTreeNode.setElement(1);
        objectBSTreeNode.setLeftChild(new BSTreeNode<>(2));
        objectBSTreeNode.setRightChild(new BSTreeNode<>(3));
        objectBSTreeNode.getLeftChild().setLeftChild(new BSTreeNode<>(4));
        objectBSTreeNode.getLeftChild().setRightChild(new BSTreeNode<>(5));
        objectBSTreeNode.getRightChild().setLeftChild(new BSTreeNode<>(6));
        objectBSTreeNode.getRightChild().setRightChild(new BSTreeNode<>(7));
        objectBSTreeNode.getLeftChild().getLeftChild().setLeftChild(new BSTreeNode<>(8));
        objectBSTreeNode.getLeftChild().getLeftChild().setRightChild(new BSTreeNode<>(9));
        objectBSTreeNode.getLeftChild().getRightChild().setLeftChild(new BSTreeNode<>(10));
        objectBSTreeNode.getLeftChild().getRightChild().setRightChild(new BSTreeNode<>(11));
        objectBSTreeNode.getRightChild().getLeftChild().setLeftChild(new BSTreeNode<>(12));
        objectBSTreeNode.getRightChild().getLeftChild().setRightChild(new BSTreeNode<>(13));
        objectBSTreeNode.getRightChild().getRightChild().setLeftChild(new BSTreeNode<>(14));
        objectBSTreeNode.hasLeftChild();
        objectBSTreeNode.hasRightChild();
        objectBSTreeNode.getLeftChild().hasLeftChild();
        objectBSTreeNode.getLeftChild().hasRightChild();
        objectBSTreeNode.getRightChild().hasLeftChild();
        System.out.println(objectBSTreeNode.getRightChild().hasRightChild());
        objectBSTreeNode.getLeftChild().getLeftChild().hasLeftChild();
        objectBSTreeNode.getLeftChild().getLeftChild().hasRightChild();
    }
    
}
