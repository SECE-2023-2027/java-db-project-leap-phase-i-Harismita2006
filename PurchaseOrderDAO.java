package com.org.supplier.dao;

import com.org.supplier.model.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderDAO {
    void addPurchaseOrder(PurchaseOrder purchaseOrder);
    List<PurchaseOrder> getAllPurchaseOrders();
    void updatePurchaseOrderStatus(int orderId, String status);
	void updateDeliveredStatus(int orderId, boolean delivered);
}
