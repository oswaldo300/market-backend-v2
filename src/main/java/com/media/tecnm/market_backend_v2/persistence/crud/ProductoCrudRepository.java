package com.media.tecnm.market_backend_v2.persistence.crud;

import com.media.tecnm.market_backend_v2.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Métodos abstractos que después se implementarán
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    /*SQL Query Method
    Select *
    FROM productos
    WHERE id_categoria = 10?
    ORDER BY nombre ASC
     */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //cantidad stock
  Optional<List<Producto>> findByCantidadStockLessThenAndEstado(int cantidadstock, boolean estado);


}
