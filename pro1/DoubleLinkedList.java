/**
 * Created by ShaNa on 2014/11/29.
 */
public class DoubleLinkedList {

    private DNode m_header, m_tailer;
    private long m_size;

    public DoubleLinkedList()
    {
        m_header = new DNode();
        m_tailer = new DNode();
        m_header.setNext(m_tailer);
        m_tailer.setPrev(m_header);
        m_size = 0;
    }

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

    public boolean IsEmpty()
    {
        return (getDoubleLinkedListSize() == 0);
    }

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

    public DNode getHeader()
    {
        return m_header;
    }
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

    public DNode getTailer()
    {
        return m_tailer;
    }

    public DNode getPrev(DNode node)
    {
        if(node == m_header)
        {
            System.out.println("no node before header");
            return null;
        }

        return getPrev(node);
    }

    public DNode getNext(DNode node)
    {
        if(node == m_tailer)
        {
            System.out.println("no node after tailer");
            return null;
        }

        return getNext(node);
    }

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
    public void addFirst(DNode node)
    {
        addAfter(m_header, node);
    }

    public void addLast(DNode node)
    {
        addBefore(m_tailer, node);
    }

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
