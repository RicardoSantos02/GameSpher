-- Requisito 1: Cadastro de Jogos Físicos e Digitais
CREATE TABLE jogos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    plataforma VARCHAR(50) NOT NULL,
    tipo VARCHAR(20) CHECK (tipo IN ('Físico', 'Digital')),
    preco DECIMAL(10, 2) NOT NULL,
    ano_lancamento INT
);