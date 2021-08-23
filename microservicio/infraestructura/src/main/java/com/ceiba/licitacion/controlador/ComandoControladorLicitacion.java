package com.ceiba.licitacion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.licitacion.comando.ComandoLicitacion;
import com.ceiba.licitacion.comando.manejador.ManejadorActualizarLicitacion;
import com.ceiba.licitacion.comando.manejador.ManejadorCrearLicitacion;
import com.ceiba.licitacion.comando.manejador.ManejadorEliminarLicitacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/licitaciones")
@Api(tags = { "Controlador comando Licitacion"})
public class ComandoControladorLicitacion {

    private final ManejadorCrearLicitacion manejadorCrearLicitacion;
	private final ManejadorEliminarLicitacion manejadorEliminarLicitacion;
	private final ManejadorActualizarLicitacion manejadorActualizarLicitacion;

    @Autowired
    public ComandoControladorLicitacion(ManejadorCrearLicitacion manejadorCrearLicitacion,
									 ManejadorEliminarLicitacion manejadorEliminarLicitacion,
									 ManejadorActualizarLicitacion manejadorActualizarLicitacion) {
        this.manejadorCrearLicitacion = manejadorCrearLicitacion;
		this.manejadorEliminarLicitacion = manejadorEliminarLicitacion;
		this.manejadorActualizarLicitacion = manejadorActualizarLicitacion;
    }

    @PostMapping
    @ApiOperation("Crear Licitacion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoLicitacion comandoLicitacion) {
        return manejadorCrearLicitacion.ejecutar(comandoLicitacion);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Licitacion")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarLicitacion.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Licitacion")
	public void actualizar(@RequestBody ComandoLicitacion comandoLicitacion,@PathVariable Long id) {
		comandoLicitacion.setId(id);
		manejadorActualizarLicitacion.ejecutar(comandoLicitacion);
	}
}
