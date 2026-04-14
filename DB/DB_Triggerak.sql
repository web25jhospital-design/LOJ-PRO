-- TRIGGER-a gailuelektronikoa taulan INSERT-a burutzean
DELIMITER $$
DROP TRIGGER IF EXISTS trg_gailua_insert$$
CREATE TRIGGER trg_gailua_insert
AFTER INSERT ON gailuelektronikoa 
FOR EACH ROW
BEGIN
	INSERT INTO kudeatu (id_gailua, id_erabiltzailea, kudeatze_data, kudeatze_mota)
    VALUES (NEW.id_gailua, @erabiltzailea, NOW(), 'gehitu');
END$$


-- TRIGGER-a gailuelektronikoa taulan UPDATE-a burutzean:
-- TRIGGER-a gailuelektronikoa taulan DELETE-a burutzean:
-- Gailu bat ezabatzeko berez aplikazioak egiten duena da: gailu horren update bat baja fetxa jarriaz.
DROP TRIGGER IF EXISTS trg_gailua_update$$
CREATE TRIGGER trg_gailua_update 
BEFORE UPDATE ON gailuelektronikoa
FOR EACH ROW
BEGIN
	IF (NEW.baja_data IS NULL) THEN
		INSERT INTO kudeatu (id_gailua, id_erabiltzailea, kudeatze_data, kudeatze_mota)
		VALUES (OLD.id_gailua, @erabiltzailea, NOW(), 'editatu');
	ELSE
		INSERT INTO kudeatu (id_gailua, id_erabiltzailea, kudeatze_data, kudeatze_mota)
		VALUES (OLD.id_gailua, @erabiltzailea, NOW(), 'ezabatu');
    END IF;
END;$$

DELIMITER ;
