/**
 * A node tree to be used
 * for the calculus project
 * Lindsey Olson
 * (Used RIT CS department (Sean Strout) to construct)
 */
public class Node<T> {


    /** Left node link
     * Right node link
     * and the value
     * */
    private Node<T> left;
    private Node<T> right;
    private T value;

    /**
     * Construct a new Node object.
     */
    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * Get the successor Node.
     * @return the next left Node (null if none)
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * Get the successor Node.
     * @return the next right Node (null if none)
     */
    public Node<T> getRight()
    {
        return right;
    }

    /**
     * Get the Node's value.
     * @return the user value
     */
    public T getValue() {
        return value;
    }

    /**
     * Change the Node's successor.
     * @param left the Node's new left link
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /**
     * Change the Node's successor.
     * @param right the Node's new right link
     */
    public void setRight(Node<T> right) {
        this.right = right;
    }

    /**
     * Change the Node's data.
     * @param value the Node's new value
     */
    public void setValue(T value) {
        this.value = value;
    }

    public boolean isLeaf()
    {
        return this.left == null && this.right == null;
    }
}