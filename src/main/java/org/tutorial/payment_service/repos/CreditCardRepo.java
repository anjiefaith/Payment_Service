package org.tutorial.payment_service.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.tutorial.payment_service.models.CreditCard;

import java.util.List;
import java.util.Optional;

public interface CreditCardRepo extends MongoRepository<CreditCard, String> {
    Optional<CreditCard> findByPaymentId(String paymentId);

    // Find payments by status (e.g., AUTHORIZED, CAPTURED)
    List<CreditCard> findByStatus(String status);


}
