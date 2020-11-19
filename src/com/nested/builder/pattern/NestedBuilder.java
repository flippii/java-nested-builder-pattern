package com.nested.builder.pattern;

import java.util.function.Consumer;

public abstract class NestedBuilder<T, V> {

    private T parent;
    private Consumer<V> callBack;

    public final T end() {
        if (parent == null) {
            throw new NullPointerException("Parameter parent is null.");
        }

        if (callBack != null) {
            callBack.accept(build());
        }

        return parent;
    }

    public abstract V build();

    @SuppressWarnings("unchecked")
    public final <P extends NestedBuilder<T, V>> P withParentBuilder(T parent, Consumer<V> callBack) {
        this.parent = parent;
        this.callBack = callBack;
        return (P) this;
    }

}
