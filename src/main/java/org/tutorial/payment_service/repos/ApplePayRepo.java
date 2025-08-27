package org.tutorial.payment_service.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.tutorial.payment_service.models.ApplePay;


import java.util.List;
import java.util.Optional;

public interface ApplePayRepo extends MongoRepository<ApplePay, String> {
    Optional<ApplePay> findByPaymentId(String paymentId);

    // Find payments by status (e.g., AUTHORIZED, CAPTURED)
    List<ApplePay> findByStatus(String status);

}
