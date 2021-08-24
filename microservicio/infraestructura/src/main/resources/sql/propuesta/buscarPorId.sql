SELECT id, licitacion_id, nombre, descripcion, nombre_cliente, valor, fecha_creacion, fecha_publicacion, estado 
FROM propuesta
WHERE id = :id