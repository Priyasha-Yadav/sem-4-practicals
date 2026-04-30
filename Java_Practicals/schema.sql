CREATE TABLE accounts (
    account_number INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    balance DECIMAL(15,2) NOT NULL
);

INSERT INTO accounts (account_number, name, balance) VALUES
    (101, 'Alice', 5000.00),
    (102, 'Bank Reserve', 1000.00);