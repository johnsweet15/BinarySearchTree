import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class contains the test methods for the Bst class
 * 
 * @author John Sweet
 * @version 20161121
 * 
 */

public class BstTest {

    /**
     * Does contains() accurately determine if a given node is in a tree
     */
    @Test
    public void doesContainsDetermineIfValueIsInTree() {
        Bst bst = new Bst();
        bst.insert(5);
        bst.insert(7);
        bst.insert(3);
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(7));
        assertTrue(bst.contains(3));
        assertFalse(bst.contains(10));
    }

    /**
     * Does insert() add one node to a tree
     */
    @Test
    public void doesInsertAddNodeToTree() {
        Bst bst = new Bst();
        bst.insert(5);
        assertTrue(bst.contains(5));
    }

    /**
     * Does preorder return a string of the preorder traversal of the tree
     */
    @Test
    public void doesPreorderReturnStringOfPreorderTraversal() {
        Bst bst = new Bst();
        bst.insert(10);
        bst.insert(15);
        bst.insert(21);
        bst.insert(7);
        bst.insert(9);
        assertEquals("< 10 7 9 15 21 >", bst.preorder());
    }

    /**
     * Does isBalanced() determine if the tree is balanced
     */
    @Test
    public void doesIsBalancedDetermineIfTreeIsBalanced() {
        Bst bst = new Bst();
        bst.insert(10);
        bst.insert(15);
        bst.insert(21);
        bst.insert(7);
        bst.insert(9);
        assertTrue(bst.isBalanced());
    }

    /**
     * Does isBalanced() determine if the tree is balanced
     */
    @Test
    public void doesIsBalancedDetermineIfTreeIsBalanced2() {
        Bst bst = new Bst();
        bst.insert(10);
        bst.insert(15);
        bst.insert(6);
        bst.insert(7);
        bst.insert(8);
        bst.insert(9);
        assertFalse(bst.isBalanced());
    }

    /**
     * Does isBalanced() determine if the tree is not balanced
     */
    @Test
    public void doesIsBalancedDetermineIfTreeIsNotBalanced() {
        Bst bst = new Bst();
        bst.insert(10);
        bst.insert(15);
        bst.insert(21);
        bst.insert(25);
        bst.insert(32);
        assertFalse(bst.isBalanced());
    }

    /**
     * Does isBalanced() determine if the tree is balanced when the tree is
     * empty
     */
    @Test
    public void doesIsBalancedDetermineIfTreeIsNotBalancedWhenNull() {
        Bst bst = new Bst();
        assertTrue(bst.isBalanced());
    }

    /**
     * Does moves() give the correct moves to get to the given node
     */
    @Test
    public void doesMovesGiveLeftRightDirectionsToNode() {
        Bst bst = new Bst();
        bst.insert(10);
        bst.insert(15);
        bst.insert(21);
        bst.insert(7);
        bst.insert(9);
        assertEquals("LR", bst.moves(9));
        assertEquals("RR", bst.moves(21));
        assertEquals("LL", bst.moves(6));
    }

    /**
     * Does remove() delete one node from a given tree
     */
    @Test
    public void doesRemoveDeleteNodeFromTree() {
        Bst bst = new Bst();
        bst.insert(5);
        bst.insert(8);
        bst.remove(8);
        assertEquals(false, bst.contains(8));
    }

    /**
     * Does remove() delete one node from a given tree
     */
    @Test
    public void doesRemoveDeleteNodeFromTree2() {
        Bst bst = new Bst();
        bst.insert(5);
        bst.insert(6);
        bst.insert(8);
        bst.remove(8);
        assertEquals(false, bst.contains(8));
    }

    /**
     * Does remove() delete one node from a given tree
     */
    @Test
    public void doesRemoveDeleteNodeFromTree3() {
        Bst bst = new Bst();
        bst.insert(5);
        bst.insert(6);
        bst.insert(8);
        bst.remove(6);
        assertEquals(false, bst.contains(6));
    }

    /**
     * Does remove() delete one node from a given tree
     */
    @Test
    public void doesRemoveDeleteNodeFromTree4() {
        Bst bst = new Bst();
        bst.insert(5);
        bst.insert(4);
        bst.insert(6);
        bst.remove(4);
        assertEquals(false, bst.contains(4));
    }

    /**
     * Does remove() delete one node from a given tree
     */
    @Test
    public void doesRemoveDeleteNodeFromTree5() {
        Bst bst = new Bst();
        bst.insert(5);
        bst.insert(4);
        bst.remove(4);
        assertEquals(false, bst.contains(4));
    }
    
    /**
     * Does remove() delete one node from a given tree
     */
    @Test
    public void doesRemoveDeleteNodeFromTree6() {
        Bst bst = new Bst();
        bst.insert(10);
        bst.insert(5);
        bst.insert(6);
        bst.insert(3);
        bst.insert(15);
        bst.insert(12);
        bst.insert(16);
        bst.insert(2);
        bst.remove(5);
        
        assertEquals(true, bst.contains(12));
        
        
    }
    
    /**
     * Does calling leftSubtree() return the left subtree of a given tree
     */
    @Test
    public void doesLeftSubtreeReturnTheLeftSubtree() {
        BstADT bst = new Bst();
        bst.insert(10);
        bst.insert(15);
        bst.insert(21);
        bst.insert(7);
        bst.insert(9);
        bst.leftSubtree();
        BstADT leftTree = new Bst();
        leftTree.insert(7);
        leftTree.insert(9);
        assertEquals(leftTree.valOfRoot(), bst.leftSubtree().valOfRoot());
    }

    /**
     * Does calling leftSubtree() return the left subtree of a given tree
     */
    @Test
    public void doesLeftSubtreeReturnTheLeftSubtreeReturnNull() {
        BstADT bst = new Bst();
        bst.insert(10);
        bst.insert(15);
        bst.insert(21);
        assertNull(bst.leftSubtree());
    }

    /**
     * Does calling rightSubtree() return the right subtree of a given tree
     */
    @Test
    public void doesRightSubtreeReturnTheRightSubtree() {
        BstADT bst = new Bst();
        bst.insert(10);
        bst.insert(15);
        bst.insert(21);
        bst.insert(7);
        bst.insert(9);
        BstADT rightTree = new Bst();
        rightTree.insert(15);
        rightTree.insert(21);
        assertEquals(rightTree.valOfRoot(), bst.rightSubtree().valOfRoot());
    }

    /**
     * Does calling rightSubtree() return the right subtree of a given tree
     */
    @Test
    public void doesRightSubtreeReturnTheLeftSubtreeReturnNull() {
        BstADT bst = new Bst();
        bst.insert(10);
        bst.insert(9);
        bst.insert(8);
        assertNull(bst.rightSubtree());
    }

    /**
     * Does valOfRoot() return the root value
     */
    @Test
    public void deosValOfRootReturnRootElement() {
        BstADT bst = new Bst();
        bst.insert(10);
        assertEquals(10, bst.valOfRoot());
    }

    /**
     * Does valOfRoot() throw an ISE when tree is empty
     */
    @Test(expected = IllegalStateException.class)
    public void deosValOfRootThrowISEWhenNull() {
        BstADT bst = new Bst();
        bst.valOfRoot();
        assertEquals(0, bst.valOfRoot());
    }

    /**
     * Does isEmpty() determine if a tree is empty when it is empty
     */
    @Test
    public void doesIsEmptyDetermineIfTreeIsEmptyWhenEmpty() {
        BstADT bst = new Bst();
        assertTrue(bst.isEmpty());
    }

    /**
     * Does isEmpty() determine if a tree is empty when it is not empty
     */
    @Test
    public void doesIsEmptyDetermineIfTreeIsEmptyWhenNotEmpty() {
        BstADT bst = new Bst();
        bst.insert(5);
        assertFalse(bst.isEmpty());
    }

}
