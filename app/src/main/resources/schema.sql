-- 1. Tabela de Vendedores
CREATE TABLE IF NOT EXISTS vendedores (
    id_vendedor BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    cpf VARCHAR(20) UNIQUE NOT NULL 
);

-- 2. Tabela de Jogos (Atualizado para TEXT)
CREATE TABLE IF NOT EXISTS jogos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    plataforma VARCHAR(50) NOT NULL,
    tipo VARCHAR(20) CHECK (tipo IN ('Físico', 'Digital')),
    preco DECIMAL(10, 2) NOT NULL,
    ano_lancamento INT,
    descricao TEXT,
    imagem_url TEXT, -- Aceita URLs de qualquer tamanho
    loja_url TEXT    -- Aceita URLs de qualquer tamanho
);

-- 3. Tabela de Hardware (Atualizado para TEXT)
CREATE TABLE IF NOT EXISTS hardware (
    id_hardware BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    fabricante VARCHAR(100),
    categoria VARCHAR(20) CHECK (categoria IN ('Console', 'Acessório', 'Periférico')),
    plataforma VARCHAR(50),
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    imagem_url TEXT, -- Mudado para TEXT
    loja_url TEXT    -- Mudado para TEXT
);

-- 4. Tabela de Colecionáveis (Atualizado para TEXT)
CREATE TABLE IF NOT EXISTS colecionaveis (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    franquia VARCHAR(100),
    tipo_item VARCHAR(50),
    edicao_exclusiva BOOLEAN DEFAULT FALSE,
    preco DECIMAL(10, 2) NOT NULL,
    descricao TEXT,
    imagem_url TEXT, -- Mudado para TEXT
    loja_url TEXT    -- Mudado para TEXT
);

-- 5. Tabela de Gift Cards
CREATE TABLE IF NOT EXISTS giftcards (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    plataforma VARCHAR(50) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    codigo_exemplo VARCHAR(50)
);

-- 6. Tabela de Usuários
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(20),
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    tipo VARCHAR(20) DEFAULT 'CLIENTE'
);

-- 7. Tabela de Pedidos
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