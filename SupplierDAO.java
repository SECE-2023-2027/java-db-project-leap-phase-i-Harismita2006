package com.org.supplier.dao;

import com.org.supplier.model.Supplier;
import java.util.List;

public interface SupplierDAO {
    void addSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    void deleteSupplier(int supplierId);
	void updateSupplierInfo(int supplierId, String newName, String newContact, String newAddress);
}
