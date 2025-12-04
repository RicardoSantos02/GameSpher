CREATE TABLE IF NOT EXISTS produtos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    imagem_url TEXT,
    loja_url TEXT
);

CREATE TABLE IF NOT EXISTS jogos (
    id BIGINT PRIMARY KEY,
    plataforma VARCHAR(50),
    tipo VARCHAR(20),
    ano_lancamento INT,
    FOREIGN KEY (id) REFERENCES produtos(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS hardware (
    id BIGINT PRIMARY KEY,
    fabricante VARCHAR(100),
    categoria VARCHAR(50),
    plataforma VARCHAR(50),
    FOREIGN KEY (id) REFERENCES produtos(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS colecionaveis (
    id BIGINT PRIMARY KEY,
    franquia VARCHAR(100),
    tipo_item VARCHAR(50),
    edicao_exclusiva BOOLEAN,
    FOREIGN KEY (id) REFERENCES produtos(id) ON DELETE CASCADE
);

-- Tabelas auxiliares
CREATE TABLE IF NOT EXISTS vendedores (
    id_vendedor BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    cpf VARCHAR(20) UNIQUE NOT NULL 
);

CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(20),
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    tipo VARCHAR(20) DEFAULT 'CLIENTE'
);

CREATE TABLE IF NOT EXISTS pedidos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50),
    data_pedido VARCHAR(20),
    total DECIMAL(10, 2),
    status VARCHAR(50),
    itens_resumo TEXT,
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);