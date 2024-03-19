public class Main {
    public static void main(String[] args) {

        Triangle tri = new Triangle(1.1f, 2.0f,"Black");
        Circle c = new Circle(1.5f,"Blue");
        Square sq = new Square(1.2f,"Red");
        System.out.println("Triangle area = " + tri.getArea()+" details: " + tri);
        System.out.println("Circle area = " + c.getArea() + " details: " + c);
        System.out.println("Square area = " + sq.getArea() + " details: " + sq);
        Triangle tri2 = new Triangle(1.1f, 2.0f,"Red");
        System.out.println("Triangle2 equals to Triangle1: " + tri.equals(tri2));

        System.out.println("S-au creat " + Form.getCounter()+" instante.");

    }
}