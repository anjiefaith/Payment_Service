package org.tutorial.payment_service.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "ApplePay")
public class ApplePay implements Payments {

    @Id
    private String paymentId;           // Mongo primary key
    private double amount;
    private String currency;
    private String status;              // CREATED, REQUIRES_ACTION, AUTHORIZED, CAPTURED, FAILED
    private String provider;            // TABBY, TAMARA, APPLE_PAY, CREDIT_CARD
    private Customer customer;          // Nested class for customer info



    // + Constructors, getters, setters

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




}

class Customer {
    private String name;
    private String email;
    private String phone;
    private String AppleID;

    public String getAppleID() {
        return AppleID;
    }

    public void setAppleID(String appleID) {
        AppleID = appleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}






