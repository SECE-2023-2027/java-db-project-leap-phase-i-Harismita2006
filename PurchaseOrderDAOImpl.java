package com.org.supplier.dao;

import com.org.supplier.model.PurchaseOrder;
import com.org.supplier.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderDAOImpl implements PurchaseOrderDAO {
	@Override
	public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
	    String query = "INSERT INTO PurchaseOrder (supplier_id, product_id, quantity, delivered, order_date, received_date) VALUES (?, ?, ?, ?, ?, ?)";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        
	        stmt.setInt(1, purchaseOrder.getSupplierId());
	        stmt.setInt(2, purchaseOrder.getProductId());
	        stmt.setInt(3, purchaseOrder.getQuantity());
	        stmt.setBoolean(4, purchaseOrder.isDelivered());
	        stmt.setDate(5, new java.sql.Date(purchaseOrder.getOrderDate().getTime()));
	        if (purchaseOrder.isDelivered()) {
	            stmt.setDate(6, new java.sql.Date(purchaseOrder.getReceivedDate().getTime()));
	        } else {
	            stmt.setNull(6, java.sql.Types.DATE);
	        }
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

@Override
public List<PurchaseOrder> getAllPurchaseOrders() {
    List<PurchaseOrder> purchaseOrders = new ArrayList<>();
    String query = "SELECT * FROM PurchaseOrder";
    
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        while (rs.next()) {
            Date receivedDate = rs.getDate("received_date");

            purchaseOrders.add(new PurchaseOrder(
                    rs.getInt("order_id"),
                    rs.getInt("supplier_id"),
                    rs.getInt("product_id"),
                    rs.getInt("quantity"),
                    rs.getBoolean("delivered"),
                    receivedDate, receivedDate
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return purchaseOrders;
}

    @Override
    public void updatePurchaseOrderStatus(int orderId, String status) {
        String query = "UPDATE PurchaseOrder SET status = ? WHERE order_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setInt(2, orderId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateDeliveredStatus(int orderId, boolean delivered) {
        String sql = "UPDATE PurchaseOrder SET delivered = ?, received_date = ? WHERE order_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setBoolean(1, delivered);

            if (delivered) {
                stmt.setDate(2, new java.sql.Date(new java.util.Date().getTime())); 
            } else {
                stmt.setNull(2, java.sql.Types.DATE); 
            }
            
            stmt.setInt(3, orderId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
