package com.ceiba.propuesta.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.propuesta.comando.ComandoPropuesta;
import com.ceiba.propuesta.comando.manejador.ManejadorActualizarPropuesta;
import com.ceiba.propuesta.comando.manejador.ManejadorCrearPropuesta;
import com.ceiba.propuesta.comando.manejador.ManejadorEliminarPropuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/licitaciones/{idLicitacion}/propuestas")
@Api(tags = { "Controlador comando Propuestas de Licitación"})
public class ComandoControladorPropuesta {

    private final ManejadorCrearPropuesta manejadorCrearPropuesta;
    private final ManejadorEliminarPropuesta manejadorEliminarPropuesta;
	private final ManejadorActualizarPropuesta manejadorActualizarPropuesta;

    @Autowired
    public ComandoControladorPropuesta(
    		ManejadorCrearPropuesta manejadorCrearPropuesta,
    		ManejadorEliminarPropuesta manejadorEliminarPropuesta,
			ManejadorActualizarPropuesta manejadorActualizarPropuesta) {
        this.manejadorCrearPropuesta = manejadorCrearPropuesta;
		this.manejadorEliminarPropuesta = manejadorEliminarPropuesta;
		this.manejadorActualizarPropuesta = manejadorActualizarPropuesta;
    }

    @PostMapping
    @ApiOperation("Crear Requerimiento de Licitación")
    public ComandoRespuesta<Long> crear(
    		@RequestBody ComandoPropuesta comandoPropuesta,
    		@PathVariable Long idLicitacion) {
    	comandoPropuesta.setLicitacionId(idLicitacion);
        return manejadorCrearPropuesta.ejecutar(comandoPropuesta);
    }
    
    @DeleteMapping(value="/{idPropuesta}")
	@ApiOperation("Eliminar la Propuesta de la Licitación")
	public void eliminar(@PathVariable Long idLicitacion, @PathVariable Long idPropuesta) {
		manejadorEliminarPropuesta.ejecutar(idLicitacion, idPropuesta);
	}

	@PutMapping(value="/{idPropuesta}")
	@ApiOperation("Actualizar Requerimiento de Licitación")
	public void actualizar(
			@RequestBody ComandoPropuesta comandoPropuesta,
			@PathVariable Long idLicitacion,
			@PathVariable Long idPropuesta) {
		comandoPropuesta.setId(idPropuesta);
		comandoPropuesta.setLicitacionId(idLicitacion);
		manejadorActualizarPropuesta.ejecutar(comandoPropuesta);
	}
}
