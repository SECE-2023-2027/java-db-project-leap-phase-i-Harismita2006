package com.org.supplier.dao;

import com.org.supplier.model.Product;
import java.util.List;

public interface ProductDAO {
    void addProduct(Product product);
    List<Product> getAllProducts();
    void deleteProduct(int productId);
	void updateProductStock(int productId, int additionalStock);
}

