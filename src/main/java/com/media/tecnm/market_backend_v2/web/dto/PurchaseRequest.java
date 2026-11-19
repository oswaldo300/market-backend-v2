package com.media.tecnm.market_backend_v2.web.dto;

import java.util.List;

public class PurchaseRequest {

    private String idCliente;
    private String medioPago;
    private String comentario;
    private List<PurchaseItemRequest> productosAdquiridos;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<PurchaseItemRequest> getProductosAdquiridos() {
        return productosAdquiridos;
    }

    public void setProductosAdquiridos(List<PurchaseItemRequest> productosAdquiridos) {
        this.productosAdquiridos = productosAdquiridos;
    }
}
