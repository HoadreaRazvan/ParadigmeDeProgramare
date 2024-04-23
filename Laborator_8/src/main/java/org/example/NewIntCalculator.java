package org.example;

public class NewIntCalculator extends ACalculator<Integer> {

    public NewIntCalculator(int state) {
        this.state = state;
    }

    protected void init() {
        state = 0;
    }

    public NewIntCalculator add(int value) {
        this.state += value;
        return this;
    }

    public NewIntCalculator subtract(int value) {
        state -= value;
        return this;
    }

    public NewIntCalculator multiply(int value) {
        state *= value;
        return this;
    }
    public NewIntCalculator divide(int value) {
        state /= value;
        return this;
    }
}
