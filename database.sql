CREATE DATABASE DrugStore;
USE DrugStore;

CREATE TABLE SpecialClient (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    rg VARCHAR(12) UNIQUE NOT NULL,
    phone VARCHAR(10) NOT NULL,
    email VARCHAR(60) UNIQUE NOT NULL,
    databirth DATE
);

CREATE TABLE Employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    is_manager BIT DEFAULT 0 NOT NULL,
    email VARCHAR(60) UNIQUE NOT NULL,
    user VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE Cashier (
    number INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE CashierLog (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cashier_number INT NOT NULL,
    date_recorded DATE,
    time_recorded TIME,
    FOREIGN KEY(cashier_number) REFERENCES cashier(number)
);

CREATE TABLE Drug (
    id INT AUTO_INCREMENT PRIMARY KEY,
    is_generic BIT DEFAULT 0 NOT NULL,
    unit_price DECIMAL(6,2) NOT NULL,
    name VARCHAR(120) NOT NULL
);

CREATE TABLE OrderInfo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date_ordered DATE,
    time_ordered TIME,
    subtotal DECIMAL(12,2) NOT NULL,
    discount DECIMAL(12,2) NOT NULL,
    freight DECIMAL(12,2) NOT NULL,
    total DECIMAL(12,2) NOT NULL
);

CREATE TABLE OrderItems (
    order_id INT NOT NULL,
    drug_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY(order_id) REFERENCES order_info(id),
    FOREIGN KEY(drug_id) REFERENCES drug(id)
);