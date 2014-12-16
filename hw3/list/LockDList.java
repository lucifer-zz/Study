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

    @Override
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

    @Override
    protected DListNode newNode(Object item, DListNode prev, DListNode next) {
        return new LockDListNode(item, prev, next);
    }


}
