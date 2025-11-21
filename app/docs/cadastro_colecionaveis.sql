-- Requisito 4: Cadastro de Colecionáveis e Itens Exclusivos
CREATE TABLE colecionaveis (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    franquia VARCHAR(100),
    tipo_item VARCHAR(50),
    edicao_exclusiva BOOLEAN DEFAULT FALSE,
    preco DECIMAL(10, 2) NOT NULL
);