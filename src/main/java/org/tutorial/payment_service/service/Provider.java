package org.tutorial.payment_service.service;

import org.tutorial.payment_service.models.Payments;

import java.util.Optional;

public interface Provider<T extends Payments> {
    // Unique provider name (e.g. "CREDITCARD", "TABBY")
    String getName();

    // Start/initiate the payment (each provider does it differently)
    T initiatePayment(T payment);

    // Which Payment model this provider supports
    Class<T> getPaymentType();

    Optional<? extends Payments> getPaymentById(String paymentId);
}
