package org.tutorial.payment_service.contoller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tutorial.payment_service.models.*;
import org.tutorial.payment_service.service.PaymentProviderFactory;
import org.tutorial.payment_service.service.PaymentService;
import org.tutorial.payment_service.service.Provider;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/payments")
public class Controller {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PaymentProviderFactory providerFactory;

    /**
     * List all available payment providers
     */
    @GetMapping("/providers")
    public ResponseEntity<java.util.Set<String>> getPaymentProviders() {
        return ResponseEntity.ok(providerFactory.getAvailableProviders());
    }


    @PostMapping("/{providerName}")
    public ResponseEntity<? extends Payments> createPayment(
            @PathVariable String providerName,
            @RequestBody Map<String, Object> paymentRequest
    ) {
        Provider<? extends Payments> provider = providerFactory.getProvider(providerName);

        // Dynamically map JSON → correct model class
        Payments payment = objectMapper.convertValue(paymentRequest, provider.getPaymentType());
        payment.setProvider(providerName);

        Payments savedPayment = paymentService.createPayment(payment);
        return ResponseEntity.ok(savedPayment);
    }

    /**
     * Get payment by ID
     */
    @GetMapping("/{provider}/{paymentId}")
    public ResponseEntity<? extends Payments> getPayment(
            @PathVariable String provider,
            @PathVariable String paymentId
    ) {
        Optional<? extends Payments> payment = paymentService.getPaymentById(provider, paymentId);
        return payment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
