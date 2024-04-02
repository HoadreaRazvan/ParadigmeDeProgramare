public class Calculator<T extends Number> extends ACalculator<Integer> {

    private T result;
    public Calculator(T number)
    {
        this.result=number;
        this.init();
    }

    public Calculator<T> add(Integer number)
    {
        this.state += number;
        return this;
    }
    public Calculator<T> subtract(T number)
    {
        this.result.doubleValue()-=number.doubleValue();
        return this;
    }
    public Calculator<T> multiply(T number)
    {
        this.result*=number;
        return this;
    }

    @Override
    protected void init() {
        super.state= this;
    }

    public T getResult() {
        return result;
    }
}