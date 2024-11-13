package com.org.supplier.model;

import java.sql.Date;

public class PurchaseOrder {
    private int orderId;
    private int supplierId;
    private int productId;
    private int quantity;
    private boolean delivered;
    private java.util.Date orderDate;
    private Date receivedDate;  

    public PurchaseOrder(int orderId, int supplierId, int productId, int quantity, boolean delivered, java.util.Date receivedDate2, Date receivedDate) {
        this.orderId = orderId;
        this.supplierId = supplierId;
        this.productId = productId;
        this.quantity = quantity;
        this.delivered = delivered;
        this.orderDate = receivedDate2;
        this.receivedDate = receivedDate;
    }

    public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public java.util.Date getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "orderId=" + orderId +
                ", supplierId=" + supplierId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", delivered=" + delivered +
                ", orderDate=" + orderDate +
                ", receivedDate=" + receivedDate +
                '}';
    }
}
