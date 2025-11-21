-- 1. JOGOS (Físicos e Digitais)
INSERT INTO jogos (titulo, plataforma, tipo, preco, ano_lancamento) VALUES
('The Legend of Zelda: Tears of the Kingdom', 'Nintendo Switch', 'Físico', 349.90, 2023),
('God of War Ragnarök', 'PlayStation 5', 'Físico', 299.90, 2022),
('Elden Ring', 'PC', 'Digital', 229.90, 2022),
('Grand Theft Auto V', 'Xbox Series X', 'Digital', 99.90, 2013),
('Cyberpunk 2077', 'PC', 'Digital', 199.90, 2020),
('Super Mario Odyssey', 'Nintendo Switch', 'Físico', 299.00, 2017),
('Red Dead Redemption 2', 'PlayStation 4', 'Físico', 149.90, 2018),
('Minecraft', 'PC', 'Digital', 129.90, 2011),
('The Last of Us Part I', 'PlayStation 5', 'Físico', 349.50, 2022),
('FIFA 24 (EA FC)', 'Xbox One', 'Digital', 299.90, 2023);

-- 2. CONSOLES E ACESSÓRIOS (Tabela Hardware - Categoria 'Console' ou 'Acessório')
INSERT INTO hardware (nome, fabricante, categoria, plataforma, descricao, preco) VALUES
('PlayStation 5 Edição Digital', 'Sony', 'Console', 'PlayStation', 'Console PS5 sem leitor de disco', 3999.90),
('Xbox Series X', 'Microsoft', 'Console', 'Xbox', 'O Xbox mais rápido e poderoso de todos os tempos', 4499.90),
('Nintendo Switch OLED', 'Nintendo', 'Console', 'Nintendo', 'Tela OLED vibrante de 7 polegadas', 2199.90),
('Controle DualSense', 'Sony', 'Acessório', 'PlayStation', 'Feedback háptico e gatilhos adaptáveis - Branco', 449.90),
('Controle Xbox Wireless', 'Microsoft', 'Acessório', 'Xbox', 'Robot White, compatível com PC e Mobile', 399.00),
('Headset Pulse 3D', 'Sony', 'Acessório', 'PlayStation', 'Áudio 3D ajustado para consoles PS5', 599.90),
('Joy-Con Par (Neon)', 'Nintendo', 'Acessório', 'Nintendo', 'Controles versáteis para Switch', 499.00),
('Base de Carregamento DualSense', 'Sony', 'Acessório', 'PlayStation', 'Carregue dois controles simultaneamente', 199.90),
('Cartão de Expansão Seagate 1TB', 'Seagate', 'Acessório', 'Xbox', 'Armazenamento extra SSD para Xbox Series X|S', 1299.00),
('Capa Protetora Switch', 'Hori', 'Acessório', 'Nintendo', 'Capa rígida para transporte seguro', 129.90);

-- 3. PERIFÉRICOS PARA PC (Tabela Hardware - Categoria 'Periférico')
INSERT INTO hardware (nome, fabricante, categoria, plataforma, descricao, preco) VALUES
('Teclado Mecânico HyperX Alloy', 'HyperX', 'Periférico', 'PC', 'Switch Blue, RGB, Layout ABNT2', 599.90),
('Mouse Gamer Logitech G502', 'Logitech', 'Periférico', 'PC', 'Sensor HERO 25K, Pesos ajustáveis', 299.90),
('Monitor Gamer LG UltraGear 27"', 'LG', 'Periférico', 'PC', '144Hz, 1ms, IPS Full HD', 1599.00),
('Headset Gamer Razer BlackShark V2', 'Razer', 'Periférico', 'PC', 'Drivers de 50mm, som surround 7.1', 649.90),
('Cadeira Gamer DX Racer', 'DX Racer', 'Periférico', 'PC', 'Ergonômica, reclinável até 180 graus', 1899.90),
('Mousepad Gamer Extra Grande', 'Redragon', 'Periférico', 'PC', '80x30cm, base antiderrapante', 89.90),
('Webcam Logitech C920', 'Logitech', 'Periférico', 'PC', 'Full HD 1080p, foco automático', 399.00),
('Microfone HyperX QuadCast', 'HyperX', 'Periférico', 'PC', 'Microfone condensador USB com RGB', 899.90),
('Teclado Corsair K70 RGB', 'Corsair', 'Periférico', 'PC', 'Switch Cherry MX Red, estrutura em alumínio', 999.90),
('Mouse Wireless Razer Viper', 'Razer', 'Periférico', 'PC', 'Ultraleve, tecnologia HyperSpeed', 499.90);

-- 4. COLECIONÁVEIS E ITENS EXCLUSIVOS
INSERT INTO colecionaveis (nome, franquia, tipo_item, edicao_exclusiva, preco) VALUES
('Funko Pop! Geralt of Rivia', 'The Witcher', 'Action Figure', FALSE, 129.90),
('Estátua Kratos & Atreus 1/10', 'God of War', 'Estátua', TRUE, 899.90),
('Camiseta Logo Umbrella Corp', 'Resident Evil', 'Vestuário', FALSE, 69.90),
('Réplica Varinha das Varinhas', 'Harry Potter', 'Réplica', FALSE, 249.90),
('Action Figure Spider-Man Miles Morales', 'Marvel', 'Action Figure', FALSE, 299.90),
('Pôster Metálico Cyberpunk', 'Cyberpunk 2077', 'Decoração', TRUE, 159.90),
('Capacete Master Chief (Decorativo)', 'Halo', 'Réplica', TRUE, 599.00),
('Caneca Térmica Nuka Cola', 'Fallout', 'Utensílio', FALSE, 89.90),
('Pelúcia Pikachu Gigante', 'Pokémon', 'Pelúcia', FALSE, 199.90),
('Chaveiro Espada Buster Sword', 'Final Fantasy VII', 'Acessório', FALSE, 39.90);

-- 5. GIFT CARDS E CRÉDITOS DIGITAIS
INSERT INTO giftcards (plataforma, valor, codigo_exemplo) VALUES
('PlayStation Store', 100.00, 'PSN-BR-100-EXAMPLE'),
('PlayStation Store', 250.00, 'PSN-BR-250-EXAMPLE'),
('Xbox Live', 100.00, 'XBX-BR-100-EXAMPLE'),
('Xbox Game Pass Ultimate (1 Mês)', 49.90, 'XGP-ULT-1M-EXAMPLE'),
('Steam', 50.00, 'STM-BR-50-EXAMPLE'),
('Steam', 100.00, 'STM-BR-100-EXAMPLE'),
('Nintendo eShop', 100.00, 'NIN-BR-100-EXAMPLE'),
('Nintendo eShop', 300.00, 'NIN-BR-300-EXAMPLE'),
('Riot Points (League of Legends)', 50.00, 'RIOT-BR-50-EXAMPLE'),
('Roblox Robux', 25.00, 'RBX-BR-25-EXAMPLE');