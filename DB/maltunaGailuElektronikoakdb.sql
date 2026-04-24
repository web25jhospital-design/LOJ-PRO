-- ============================
-- Datubasea sortu
-- ============================
-- maltunaGailuElektronikoakdb
-- ============================

DROP DATABASE IF EXISTS maltunaGailuElektronikoakdb;
CREATE DATABASE IF NOT EXISTS maltunaGailuElektronikoakdb;
USE maltunaGailuElektronikoakdb;



-- =============================
-- eraikina taula sortu
-- =============================
CREATE TABLE eraikina (
id_eraikina VARCHAR(4) PRIMARY KEY,
izena VARCHAR(20) NOT NULL,
deskribapena VARCHAR(200) NOT NULL
);


-- =============================
-- gela taula sortu
-- =============================
CREATE TABLE gela (
id_gela INT AUTO_INCREMENT,
id_eraikina VARCHAR(4),
izena VARCHAR(7) UNIQUE NOT NULL,
deskribapena VARCHAR(200),
PRIMARY KEY (id_gela, id_eraikina),
FOREIGN KEY (id_eraikina) REFERENCES eraikina(id_eraikina) ON UPDATE CASCADE ON DELETE CASCADE
);



-- =============================
-- gailuElektronikoa taula sortu
-- =============================
CREATE TABLE gailuelektronikoa (
id_gailua INT AUTO_INCREMENT PRIMARY KEY,
marka VARCHAR(20) NOT NULL,
modeloa VARCHAR(50) NOT NULL,
serie_zenb VARCHAR(50) NOT NULL,
alta_data DATETIME NOT NULL,
baja_data DATETIME,
egoera ENUM('erabilgarri', 'hartua', 'mantenuan', 'bajan') NOT NULL, -- erabilgarri / hartua / mantenuan / bajan
mota VARCHAR(50) NOT NULL
);



-- =============================
-- erabiltzailea taula sortu
-- =============================
CREATE TABLE erabiltzailea (
id_erabiltzailea INT AUTO_INCREMENT PRIMARY KEY,
izena VARCHAR(20) NOT NULL,
abizena VARCHAR(40) NOT NULL,
erabiltzaile_izena VARCHAR(20) NOT NULL UNIQUE,
pasahitza VARCHAR(20) NOT NULL,
erabiltzaile_rola ENUM('admin', 'arrunta') NOT NULL, -- admin / arrunta
alta_data DATETIME NOT NULL,
baja_data DATETIME
);



-- =============================
-- kudeatu taula sortu
-- =============================
CREATE TABLE kudeatu (
id_kudeatu INT AUTO_INCREMENT,
id_erabiltzailea INT,
id_gailua INT,
kudeatze_data DATETIME NOT NULL,
kudeatze_mota ENUM('gehitu', 'editatu', 'ezabatu') NOT NULL, -- gehitu / editatu / ezabatu
PRIMARY KEY (id_kudeatu, id_erabiltzailea, id_gailua),
FOREIGN KEY (id_erabiltzailea) REFERENCES erabiltzailea(id_erabiltzailea),
FOREIGN KEY (id_gailua) REFERENCES gailuElektronikoa(id_gailua)
);



-- =============================
-- egon taula sortu
-- =============================
CREATE TABLE egon (
id_egon INT AUTO_INCREMENT,
id_gailua INT,
id_gela INT,
hasiera_data DATETIME NOT NULL,
amaiera_data DATETIME,
PRIMARY KEY (id_egon, id_gailua),
FOREIGN KEY (id_gailua) REFERENCES gailuElektronikoa(id_gailua),
FOREIGN KEY (id_gela) REFERENCES gela(id_gela)
);