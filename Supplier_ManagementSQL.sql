CREATE DATABASE supplierDB;
USE supplierDB;

CREATE TABLE Supplier (
    supplier_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    contact_info VARCHAR(100),
    type VARCHAR(20) NOT NULL
);

CREATE TABLE Product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(50) NOT NULL,
    stock_quantity INT DEFAULT 0
);

CREATE TABLE PurchaseOrder (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    supplier_id INT,
    product_id INT,
    quantity INT NOT NULL,
    delivered BOOLEAN DEFAULT FALSE,
    order_date DATE,
    FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE
);

ALTER TABLE Product
ADD price DECIMAL(10, 2) DEFAULT 0;

ALTER TABLE PurchaseOrder
ADD received_date DATE,
ADD status VARCHAR(20) DEFAULT 'Pending';

ALTER TABLE Supplier
ADD COLUMN address VARCHAR(255);

select * from supplier;
select * from product;
select * from PurchaseOrder;
