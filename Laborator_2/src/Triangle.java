public class Triangle extends Form
{
    private float height,base;

    public Triangle(){}

    public Triangle(float height,float base,String color)
    {
        super(color);
        this.height=height;
        this.base=base;
    }

    @Override
    public float getArea() {
        return height*base/2.0f;
    }

    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
