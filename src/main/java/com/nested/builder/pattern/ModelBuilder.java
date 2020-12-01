package com.nested.builder.pattern;

public abstract class ModelBuilder<V> {

    public V build() {
        isValid();
        return instance();
    }

    void isValid() {

    }

    abstract V instance();

}
