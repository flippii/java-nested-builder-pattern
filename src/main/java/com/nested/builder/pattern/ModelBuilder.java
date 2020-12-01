package com.nested.builder.pattern;

import java.util.function.Consumer;

public abstract class ModelBuilder<V, E> {

    private Consumer<E> validation;

    @SuppressWarnings("unchecked")
    public V build() {
        if (validation != null) {
            validation.accept((E) this);
        }
        return instance();
    }

    public final void withValidation(Consumer<E> validation) {
        this.validation = validation;
    }

    protected abstract V instance();

}
