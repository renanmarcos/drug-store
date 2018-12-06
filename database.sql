CREATE DATABASE DrugStore;
USE DrugStore;

CREATE TABLE SpecialClient (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    rg VARCHAR(12) UNIQUE NOT NULL,
    phone VARCHAR(10) NOT NULL,
    email VARCHAR(60) UNIQUE NOT NULL,
    datebirth DATE
);

CREATE TABLE Cashier (
    number INT AUTO_INCREMENT PRIMARY KEY,
    current_status VARCHAR(20) DEFAULT 'closed'
);

CREATE TABLE CashierLog (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cashier_number INT NOT NULL,
    date_recorded DATE,
    time_recorded TIME,
    status VARCHAR(20) DEFAULT 'closed',
    FOREIGN KEY(cashier_number) REFERENCES Cashier(number) ON DELETE CASCADE
);

CREATE TABLE Drug (
    id INT AUTO_INCREMENT PRIMARY KEY,
    com_name VARCHAR(60) NOT NULL,
    type_drug VARCHAR(60) NOT NULL,
    lab VARCHAR(60) NOT NULL,
    is_generic BIT DEFAULT 0 NOT NULL,
    need_pre BIT DEFAULT 0 NOT NULL,
    unit_price DECIMAL(6,2) NOT NULL,
    desc_drug VARCHAR(120) NOT NULL,
    dateshelf DATE
);

CREATE TABLE OrderInfo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date_ordered DATE,
    time_ordered TIME,
    special_client_id INT,
    subtotal DECIMAL(12,2) NOT NULL,
    discount DECIMAL(12,2) NOT NULL,
    freight DECIMAL(12,2) NOT NULL,
    total DECIMAL(12,2) NOT NULL,
    FOREIGN KEY(special_client_id) REFERENCES SpecialClient(id)
);

CREATE TABLE OrderItems (
    order_id INT NOT NULL,
    drug_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY(order_id) REFERENCES OrderInfo(id) ON DELETE CASCADE,
    FOREIGN KEY(drug_id) REFERENCES Drug(id)
);

INSERT INTO SpecialClient (name, cpf, rg, phone, email, datebirth) 
VALUES 
("Roberto Marinho", "985.105.201-22", "12.221.018-1", "1114019707", "roberto.marinho@gmail.com", 
date_add(date_add(curdate(), INTERVAL -(SELECT FLOOR(RAND()*(50-10+1))+10) YEAR), INTERVAL (SELECT FLOOR(RAND()*(30-0+1))) DAY)),
("Joao Silva", "005.998.158-04", "05.004.458-0", "1154209707", "joao.silva@hotmail.com", 
date_add(date_add(curdate(), INTERVAL -(SELECT FLOOR(RAND()*(50-10+1))+10) YEAR), INTERVAL (SELECT FLOOR(RAND()*(30-0+1))) DAY)),
("Mario Moura", "001.658.002-11", "00.987.050-2", "1190590456", "mario.moura@gmail.com", 
date_add(date_add(curdate(), INTERVAL -(SELECT FLOOR(RAND()*(50-10+1))+10) YEAR), INTERVAL (SELECT FLOOR(RAND()*(30-0+1))) DAY));

INSERT INTO Cashier (current_status) VALUES (DEFAULT), (DEFAULT), (DEFAULT), (DEFAULT);

INSERT INTO CashierLog (cashier_number, date_recorded, time_recorded, status) 
VALUES (1, curdate(), addtime(curtime(), "-2:00:00"), "open"),
       (1, curdate(), curtime(), DEFAULT),
       (1, curdate(), addtime(curtime(), "1:00:00"), "open"),
       (1, curdate(), addtime(curtime(), "2:00:00"), DEFAULT),
       (2, curdate(), addtime(curtime(), "-2:00:00"), "open"),
       (2, curdate(), curtime(), DEFAULT);

INSERT INTO Drug (com_name, type_drug, lab, is_generic, need_pre, unit_price, desc_drug, dateshelf) 
VALUES ("Dipirona", "comprimido", "HYPERMARCAS", 1, DEFAULT, 4.50, 
"Metamizol ou, comercialmente, dipirona é medicamento ainda utilizado principalmente como analgesico e antipiretico.",
date_add(date_add(curdate(), INTERVAL -(SELECT FLOOR(RAND()*(3-0+1))) YEAR), INTERVAL (SELECT FLOOR(RAND()*(30-0+1))) DAY)),
("Buscopan", "liquido", "EUROFARMA", 0, 1, 10.00, 
"A escopolamina e um farmaco antagonista dos receptores muscarinicos, tambem conhecido como uma substância anticolinergica.",
date_add(date_add(curdate(), INTERVAL -(SELECT FLOOR(RAND()*(3-0+1))) YEAR), INTERVAL (SELECT FLOOR(RAND()*(30-0+1))) DAY));

INSERT INTO OrderInfo (date_ordered, time_ordered, special_client_id, subtotal, discount, freight, total) 
VALUES (curdate(), curtime(), 1, 72.50, 15.00, 10.00, 67.50),
(date_add(date_add(curdate(), INTERVAL -(SELECT FLOOR(RAND()*(3+1))) YEAR), INTERVAL (SELECT FLOOR(RAND()*(30-0+1))) DAY),
addtime(curtime(), "-1:10:00"), 1, 4.50, 1.00, 1.00, 4.50),
(date_add(date_add(curdate(), INTERVAL -(SELECT FLOOR(RAND()*(2+1))) YEAR), INTERVAL (SELECT FLOOR(RAND()*(10-0+1))) DAY),
addtime(curtime(), "0:10:00"), NULL, 4.50, 1.00, 1.00, 4.50);

INSERT INTO OrderItems (order_id, drug_id, quantity) 
VALUES (1, 1, 5),
       (1, 2, 5),
       (2, 1, 1),
       (3, 1, 1);