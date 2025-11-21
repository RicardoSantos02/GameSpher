--Requisito 3
CREATE TABLE hardware (
    id_hardware INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    fabricante VARCHAR(100),
    categoria ENUM('Console', 'Acessório', 'Periférico') NOT NULL,
    plataforma VARCHAR(50), -- ex: PC, PlayStation, Xbox, Nintendo
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL
);
