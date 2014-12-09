/**
 * Created by ShaNa on 2014/11/29.
 */
/**
 *  The DNode class represents a node which is used in DoubleLinkedList.
 *  A node object includes node basic attributes, such as next object, previous object,
 *  and also includes some attributes which are served for pixel primary colors, such as
 *  red, green, blue, which arrange from 0 to 255. Value here, it is just a general value object,
 *  lately it refers to consecutive num.
 *
 */
public class DNode {

    //here are private attributes of node
    private int m_value;
    private short m_red, m_green, m_blue;
    private DNode m_next, m_prev;

    /**
     * DNode() default constructor, constructs a node with out connection relationship.
     */
    public DNode()
    {
        m_value = -1;
        m_next = null;
        m_prev = null;
    }
    /**
     * DNode constructs a node with full info, it specializes connection relationship
     * primary colors info
     * @param value the num of consecutive node.
     * @param red the value of primary color red.
     * @param green the value of consecutive green.
     * @param blue the value of consecutive blue.
     * @param next next node of the node.
     * @param prev previous node of the node.
     */
    public DNode(int value, short red, short green, short blue, DNode next, DNode prev)
    {
        m_value = value;
        m_red = red;
        m_green = green;
        m_blue = blue;
        m_next = next;
        m_prev = prev;
    }

    /**
     * getValue return the value of node
     * @return the value of node.
     */
    public int getValue()
    {
        return m_value;
    }

    /**
     * setValue set value of node
     * @param value the value of node.
     */
    public void setValue(int value)
    {
        m_value = value;
    }

    /**
     * getNext return next node of the node
     * @return next node of the node.
     */
    public DNode getNext()
    {
        return m_next;
    }

    /**
     * setNext set next node of the node
     * @param next next node of node.
     */
    public void setNext(DNode next)
    {
        m_next = next;
    }

    /**
     * getPrev return previous node of the node
     * @return previous node of the node.
     */
    public DNode getPrev()
    {
        return m_prev;
    }

    /**
     * setPrev set previous node of the node
     * @param prev previous node of node.
     */
    public void setPrev(DNode prev)
    {
        m_prev = prev;
    }

    /**
     * getRed return the value of red
     * @return the value of red.
     */
    public short getRed()
    {
        return m_red;
    }

    /**
     * getGreen return the value of green
     * @return the value of green.
     */
    public short getGreen()
    {
        return m_green;
    }

    /**
     * getBlue return the value of blue
     * @return the value of blue.
     */
    public short getBlue()
    {
        return m_blue;
    }
}
