public class Main {
    public static void main(String[] args)
    {
        SimpleChained simpleChained = new SimpleChained();
        simpleChained.add(5);
        simpleChained.add(4);
        simpleChained.add(3);
        simpleChained.add(2);
        simpleChained.add(1);

        simpleChained.show();

        //System.out.println(simpleChained.getSize());

        //simpleChained.remove(1);
        //simpleChained.show();

        simpleChained.sort1(simpleChained.getFirst());
        simpleChained.show();


    }
}