package com.media.tecnm.market_backend_v2.persistence;

import com.media.tecnm.market_backend_v2.persistence.crud.ProductoCrudRepository;
import com.media.tecnm.market_backend_v2.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    //SELECT * FROM Productos
    public List<Producto> getAll(){
        //Vamos a "castear"
        return (List<Producto>) productoCrudRepository.findAll();
    }
}
