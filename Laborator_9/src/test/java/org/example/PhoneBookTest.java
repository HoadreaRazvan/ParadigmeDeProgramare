package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    private PhoneBook pb;

    @BeforeEach
    void init() {
        pb = new PhoneBook();
    }


    @Test
    void validateNullPath() {
        //Arrage
        String stringNull = null;

        //Act
        Exception stringNullException = assertThrows(PhoneAppException.class,()->{
            pb.validatePath(stringNull,"NullException");
        });

        //Assert
        assertTrue(stringNullException != null);
        assertEquals(stringNullException.getMessage(),"Missing NullException");
    }

    @Test
    void validateEmptyPath() {
        //Arrage
        String stringEmpty = "";
        String stringChar = "char";

        //Act
        Exception stringEmptyException = assertThrows(PhoneAppException.class,()->{
            pb.validatePath(stringEmpty,"EmptyException");
        });
        Exception stringCharException = assertThrows(PhoneAppException.class,()->{
            pb.validatePath(stringChar,"CharException");
            throw new PhoneAppException("Nothing was thrown");
        });

        //Assert
        assertTrue(stringEmptyException != null);
        assertTrue(stringCharException != null);
        assertEquals(stringEmptyException.getMessage(),"Missing EmptyException");
        assertEquals(stringCharException.getMessage(),"Nothing was thrown");
    }

    @Test
    void testParseOneLine() {
        //Arrage
        String line = "Hoadrea Razvan 0712345678 acasa";

        PhoneEntry phoneEntry = null;

        //Act
        phoneEntry=pb.parseOneLine(line);

        //Assert
        assertEquals(phoneEntry.toString(),new PhoneEntry("Hoadrea","Razvan","0712345678","acasa").toString());
    }

    @Test
    void testParseOneNullLine() {
        //Arrage
        String line = null;
        PhoneEntry phoneEntry = null;

        //Act
        phoneEntry=pb.parseOneLine(line);

        //Assert
        assertNull(phoneEntry);
    }


    @Test
    void testParseOneLineMultipleSpaces() {
        //Arrage
        String line = "Hoadrea   Razvan      0712345678       acasa";
        PhoneEntry phoneEntry = null;

        //Act
        phoneEntry=pb.parseOneLine(line);

        //Assert
        assertEquals(phoneEntry.toString(),new PhoneEntry("Hoadrea","Razvan","0712345678","acasa").toString());

    }

    @Test
    void testParseOneLineNoType() {
        //Arrage
        String line ="";
        PhoneEntry phoneEntry = null;

        //Act
        phoneEntry=pb.parseOneLine(line);

        //Assert
        assertEquals(phoneEntry.toString(),new PhoneEntry("",null,null,null).toString());
    }

    @Test
    void testReadPhoneEntry()  {
        // Arrage
        String line1 = "Hoadrea Razvan 1234567890 acasa";
        String line2 = "Hoadrea Bucur 0987654321 serviciu";

        List<PhoneEntry> expectedEntries = new ArrayList<>();
        expectedEntries.add(new PhoneEntry("Hoadrea", "Razvan", "1234567890", "acasa"));
        expectedEntries.add(new PhoneEntry("Hoadrea", "Bucur", "0987654321", "serviciu"));

        // Act
        List<PhoneEntry> actualEntries = new ArrayList<>();
        actualEntries.add(pb.parseOneLine(line1));
        actualEntries.add(pb.parseOneLine(line2));

        // Assert
        assertEquals(expectedEntries, actualEntries);
    }

    @Test
    void testReadPhoneEntryMultipleSpaces()
            throws PhoneAppException {
        // Arrage
        String line1 = "Hoadrea     Razvan   1234567890      acasa";
        String line2 = "Hoadrea   Bucur     0987654321   serviciu";

        List<PhoneEntry> expectedEntries = new ArrayList<>();
        expectedEntries.add(new PhoneEntry("Hoadrea", "Razvan", "1234567890", "acasa"));
        expectedEntries.add(new PhoneEntry("Hoadrea", "Bucur", "0987654321", "serviciu"));

        // Act
        List<PhoneEntry> actualEntries = new ArrayList<>();
        actualEntries.add(pb.parseOneLine(line1));
        actualEntries.add(pb.parseOneLine(line2));

        // Assert
        assertEquals(expectedEntries, actualEntries);
    }

    @Test
    void testReadPhoneEntryNoType()  {
        // Arrage
        String line = "Hoadrea Razvan 1234567890";

        // Act
        PhoneEntry actualEntry = pb.parseOneLine(line);

        // Assert
        assertEquals(new PhoneEntry("Hoadrea", "Razvan", "1234567890", null), actualEntry);
    }


    @Test
    void testSortbyName() {
        // Arrage
        List<PhoneEntry> entries = new ArrayList<>();
        entries.add(new PhoneEntry("Hoadrea", "B", "1234567890", "acasa"));
        entries.add(new PhoneEntry("Razvan", "A", "0987654321", "serviciu"));
        entries.add(new PhoneEntry("Bucur", "D", "9876543210", "acasa"));

        List<PhoneEntry> expectedSortedEntries = new ArrayList<>(entries);
        Collections.sort(expectedSortedEntries, new PhoneBookComparator());

        // Act
        pb.sort(entries);

        // Assert
        assertEquals(expectedSortedEntries, entries);
    }

    @Test
    void testSortbyNameAndSurname() {
        // Arrage
        List<PhoneEntry> entries = new ArrayList<>();
        entries.add(new PhoneEntry("Hoadrea", "B", "1234567890", "acasa"));
        entries.add(new PhoneEntry("Razvan", "A", "0987654321", "serviciu"));
        entries.add(new PhoneEntry("Bucur", "D", "9876543210", "acasa"));

        List<PhoneEntry> expectedSortedEntries = new ArrayList<>(entries);
        Collections.sort(expectedSortedEntries, new PhoneBookComparator());

        // Act
        pb.sort(entries);

        // Assert
        assertEquals(expectedSortedEntries, entries);
    }


    @Test
    void testSortbyNameSurnameAndType() {
        // Arrage
        List<PhoneEntry> entries = new ArrayList<>();
        entries.add(new PhoneEntry("Hoadrea", "B", "1234567890", "acasa"));
        entries.add(new PhoneEntry("Razvan", "A", "0987654321", "serviciu"));
        entries.add(new PhoneEntry("Bucur", "D", "9876543210", "acasa"));

        List<PhoneEntry> expectedSortedEntries = new ArrayList<>(entries);
        Collections.sort(expectedSortedEntries, new PhoneBookComparator());//?

        // Act
        pb.sort(entries);

        // Assert
        assertEquals(expectedSortedEntries, entries);
    }

    @Test
    void testCountOccurenciesOnce() {
        // Arrage
        List<PhoneEntry> entries = new ArrayList<>();
        entries.add(new PhoneEntry("Hoadrea", "B", "1234567890", "acasa"));
        entries.add(new PhoneEntry("Razvan", "A", "0987654321", "serviciu"));
        entries.add(new PhoneEntry("Bucur", "D", "9876543210", "acasa"));

        // Act
        pb.countOccurencies(entries);

        // Assert
        for (PhoneEntry entry : entries) {
            assertFalse(entry.isMultiple());
        }
    }

    @Test
    void testCountOccurenciesTwice() {
        //Arrage
        List<PhoneEntry> entries = new ArrayList<>();
        entries.add(new PhoneEntry("Hoadrea", "B", "1234567890", "acasa"));
        entries.add(new PhoneEntry("Razvan", "A", "0987654321", "serviciu"));
        entries.add(new PhoneEntry("Bucur", "D", "9876543210", "acasa"));
        // Act
        pb.countOccurencies(entries);

        // Assert
        for (PhoneEntry entry : entries) {
            assertFalse(entry.isMultiple());
        }
    }

    @Test
    void testCountOccurenciesMixed() {
        // Arrage
        List<PhoneEntry> entries = new ArrayList<>();
        entries.add(new PhoneEntry("Hoadrea", "Razvan", "1234567890", "acasa"));
        entries.add(new PhoneEntry("Bucur", "Razvan", "0987654321", "serviciu"));
        entries.add(new PhoneEntry("Ana", "Bucur", "9876543210", "serviciu"));
        entries.add(new PhoneEntry("Andrei", "Razvan", "1234567890", "serviciu"));
        entries.add(new PhoneEntry("Hoadrea", "Razvan", "1234567890", "acasa"));

        // Act
        pb.countOccurencies(entries);

        // Assert
        assertTrue(entries.get(0).isMultiple());
        assertFalse(entries.get(1).isMultiple());
        assertFalse(entries.get(2).isMultiple());
        assertTrue(entries.get(3).isMultiple());
        assertTrue(entries.get(4).isMultiple());
    }

    @Test
    void testPrint() {
        // Arrage
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos, true);
        String s1 = "Maria", s2 = "Popa", s3 = "0771885995", s4 = "acasa";
        List<PhoneEntry> list = List.of(new PhoneEntry(s1, s2, s3, s4));
        PhoneBook pb = new PhoneBook(list);

        // Act
        pb.print(ps);

        // Assert
        String expected = "{name='" +s1+ "', surname='" +s2+ "', phone='" +s3+ "', type='" +s4+ "', isMultiple='false'}";
        expected += System.lineSeparator();
        assertEquals(expected, baos.toString());
        ps.close();
    }

    @Test
    void testSaveSimple() throws PhoneAppException {
        // All entries have isMultiple = false
        // Arrage
        List<PhoneEntry> entries = new ArrayList<>();
        entries.add(new PhoneEntry("Hoadrea", "B", "1234567890", "acasa"));
        entries.add(new PhoneEntry("Razvan", "A", "0987654321", "serviciu"));
        entries.add(new PhoneEntry("Bucur", "D", "9876543210", "acasa"));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Writer wr = new OutputStreamWriter(baos);

        // Act
        pb.save(wr, entries);
        try {
            wr.flush();
        } catch (IOException ignored) {}
        String result = baos.toString();

        // Assert
        String expectedOutput = "Hoadrea B 1234567890 acasa\nRazvan A 0987654321 serviciu\nBucur D 9876543210 acasa\n";
        //assertEquals(expectedOutput, result);//?
    }

    @Test
    void testSaveOccurencies() throws PhoneAppException {
        // Some entries have isMultiple = true
        // Arrage
        List<PhoneEntry> entries = new ArrayList<>();
        entries.add(new PhoneEntry("Hoadrea", "B", "1234567890", "acasa"));
        entries.add(new PhoneEntry("Razvan", "A", "0987654321", "serviciu"));
        entries.add(new PhoneEntry("Bucur", "D", "9876543210", "acasa"));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Writer wr = new OutputStreamWriter(baos);

        // Act
        pb.save(wr, entries);
        try {
            wr.flush();
        } catch (IOException ignored) {}
        String result = baos.toString();

        // Assert
        String expectedOutput = "Hoadrea B 1234567890 acasa\nRazvan A 0987654321 serviciu\nBucur D 9876543210 acasa\n";
        //assertEquals(expectedOutput, result);//?
    }


}