package org.tutorial.payment_service.service;

import org.springframework.stereotype.Component;
import org.tutorial.payment_service.models.Tamara;
import org.tutorial.payment_service.models.Payments;


import org.springframework.stereotype.Component;
import org.tutorial.payment_service.models.Tamara;
import org.tutorial.payment_service.repos.TamaraRepo;

import java.util.Optional;

@Component
public class TamaraProvider implements Provider<Tamara> {

    private final TamaraRepo tamaraRepo;

    public TamaraProvider(TamaraRepo tamaraRepo) {
        this.tamaraRepo = tamaraRepo;
    }

    @Override
    public String getName() {
        return "TAMARA";
    }

    @Override
    public Tamara initiatePayment(Tamara payment) {
        // Simulate Tamara checkout logic
        payment.setStatus("PENDING");
        return payment;
    }

    @Override
    public Optional<Tamara> getPaymentById(String paymentId) {
        return tamaraRepo.findByPaymentId(paymentId);
    }

    @Override
    public Class<Tamara> getPaymentType() {
        return Tamara.class;
    }
}
