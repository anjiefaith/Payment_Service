package org.tutorial.payment_service.service;

import org.springframework.stereotype.Component;
import org.tutorial.payment_service.models.CreditCard;




import org.tutorial.payment_service.repos.CreditCardRepo;

import java.util.Optional;

@Component
public class CreditCardProvider implements Provider<CreditCard> {

    private final CreditCardRepo creditCardRepo;

    public CreditCardProvider(CreditCardRepo creditCardRepo) {
        this.creditCardRepo = creditCardRepo;
    }

    @Override
    public String getName() {
        return "CREDITCARD";
    }

    @Override
    public CreditCard initiatePayment(CreditCard payment) {
        // Simulate credit card processing (e.g., via a gateway)
        payment.setStatus("AUTHORIZED");
        return payment;
    }

    @Override
    public Optional<CreditCard> getPaymentById(String paymentId) {
        return creditCardRepo.findByPaymentId(paymentId);
    }

    @Override
    public Class<CreditCard> getPaymentType() {
        return CreditCard.class;
    }
}
