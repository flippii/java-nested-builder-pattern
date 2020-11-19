package com.nested.builder.pattern;

public class InvoiceActor {

    private String actorName;
    private InvoiceActorType actorType;

    public static Builder builder() {
        return new InvoiceActor.Builder();
    }

    private InvoiceActor() {}

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

    public final static class Builder extends NestedBuilder<Invoice.Builder, InvoiceActor> {

        private final InvoiceActor invoiceActor = new InvoiceActor();

        public Builder() {}

        public Builder named(String actorName) {
            invoiceActor.actorName = actorName;
            return this;
        }

        public Builder as(InvoiceActorType actorType) {
            invoiceActor.actorType = actorType;
            return this;
        }

        public InvoiceActor build() {
            return invoiceActor;
        }

    }

}
