package com.media.tecnm.market_backend_v2.domain.service;

import com.media.tecnm.market_backend_v2.domain.Client;
import com.media.tecnm.market_backend_v2.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(String clientId) {
        return clientRepository.getClient(clientId);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> update(String clientId, Client client) {
        if (getClient(clientId).isPresent()) {
            client.setClientId(clientId);
            return Optional.of(save(client));
        }
        return Optional.empty();
    }

    public boolean delete(String clientId) {
        if (getClient(clientId).isPresent()) {
            clientRepository.delete(clientId);
            return true;
        }
        return false;
    }
}
