package com.media.tecnm.market_backend_v2.persistence;

import com.media.tecnm.market_backend_v2.persistence.crud.ProductoCrudRepository;
import com.media.tecnm.market_backend_v2.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    //SELECT * FROM Productos
    public List<Producto> getAll(){
        //Vamos a "castear"
        return (List<Producto>) productoCrudRepository.findAll();
    }

   public List<Producto> getByCategory(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThenAndEstado(cantidad, true);
    }

   public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }
    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }
        public void delete(int idProducto){
            productoCrudRepository.deleteById(idProducto);
        }
    }

