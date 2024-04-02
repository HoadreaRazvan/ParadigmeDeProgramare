public class Main {
    public static void main(String[] args) {
        //IntCalculator calculator = new IntCalculator(10);
        //int result = calculator.add(5).subtract(3).multiply(2).result();
        //System.out.println("a) " + result);

        //AdvancedCalculator advancedCalculator = new AdvancedCalculator(10);
        //int result2 = advancedCalculator.divide(4).power(2).root(2).result();
        //System.out.println("b) "+result2);

        NewIntCalculator newIntCalculator = new NewIntCalculator(10);
        Object result3 = newIntCalculator.add(5).subtract(3).multiply(2).result();
        System.out.println("c) "+((NewIntCalculator)result3).getResult());

        DoubleCalculator doubleCalculator = new DoubleCalculator(10.0);
        Object result4 = doubleCalculator.add(5.0).subtract(3.3).multiply(2.2).result();
        System.out.println("d) "+((DoubleCalculator)result4).getResult());


        Calculator<Integer> calculator = new Calculator<Integer>(10);
        Object result5 = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("e) "+((Calculator<Integer>)result5).getResult());
    }
}