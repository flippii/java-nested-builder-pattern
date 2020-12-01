package com.nested.builder.pattern.invoice;

import com.nested.builder.pattern.NestedModelBuilder;

public class InvoiceItem {

    private final String itemGtin;
    private final Integer quantityRequested;
    private final Integer quantityShipped;

    public static Builder builder() {
        return new Builder();
    }

    public InvoiceItem(String itemGtin, Integer quantityRequested, Integer quantityShipped) {
        this.itemGtin = itemGtin;
        this.quantityRequested = quantityRequested;
        this.quantityShipped = quantityShipped;
    }

    public String getItemGtin() {
        return itemGtin;
    }

    public Integer getQuantityRequested() {
        return quantityRequested;
    }

    public Integer getQuantityShipped() {
        return quantityShipped;
    }

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "itemGtin='" + itemGtin + '\'' +
                ", quantityRequested=" + quantityRequested +
                ", quantityShipped=" + quantityShipped +
                '}';
    }

    public final static class Builder extends NestedModelBuilder<Invoice.Builder, InvoiceItem, Builder> {

        private String itemGtin;
        private Integer quantityRequested;
        private Integer quantityShipped;

        public Builder() { }

        public Builder as(String itemGtin) {
            this.itemGtin = itemGtin;
            return this;
        }

        public Builder orderedQuantity(Integer quantityRequested) {
            this.quantityRequested = quantityRequested;
            return this;
        }

        public Builder shippedQuantity(Integer quantityShipped) {
            this.quantityShipped = quantityShipped;
            return this;
        }

        @Override
        protected InvoiceItem instance() {
            return new InvoiceItem(itemGtin, quantityRequested, quantityShipped);
        }

    }

}
