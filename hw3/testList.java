import list.DList;
import list.DListNode;

import list.LockDList;
import list.LockDListNode;
/**
 * Created by ShaNa on 2014/12/14.
 */

public class testList {
    public static void main(String args[])
    {
        DList list = new DList();
        System.out.println("list size should be 0, in fact it is " + list.length());

        int i, size = 9;
        for(i = 0; i < size; i++)
        {
            list.insertBack(i);
        }

        System.out.println("now list info: " + list.toString());

        list.insertFront(99);
        System.out.println("now list info: " + list.toString());
        list.insertBack(909);
        System.out.println("now list info: " + list.toString());


        list.remove(null);

        size = list.length();
        System.out.println("now list length: " + size);

        Object item = 5;
        DListNode curnode = list.front();
        while(curnode != null)
        {
            if(curnode.item.equals(item))
            {
                System.out.println("we find it....");
                list.remove(curnode);
                break;
            }
            curnode = list.next(curnode);
        }
        System.out.println("now list length: " + list.length());
        System.out.println("now list info: " + list.toString());

        //LockDList test
        System.out.println("Now start locklist test....");
        LockDList locklist = new LockDList();
        System.out.println("locklist size should be 0, in fact it is " + locklist.length());

        size = 9;
        for(i = 0; i < size; i++)
        {
            locklist.insertBack(i);
        }

        System.out.println("now locklist info: " + locklist.toString());

        locklist.insertFront(99);
        System.out.println("now locklist info: " + locklist.toString());
        locklist.insertBack(909);
        System.out.println("now locklist info: " + locklist.toString());


        locklist.remove(null);

        size = locklist.length();
        System.out.println("now locklist length: " + size);


        DListNode curlocknode = locklist.front();
        while(curlocknode != null)
        {
            if(curlocknode.item.equals(item))
            {
                locklist.lockNode(curlocknode);
                break;
            }
            curlocknode = locklist.next(curlocknode);
        }
        curlocknode = locklist.front();
        while(curlocknode != null)
        {
            if(curlocknode.item.equals(item))
            {
                System.out.println("we find it....");
                locklist.remove(curlocknode);
                break;
            }
            curlocknode = locklist.next(curlocknode);
        }
        System.out.println("now locklist length: " + locklist.length());
        System.out.println("now locklist info: " + locklist.toString());
    }
}
