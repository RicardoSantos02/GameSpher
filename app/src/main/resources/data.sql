-- Inserir Vendedores
INSERT INTO vendedores (nome, email, telefone, cpf) VALUES
('MegaGames', 'contato@megagames.com', '(11) 98765-4321', '111.111.111-11'),
('Player 1', 'vendas@player1.com.br', '(21) 91234-5678', '222.222.222-22'),
('Geek Store', 'suporte@geekstore.net', '(31) 99999-8888', '333.333.333-33');

-- Inserir Produtos da Categoria: Jogos (10)
INSERT INTO produtos (nome, descricao, preco, quantidade_estoque, categoria, url_imagem, vendedor_id) VALUES
('The Last of Us Part II', 'Ação-aventura, 2020', 199.90, 50, 'Jogos', 'url_imagem_jogo1', 1),
('Red Dead Redemption 2', 'Ação-aventura, 2018', 249.50, 30, 'Jogos', 'url_imagem_jogo2', 1),
('God of War Ragnarök', 'Ação-aventura, 2022', 299.99, 40, 'Jogos', 'url_imagem_jogo3', 2),
('Elden Ring', 'RPG de ação, 2022', 279.90, 60, 'Jogos', 'url_imagem_jogo4', 2),
('Cyberpunk 2077', 'RPG de ação, 2020', 159.90, 25, 'Jogos', 'url_imagem_jogo5', 3),
('The Witcher 3: Wild Hunt', 'RPG de ação, 2015', 129.90, 80, 'Jogos', 'url_imagem_jogo6', 1),
('Hades', 'Roguelike, 2020', 47.49, 100, 'Jogos', 'url_imagem_jogo7', 3),
('Stardew Valley', 'Simulação, 2016', 24.99, 150, 'Jogos', 'url_imagem_jogo8', 2),
('Hollow Knight', 'Metroidvania, 2017', 28.99, 120, 'Jogos', 'url_imagem_jogo9', 1),
('Celeste', 'Plataforma, 2018', 36.99, 90, 'Jogos', 'url_imagem_jogo10', 3);

-- Inserir Produtos da Categoria: Colecionáveis (10)
INSERT INTO produtos (nome, descricao, preco, quantidade_estoque, categoria, url_imagem, vendedor_id) VALUES
('Funko Pop! Geralt of Rivia', 'Figura de vinil, The Witcher', 89.90, 40, 'Colecionáveis', 'url_imagem_col1', 3),
('Estátua Kratos & Atreus', 'Estátua de resina, God of War', 899.90, 10, 'Colecionáveis', 'url_imagem_col2', 2),
('Action Figure Master Chief', 'Figura de ação, Halo', 299.90, 20, 'Colecionáveis', 'url_imagem_col3', 1),
('Nendoroid Link', 'Figura de ação, The Legend of Zelda', 349.90, 15, 'Colecionáveis', 'url_imagem_col4', 2),
('Réplica Lâminas do Caos', 'Réplica em escala 1:1, God of War', 1299.00, 5, 'Colecionáveis', 'url_imagem_col5', 2),
('Luminária Bloco Interrogação', 'Luminária temática, Super Mario', 149.90, 30, 'Colecionáveis', 'url_imagem_col6', 1),
('Caneca PlayStation Shapes', 'Caneca de cerâmica, 300ml', 49.90, 60, 'Colecionáveis', 'url_imagem_col7', 3),
('Chaveiro Martelo do Thor', 'Chaveiro de metal, Marvel', 29.90, 100, 'Colecionáveis', 'url_imagem_col8', 3),
('Pôster Mapa de Hyrule', 'Pôster A3, The Legend of Zelda', 39.90, 80, 'Colecionáveis', 'url_imagem_col9', 2),
('Moletom Horde', 'Moletom com capuz, World of Warcraft', 249.90, 25, 'Colecionáveis', 'url_imagem_col10', 1);

-- Inserir Produtos da Categoria: Gift Cards (10)
INSERT INTO produtos (nome, descricao, preco, quantidade_estoque, categoria, url_imagem, vendedor_id) VALUES
('Cartão Presente Steam R0', 'Crédito para a carteira Steam', 50.00, 500, 'Gift Cards', 'url_imagem_gc1', 1),
('Cartão Presente PSN R00', 'Crédito para a PlayStation Store', 100.00, 400, 'Gift Cards', 'url_imagem_gc2', 2),
('Cartão Presente Xbox R00', 'Crédito para a Xbox Store', 100.00, 450, 'Gift Cards', 'url_imagem_gc3', 1),
('Cartão Presente Nintendo eShop R0', 'Crédito para a Nintendo eShop', 50.00, 300, 'Gift Cards', 'url_imagem_gc4', 2),
('Cartão Presente Google Play R0', 'Crédito para a Google Play Store', 30.00, 600, 'Gift Cards', 'url_imagem_gc5', 3),
('Cartão Presente iFood R0', 'Crédito para o app iFood', 50.00, 200, 'Gift Cards', 'url_imagem_gc6', 3),
('Cartão Presente Netflix R0', 'Crédito para assinatura Netflix', 50.00, 250, 'Gift Cards', 'url_imagem_gc7', 1),
('Cartão Presente Spotify R0', 'Crédito para assinatura Spotify Premium', 20.00, 350, 'Gift Cards', 'url_imagem_gc8', 2),
('Cartão Presente Uber R0', 'Crédito para viagens Uber', 50.00, 150, 'Gift Cards', 'url_imagem_gc9', 3),
('Cartão Presente League of Legends R0', 'Riot Points para LoL', 50.00, 400, 'Gift Cards', 'url_imagem_gc10', 1);

-- Inserir Produtos da Categoria: Consoles e Periféricos (10)
INSERT INTO produtos (nome, descricao, preco, quantidade_estoque, categoria, url_imagem, vendedor_id) VALUES
('Console PlayStation 5', 'Edição com leitor de disco', 4499.00, 10, 'Consoles e Periféricos', 'url_imagem_cp1', 2),
('Console Xbox Series X', '1TB SSD', 4349.00, 12, 'Consoles e Periféricos', 'url_imagem_cp2', 1),
('Console Nintendo Switch OLED', 'Tela de 7 polegadas', 2599.00, 20, 'Consoles e Periféricos', 'url_imagem_cp3', 2),
('Controle DualSense PS5', 'Branco', 469.00, 50, 'Consoles e Periféricos', 'url_imagem_cp4', 2),
('Controle Xbox Series Carbon Black', 'Preto', 429.00, 60, 'Consoles e Periféricos', 'url_imagem_cp5', 1),
('Headset sem Fio Pulse 3D PS5', 'Áudio 3D', 599.00, 30, 'Consoles e Periféricos', 'url_imagem_cp6', 2),
('Teclado Mecânico Gamer HyperX Alloy', 'Switch Red', 699.90, 25, 'Consoles e Periféricos', 'url_imagem_cp7', 3),
('Mouse Gamer Logitech G502 Hero', 'Sensor de 25600 DPI', 349.90, 40, 'Consoles e Periféricos', 'url_imagem_cp8', 3),
('Webcam Logitech C920s Pro', 'Full HD 1080p', 499.90, 35, 'Consoles e Periféricos', 'url_imagem_cp9', 1),
('Monitor Gamer LG UltraGear 27\', '144Hz, 1ms', 1899.00, 15, 'Consoles e Periféricos', 'url_imagem_cp10', 3);
