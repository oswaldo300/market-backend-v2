package com.media.tecnm.market_backend_v2.domain;

public class PurchaseItem {

    // Wrappers (no primitivos): si una fila en compras_productos tiene
    // cantidad, total o estado en NULL, el mapeo deja el valor en null en
    // vez de reventar con NullPointerException al desempaquetar (500 en
    // GET /purchases). El JSON no cambia cuando los valores existen.
    private int productId;
    private Integer quantity;
    private Double total;
    private Boolean active;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
