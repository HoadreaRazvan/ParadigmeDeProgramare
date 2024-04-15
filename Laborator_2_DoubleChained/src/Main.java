public class Main {
    public static void main(String[] args)
    {
        DoubleChained doubleeChained = new DoubleChained();
        doubleeChained.add(5);
        doubleeChained.add(4);
        doubleeChained.add(3);
        doubleeChained.add(2);
        doubleeChained.add(1);

        doubleeChained.show();

        System.out.println(doubleeChained.getSize());

        doubleeChained.remove(1);
        doubleeChained.show();

        doubleeChained.sort();
        doubleeChained.show();
    }
}