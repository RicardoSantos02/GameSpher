-- Requisito 5: Cadastro de Gift Cards e Créditos Digitais
CREATE TABLE giftcards (
    id INT PRIMARY KEY AUTO_INCREMENT,
    plataforma VARCHAR(50) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    codigo_exemplo VARCHAR(50)
);