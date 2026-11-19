package com.media.tecnm.market_backend_v2.domain.service;

import com.media.tecnm.market_backend_v2.domain.Product;
import com.media.tecnm.market_backend_v2.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);

    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> update(int productId, Product product) {
        //Verificar que existe antes de actualizar
        if (getProduct(productId).isPresent()) {
            product.setProductId(productId);
            return Optional.of(save(product));
        }
        return Optional.empty();
    }

    public boolean delete(int productId) {
        //Verificar que existe antes de borrar
        if (getProduct(productId).isPresent()) {
            productRepository.delete(productId);
            return true;
        } else {
            return false;
        }
    }
}
