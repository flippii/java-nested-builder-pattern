package com.nested.builder.pattern.invoice;

import com.nested.builder.pattern.ModelBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.nested.builder.pattern.invoice.InvoiceValidation.INVOICE_VALIDATION;

public class Invoice {

    private final InvoiceActor invoiceSupplier;
    private final InvoiceActor invoiceDestination;
    private final String supplierDocumentId;
    private final Date documentDate;
    private final String trailerNumber;
    private final List<InvoiceItem> items;

    public static Builder builder() {
        return new Builder();
    }

    public Invoice(InvoiceActor invoiceSupplier,
                   InvoiceActor invoiceDestination,
                   String supplierDocumentId,
                   Date documentDate,
                   String trailerNumber,
                   List<InvoiceItem> items) {

        this.invoiceSupplier = invoiceSupplier;
        this.invoiceDestination = invoiceDestination;
        this.supplierDocumentId = supplierDocumentId;
        this.documentDate = documentDate;
        this.trailerNumber = trailerNumber;
        this.items = items;
    }

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

    public final static class Builder extends ModelBuilder<Invoice, Builder> {

        InvoiceActor invoiceSupplier;
        InvoiceActor invoiceDestination;
        String supplierDocumentId;
        Date documentDate;
        String trailerNumber;
        final List<InvoiceItem> items = new ArrayList<>();

        public Builder() {
            withValidation(INVOICE_VALIDATION);
        }

        public Builder createdOn(Date documentDate) {
            this.documentDate = documentDate;
            return this;
        }

        public Builder shippingOnTrailer(String trailerNumber) {
            this.trailerNumber = trailerNumber;
            return this;
        }

        public Builder withDocumentNumber(String supplierDocumentId) {
            this.supplierDocumentId = supplierDocumentId;
            return this;
        }

        public InvoiceActor.Builder suppliedBy() {
            return InvoiceActor.builder()
                    .withParentBuilder(this, obj -> invoiceSupplier = obj);
        }

        public InvoiceActor.Builder beingSentTo() {
            return InvoiceActor.builder()
                    .withParentBuilder(this, obj -> invoiceDestination = obj);
        }

        public InvoiceItem.Builder withItem() {
            return InvoiceItem.builder()
                    .withParentBuilder(this, items::add);
        }

        @Override
        protected Invoice instance() {
            return new Invoice(invoiceSupplier, invoiceDestination, supplierDocumentId, documentDate, trailerNumber, items);
        }

    }

}
