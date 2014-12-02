/**
 * Created by ShaNa on 2014/11/29.
 */
public class DNode {
    private int m_value;
    private short m_red, m_green, m_blue;
    private DNode m_next, m_prev;

    public DNode()
    {
        m_value = -1;
        m_next = null;
        m_prev = null;
    }
    public DNode(int value, short red, short green, short blue, DNode next, DNode prev)
    {
        m_value = value;
        m_red = red;
        m_green = green;
        m_blue = blue;
        m_next = next;
        m_prev = prev;
    }

    public int getValue()
    {
        return m_value;
    }

    public void setValue(int value)
    {
        m_value = value;
    }

    public DNode getNext()
    {
        return m_next;
    }

    public void setNext(DNode next)
    {
        m_next = next;
    }

    public DNode getPrev()
    {
        return m_prev;
    }

    public void setPrev(DNode prev)
    {
        m_prev = prev;
    }

    public short getRed()
    {
        return m_red;
    }

    public short getGreen()
    {
        return m_green;
    }

    public short getBlue()
    {
        return m_blue;
    }
}
