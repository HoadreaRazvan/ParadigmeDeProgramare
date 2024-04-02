public class NewIntCalculator extends ACalculator {

    private Integer result;
    public NewIntCalculator(Integer number)
    {
        this.result=number;
        this.init();
    }

    public NewIntCalculator add(int number)
    {
        this.result+=number;
        return this;
    }
    public NewIntCalculator subtract(int number)
    {
        this.result-=number;
        return this;
    }
    public NewIntCalculator multiply(int number)
    {
        this.result*=number;
        return this;
    }

    @Override
    protected void init() {
        super.state= this;
    }

    public Integer getResult() {
        return result;
    }
}