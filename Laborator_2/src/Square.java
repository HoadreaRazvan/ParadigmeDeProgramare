public class Square extends Form
{
    private float side;

    public Square(){}

    public Square(float side,String color)
    {
        super(color);
        this.side=side;
    }

    @Override
    public float getArea() {
        return side*side;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
