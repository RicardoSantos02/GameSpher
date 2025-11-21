-- Requisito 1
-- Cria a tabela 'vendedores' se ela ainda não existir
CREATE TABLE IF NOT EXISTS vendedores (
    id_vendedor BIGINT AUTO_INCREMENT PRIMARY KEY, -- Usando BIGINT para corresponder ao Long da entidade
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    cpf VARCHAR(20) UNIQUE NOT NULL 
);
