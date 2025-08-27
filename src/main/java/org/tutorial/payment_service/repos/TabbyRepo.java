package org.tutorial.payment_service.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.tutorial.payment_service.models.Tabby;

import java.util.List;
import java.util.Optional;

public interface TabbyRepo extends MongoRepository<Tabby,String> {
    Optional<Tabby> findByPaymentId(String paymentId);

    // Find payments by status (e.g., AUTHORIZED, CAPTURED)
    List<Tabby> findByStatus(String status);

}
