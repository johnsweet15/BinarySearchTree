/**
 * BstADT interface file for student use.
 * 
 * @author acsiochi
 * @version 20161107
 */
@SuppressWarnings("rawtypes")
public interface BstADT {

    /**
     * Runs the contains helper method
     * 
     * @param val
     *            the value received
     * @return true if the tree contains the given value and false otherwise
     */
    public boolean contains(Comparable val);

    /**
     * Runs the insert helper method
     * 
     * @param val
     *            the value received
     */
    public void insert(Comparable val);

    /**
     * Runs the preorder helper method
     * 
     * @return the string with the correct order surrounded by brackets
     */
    public String preorder();

    /**
     * Runs the isBalanced helper method
     * 
     * @return true if the tree is balanced and false otherwise
     */
    public boolean isBalanced();

    /**
     * Runs the moves helper method
     * 
     * @param val
     *            the value received
     * @return string of moves in the form of L for left and R for right
     */
    public String moves(Comparable val);

    /**
     * Runs the remove helper method
     * 
     * @param val
     *            the value received
     */
    public void remove(Comparable val);

    /**
     * Returns the left subtree
     * 
     * @return the left subtree
     */
    public BstADT leftSubtree();

    /**
     * Returns the right subtree
     * 
     * @return the right subtree
     */
    public BstADT rightSubtree();

    /**
     * Returns the value of the root of a tree
     * 
     * @return the value of the root of a tree
     */
    public Comparable valOfRoot() throws IllegalStateException;

    /**
     * Determines if a tree is empty or not
     * 
     * @return true if the tree is empty and false otherwise
     */
    public boolean isEmpty();
}
