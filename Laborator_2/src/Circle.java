public class Circle extends Form
{
    private float radius;

    public Circle(){}

    public Circle(float radius,String color)
    {
        super(color);
        this.radius=radius;
    }

    @Override
    public float getArea() {
        return 3.1415f*radius*radius;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
