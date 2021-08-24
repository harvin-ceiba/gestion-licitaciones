insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

INSERT INTO licitacion (id, codigo, nombre, descripcion, presupuesto, fecha_inicio, fecha_fin) VALUES (1, '001', 'LICITACION1', 'DESCRIPCION1', 10000000, '2021-08-01', '2021-08-31');

INSERT INTO requerimiento (id, descripcion, estado) VALUES (1, 'REQ1', 1);
INSERT INTO requerimiento (id, descripcion, estado) VALUES (2, 'REQ2', 1);

INSERT INTO licitacion_requerimiento (licitacion_id, requerimiento_id, peso_porcentual) VALUES (1, 1, 40);
INSERT INTO licitacion_requerimiento (licitacion_id, requerimiento_id, peso_porcentual) VALUES (1, 2, 60);