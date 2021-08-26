UPDATE propuesta 
SET 
	puntaje = :puntaje,
	fecha_publicacion = CURRENT_TIMESTAMP,
	estado = 1
WHERE id = :id