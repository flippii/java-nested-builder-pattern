package com.nested.builder.pattern.invoice;

import com.nested.builder.pattern.NestedModelBuilder;

public class InvoiceActor {

    private final String actorName;
    private final InvoiceActorType actorType;

    public static Builder builder() {
        return new Builder();
    }

    public InvoiceActor(String actorName, InvoiceActorType actorType) {
        this.actorName = actorName;
        this.actorType = actorType;
    }

    public String getActorName() {
        return actorName;
    }

    public InvoiceActorType getActorType() {
        return actorType;
    }

    @Override
    public String toString() {
        return "InvoiceActor{" +
                "actorName='" + actorName + '\'' +
                ", actorType=" + actorType +
                '}';
    }

    public final static class Builder extends NestedModelBuilder<Invoice.Builder, InvoiceActor, Builder> {

        private String actorName;
        private InvoiceActorType actorType;

        public Builder() { }

        public Builder named(String actorName) {
            this.actorName = actorName;
            return this;
        }

        public Builder as(InvoiceActorType actorType) {
            this.actorType = actorType;
            return this;
        }

        @Override
        protected InvoiceActor instance() {
            return new InvoiceActor(actorName, actorType);
        }

    }

}
