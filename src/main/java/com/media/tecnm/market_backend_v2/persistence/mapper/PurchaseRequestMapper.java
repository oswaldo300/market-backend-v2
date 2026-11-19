package com.media.tecnm.market_backend_v2.persistence.mapper;

import com.media.tecnm.market_backend_v2.domain.Purchase;
import com.media.tecnm.market_backend_v2.domain.PurchaseItem;
import com.media.tecnm.market_backend_v2.web.dto.PurchaseItemRequest;
import com.media.tecnm.market_backend_v2.web.dto.PurchaseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseRequestMapper {

    @Mappings({
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "productosAdquiridos", target = "items")
    })
    Purchase toPurchase(PurchaseRequest request);

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "total", target = "total")
    })
    PurchaseItem toPurchaseItem(PurchaseItemRequest item);

    List<PurchaseItem> toPurchaseItems(List<PurchaseItemRequest> items);
}
