package com.ceiba.licitacion_requerimiento.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.licitacion_requerimiento.comando.ComandoLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.comando.manejador.ManejadorActualizarLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.comando.manejador.ManejadorCrearLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.comando.manejador.ManejadorEliminarLicitacionRequerimiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/licitaciones/{idLicitacion}/requerimientos/{idRequerimiento}")
@Api(tags = { "Controlador comando Requerimientos de Licitaci�n"})
public class ComandoControladorLicitacionRequerimiento {

    private final ManejadorCrearLicitacionRequerimiento manejadorCrearLicitacionRequerimiento;
    private final ManejadorEliminarLicitacionRequerimiento manejadorEliminarLicitacionRequerimiento;
	private final ManejadorActualizarLicitacionRequerimiento manejadorActualizarLicitacionRequerimiento;

    @Autowired
    public ComandoControladorLicitacionRequerimiento(
    		ManejadorCrearLicitacionRequerimiento manejadorCrearLicitacionRequerimiento,
    		ManejadorEliminarLicitacionRequerimiento manejadorEliminarLicitacionRequerimiento,
			ManejadorActualizarLicitacionRequerimiento manejadorActualizarLicitacionRequerimiento) {
        this.manejadorCrearLicitacionRequerimiento = manejadorCrearLicitacionRequerimiento;
		this.manejadorEliminarLicitacionRequerimiento = manejadorEliminarLicitacionRequerimiento;
		this.manejadorActualizarLicitacionRequerimiento = manejadorActualizarLicitacionRequerimiento;
    }

    @PostMapping
    @ApiOperation("Crear Requerimiento de Licitaci�n")
    public ComandoRespuesta<Long> crear(
    		@RequestBody ComandoLicitacionRequerimiento comandoLicitacionRequerimiento,
    		@PathVariable Long idLicitacion, @PathVariable Long idRequerimiento) {
    	comandoLicitacionRequerimiento.setLicitacionId(idLicitacion);
    	comandoLicitacionRequerimiento.setRequerimientoId(idRequerimiento);
        return manejadorCrearLicitacionRequerimiento.ejecutar(comandoLicitacionRequerimiento);
    }
    
    @DeleteMapping
	@ApiOperation("Eliminar Requerimiento de Licitaci�n")
	public void eliminar(@PathVariable Long idLicitacion, @PathVariable Long idRequerimiento) {
		manejadorEliminarLicitacionRequerimiento.ejecutar(idLicitacion, idRequerimiento);
	}

	@PutMapping
	@ApiOperation("Actualizar Requerimiento de Licitaci�n")
	public void actualizar(
			@RequestBody ComandoLicitacionRequerimiento comandoLicitacionRequerimiento,
			@PathVariable Long idLicitacion, @PathVariable Long idRequerimiento) {
		comandoLicitacionRequerimiento.setLicitacionId(idLicitacion);
		comandoLicitacionRequerimiento.setRequerimientoId(idRequerimiento);
		manejadorActualizarLicitacionRequerimiento.ejecutar(comandoLicitacionRequerimiento);
	}
}
