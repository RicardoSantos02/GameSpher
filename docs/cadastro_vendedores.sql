-- Requisito 1
CREATE TABLE vendedores (
    id_vendedor INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    cnpj_cpf VARCHAR(20),
    tipo ENUM('Pessoa Física', 'Pessoa Jurídica') NOT NULL
);
