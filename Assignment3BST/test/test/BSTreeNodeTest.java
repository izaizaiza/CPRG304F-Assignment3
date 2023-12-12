/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test;

//Lets use junit 4
import org.junit.Test;
import static org.junit.Assert.*;

import treeImplementation.BSTreeNode;

/**
 * @author dlg12
 * @author izalu
 */

public class BSTreeNodeTest {

    @Test
    public void testConstructorAndGetters() {
        // Create a BSTreeNode with an element
        Integer element = 42;
        BSTreeNode<Integer> node = new BSTreeNode<>(element);

        // Verify that the element is set correctly
        assertEquals(element, node.getElement());

        // Verify that left and right children are initially null
        assertNull(node.getLeftChild());
        assertNull(node.getRightChild());
    }

    @Test
    public void testSetters() {
        // Create a BSTreeNode with an initial element
        Integer initialElement = 42;
        BSTreeNode<Integer> node = new BSTreeNode<>(initialElement);

        // Create new elements for the left and right children
        Integer leftElement = 20;
        Integer rightElement = 60;

        // Create new nodes for the left and right children
        BSTreeNode<Integer> leftChild = new BSTreeNode<>(leftElement);
        BSTreeNode<Integer> rightChild = new BSTreeNode<>(rightElement);

        // Set the left and right children of the node
        node.setLeftChild(leftChild);
        node.setRightChild(rightChild);

        // Verify that the left and right children are set correctly
        assertEquals(leftChild, node.getLeftChild());
        assertEquals(rightChild, node.getRightChild());
    }

    @Test
    public void testHasLeftAndRightChild() {
        // Create a BSTreeNode with no children
        BSTreeNode<Integer> nodeNoChildren = new BSTreeNode<>(10);

        // Verify that it has no left or right child
        assertFalse(nodeNoChildren.hasLeftChild());
        assertFalse(nodeNoChildren.hasRightChild());

        // Create a BSTreeNode with left and right children
        BSTreeNode<Integer> leftChild = new BSTreeNode<>(5);
        BSTreeNode<Integer> rightChild = new BSTreeNode<>(15);
        BSTreeNode<Integer> nodeWithChildren = new BSTreeNode<>(10, leftChild, rightChild);

        // Verify that it has left and right children
        assertTrue(nodeWithChildren.hasLeftChild());
        assertTrue(nodeWithChildren.hasRightChild());
    }
}

