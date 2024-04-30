package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookComparatorTest {

    @Test
    void testCompareForName() {
        PhoneBookComparator pbc = new PhoneBookComparator();
        PhoneEntry p1 = new PhoneEntry("Abc", "mm", "123", "ooo");
        PhoneEntry p2 = new PhoneEntry("Ghi", "mm", "123", "ooo");

        int result1 = pbc.compare(p1, p2);
        int result2 = pbc.compare(p2, p1);

        assertTrue( result1 < 0, "Comparator for name not working");
        assertTrue(result2 > 0,"Comparator for name not working");
    }

    @Test
    void testCompareForSurname() {
        PhoneBookComparator pbc = new PhoneBookComparator();
        PhoneEntry p1 = new PhoneEntry("Abc", "aa", "123", "ooo");
        PhoneEntry p2 = new PhoneEntry("Abc", "mm", "123", "ooo");

        int result1 = pbc.compare(p1, p2);
        int result2 = pbc.compare(p2, p1);


        assertTrue( result1 < 0, "Comparator for surname not working");
        assertTrue(result2 > 0,"Comparator for surname not working");
    }

    @Test
    void testCompareForType() {
        PhoneBookComparator pbc = new PhoneBookComparator();
        PhoneEntry p1 = new PhoneEntry("Abc", "aa", "123", "aaa");
        PhoneEntry p2 = new PhoneEntry("Abc", "aa", "456", "ooo");

        int result1 = pbc.compare(p1, p2);
        int result2 = pbc.compare(p2, p1);

        assertTrue( result1 < 0, "Comparator for type not working");
        assertTrue(result2 > 0,"Comparator for type not working");
    }

    @Test
    void testComparatorEquals() {
        //note: comparator ignores the phone values.
        PhoneBookComparator pbc = new PhoneBookComparator();
        PhoneEntry p1 = new PhoneEntry("Ghi", "mm", "123", "ooo");
        PhoneEntry p2 = new PhoneEntry("Ghi", "mm", "456", "ooo");

        int result1 = pbc.compare(p1, p2);
        int result2 = pbc.compare(p2, p1);

        assertTrue( result1 == 0, "Comparator for equal not working");
        assertTrue(result2 == 0,"Comparator for equal not working");
    }
}