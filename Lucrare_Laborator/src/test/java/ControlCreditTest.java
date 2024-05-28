import org.example.ControlCredit;
import org.example.Credit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class ControlCreditTest {

    private ControlCredit controlCredit;

    @BeforeEach
    public void setup() {
        this.controlCredit=new ControlCredit();
    }

    @Test
    public void cautareDataTest()
    {
        controlCredit.adaugareOperatie("1.1.2000 test 12");

        ArrayList<Credit> cautare = controlCredit.cautareData("1.1.2000");
        ArrayList<Credit> cautare1 = controlCredit.cautareData("1.1.202300");


        Assertions.assertTrue(cautare.size()==1);
        Assertions.assertTrue(cautare1.size()==0);
    }

    @Test
    public void cautareDescriereTest()
    {
        controlCredit.adaugareOperatie("1.1.2000 abonamente_tesst 12");

        ArrayList<Credit> cautare = controlCredit.cautareDescriere("abonamente");
        ArrayList<Credit> cautare1 = controlCredit.cautareDescriere("abonamente1");

        Assertions.assertTrue(cautare.size()==1);
        Assertions.assertTrue(cautare1.size()==0);
    }


    @Test
    public void cautareSumaTest()
    {
        controlCredit.adaugareOperatie("1.1.2000 abonamente_tesst 12");

        ArrayList<Credit> cautare = controlCredit.cautareSume(12);
        ArrayList<Credit> cautare1 = controlCredit.cautareSume(21);

        Assertions.assertTrue(cautare.size()==1);
        Assertions.assertTrue(cautare1.size()==0);
    }
}
