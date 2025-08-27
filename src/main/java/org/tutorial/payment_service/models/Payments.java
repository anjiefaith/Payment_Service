package org.tutorial.payment_service.models;

public interface Payments {
    String getPaymentId();
    void setPaymentId(String paymentId);
    String getStatus();
    void setStatus(String status);
    String getProvider();
    void setProvider(String provider);
}
