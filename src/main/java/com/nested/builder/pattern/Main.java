package com.nested.builder.pattern;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Invoice invoice = Invoice.builder()
                .createdOn(new Date())
                .withDocumentNumber("5150")
                .shippingOnTrailer("2112")
                .suppliedBy()
                    .named("101")
                    .as(InvoiceActorType.DC)
                    .end()
                .beingSentTo()
                    .named("42")
                    .as(InvoiceActorType.STORE)
                    .end()
                .withItem()
                    .as("TK421")
                    .orderedQuantity(10)
                    .shippedQuantity(8)
                    .end()
                .withItem()
                    .as("FN2187")
                    .orderedQuantity(5)
                    .shippedQuantity(5)
                    .end()
                .build();

        System.out.println(invoice);
    }
}
