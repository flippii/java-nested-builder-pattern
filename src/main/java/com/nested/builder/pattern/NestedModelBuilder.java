package com.nested.builder.pattern;

import java.util.function.Consumer;

public abstract class NestedModelBuilder<T, V, E> extends ModelBuilder<V, E> {

    private T parent;
    private Consumer<V> mapper;

    public final T end() {
        if (parent == null) {
            throw new NullPointerException("Parameter parent is null.");
        }

        if (mapper != null) {
            mapper.accept(build());
        }

        return parent;
    }

    @SuppressWarnings("unchecked")
    public final <P extends NestedModelBuilder<T, V, E>> P withParentBuilder(T parent, Consumer<V> mapper) {
        this.parent = parent;
        this.mapper = mapper;
        return  (P) this;
    }

}
