package com.nested.builder.pattern;

public class InvoiceItem {

    private String itemGtin;
    private Integer quantityRequested;
    private Integer quantityShipped;

    public static Builder builder() {
        return new InvoiceItem.Builder();
    }

    private InvoiceItem() {}

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

    public final static class Builder extends NestedBuilder<Invoice.Builder, InvoiceItem> {

        private final InvoiceItem invoiceItem = new InvoiceItem();

        public Builder as(String itemGtin) {
            invoiceItem.itemGtin = itemGtin;
            return this;
        }

        public Builder orderedQuantity(Integer quantityRequested) {
            invoiceItem.quantityRequested = quantityRequested;
            return this;
        }

        public Builder shippedQuantity(Integer quantityShipped) {
            invoiceItem.quantityShipped = quantityShipped;
            return this;
        }

        public InvoiceItem build() {
            return invoiceItem;
        }

    }

}
