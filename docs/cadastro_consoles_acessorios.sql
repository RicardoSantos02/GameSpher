-- Requisito 2: Cadastro de Consoles e Acessórios
CREATE TABLE consoles_acessorios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) CHECK (tipo IN ('Console', 'Acessório')),
    compatibilidade VARCHAR(100),
    preco DECIMAL(10, 2) NOT NULL
);