package com.media.tecnm.market_backend_v2.domain.repository;

import com.media.tecnm.market_backend_v2.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> getAll();
    Optional<Client> getClient(String clientId);
    Client save(Client client);
    void delete(String clientId);
}
