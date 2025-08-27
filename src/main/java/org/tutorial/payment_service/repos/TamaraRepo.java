package org.tutorial.payment_service.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.tutorial.payment_service.models.Tamara;

import java.util.List;
import java.util.Optional;

public interface TamaraRepo extends MongoRepository<Tamara, String> {
    Optional<Tamara> findByPaymentId(String paymentId);

    // Find payments by status (e.g., AUTHORIZED, CAPTURED)
    List<Tamara> findByStatus(String status);

}
