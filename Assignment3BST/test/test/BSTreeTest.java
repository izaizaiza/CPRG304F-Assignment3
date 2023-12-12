/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;

//Lets use junit 4
import org.junit.Test;
import static org.junit.Assert.*;
import treeImplementation.BSTree;
import utilities.Iterator;
/**
 * @author dlg12
 * @author izalu
 */
public class BSTreeTest {
    
    private BSTree<Integer> bst;
    

    @Test
    public void testAdd(){
        bst = new BSTree<>();
        assertTrue(bst.add(10));
        assertTrue(bst.add(20));
        assertTrue(bst.add(30));
        
        
        // test size increase
        assertEquals(3, bst.size());
    }
    
    @Test
    public void testContains(){
        bst = new BSTree<>();
        assertFalse(bst.contains(10));
        bst.add(10);
        assertTrue(bst.contains(10));
        
        //test contains with null entry
        assertFalse(bst.contains(null));
    }
    
    
    @Test
    public void testRemoveMin(){
        bst = new BSTree<>();
        
        bst.add(1);
        bst.add(2);
        bst.add(3);
        
        // test removing min
        assertEquals(1, (int)bst.removeMin().getElement());
        assertEquals(2, bst.size());
        
    }
    
    @Test
    public void testRemoveMax() {
        bst = new BSTree<>();
        assertNull(bst.removeMax());
        bst.add(10);
        bst.add(5);
        bst.add(15);
        assertEquals(15, (int) bst.removeMax().getElement());
        assertEquals(2, bst.size());
    }
    
    @Test
    public void testInorderIterator(){
        bst = new BSTree<>();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(8);
        bst.add(12);
        
        Integer[] expectedOrder = {5,8,10,12,15};
        int i=0;
        
        
        for (Iterator<Integer> iterator = bst.inorderIterator(); iterator.hasNext(); ) {
            assertEquals(expectedOrder[i++], iterator.next());
        }
        
    }
    
    
    @Test
    public void testPostOrderIterator(){
        bst = new BSTree<>();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(8);
        bst.add(12);
        
        Integer[] expectedOrder = {8,5,12,15,10};
        int i=0;
        
        for (Iterator<Integer> iterator = bst.postorderIterator(); iterator.hasNext(); ) {
            assertEquals(expectedOrder[i++], iterator.next());
        }
        
    }
    
    
    
    @Test
    public void testPreOrderIterator(){
        bst = new BSTree<>();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(8);
        bst.add(12);
        
        Integer[] expectedOrder = {10,5,8,15,12};
        int i=0;
        
        for (Iterator<Integer> iterator = bst.preorderIterator(); iterator.hasNext(); ) {
            assertEquals(expectedOrder[i++], iterator.next());
        }
        
    }
            
}
