public class AdvancedCalculator extends IntCalculator{
    public AdvancedCalculator(int result)
    {
        super(result);
    }
    public AdvancedCalculator root(int number)
    {
        super.result = (int)Math.pow(super.result,1.0/number);
        return this;
    }
    public AdvancedCalculator divide(int number)
    {
        super.result = super.result/number;
        return this;
    }
    public AdvancedCalculator power(int number)
    {
        super.result = (int)Math.pow(super.result,number);
        return this;
    }

    public int result() {
        return super.result();
    }
}
