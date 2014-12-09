/**
 * Created by ShaNa on 2014/11/29.
 */

/**
 *  The DoubleLinkedList class represents a double-linked list, include basic operation of
 *  double linked list. It includes header and tailer, two sentinels, which could help improve
 *  operation performance.
 *
 */
public class DoubleLinkedList {

    //here are class attributes of class
    private DNode m_header, m_tailer;
    // m_size will be used for getSize operation
    private long m_size;

    /**
     * DoubleLinkedList() default constructor, constructs a list with header and tailer only.
     */
    public DoubleLinkedList()
    {
        m_header = new DNode();
        m_tailer = new DNode();
        m_header.setNext(m_tailer);
        m_tailer.setPrev(m_header);
        m_size = 0;
    }

    /**
     * getDoubleLinkedListSize return size of the list
     * function will calculate whole list once it is called.
     * it will change solution lately, return size directly.
     * @return size of the list.
     */
    public long getDoubleLinkedListSize()
    {
        long size = 0;
        DNode curnode = m_header;
        while(curnode.getNext() != m_tailer)
        {
            size++;
            curnode = curnode.getNext();
        }
        return size;
    }

    /**
     * IsEmpty return the status of list, empty of not
     * @return true if it is empty.
     */
    public boolean IsEmpty()
    {
        return (getDoubleLinkedListSize() == 0);
    }

    /**
     * getFirst return the first node of the list, the node after header
     * @return the first node of the list
     */
    public DNode getFirst()
    {
        if(IsEmpty())
        {
            System.out.println("List is Empty");
            return null;
            //throw new IllegalStateException("List is Empty");
        }
        return m_header.getNext();
    }

    /**
     * getHeader return the header node of the list
     * @return the header node of the list
     */
    public DNode getHeader()
    {
        return m_header;
    }

    /**
     * getLast return the last node of the list, the node before tailer
     * @return the last node of the list
     */
    public DNode getLast()
    {
        if(IsEmpty())
        {
            System.out.println("List is Empty");
            return null;
            //throw new IllegalStateException("List is Empty");
        }
        return m_tailer.getPrev();
    }

    /**
     * getTailer return the tailer node of the list
     * @return the tailer node of the list
     */
    public DNode getTailer()
    {
        return m_tailer;
    }

    /**
     * getPrev return the previous node of pointed node
     * @param node the pointed node.
     * @return previous node of pointed node
     */
    public DNode getPrev(DNode node)
    {
        if(node == m_header)
        {
            System.out.println("no node before header");
            return null;
        }

        return getPrev(node);
    }

    /**
     * getNext return the next node of pointed node
     * @param node the pointed node.
     * @return next node of pointed node
     */
    public DNode getNext(DNode node)
    {
        if(node == m_tailer)
        {
            System.out.println("no node after tailer");
            return null;
        }

        return getNext(node);
    }

    /**
     * findNode return the node with pointed value
     * @param value the pointed value.
     * @return the node with pointed value, return null if can not be found
     */
    public DNode findNode(long value)
    {
        DNode curNode = m_header.getNext();
        while(curNode != m_tailer)
        {
            if(curNode.getValue() == value)
            {
                return curNode;
            }

            curNode = curNode.getNext();
        }

        return null;
    }

    /**
     * removeNode return the result of remove operation
     * @param node the pointed node which will be removed.
     * @return the result of remove operation
     */
    public int removeNode(DNode node)
    {
        if((node == m_header)||(node == m_tailer))
            return 1;
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        node.setNext(null);
        node.setPrev(null);
        return 0;
    }
    /*
    public int removeNode(DNode node)
    {
        DNode curNode = m_header.getNext();
        while(curNode != m_tailer)
        {
            if(node == curNode)
            {
                curNode.getPrev().setNext(curNode.getNext());
                curNode.getNext().setPrev(curNode.getPrev());
                return 0;
            }

            curNode = curNode.getNext();
        }

        return 1;
    }
*/

    /**
     * addFirst add a node at front of the list
     * @param node the pointed node which will be added.
     */
    public void addFirst(DNode node)
    {
        addAfter(m_header, node);
    }

    /**
     * addFirst add a node at end of the list
     * @param node the pointed node which will be added.
     */
    public void addLast(DNode node)
    {
        addBefore(m_tailer, node);
    }

    /**
     * addAfter add a node after the pointed node
     * @param oldnode the pointed node
     * @param newnode the node which will be added.
     */
    public void addAfter(DNode oldnode, DNode newnode)
    {
        if(oldnode == m_tailer)
        {
            System.out.println("Can not add node after tailer sentinel");
            return;
        }
        newnode.setNext(oldnode.getNext());
        oldnode.getNext().setPrev(newnode);
        oldnode.setNext(newnode);
        newnode.setPrev(oldnode);
    }

    /**
     * addBefore add a node before the pointed node
     * @param oldnode the pointed node
     * @param newnode the node which will be added.
     */
    public void addBefore(DNode oldnode, DNode newnode)
    {
        if(oldnode == m_header)
        {
            System.out.println("Can not add node before header sentinel");
            return;
        }

        newnode.setPrev(oldnode.getPrev());
        oldnode.getPrev().setNext(newnode);
        newnode.setNext(oldnode);
        oldnode.setPrev(newnode);
    }
}
