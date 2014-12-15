package list;

/**
 * Created by ShaNa on 2014/12/14.
 */
public class LockDList extends DList {

    public void lockNode(DListNode node)
    {
        if(node != null)
        {
            if(node instanceof LockDListNode)
            {
              ((LockDListNode) node).m_lock = true;
            }
        }
    }

    public void remove(DListNode node)
    {
        if(node != null)
        {
            if(node instanceof LockDListNode)
            {
                if(((LockDListNode) node).m_lock == false)
                {
                    super.remove(node);
                }
                else
                {
                    System.out.println("node is locked.");
                }

            }
        }

    }

    protected LockDListNode newLockNode(Object item, DListNode prev, DListNode next) {
        return new LockDListNode(item, prev, next);
    }

    public void insertFront(Object item) {
        // Your solution here.
        LockDListNode newnode = newLockNode(item, head, head.next);
        head.next.prev = newnode;
        head.next = newnode;
        size++;
    }

    /**
     *  insertBack() inserts an item at the back of this DList.
     *  @param item is the item to be inserted.
     *  Performance:  runs in O(1) time.
     */
    public void insertBack(Object item) {
        // Your solution here.
        LockDListNode newnode = newLockNode(item, head.prev, head);
        head.prev.next = newnode;
        head.prev = newnode;
        size++;
    }

    public void insertAfter(Object item, DListNode node) {
        // Your solution here.
        if(node != null)
        {
            LockDListNode newnode = newLockNode(item, node, node.next);
            node.next.prev = newnode;
            node.next = newnode;
            size++;
        }
    }

    /**
     *  insertBefore() inserts an item in this DList immediately before "node".
     *  If "node" is null, do nothing.
     *  @param item the item to be inserted.
     *  @param node the node to insert the item before.
     *  Performance:  runs in O(1) time.
     */
    public void insertBefore(Object item, DListNode node) {
        // Your solution here.
        if(node != null)
        {
            LockDListNode newnode = newLockNode(item, node.prev, node);
            node.prev.next = newnode;
            node.prev = newnode;
            size++;
        }
    }
}
