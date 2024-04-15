public class Calculator<T extends Number> extends ACalculator {

    private T result;

    public Calculator(T number) {
        this.result = number;
        this.init();
    }

    public Calculator add(T number) {
        result = (T) addNumbers(result, number);
        return this;
    }

    public Calculator subtract(T number) {
        result = (T) subtractNumbers(result, number);
        return this;
    }

    public Calculator multiply(T number) {
        result = (T) multiplyNumbers(result, number);
        return this;
    }

    @Override
    protected void init() {
        super.state = this;
    }

    public T getResult() {
        return result;
    }

    private Number addNumbers(T num1, T num2) {
        if (num1 instanceof Integer) {
            return num1.intValue() + num2.intValue();
        } else if (num1 instanceof Double) {
            return num1.doubleValue() + num2.doubleValue();
        } else if (num1 instanceof Float) {
            return num1.floatValue() + num2.floatValue();
        } else if (num1 instanceof Long) {
            return num1.longValue() + num2.longValue();
        } else if (num1 instanceof Short) {
            return num1.shortValue() + num2.shortValue();
        } else if (num1 instanceof Byte) {
            return num1.byteValue() + num2.byteValue();
        }
        return 0;
    }

    private Number subtractNumbers(T num1, T num2) {
        if (num1 instanceof Integer) {
            return num1.intValue() - num2.intValue();
        } else if (num1 instanceof Double) {
            return num1.doubleValue() - num2.doubleValue();
        } else if (num1 instanceof Float) {
            return num1.floatValue() - num2.floatValue();
        } else if (num1 instanceof Long) {
            return num1.longValue() - num2.longValue();
        } else if (num1 instanceof Short) {
            return num1.shortValue() - num2.shortValue();
        } else if (num1 instanceof Byte) {
            return num1.byteValue() - num2.byteValue();
        }
        return 0;
    }

    private Number multiplyNumbers(T num1, T num2) {
        if (num1 instanceof Integer) {
            return num1.intValue() * num2.intValue();
        } else if (num1 instanceof Double) {
            return num1.doubleValue() * num2.doubleValue();
        } else if (num1 instanceof Float) {
            return num1.floatValue() * num2.floatValue();
        } else if (num1 instanceof Long) {
            return num1.longValue() * num2.longValue();
        } else if (num1 instanceof Short) {
            return num1.shortValue() * num2.shortValue();
        } else if (num1 instanceof Byte) {
            return num1.byteValue() * num2.byteValue();
        }
        return 0;
    }
}
