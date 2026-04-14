-- ========================================================
-- maltunaGailuElektronikoakdb Datu Basearen inplementazioa
-- ========================================================
-- ========================================================
-- eraikina taularen inplementazioa
-- ========================================================
INSERT INTO eraikina (id_eraikina, izena, deskribapena) VALUES
('N', 'Nagusia', 'Ikastetxeko eraikin nagusia'),
('T', 'Teknologia', 'Tailerrak eta laborategiak');



-- ========================================================
-- gela taularen inplementazioa
-- ========================================================
INSERT INTO gela (id_eraikina, izena, deskribapena) VALUES
('N', 'N011', 'Irakasle gela'),
('N', 'N101', 'Zuzendaritza'),
('T', 'T001', 'Mekanizazio tailerra'),
('T', 'T209', 'Informatika laborategia'),
('T', 'T310', 'Robotika laborategia'),
('T', 'T104', 'Ikasgela'),
('N', 'N001', 'Idazkaritza');


-- ========================================================
-- gailuElektronikoa taularen inplementazioa
-- ========================================================
INSERT INTO gailuElektronikoa 
(marka, modeloa, serie_zenb, alta_data, baja_data, egoera, mota) VALUES
('Dell', 'OptiPlex 7090', 'SN12345', '2023-01-10', NULL, 'erabilgarri', 'ordenagailua'),
('Lenovo', 'ThinkPad X1', 'SN12347', '2023-03-20', NULL, 'erabilgarri', 'ordenagailu eramangarria'),
('Apple', 'iPad Air', 'SN12349', '2023-05-12', NULL, 'erabilgarri', 'arbela digitala'),
('Canon', 'PIXMA G6050', 'SN12351', '2023-07-22', NULL, 'erabilgarri', 'inprimagailua'),
('Asus', 'VivoBook 15', 'SN12353', '2024-09-14', NULL, 'erabilgarri', 'ordenagailu eramangarria'),
('Samsung', 'Galaxy Tab S7', 'SN12348', '2023-04-05', NULL, 'mantenuan', 'arbela digitala'),
('Acer', 'Aspire 5', 'SN12354', '2023-10-01', '2025-11-01', 'bajan', 'ordenagailua'),
('Asus', 'VivoBook 17', 'SN12364', '2022-10-01', '2024-11-01', 'bajan', 'ordenagailua'),
('HP', 'EliteBook 840', 'SN12346', '2023-02-15', NULL, 'hartua', 'ordenagailu eramangarria'),
('Samsung', 'Galaxy Tab S2', 'SN12351', '2024-04-05', NULL, 'hartua', 'arbela digitala'),
('Apple', 'i Mac', 'SN12370', '2024-05-12', NULL, 'mantenuan', 'tableta'),
('Epson', 'EB-X41', 'SN12350', '2023-06-18', NULL, 'hartua', 'proiektorea'),
('Canon', 'PIXMA G1000', 'SN22222', '2025-07-22', NULL, 'hartua', 'inprimagailua'),
('LG', '24MK600M', 'SN12352', '2023-08-30', NULL, 'mantenuan', 'monitorea');



-- ========================================================
-- erabiltzailea taularen inplementazioa
-- ========================================================
INSERT INTO erabiltzailea
(izena, abizena, erabiltzaile_izena, pasahitza, erabiltzaile_rola, alta_data, baja_data) VALUES
('Jon', 'Etxeberria', 'jonetx', '123', 'admin', '2024-01-10', NULL),
('Ane', 'Garcia', 'user', '123', 'arrunta', '2024-01-12', NULL),
('Mikel', 'Lopez', 'mikello', '123', 'arrunta', '2024-01-15', NULL),
('Leire', 'Fernandez', 'admin', '123', 'admin', '2022-01-20', NULL),
('Unai', 'Martinez', 'unaim', '123', 'arrunta', '2023-02-01', NULL),
('Nerea', 'Sanchez', 'nereas', '123', 'arrunta', '2022-02-05', NULL),
('Iker', 'Ruiz', 'ikerr', '123', 'arrunta', '2024-02-10', NULL),
('Maite', 'Gomez', 'maiteg', '123', 'admin', '2024-02-15','2024-12-31'),
('Asier', 'Diaz', 'asierd', '123', 'arrunta', '2024-02-20', '2024-12-31'),
('Irati', 'Moreno', 'iratim', '123', 'arrunta', '2023-03-01', '2024-12-31');



-- ========================================================
-- kudeatu taularen inplementazioa
-- ========================================================
INSERT INTO kudeatu 
(id_erabiltzailea, id_gailua, kudeatze_data, kudeatze_mota) VALUES
(4, 1, '2023-02-15', 'gehitu'),
(1, 3, '2024-03-05', 'editatu'),
(4, 7, '2025-11-01', 'ezabatu');



-- ========================================================
-- egon taularen inplementazioa
-- ========================================================
INSERT INTO egon 
(id_gailua, id_gela, hasiera_data, amaiera_data) VALUES
(1, 1, '2025-01-01', '2025-01-02'),
(2, 2, '2025-02-02', NULL),
(3, 3, '2025-03-03', NULL),
(4, 4, '2025-01-04', NULL),
(5, 5, '2025-03-05', NULL),
(6, 6, '2024-02-06', NULL);