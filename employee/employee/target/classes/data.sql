CREATE TABLE employee (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  lastName VARCHAR(255),
  email VARCHAR(255) UNIQUE,
  phone VARCHAR(50),
  address VARCHAR(255)
);

INSERT INTO employee(name, lastName, email, phone, address)
VALUES ('siva', 'ram', 'siva@example.com','9999999', 'Chennai');
