package com.org.supplier.model;

public class Supplier {
    private int supplierId;
    private String supplierName;
    private String contact;
    private String address;
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type; 

    public Supplier(int supplierId, String supplierName, String contact, String address,String type) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contact = contact;
        this.address = address;
        this.type = type;  
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Supplier ID: " + supplierId + "\n" +
               "Name: " + supplierName + "\n" +
               "Contact Info: " + contact + "\n" +
               "Type: " + type + "\n" +
               "Address: " + address;
    }
}
