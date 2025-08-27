package org.tutorial.payment_service.service;

import org.springframework.stereotype.Component;
import org.tutorial.payment_service.models.ApplePay;


import org.springframework.stereotype.Component;
import org.tutorial.payment_service.models.ApplePay;
import org.tutorial.payment_service.repos.ApplePayRepo;

import java.util.Optional;

@Component
public class ApplePayProvider implements Provider<ApplePay> {

    private final ApplePayRepo applePayRepo;

    public ApplePayProvider(ApplePayRepo applePayRepo) {
        this.applePayRepo = applePayRepo;
    }

    @Override
    public String getName() {
        return "APPLEPAY";
    }

    @Override
    public ApplePay initiatePayment(ApplePay payment) {
        // Simulate Apple Pay processing
        payment.setStatus("AUTHORIZED");
        return payment;
    }


    @Override
    public Optional<ApplePay> getPaymentById(String paymentId) {
        return applePayRepo.findByPaymentId(paymentId);
    }

    @Override
    public Class<ApplePay> getPaymentType() {
        return ApplePay.class;
    }
}
