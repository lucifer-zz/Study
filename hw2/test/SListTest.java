import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SListTest {

    private SList testList, testSingleElemList, testNullList;
    @Before
    //case1: 1->1->1->3->4->5->5->5->5->9
    //case2: 1

    public void setUp() throws Exception {
        testList = new SList();
        testNullList = new SList();
        testSingleElemList = new SList();

        testList.insertFront(1);
        testList.insertEnd(1);
        testList.insertEnd(1);
        testList.insertEnd(3);
        testList.insertEnd(4);
        testList.insertEnd(5);
        testList.insertEnd(5);
        testList.insertEnd(5);
        testList.insertEnd(5);
        testList.insertEnd(9);

        testSingleElemList.insertFront(1);
    }

    @Test
    public void testSquish() throws Exception {

        SList testListr = new SList();
        testListr.insertFront(1);
        testListr.insertEnd(3);
        testListr.insertEnd(4);
        testListr.insertEnd(5);
        testListr.insertEnd(9);

        SList testSingleElemListr = new SList();
        testSingleElemListr.insertFront(1);

        testList.squish();
        testNullList.squish();
        testSingleElemList.squish();

        //assertEquals(testList.length(), testListr.length());
        for(int i = 0; i< testListr.length(); i++)
        {
            assertEquals(testListr.nth(i), testList.nth(i));
        }

        assertNull(testNullList.nth(0));

        assertEquals(testSingleElemListr.nth(0), testSingleElemList.nth(0));
    }

    @Test
    public void testTwin() throws Exception {

    }
}