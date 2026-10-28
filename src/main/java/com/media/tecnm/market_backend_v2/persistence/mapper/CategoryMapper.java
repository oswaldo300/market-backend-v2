package com.media.tecnm.market_backend_v2.persistence.mapper;

import com.media.tecnm.market_backend_v2.domain.Category;
import com.media.tecnm.market_backend_v2.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category); // Ojo: el tipo de retorno debe ser Categoria (entidad), no Category (dominio)
}