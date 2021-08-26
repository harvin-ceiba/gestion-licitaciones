SELECT id, licitacion_id, nombre, descripcion, nombre_cliente, valor, puntaje, fecha_creacion, fecha_publicacion, estado 
FROM propuesta
WHERE licitacion_id = :licitacionId AND estado = 1
ORDER BY puntaje DESC