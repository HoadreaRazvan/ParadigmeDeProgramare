public class IntCalculator {
    protected int result;
    public IntCalculator(int result)
    {
        this.result=result;
    }

    public IntCalculator add(int number)
    {
        this.result+=number;
        return this;
    }
    public IntCalculator subtract(int number)
    {
        this.result-=number;
        return this;
    }
    public IntCalculator multiply(int number)
    {
        this.result*=number;
        return this;
    }


    public int result() {
        return this.result;
    }

}
