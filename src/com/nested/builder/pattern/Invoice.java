package com.nested.builder.pattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {

    private InvoiceActor invoiceSupplier;
    private InvoiceActor invoiceDestination;

    private String supplierDocumentId;
    private Date documentDate;

    private String trailerNumber;

    private List<InvoiceItem> items;

    public static Builder builder() {
        return new Invoice.Builder();
    }

    private Invoice() {}

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public String getSupplierDocumentId() {
        return supplierDocumentId;
    }

    public InvoiceActor getInvoiceSupplier() {
        return invoiceSupplier;
    }

    public InvoiceActor getInvoiceDestination() {
        return invoiceDestination;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public List<InvoiceItem> getItems() {
        return List.copyOf(items);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceSupplier=" + invoiceSupplier +
                ", invoiceDestination=" + invoiceDestination +
                ", supplierDocumentId='" + supplierDocumentId + '\'' +
                ", documentDate=" + documentDate +
                ", trailerNumber='" + trailerNumber + '\'' +
                ", items=" + items +
                '}';
    }

    public final static class Builder {

        private final Invoice invoice = new Invoice();

        public Builder createdOn(Date documentDate) {
            invoice.documentDate = documentDate;
            return this;
        }

        public Builder shippingOnTrailer(String trailerNumber) {
            invoice.trailerNumber = trailerNumber;
            return this;
        }

        public Builder withDocumentNumber(String supplierDocumentId) {
            invoice.supplierDocumentId = supplierDocumentId;
            return this;
        }

        public InvoiceActor.Builder suppliedBy() {
            return InvoiceActor.builder()
                    .withParentBuilder(this, obj -> invoice.invoiceSupplier = obj);
        }

        public InvoiceActor.Builder beingSentTo() {
            return InvoiceActor.builder()
                    .withParentBuilder(this, obj -> invoice.invoiceDestination = obj);
        }

        public InvoiceItem.Builder withItem() {
            if (invoice.items == null) {
                invoice.items = new ArrayList<>();
            }

            return InvoiceItem.builder()
                    .withParentBuilder(this, obj -> invoice.items.add(obj));
        }

        public Invoice build() {
            return invoice;
        }

    }

}
