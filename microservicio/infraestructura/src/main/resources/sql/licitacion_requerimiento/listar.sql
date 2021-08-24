SELECT id, licitacion_id, requerimiento_id, peso_porcentual 
FROM licitacion_requerimiento
WHERE licitacion_id = :licitacionId