-- Requisito 1
-- Cria a tabela 'vendedores' se ela ainda não existir
CREATE TABLE IF NOT EXISTS vendedores (
    id_vendedor BIGINT AUTO_INCREMENT PRIMARY KEY, -- Usando BIGINT para corresponder ao Long da entidade
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    cnpj_cpf VARCHAR(20) UNIQUE NOT NULL, -- Adicionado UNIQUE para corresponder à entidade
    tipo VARCHAR(20) NOT NULL -- Alterado de ENUM para VARCHAR para corresponder à entidade Java
);
