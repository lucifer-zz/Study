package list;

/**
 * Created by ShaNa on 2014/12/14.
 */
public class LockDListNode extends DListNode {

    protected boolean m_lock;


    public LockDListNode(Object i, DListNode p, DListNode n)
    {
        super(i, p, n);
        m_lock = false;
    }


}
