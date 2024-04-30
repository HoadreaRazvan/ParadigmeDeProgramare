package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        //Arrage

        //Act

        //Assert
    }

    @Test
    void testReadPhoneEntryMultipleSpaces()
            throws PhoneAppException {
        //Arrage

        //Act

        //Assert
    }

    @Test
    void testReadPhoneEntryNoType()  {
        //Arrage

        //Act

        //Assert
    }


    @Test
    void testSortbyName() {
        //Arrage

        //Act

        //Assert
    }

    @Test
    void testSortbyNameAndSurname() {
        //Arrage

        //Act

        //Assert
    }


    @Test
    void testSortbyNameSurnameAndType() {
        //Arrage

        //Act

        //Assert
    }

    @Test
    void testCountOccurenciesOnce() {
        //Arrage

        //Act

        //Assert
    }

    @Test
    void testCountOccurenciesTwice() {
        //Arrage

        //Act

        //Assert
    }

    @Test
    void testCountOccurenciesMixed() {
        //Arrage

        //Act

        //Assert
    }

    @Test
    void testPrint() {
        //Arrage

        //Act

        //Assert
    }

    @Test
    void testSaveSimple() throws PhoneAppException{
        //all entries have isMultiple = false
        //Arrage

        //Act

        //Assert
    }

    @Test
    void testSaveOccurencies() throws PhoneAppException{
        //some entries have isMultiple = true
        //Arrage

        //Act

        //Assert
    }

}