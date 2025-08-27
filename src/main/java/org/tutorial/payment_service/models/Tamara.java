package org.tutorial.payment_service.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "Tamara")
public class Tamara implements Payments {

    @Id
    private String paymentId;           // Mongo primary key
    private double amount;
    private String currency;
    private String status;              // CREATED, REQUIRES_ACTION, AUTHORIZED, CAPTURED, FAILED
    private String provider;            // TABBY, TAMARA, APPLE_PAY, CREDIT_CARD
    private String link;          // Nested class for customer info
                 // Nested class for order details


    // + Constructors, getters, setters


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }





}






