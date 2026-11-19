package com.media.tecnm.market_backend_v2.domain.service;

import com.media.tecnm.market_backend_v2.domain.Purchase;
import com.media.tecnm.market_backend_v2.domain.repository.PurchaseRepository;
import com.media.tecnm.market_backend_v2.persistence.mapper.PurchaseRequestMapper;
import com.media.tecnm.market_backend_v2.web.dto.PurchaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseRequestMapper purchaseRequestMapper;

    // Los GET leen la colección lazy 'productos' de Compra al mapear a Purchase.
    // Con spring.jpa.open-in-view=false la sesión se cierra al terminar el
    // repositorio, así que el mapeo debe ocurrir dentro de una transacción;
    // sin esto, GET /purchases daba LazyInitializationException (500).
    @Transactional(readOnly = true)
    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    @Transactional(readOnly = true)
    public Optional<Purchase> getPurchase(int purchaseId) {
        return purchaseRepository.getPurchase(purchaseId);
    }

    @Transactional(readOnly = true)
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

    @Transactional
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Transactional
    public Purchase save(PurchaseRequest request) {
        if (request.getProductosAdquiridos() == null || request.getProductosAdquiridos().isEmpty()) {
            throw new IllegalArgumentException("La compra debe tener al menos un producto");
        }

        Purchase purchase = purchaseRequestMapper.toPurchase(request);
        purchase.setDate(LocalDateTime.now());
        purchase.setState("A");
        purchase.getItems().forEach(item -> item.setActive(true));

        return purchaseRepository.save(purchase);
    }
}
