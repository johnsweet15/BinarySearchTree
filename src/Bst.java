
/**
 * The purpose of this class is to implement a Binary Search Tree ADT
 * 
 * @author John Sweet
 * @version 20161121
 *
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Bst implements BstADT {

    private Node root;
    @SuppressWarnings("unused")
    private int count;

    /**
     * Creates an empty binary search tree
     */
    public Bst() {
        root = null;
        count = 0;
    }

    /**
     * Runs the contains helper method
     * 
     * @param val
     *            the value received
     * @return true if the tree contains the given value and false otherwise
     */
    @Override
    public boolean contains(Comparable val) {
        return (containsHelp(root, val) != null);
    }

    /**
     * Determines if a given value is in a tree or not
     * 
     * @param rt
     *            the node used to search for the value
     * @param val
     *            the value being searched
     * @return true if the tree contains the given value and false otherwise
     */
    private Comparable containsHelp(Node rt, Comparable val) {
        if (rt == null) {
            return null;
        }
        if (rt.element().compareTo(val) > 0) {
            return containsHelp(rt.left(), val);
        }
        else if (rt.element().compareTo(val) < 0) {
            return containsHelp(rt.right(), val);
        }
        else {
            return rt.element();
        }
    }

    /**
     * Runs the insert helper method
     * 
     * @param val
     *            the value received
     */
    @Override
    public void insert(Comparable val) {
        this.root = insertHelp(root, val);
        count++;
    }

    /**
     * Inserts a new node into a tree at the correct place
     * 
     * @param rt
     *            the node to be inserted
     * @param val
     *            the value of the node
     * @return the node that is to be inserted
     */
    private Node insertHelp(Node rt, Comparable val) {
        if (rt == null) {
            return new Node(val);
        }
        if (rt.element().compareTo(val) >= 0) {
            rt.setLeft(insertHelp(rt.left(), val));
        }
        else {
            rt.setRight(insertHelp(rt.right(), val));
        }
        return rt;
    }

    /**
     * Runs the preorder helper method
     * 
     * @return the string with the correct order surrounded by brackets
     */
    @Override
    public String preorder() {
        return preorder(root);
    }

    /**
     * Arranges the contents of a tree in a preorder traversal and turns it into
     * a string
     * 
     * @param rt
     *            the node used to put the tree in the correct order
     * @return the string with the correct order surrounded by brackets
     */
    private String preorder(Node rt) {
        String str = "";
        if (rt == null) {
            return "";
        }
        str += rt.element().toString() + " ";
        str += preorder(rt.left());
        str += preorder(rt.right());
        if (rt == root) {
            str = "< " + str + ">";
        }
        return str;
    }

    /**
     * Runs the isBalanced helper method
     */
    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * Determines if a tree is balanced or not
     * 
     * @param rt
     *            the node received to traverse the tree
     * @return true if the tree is balanced and false if not
     */
    private boolean isBalanced(Node rt) {
        if (rt == null) {
            return true;
        }
        int leftHeight = getHeight(rt.left());
        int rightHeight = getHeight(rt.right());

        return (isBalanced(rt.left()) && isBalanced(rt.right())
                && (Math.abs(leftHeight - rightHeight) < 2));
    }

    /**
     * Finds the height of the tree to help determine if the tree is balanced or
     * not
     * 
     * @param rt
     *            the node used to determine the height
     * @return the height of the tree
     */
    private int getHeight(Node rt) {
        if (rt == null) {
            return 0;
        }
        int height = 0;
        if (getHeight(rt.left()) > getHeight(rt.right())) {
            height = getHeight(rt.left());
        }
        else {
            height = getHeight(rt.right());
        }
        return height + 1;

    }

    /**
     * Runs the moves helper method
     * 
     * @param val
     *            the value received
     * @return string of moves in the form of L for left and R for right
     */
    @Override
    public String moves(Comparable val) {
        return moves(root, val);
    }

    /**
     * Determines the moves needed to get the given value
     * 
     * @param rt
     *            node used to determine moves
     * @param val
     *            value being searched for
     * @return string of moves in the form of L for left and R for right
     */
    private String moves(Node rt, Comparable val) {
        String str = "";
        try {
            if (root == null) {
                return "";
            }
            if (rt.element().compareTo(val) > 0) {
                str += "L" + moves(rt.left(), val);
            }
            else if (rt.element().compareTo(val) < 0) {
                str += "R" + moves(rt.right(), val);
            }
            return str;
        }
        catch (NullPointerException e) {
            return str;
        }
    }

    /**
     * Runs the remove helper method
     * 
     * @param val
     *            the value received
     */
    @Override
    public void remove(Comparable val) {
        removeHelp(root, val);
        count--;
    }

    /**
     * Removes a the given node form the tree
     * 
     * @param rt
     *            the node being removed
     * @param val
     *            the value to be removed
     * @return the node that is to be removed
     */
    private Node removeHelp(Node rt, Comparable val) {
        if (rt.element().compareTo(val) > 0) {
            rt.setLeft(removeHelp(rt.left(), val));
        }
        else if (rt.element().compareTo(val) < 0) {
            rt.setRight(removeHelp(rt.right(), val));
        }
        else {
            if (rt.right() == null) {
                return rt.left();
            }
            else if (rt.left() == null) {
                return rt.right();
            }
            else {
                Node node = max(rt.left());
                rt.setElement(node.element());
                rt.setLeft(deleteMax(rt.left()));
            }
        }
        return rt;
    }

    /**
     * Returns the highest element in the subtree
     * 
     * @param rt
     *            the node received
     * @return the highest element in the subtree
     */
    private Node max(Node rt) {
        if (rt.right() == null) {
            return rt;
        }
        return max(rt.right());
    }

    /**
     * Deletes the highest element in the subtree
     * 
     * @param rt
     *            the node received
     * @return the max element to be deleted
     */
    private Node deleteMax(Node rt) {
        if (rt.right() == null) {
            return rt.left();
        }
        rt.setRight(deleteMax(rt.right()));
        return rt;
    }

    /**
     * Returns the left subtree
     * 
     * @return the left subtree
     */
    @Override
    public BstADT leftSubtree() {
        if (root.left() == null) {
            return null;
        }
        Bst leftTree = new Bst();
        leftTree.root = root.left();
        return leftTree;
    }

    /**
     * Returns the right subtree
     * 
     * @return the right subtree
     */
    @Override
    public BstADT rightSubtree() {
        if (root.right() == null) {
            return null;
        }
        Bst rightTree = new Bst();
        rightTree.root = root.right();
        return rightTree;
    }

    /**
     * Returns the value of the root of a tree
     * 
     * @return the value of the root of a tree
     */
    @Override
    public Comparable valOfRoot() throws IllegalStateException {
        if (root == null) {
            throw new IllegalStateException();
        }
        else {
            return root.element();
        }
    }

    /**
     * Determines if a tree is empty or not
     * 
     * @return true if the tree is empty and false otherwise
     */
    @Override
    public boolean isEmpty() {
        return (root == null);
    }

}
