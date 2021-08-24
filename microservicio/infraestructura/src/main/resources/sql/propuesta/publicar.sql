UPDATE propuesta 
SET 
	fecha_publicacion = CURRENT_TIMESTAMP,
	estado = 1
WHERE id = :id