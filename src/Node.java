
/**
 * The node class creates nodes used in binary search trees
 * 
 * @author John Sweet
 * @version 20161121
 *
 */

@SuppressWarnings("rawtypes")
public class Node {

    private Comparable element;
    private Node right;
    private Node left;

    /**
     * Creates a node with a given value
     * 
     * @param val
     *            value received
     */
    public Node(Comparable val) {
        left = null;
        right = null;
        element = val;
    }

    /**
     * Returns the element of a given node
     * 
     * @return the element
     */
    public Comparable element() {
        return element;
    }

    /**
     * Sets the element of a given node
     * 
     * @param o
     *            object the element is being set to
     */
    public void setElement(Object o) {
        element = (Comparable) o;
    }

    /**
     * The right child node
     * 
     * @return the right child node
     */
    public Node right() {
        return right;
    }

    /**
     * Sets the right child node
     * 
     * @param n
     *            the node to be set
     */
    public void setRight(Node n) {
        right = n;
    }

    /**
     * The left child node
     * 
     * @return the left child node
     */
    public Node left() {
        return left;
    }

    /**
     * Sets the left child node
     * 
     * @param n
     *            the node to be set
     */
    public void setLeft(Node n) {
        left = n;
    }
}
