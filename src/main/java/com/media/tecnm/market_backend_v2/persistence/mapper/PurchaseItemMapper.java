package com.media.tecnm.market_backend_v2.persistence.mapper;

import com.media.tecnm.market_backend_v2.domain.PurchaseItem;
import com.media.tecnm.market_backend_v2.persistence.entity.CompraProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
            // 'total' se mapea automáticamente por tener el mismo nombre
    })
    PurchaseItem toPurchaseItem(CompraProducto producto);

    @InheritInverseConfiguration
    @Mapping(target = "compra", ignore = true)
    @Mapping(target = "producto", ignore = true)
    @Mapping(target = "id.idCompra", ignore = true)
    CompraProducto toCompraProducto(PurchaseItem item);
}