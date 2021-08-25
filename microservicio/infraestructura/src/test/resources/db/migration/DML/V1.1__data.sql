insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

INSERT INTO licitacion (id, codigo, nombre, descripcion, presupuesto, fecha_inicio, fecha_fin) VALUES (1, '001', 'LICITACION1', 'DESCRIPCION1', 10000000, '2021-08-01', '2021-08-31');

INSERT INTO requerimiento (id, descripcion, estado) VALUES (1, 'REQUERIMIENTO1', 1);
INSERT INTO requerimiento (id, descripcion, estado) VALUES (2, 'REQUERIMIENTO2', 1);
INSERT INTO requerimiento (id, descripcion, estado) VALUES (3, 'REQUERIMIENTO3', 1);

INSERT INTO licitacion_requerimiento (licitacion_id, requerimiento_id, peso_porcentual) VALUES (1, 1, 40);
INSERT INTO licitacion_requerimiento (licitacion_id, requerimiento_id, peso_porcentual) VALUES (1, 2, 60);

INSERT INTO propuesta (licitacion_id, nombre, descripcion, nombre_cliente, valor) VALUES (1, 'PROPUESTA1', 'DESCRIPCION1', 'CLIENTE1', 9500000);

INSERT INTO propuesta_requerimiento (propuesta_id, requerimiento_id) VALUES (1, 1);
INSERT INTO propuesta_requerimiento (propuesta_id, requerimiento_id) VALUES (1, 2);