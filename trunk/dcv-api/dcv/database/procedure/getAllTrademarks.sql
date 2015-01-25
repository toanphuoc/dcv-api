DROP PROCEDURE IF EXISTS getAllTrademarks;$$
CREATE PROCEDURE getAllTrademarks()
BEGIN
	SELECT id, name, description FROM trademarks ORDER BY name;
END$$