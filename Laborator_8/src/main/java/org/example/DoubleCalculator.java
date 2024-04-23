package org.example;

public class DoubleCalculator extends ACalculator<Double> {

    public DoubleCalculator(double state) {
        this.state = state;
    }

    protected void init() {
        state = 0.0;
    }

    public DoubleCalculator add(double value) {
        this.state += value;
        return this;
    }

    public DoubleCalculator subtract(double value) {
        state -= value;
        return this;
    }

    public DoubleCalculator multiply(double value) {
        state *= value;
        return this;
    }

    public DoubleCalculator divide(double value) {
        state /= value;
        return this;
    }
}

