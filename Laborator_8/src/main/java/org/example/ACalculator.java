package org.example;

public abstract class ACalculator<T> {
    protected T state;

    public T result() {
        return state;
    }

    public ACalculator clear() {
        this.init();
        return this;
    }

    protected abstract void init();
}
