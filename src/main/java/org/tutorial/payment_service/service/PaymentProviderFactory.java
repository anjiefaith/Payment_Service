package org.tutorial.payment_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import org.tutorial.payment_service.models.Payments;

@Component
public class PaymentProviderFactory {
    private final Map<String, Provider<? extends Payments>> providers = new HashMap<>();

    @Autowired
    public PaymentProviderFactory(
            java.util.List<Provider<? extends Payments>> providerList
    ) {
        for (Provider<? extends Payments> provider : providerList) {
            providers.put(provider.getName().toUpperCase(), provider);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends Payments> Provider<T> getProvider(String providerName) {
        Provider<?> provider = providers.get(providerName.toUpperCase());
        if (provider == null) {
            throw new IllegalArgumentException("Unknown provider: " + providerName);
        }
        return (Provider<T>) provider;
    }

    public java.util.Set<String> getAvailableProviders() {
        return providers.keySet();
    }
}


