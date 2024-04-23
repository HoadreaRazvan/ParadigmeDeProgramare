import org.example.DoubleCalculator;
import org.example.NewIntCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewIntCalculatorTest {

    private NewIntCalculator newIntCalculator;

    @BeforeEach
    public void setup() {
        this.newIntCalculator=new NewIntCalculator(0);
    }

    @Test
    public void addTest()
    {
        int s=0;
        for(int i=0;i<5;i++)
            Assertions.assertTrue((s=s+i)==(Integer)newIntCalculator.add(i).result());

        Assertions.assertEquals((Integer)newIntCalculator.result(),s);
        Assertions.assertFalse((Integer)newIntCalculator.result()-1==s);
    }

    @Test
    public void subtractTest()
    {
        int s=0;
        for(int i=0;i<5;i++)
            Assertions.assertTrue((s=s-i)==(Integer)newIntCalculator.subtract(i).result());
        Assertions.assertEquals((Integer)newIntCalculator.result(),s);
        Assertions.assertFalse((Integer)newIntCalculator.result()-1==s);
    }

    @Test
    public void multiplyTest()
    {
        newIntCalculator.add(1);
        int s=0;
        for(int i=0;i<5;i++)
            Assertions.assertTrue((s=s*i)==(Integer)newIntCalculator.multiply(i).result());
        Assertions.assertEquals((Integer)newIntCalculator.result(),s);
        Assertions.assertFalse((Integer)newIntCalculator.result()-1==s);
    }


    @Test
    public void divideTest()
    {
        newIntCalculator.add(10);
        newIntCalculator.divide(2);
        Assertions.assertTrue(5==(Integer)newIntCalculator.result());

        newIntCalculator.divide(5);
        Assertions.assertTrue(1==(Integer)newIntCalculator.result());
    }

    @Test
    public void divideByZeroTest()
    {
        newIntCalculator.add(10);

//        Exception exception =
//                Assertions.assertThrows(Exception.class, () -> {
//                    doubleCalculator.divide(0);
//
//                });
//        Assertions.assertFalse(exception instanceof ArithmeticException);

//        Assertions.assertTrue((Double)doubleCalculator.result()==Double.POSITIVE_INFINITY);

    }
}
