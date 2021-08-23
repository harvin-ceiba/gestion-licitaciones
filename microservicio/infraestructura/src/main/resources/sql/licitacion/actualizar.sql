UPDATE licitacion
SET 
	codigo = :codigo,
	nombre = :nombre, 
	descripcion = :descripcion, 
	presupuesto = :presupuesto,
	fecha_inicio = :fechaInicio, 
	fecha_fin = :fechaFin, 
	estado = :estado
WHERE id = :id
