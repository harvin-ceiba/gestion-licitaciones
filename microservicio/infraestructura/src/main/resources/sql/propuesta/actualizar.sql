UPDATE propuesta 
SET 
	licitacion_id = :licitacionId, 
	nombre = :nombre,
	descripcion = :descripcion,
	nombre_cliente = :nombreCliente,
	valor = :valor,
	estado = :estado
WHERE id = :id