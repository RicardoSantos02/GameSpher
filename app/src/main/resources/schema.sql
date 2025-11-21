-- Tabela de Vendedores (Já existia)
CREATE TABLE IF NOT EXISTS vendedores (
    id_vendedor BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    cpf VARCHAR(20) UNIQUE NOT NULL 
);

-- Tabela de Jogos (RF.002)
CREATE TABLE IF NOT EXISTS jogos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    plataforma VARCHAR(50) NOT NULL,
    tipo VARCHAR(20) CHECK (tipo IN ('Físico', 'Digital')),
    preco DECIMAL(10, 2) NOT NULL,
    ano_lancamento INT
);

-- Tabela de Hardware (Consoles, Acessórios e Periféricos - RF.003)
CREATE TABLE IF NOT EXISTS hardware (
    id_hardware BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    fabricante VARCHAR(100),
    categoria VARCHAR(20) CHECK (categoria IN ('Console', 'Acessório', 'Periférico')),
    plataforma VARCHAR(50),
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL
);

-- Tabela de Colecionáveis (RF.004)
CREATE TABLE IF NOT EXISTS colecionaveis (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    franquia VARCHAR(100),
    tipo_item VARCHAR(50),
    edicao_exclusiva BOOLEAN DEFAULT FALSE,
    preco DECIMAL(10, 2) NOT NULL
);

-- Tabela de Gift Cards (RF.005)
CREATE TABLE IF NOT EXISTS giftcards (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    plataforma VARCHAR(50) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    codigo_exemplo VARCHAR(50)
);