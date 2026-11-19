package com.media.tecnm.market_backend_v2.persistence;

import com.media.tecnm.market_backend_v2.domain.Category;
import com.media.tecnm.market_backend_v2.domain.repository.CategoryRepository;
import com.media.tecnm.market_backend_v2.persistence.crud.CategoriaCrudRepository;
import com.media.tecnm.market_backend_v2.persistence.entity.Categoria;
import com.media.tecnm.market_backend_v2.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> getAll() {
        return mapper.toCategories((List<Categoria>) categoriaCrudRepository.findAll());
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoriaCrudRepository.findById(categoryId).map(mapper::toCategory);
    }

    @Override
    public Category save(Category category) {
        return mapper.toCategory(categoriaCrudRepository.save(mapper.toCategoria(category)));
    }

    @Override
    public void delete(int categoryId) {
        categoriaCrudRepository.deleteById(categoryId);
    }
}
