import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {

    private Date date1, date2;

    @Before
    public void setUp() throws Exception {
        date1 = new Date(11,12,2012);
        date2 = new Date("5/24/2017");
    }

    @Test
    public void testIsLeapYear() throws Exception {
        assertFalse(Date.isLeapYear(date2.getYear()));
        assertTrue(Date.isLeapYear(date1.getYear()));
    }

    @Test
    public void testDaysInMonth() throws Exception {
        assertEquals(28, Date.daysInMonth(2, date2.getYear()));
        assertEquals(29, Date.daysInMonth(2, date1.getYear()));
        assertEquals(31, Date.daysInMonth(1, date1.getYear()));
        assertEquals(30, Date.daysInMonth(4, date1.getYear()));

        assertEquals(0, Date.daysInMonth(13, date1.getYear()));
    }

    @Test
    public void testIsValidDate() throws Exception {

        assertTrue(Date.isValidDate(12, 12, 1234));

        assertFalse(Date.isValidDate(13, 12, 2134));
        assertFalse(Date.isValidDate(5, 39, 2913));
        assertFalse(Date.isValidDate(12, 4, 0));
        assertFalse(Date.isValidDate(12, 4, -7));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("5/24/2017", date2.toString());
    }

    @Test
    public void testIsBefore() throws Exception {
        assertTrue(date1.isBefore(date2));

        assertFalse(date2.isBefore(date1));
        assertFalse(date2.isBefore(date2));
    }

    @Test
    public void testIsAfter() throws Exception {
        assertTrue(date2.isAfter(date1));

        assertFalse(date1.isAfter(date2));
        assertFalse(date2.isAfter(date2));
    }

    @Test
    public void testDayInYear() throws Exception {
        assertEquals(317, date1.dayInYear());
        assertEquals(144, date2.dayInYear());
    }

    @Test
    public void testDifference() throws Exception {
        assertEquals(1654, date2.difference(date1));
        assertEquals(0, date2.difference(date2));
    }

    @Test
    public void testGetDay() throws Exception {
        assertEquals(24, date2.getDay());
    }

    @Test
    public void testGetMonth() throws Exception {
        assertEquals(5, date2.getMonth());
    }

    @Test
    public void testGetYear() throws Exception {
        assertEquals(2017, date2.getYear());
    }
}