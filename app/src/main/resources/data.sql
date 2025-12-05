-- ========================================================
-- 1. INSERINDO AS CATEGORIAS (Entidade Forte)
-- ========================================================
-- Para Jogos
INSERT INTO categorias (id, nome, grupo) VALUES (1, 'Mídia Física', 'JOGO');
INSERT INTO categorias (id, nome, grupo) VALUES (2, 'Código Digital', 'JOGO');

-- Para Hardware
INSERT INTO categorias (id, nome, grupo) VALUES (3, 'Console', 'HARDWARE');
INSERT INTO categorias (id, nome, grupo) VALUES (4, 'Acessório', 'HARDWARE');
INSERT INTO categorias (id, nome, grupo) VALUES (5, 'Periférico', 'HARDWARE');

-- Para Colecionáveis
INSERT INTO categorias (id, nome, grupo) VALUES (6, 'Action Figure', 'COLECIONAVEL');
INSERT INTO categorias (id, nome, grupo) VALUES (7, 'Estátua', 'COLECIONAVEL');
INSERT INTO categorias (id, nome, grupo) VALUES (8, 'Réplica', 'COLECIONAVEL');
INSERT INTO categorias (id, nome, grupo) VALUES (9, 'Decoração', 'COLECIONAVEL');
INSERT INTO categorias (id, nome, grupo) VALUES (10, 'Vestuário', 'COLECIONAVEL');
INSERT INTO categorias (id, nome, grupo) VALUES (11, 'Utensílio', 'COLECIONAVEL');
INSERT INTO categorias (id, nome, grupo) VALUES (12, 'Pelúcia', 'COLECIONAVEL');


-- ========================================================
-- 2. JOGOS (10 Itens)
-- ========================================================
-- Zelda (Físico)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(1, 'The Legend of Zelda: Tears of the Kingdom', 349.90, 'Uma aventura épica pelos céus e terras de Hyrule.', 'https://m.media-amazon.com/images/I/618GR0WMoQL._AC_SX679_.jpg', 'https://www.amazon.com.br/Legend-Zelda-Kingdom-Nintendo-Switch/dp/B0C3JL1R92', 1);
INSERT INTO jogos (id, plataforma, ano_lancamento) VALUES (1, 'Switch', 2023);

-- God of War (Físico)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(2, 'God of War Ragnarök', 249.90, 'Kratos e Atreus devem viajar pelos Nove Reinos em busca de respostas.', 'https://m.media-amazon.com/images/I/8136lnf0n2L._AC_SX342_SY445_QL70_ML2_.jpg', 'https://www.amazon.com.br/God-War-Ragnar%C3%B6k-Standard-PlayStation/dp/B0BH59HP23', 1);
INSERT INTO jogos (id, plataforma, ano_lancamento) VALUES (2, 'PS5', 2022);

-- Elden Ring (Físico)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(3, 'Elden Ring', 229.90, 'Levante-se, Maculado, e seja guiado pela graça.', 'https://m.media-amazon.com/images/I/81j-34Pnr2L._AC_SX679_.jpg', 'https://www.amazon.com.br/Elden-Ring-Shadow-Erdtree-PlayStation/dp/B0D3VGPSNX', 1);
INSERT INTO jogos (id, plataforma, ano_lancamento) VALUES (3, 'PS5', 2022);

-- GTA V (Físico)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(4, 'Grand Theft Auto V', 119.90, 'Explore o mundo premiado de Los Santos e Blaine County.', 'https://m.media-amazon.com/images/I/91CtyoIhXoL._AC_SX342_SY445_QL70_ML2_.jpg', 'https://www.amazon.com.br/GTA-Premium-Online-Xbox-One/dp/B07D96NFFD', 1);
INSERT INTO jogos (id, plataforma, ano_lancamento) VALUES (4, 'Xbox One', 2013);

-- Cyberpunk (Físico)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(5, 'Cyberpunk 2077', 149.90, 'Torne-se um mercenário urbano fora da lei em Night City.', 'https://m.media-amazon.com/images/I/81YptknEr3L._AC_SX342_SY445_QL70_ML2_.jpg', 'https://www.amazon.com.br/Cyberpunk-2077-Xbox-One-Games/dp/B07DJWBYKP', 1);
INSERT INTO jogos (id, plataforma, ano_lancamento) VALUES (5, 'PS4', 2020);

-- RDR2 (Físico)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(6, 'Red Dead Redemption 2', 149.90, 'A vida no coração da América no início da era moderna.', 'https://m.media-amazon.com/images/I/71XrxGqPosL._AC_SX569_.jpg', 'https://www.amazon.com.br/Rockstar-Games-TT000193PS4-Dead-Redemption/dp/B07GT6FMDK', 1);
INSERT INTO jogos (id, plataforma, ano_lancamento) VALUES (6, 'PS4', 2018);

-- Minecraft (Físico)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(7, 'Minecraft', 169.90, 'Construa, explore e sobreviva em um mundo de blocos.', 'https://m.media-amazon.com/images/I/71dIHv1zh7L._AC_SY741_.jpg', 'https://www.amazon.com.br/NINTENDO-HACPAEUCA-Minecraft-Switch/dp/B07D13QGXM', 1);
INSERT INTO jogos (id, plataforma, ano_lancamento) VALUES (7, 'Switch', 2011);

-- EA FC 24 (Físico)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(8, 'EA SPORTS FC 24', 199.90, 'O jogo de todo mundo. O novo capítulo do futebol.', 'https://m.media-amazon.com/images/I/61+lZsNKGuL._AC_SX679_.jpg', 'https://www.amazon.com.br/EA-Sports-FC-24-PlayStation/dp/B0CH3NF7YH', 1);
INSERT INTO jogos (id, plataforma, ano_lancamento) VALUES (8, 'PS5', 2023);

-- Horizon FW (Físico)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(9, 'Horizon Forbidden West', 199.90, 'Explore terras distantes, enfrente máquinas maiores.', 'https://m.media-amazon.com/images/I/61MXORMRgML._AC_SX679_.jpg', 'https://www.amazon.com.br/Horizon-Forbidden-West-Edi%C3%A7%C3%A3o-Padr%C3%A3o/dp/B09FTL6HQW', 1);
INSERT INTO jogos (id, plataforma, ano_lancamento) VALUES (9, 'PS5', 2022);

-- Starfield (Físico)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(10, 'Starfield', 349.90, 'Neste RPG de nova geração, crie qualquer personagem.', 'https://store-images.s-microsoft.com/image/apps.35187.13567343664224659.1eb6fdf9-8a0b-4344-a135-ab17dfa3c609.c83b6d6a-56c3-4c3f-8b31-456cfb21c3b7?q=90&w=177&h=265', 'https://www.xbox.com/en-US/games/store/starfield', 1);
INSERT INTO jogos (id, plataforma, ano_lancamento) VALUES (10, 'Xbox Series', 2023);


-- ========================================================
-- 3. HARDWARE (10 Itens)
-- ========================================================
-- PS5 (Console - ID 3)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(11, 'PlayStation 5 Slim', 3799.90, 'Console PS5 Edição Digital Slim. Jogar Não Tem Limites.', 'https://m.media-amazon.com/images/I/51dfg52K-cL._AC_SX679_.jpg', 'https://www.amazon.com.br/PlayStation-1000046552-Console-PlayStation%C2%AE5-Pro/dp/B0DH8J5YGH', 3);
INSERT INTO hardware (id, fabricante, plataforma) VALUES (11, 'Sony', 'PlayStation');

-- Xbox (Console - ID 3)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(12, 'Xbox Series X', 4299.90, 'O Xbox mais rápido e poderoso de todos os tempos.', 'https://m.media-amazon.com/images/I/516pVDAQMnL._AC_SX679_.jpg', 'https://www.amazon.com.br/Microsoft-Console-Xbox-Series-X/dp/B088GHBH92', 3);
INSERT INTO hardware (id, fabricante, plataforma) VALUES (12, 'Microsoft', 'Xbox');

-- Switch (Console - ID 3)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(13, 'Nintendo Switch OLED', 1999.90, 'Tela OLED vibrante de 7 polegadas.', 'https://m.media-amazon.com/images/I/7148mbvrbWL._AC_SX679_.jpg', 'https://www.amazon.com.br/Console-Nintendo-Switch-OLED-Vermelho/dp/B098RL6SBJ', 3);
INSERT INTO hardware (id, fabricante, plataforma) VALUES (13, 'Nintendo', 'Nintendo');

-- DualSense (Acessório - ID 4)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(14, 'Controle DualSense', 439.90, 'Feedback háptico e gatilhos adaptáveis.', 'https://m.media-amazon.com/images/I/517nIWAoJFL._AC_SX342_SY445_QL70_ML2_.jpg', 'https://www.amazon.com.br/PlayStation-DualSense-Controle-sem-fio/dp/B0CQKKHT5J', 4);
INSERT INTO hardware (id, fabricante, plataforma) VALUES (14, 'Sony', 'PS5');

-- Pulse 3D (Acessório - ID 4)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(15, 'Headset Pulse 3D', 549.90, 'Áudio 3D ajustado para consoles PS5.', 'https://m.media-amazon.com/images/I/710JQa5GUTL._AC_SX342_SY445_QL70_ML2_.jpg', 'https://www.amazon.com.br/Playstation-Headset-sem-PULSE-Modelo/dp/B0BP2NW8BL', 4);
INSERT INTO hardware (id, fabricante, plataforma) VALUES (15, 'Sony', 'PS5');

-- Teclado (Periférico - ID 5)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(16, 'Teclado HyperX Alloy', 499.00, 'Teclado mecânico compacto e resistente.', 'https://m.media-amazon.com/images/I/61b+3QeNq-L._AC_SX679_.jpg', 'https://www.amazon.com.br/Teclado-Gamer-HyperX-Origins-Layout/dp/B08YP9VMSN', 5);
INSERT INTO hardware (id, fabricante, plataforma) VALUES (16, 'HyperX', 'PC');

-- Mouse (Periférico - ID 5)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(17, 'Mouse Razer DeathAdder', 199.90, 'Mouse gamer ergonômico de alta precisão.', 'https://m.media-amazon.com/images/I/718b9wK3eaL._AC_SY300_SX300_QL70_ML2_.jpg', 'https://www.amazon.com.br/Mouse-Gamer-Logitech-G502-LIGHTSPEED/dp/B07DCSZV9Y', 5);
INSERT INTO hardware (id, fabricante, plataforma) VALUES (17, 'Razer', 'PC');

-- Monitor (Periférico - ID 5)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(18, 'Monitor LG UltraGear 27', 1399.00, 'Monitor Gamer 144Hz 1ms IPS Full HD.', 'https://m.media-amazon.com/images/I/61GElLiaorL._AC_SX679_.jpg', 'https://www.amazon.com.br/LG-UltraGear-27GS60F-B-FreeSyncTM-DisplayPort/dp/B0DB6DF87Y', 5);
INSERT INTO hardware (id, fabricante, plataforma) VALUES (18, 'LG', 'PC');

-- Cadeira (Periférico - ID 5)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(19, 'Cadeira Gamer DX Racer', 1799.00, 'Conforto e ergonomia para longas sessões.', 'https://m.media-amazon.com/images/I/51wJWWOzbeL._AC_SY300_SX300_QL70_ML2_.jpg', 'https://www.amazon.com.br/Cadeira-Gamer-Fox-Racer-Extreme/dp/B0D8JN1ZYS', 5);
INSERT INTO hardware (id, fabricante, plataforma) VALUES (19, 'DXRacer', 'PC');

-- Volante (Acessório - ID 4)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(20, 'Volante Logitech G29', 1599.00, 'Volante de corrida com Force Feedback.', 'https://m.media-amazon.com/images/I/61j1ZCgzQRL._AC_SX342_SY445_QL70_ML2_.jpg', 'https://www.amazon.com.br/Volante-Logitech-Joysticks-Controles-Computador/dp/B017RBNOI4', 4);
INSERT INTO hardware (id, fabricante, plataforma) VALUES (20, 'Logitech', 'PC/PS');


-- ========================================================
-- 4. COLECIONÁVEIS (10 Itens)
-- ========================================================
-- Geralt (Action Figure - ID 6)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(21, 'Funko Pop! Geralt', 129.90, 'O bruxo Geralt pronto para a batalha.', 'https://sw6.elbenwald.de/thumbnail/12/10/29/1686436954/E1075829_3_1600x1600.jpg', 'https://www.elbenwald.com/the-witcher/witcher-geralt-of-rivia-funko-pop-figure', 6);
INSERT INTO colecionaveis (id, franquia, edicao_exclusiva) VALUES (21, 'The Witcher', FALSE);

-- Kratos (Estátua - ID 7)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(22, 'Estátua Kratos', 899.90, 'Estátua de luxo detalhada da Iron Studios.', 'https://http2.mlstatic.com/D_NQ_NP_2X_708714-MLB73657657088_012024-F.webp', 'https://www.mercadolivre.com.br/estatua-kratos-ragnarok-30cm-de-altura-sob-encomenda', 7);
INSERT INTO colecionaveis (id, franquia, edicao_exclusiva) VALUES (22, 'God of War', TRUE);

-- Master Chief (Réplica - ID 8)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(23, 'Capacete Master Chief', 599.00, 'Réplica em tamanho real do capacete Spartan.', 'https://http2.mlstatic.com/D_NQ_NP_2X_602827-MLB69356937372_052023-F.webp', 'https://www.mercadolivre.com.br/capacete-master-chief-halo-c-suporte-e-luzes-led-escala-11', 8);
INSERT INTO colecionaveis (id, franquia, edicao_exclusiva) VALUES (23, 'Halo', TRUE);

-- Poster (Decoração - ID 9)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(24, 'Pôster Cyberpunk', 89.00, 'Arte oficial de Night City com moldura.', 'https://http2.mlstatic.com/D_NQ_NP_2X_882771-MLB44908229723_022021-F.webp', 'https://www.mercadolivre.com.br/quadro-emoldurado-poster-cyberpunk-2077-futuro-guerra-a3', 9);
INSERT INTO colecionaveis (id, franquia, edicao_exclusiva) VALUES (24, 'Cyberpunk', FALSE);

-- Caneca (Utensílio - ID 11)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(25, 'Caneca Mario Bros', 69.90, 'Caneca cerâmica bloco de interrogação.', 'https://http2.mlstatic.com/D_NQ_NP_628282-MLB41903601689_052020-O-caneca-quadrada-bloco-de-interrogaco-super-mario-original.webp', 'https://www.ideiaz.com.br/MLB-1531044948-caneca-quadrada-bloco-de-interrogaco-super-mario-original', 11);
INSERT INTO colecionaveis (id, franquia, edicao_exclusiva) VALUES (25, 'Nintendo', FALSE);

-- Chaveiro (Acessório - ID 11 ou similar)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(26, 'Chaveiro Buster Sword', 49.90, 'Espada icônica de Cloud Strife em metal.', 'https://m.media-amazon.com/images/I/410bA1K6dyL._AC_SY550_.jpg', 'https://www.amazon.com.br/DoubleChin-Chaveiro-Final-Fantasy-Buster/dp/B0BV7Z5NCF', 11);
INSERT INTO colecionaveis (id, franquia, edicao_exclusiva) VALUES (26, 'Final Fantasy', FALSE);

-- Camiseta (Vestuário - ID 10)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(27, 'Camiseta The Last of Us', 89.90, 'Estampa oficial Vaga-lumes.', 'https://http2.mlstatic.com/D_NQ_NP_2X_975500-MLB91142263226_092025-F-camiseta-the-last-of-us-estampada-em-dtf-camisa-malha-261.webp', 'https://produto.mercadolivre.com.br/MLB-4188231435-camiseta-the-last-of-us-estampada-em-dtf-camisa-malha-261', 10);
INSERT INTO colecionaveis (id, franquia, edicao_exclusiva) VALUES (27, 'TLOU', FALSE);

-- Luminária (Decoração - ID 9)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(28, 'Luminária Pac-Man', 159.90, 'Luminária fantasma que muda de cor USB.', 'https://m.media-amazon.com/images/I/71qlD4rp4cL._AC_SX342_SY445_QL70_ML2_.jpg', 'https://www.amazon.com.br/Lumin%C3%A1ria-Pac-Man-Ghost-Light-Paladone/dp/B00U1Y8S40', 9);
INSERT INTO colecionaveis (id, franquia, edicao_exclusiva) VALUES (28, 'Pac-Man', FALSE);

-- Pelúcia (Pelúcia - ID 12)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(29, 'Pelúcia Pikachu Gigante 80cm', 289.90, 'Pelúcia Pikachu Jumbo Gigante 80cm (Seu Pedido!).', 'https://http2.mlstatic.com/D_NQ_NP_2X_812005-MLA95522190658_102025-F.webp', 'https://www.mercadolivre.com.br/pikachu-pokemon-pokebola-pelucia-jumbo-gigante-80cm-cor-pikachu-pokebola', 12);
INSERT INTO colecionaveis (id, franquia, edicao_exclusiva) VALUES (29, 'Pokémon', FALSE);

-- Spider (Action Figure - ID 6)
INSERT INTO produtos (id, nome, preco, descricao, imagem_url, loja_url, categoria_id) VALUES 
(30, 'Action Figure Spider-Man', 349.90, 'Homem-Aranha traje avançado PS5.', 'https://m.media-amazon.com/images/I/610gslY5gEL._AC_SY300_SX300_QL70_ML2_.jpg', 'https://www.amazon.com.br/Marvels-Spider-Man-Miles-Morales-Playstation/dp/B08FC5J86P', 6);
INSERT INTO colecionaveis (id, franquia, edicao_exclusiva) VALUES (30, 'Marvel', TRUE);


-- USUÁRIOS
INSERT INTO usuarios (nome, email, senha, cpf, telefone, tipo) VALUES 
('Ricardo Vendedor', 'admin@gamespher.com', '123', '000.000.000-01', '(84) 99999-1111', 'VENDEDOR'),
('Cliente Teste', 'cliente@gmail.com', '123', '000.000.000-02', '(84) 99999-2222', 'CLIENTE');

-- RESET DOS IDS (Essencial)
ALTER TABLE produtos ALTER COLUMN id RESTART WITH 31;
ALTER TABLE categorias ALTER COLUMN id RESTART WITH 20;