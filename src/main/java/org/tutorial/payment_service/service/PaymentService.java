package org.tutorial.payment_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutorial.payment_service.models.*;
import org.tutorial.payment_service.repos.*;

import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentProviderFactory providerFactory;

    public PaymentService(PaymentProviderFactory providerFactory) {
        this.providerFactory = providerFactory;
    }

    /**
     * Create a new payment for any supported type
     */
    public <T extends Payments> T createPayment(T payment) {
        payment.setPaymentId(UUID.randomUUID().toString());

        Provider<T> provider = providerFactory.getProvider(payment.getProvider());

        // Provider handles initiation + persistence
        T initiated = provider.initiatePayment(payment);
        return provider.initiatePayment(payment);
    }

    /**
     * Get payment by ID
     */
    public Optional<? extends Payments> getPaymentById(String providerName, String paymentId) {
        Provider<? extends Payments> provider = providerFactory.getProvider(providerName);
        return provider.getPaymentById(paymentId);
    }
}
