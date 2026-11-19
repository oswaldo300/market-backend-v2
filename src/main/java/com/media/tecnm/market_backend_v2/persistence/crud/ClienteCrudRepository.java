package com.media.tecnm.market_backend_v2.persistence.crud;

import com.media.tecnm.market_backend_v2.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {
}
