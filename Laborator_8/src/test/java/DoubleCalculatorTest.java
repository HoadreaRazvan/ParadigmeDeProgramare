import org.example.DoubleCalculator;
import org.example.NewIntCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOError;
import java.io.IOException;

public class DoubleCalculatorTest {

    private DoubleCalculator doubleCalculator;

    @BeforeEach
    public void setup() {
       this.doubleCalculator=new DoubleCalculator(0);
    }

    @Test
    public void addTest()
    {
        double s=0;
        for(int i=0;i<5;i++)
        Assertions.assertTrue((s=s+i)==(Double)doubleCalculator.add(i).result());

        Assertions.assertEquals((Double)doubleCalculator.result(),s);
        Assertions.assertFalse((Double)doubleCalculator.result()-1==s);
    }

    @Test
    public void subtractTest()
    {
        double s=0;
        for(int i=0;i<5;i++)
            Assertions.assertTrue((s=s-i)==(Double)doubleCalculator.subtract(i).result());

        Assertions.assertEquals((Double)doubleCalculator.result(),s);
        Assertions.assertFalse((Double)doubleCalculator.result()-1==s);
    }

    @Test
    public void multiplyTest()
    {
        doubleCalculator.add(1);
        double s=0;
        for(int i=0;i<5;i++)
            Assertions.assertTrue((s=s*i)==(Double)doubleCalculator.multiply(i).result());

        Assertions.assertEquals((Double)doubleCalculator.result(),s);
        Assertions.assertFalse((Double)doubleCalculator.result()-1==s);
    }

    @Test
    public void divideTest()
    {
        doubleCalculator.add(10);
        doubleCalculator.divide(2);
        Assertions.assertTrue(5==(Double)doubleCalculator.result());

        doubleCalculator.divide(5);
        Assertions.assertTrue(1==(Double)doubleCalculator.result());
    }

    @Test
    public void divideByZeroTest()
    {
        doubleCalculator.add(10);

//        Exception exception =
//                Assertions.assertThrows(Exception.class, () -> {
//                    doubleCalculator.divide(0);
//
//                });
//        Assertions.assertFalse(exception instanceof ArithmeticException);

//        Assertions.assertTrue((Double)doubleCalculator.result()==Double.POSITIVE_INFINITY);

    }

}
