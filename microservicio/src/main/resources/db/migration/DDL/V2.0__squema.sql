CREATE TABLE IF NOT EXISTS licitacion (
  id INT NOT NULL AUTO_INCREMENT,
  codigo VARCHAR(25) NOT NULL,
  nombre VARCHAR(125) NOT NULL,
  descripcion TEXT NOT NULL,
  presupuesto DECIMAL NOT NULL,
  fecha_inicio DATE NOT NULL,
  fecha_fin DATE NOT NULL,
  estado TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  UNIQUE INDEX codigo_unique (codigo)
);

CREATE TABLE IF NOT EXISTS propuesta (
  id INT NOT NULL AUTO_INCREMENT,
  licitacion_id INT NOT NULL,
  nombre VARCHAR(125) NOT NULL,
  descripcion TEXT NOT NULL,
  nombre_cliente VARCHAR(125) NOT NULL,
  valor DECIMAL NOT NULL,
  estado TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
   CONSTRAINT fk_propuesta_licitacion_1
    FOREIGN KEY (licitacion_id)
    REFERENCES licitacion (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS requerimiento (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(125) NOT NULL,
  estado TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS licitacion_requerimiento (
  id INT NOT NULL AUTO_INCREMENT, 
  licitacion_id INT NOT NULL,
  requerimiento_id INT NOT NULL,
  peso_porcentual DECIMAL(5,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  UNIQUE INDEX uk_licitacion_requerimiento (licitacion_id, requerimiento_id),
  CONSTRAINT fk_licitacion_requerimiento_1
    FOREIGN KEY (licitacion_id)
    REFERENCES licitacion (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_licitacion_requerimiento_2
    FOREIGN KEY (requerimiento_id)
    REFERENCES requerimiento (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


CREATE TABLE IF NOT EXISTS propuesta_requerimiento (
  propuesta_id INT NOT NULL,
  requerimiento_id INT NOT NULL,
  PRIMARY KEY (propuesta_id, requerimiento_id),
  CONSTRAINT fk_propuesta_requerimiento_1
    FOREIGN KEY (propuesta_id)
    REFERENCES propuesta (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_propuesta_requerimiento_2
    FOREIGN KEY (requerimiento_id)
    REFERENCES requerimiento (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);