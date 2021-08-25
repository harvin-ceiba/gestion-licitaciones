UPDATE licitacion_requerimiento 
SET 
	peso_porcentual = :pesoPorcentual
WHERE licitacion_id = :licitacionId AND requerimiento_id = :requerimientoId