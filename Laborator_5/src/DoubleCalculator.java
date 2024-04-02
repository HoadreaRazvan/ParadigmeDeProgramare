public class DoubleCalculator extends ACalculator
{
    private Double result;
    public DoubleCalculator(Double number)
    {
        this.result=number;
        this.init();
    }

    public DoubleCalculator add(Double number)
    {
        this.result+=number;
        return this;
    }
    public DoubleCalculator subtract(Double number)
    {
        this.result-=number;
        return this;
    }
    public DoubleCalculator multiply(Double number)
    {
        this.result*=number;
        return this;
    }

    @Override
    protected void init() {
        super.state= this;
    }

    public Double getResult() {
        return result;
    }
}
