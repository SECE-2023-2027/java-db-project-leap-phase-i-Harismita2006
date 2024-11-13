package com.org.supplier;

import com.org.supplier.dao.ProductDAO;
import com.org.supplier.dao.PurchaseOrderDAO;
import com.org.supplier.dao.ProductDAOImpl;
import com.org.supplier.dao.PurchaseOrderDAOImpl;
import com.org.supplier.model.Product;
import com.org.supplier.model.PurchaseOrder;
import com.org.supplier.model.Supplier;
import com.org.supplier.dao.SupplierDAO;
import com.org.supplier.dao.SupplierDAOImpl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static ProductDAO productDAO = new ProductDAOImpl();
    private static PurchaseOrderDAO purchaseOrderDAO = new PurchaseOrderDAOImpl();
    private static SupplierDAO supplierDAO = new SupplierDAOImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addSupplier();
                    break;
                case 2:
                    viewAllSuppliers();
                    break;
                case 3:
                    deleteSupplier();
                    break;
                case 4:
                    updateSupplierInfo();
                    break;
                case 5:
                    addProduct();
                    break;
                case 6:
                    viewAllProducts();
                    break;
                case 7:
                    createPurchaseOrder();
                    break;
                case 8:
                    viewAllPurchaseOrders();
                    break;
                case 9:
                    updateInventory();
                    break;
                case 10:
                    updateDeliveredStatus();  
                    break;
                case 11:
                    System.out.println("Exiting system...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Supplier Management System ---");
        System.out.println("1. Add Supplier");
        System.out.println("2. View All Suppliers");
        System.out.println("3. Delete Supplier");
        System.out.println("4. Update Supplier Information");
        System.out.println("5. Add New Product");
        System.out.println("6. View All Products");
        System.out.println("7. Create Purchase Order");
        System.out.println("8. View All Purchase Orders");
        System.out.println("9. Update Inventory After Stock Received");
        System.out.println("10. Update Delivered Status"); 
        System.out.println("11. Exit");
        System.out.print("Select an option: ");
    }

    private static int getChoice() {
        return scanner.nextInt();
    }

    private static void addSupplier() {
        System.out.print("Enter supplier name: ");
        scanner.nextLine();  
        String supplierName = scanner.nextLine();
        
        System.out.print("Enter supplier contact: ");
        String contact = scanner.nextLine();
        
        System.out.print("Enter supplier address: ");
        String address = scanner.nextLine();
        
        System.out.print("Enter supplier type: ");
        String type = scanner.nextLine();  
        
        Supplier supplier = new Supplier(0, supplierName, contact, type, address); 
        supplierDAO.addSupplier(supplier);
        System.out.println("Supplier added successfully.");
    }

    private static void viewAllSuppliers() {
        List<Supplier> suppliers = supplierDAO.getAllSuppliers();
        System.out.println("\nAll Suppliers:");
        for (Supplier supplier : suppliers) {
            System.out.println("ID: " + supplier.getSupplierId() + ", Name: " + supplier.getSupplierName() +
                    ", Contact: " + supplier.getContact() + ", Address: " + supplier.getAddress());
        }
    }

    private static void deleteSupplier() {
        System.out.print("Enter supplier ID to delete: ");
        int supplierId = scanner.nextInt();
        supplierDAO.deleteSupplier(supplierId);
        System.out.println("Supplier deleted successfully.");
    }

    private static void updateSupplierInfo() {
        System.out.print("Enter supplier ID to update: ");
        int supplierId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new supplier name: ");
        String newSupplierName = scanner.nextLine();
        System.out.print("Enter new supplier contact: ");
        String newContact = scanner.nextLine();
        System.out.print("Enter new supplier address: ");
        String newAddress = scanner.nextLine();

        supplierDAO.updateSupplierInfo(supplierId, newSupplierName, newContact, newAddress);
        System.out.println("Supplier information updated successfully.");
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        scanner.nextLine(); 
        String productName = scanner.nextLine();
        System.out.print("Enter stock quantity: ");
        int stockQuantity = scanner.nextInt();

        Product product = new Product(0, productName, stockQuantity); 
        productDAO.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private static void viewAllProducts() {
        List<Product> products = productDAO.getAllProducts();
        System.out.println("\nAll Products:");
        for (Product product : products) {
            System.out.println("ID: " + product.getProductId() + ", Name: " + product.getProductName() + ", Stock: " + product.getStockQuantity());
        }
    }

    private static void createPurchaseOrder() {
        System.out.print("Enter supplier ID: ");
        int supplierId = scanner.nextInt();
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        Date receivedDate = new Date();
        PurchaseOrder purchaseOrder = new PurchaseOrder(0, supplierId, productId, quantity, false, receivedDate, null); 
        purchaseOrderDAO.addPurchaseOrder(purchaseOrder);
        System.out.println("Purchase order created successfully.");
    }


    private static void viewAllPurchaseOrders() {
        List<PurchaseOrder> purchaseOrders = purchaseOrderDAO.getAllPurchaseOrders();
        System.out.println("\nAll Purchase Orders:");
        for (PurchaseOrder order : purchaseOrders) {
            System.out.println("Order ID: " + order.getOrderId() +
                    ", Supplier ID: " + order.getSupplierId() +
                    ", Product ID: " + order.getProductId() +
                    ", Quantity: " + order.getQuantity() +
                    ", Delivered: " + order.isDelivered());
        }
    }

    private static void updateInventory() {
        System.out.print("Enter product ID to update: ");
        int productId = scanner.nextInt();
        System.out.print("Enter additional stock received: ");
        int additionalStock = scanner.nextInt();

        productDAO.updateProductStock(productId, additionalStock);
        System.out.println("Inventory updated successfully.");
    }
    private static void updateDeliveredStatus() {
        System.out.print("Enter purchase order ID to update: ");
        int orderId = scanner.nextInt();
        System.out.print("Is the order delivered? (true/false): ");
        boolean delivered = scanner.nextBoolean();

        purchaseOrderDAO.updateDeliveredStatus(orderId, delivered);
        System.out.println("Purchase order delivery status updated.");
    }
}
