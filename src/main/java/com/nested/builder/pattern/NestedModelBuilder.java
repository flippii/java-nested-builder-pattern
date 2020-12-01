package com.nested.builder.pattern;

import java.util.function.Consumer;

public abstract class NestedModelBuilder<T, V> extends ModelBuilder<V> {

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

    @SuppressWarnings("unchecked")
    public final <P extends NestedModelBuilder<T, V>> P withParentBuilder(T parent, Consumer<V> callBack) {
        this.parent = parent;
        this.callBack = callBack;
        return  (P) this;
    }

}
