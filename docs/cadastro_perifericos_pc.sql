-- Requisito 3: Cadastro de Periféricos para PC
CREATE TABLE perifericos_pc (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) CHECK (
        categoria IN ('Teclado', 'Mouse', 'Cadeira Gamer', 'Outro')
    ),
    marca VARCHAR(50),
    preco DECIMAL(10, 2) NOT NULL
);