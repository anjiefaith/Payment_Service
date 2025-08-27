package org.tutorial.payment_service.service;

import org.springframework.stereotype.Component;
import org.tutorial.payment_service.models.Tabby;
import org.tutorial.payment_service.models.Payments;



import org.springframework.stereotype.Component;
import org.tutorial.payment_service.models.Tabby;
import org.tutorial.payment_service.repos.TabbyRepo;

import java.util.Optional;

@Component
public class TabbyProvider implements Provider<Tabby> {

    private final TabbyRepo tabbyRepo;

    public TabbyProvider(TabbyRepo tabbyRepo) {
        this.tabbyRepo = tabbyRepo;
    }

    @Override
    public String getName() {
        return "TABBY";
    }

    @Override
    public Tabby initiatePayment(Tabby payment) {
        // Simulate Tabby redirect logic
        payment.setStatus("PENDING");
        return payment;
    }

    @Override
    public Optional<Tabby> getPaymentById(String paymentId) {
        return tabbyRepo.findByPaymentId(paymentId);
    }

    @Override
    public Class<Tabby> getPaymentType() {
        return Tabby.class;
    }
}
