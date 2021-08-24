package com.ceiba.propuesta_requerimiento.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.propuesta_requerimiento.comando.ComandoPropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.comando.manejador.ManejadorCrearPropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.comando.manejador.ManejadorEliminarPropuestaRequerimiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/propuestas/{idPropuesta}/requerimientos/{idRequerimiento}")
@Api(tags = { "Controlador comando Requerimientos de Propuesta"})
public class ComandoControladorPropuestaRequerimiento {

    private final ManejadorCrearPropuestaRequerimiento manejadorCrearPropuestaRequerimiento;
    private final ManejadorEliminarPropuestaRequerimiento manejadorEliminarPropuestaRequerimiento;

    @Autowired
    public ComandoControladorPropuestaRequerimiento(
    		ManejadorCrearPropuestaRequerimiento manejadorCrearPropuestaRequerimiento,
    		ManejadorEliminarPropuestaRequerimiento manejadorEliminarPropuestaRequerimiento) {
        this.manejadorCrearPropuestaRequerimiento = manejadorCrearPropuestaRequerimiento;
		this.manejadorEliminarPropuestaRequerimiento = manejadorEliminarPropuestaRequerimiento;
    }

    @PostMapping
    @ApiOperation("Crear Requerimiento de Propuesta")
    public ComandoRespuesta<Long> crear(@PathVariable Long idPropuesta, @PathVariable Long idRequerimiento) {
    	ComandoPropuestaRequerimiento comandoPropuestaRequerimiento = new ComandoPropuestaRequerimiento();
    	comandoPropuestaRequerimiento.setPropuestaId(idPropuesta);
    	comandoPropuestaRequerimiento.setRequerimientoId(idRequerimiento);
        return manejadorCrearPropuestaRequerimiento.ejecutar(comandoPropuestaRequerimiento);
    }
    
    @DeleteMapping
	@ApiOperation("Eliminar Requerimiento de Propuesta")
	public void eliminar(@PathVariable Long idPropuesta, @PathVariable Long idRequerimiento) {
		manejadorEliminarPropuestaRequerimiento.ejecutar(idPropuesta, idRequerimiento);
	}

}
