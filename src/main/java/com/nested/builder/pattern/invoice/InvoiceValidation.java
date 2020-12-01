package com.nested.builder.pattern.invoice;

import java.util.function.Consumer;

final class InvoiceValidation {

    static Consumer<Invoice.Builder> INVOICE_VALIDATION = builder -> {
        if (builder.invoiceSupplier == null) {
            throw new ValidationException("InvoiceSupplier in Invoice is null.");
        }
    };

}
