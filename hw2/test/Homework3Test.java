import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Homework3Test {

    private Homework3 hw3;
    @Before
    public void setUp() throws Exception {
        hw3 = new Homework3();
    }

    //test case: {}, {1}, {0,0}, {1,0,1}, {0,0,1,1,2,0,0},{1,0,0,0}
    @Test
    public void testSmoosh() throws Exception {
        int[] test0 = {};
        int[] test0r = {};
        int[] test1 = {1};
        int[] test1r = {1};
        int[] test2 = {0, 0};
        int[] test2r = {0, -1};
        int[] test3 = {1, 0, 1};
        int[] test3r = {1, 0, 1};
        int[] test4 = {0,0,1,1,2,0,0};
        int[] test4r = {0, 1, 2, 0, -1, -1, -1};
        int[] test5 = {1,0,0,0};
        int[] test5r = {1,0, -1, -1};

        hw3.smoosh(test0);
        assertArrayEquals(test0, test0r);

        hw3.smoosh(test1);
        assertArrayEquals(test1, test1r);

        hw3.smoosh(test2);
        assertArrayEquals(test2, test2r);

        hw3.smoosh(test3);
        assertArrayEquals(test3, test3r);

        hw3.smoosh(test4);
        assertArrayEquals(test4, test4r);

        hw3.smoosh(test5);
        assertArrayEquals(test5, test5r);

    }
}