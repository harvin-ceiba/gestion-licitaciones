package com.ceiba.requerimiento.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.requerimiento.comando.ComandoRequerimiento;
import com.ceiba.requerimiento.comando.manejador.ManejadorActualizarRequerimiento;
import com.ceiba.requerimiento.comando.manejador.ManejadorCrearRequerimiento;
import com.ceiba.requerimiento.comando.manejador.ManejadorEliminarRequerimiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/requerimientos")
@Api(tags = { "Controlador comando Requerimientos"})
public class ComandoControladorRequerimiento {

    private final ManejadorCrearRequerimiento manejadorCrearRequerimiento;
	private final ManejadorEliminarRequerimiento manejadorEliminarRequerimiento;
	private final ManejadorActualizarRequerimiento manejadorActualizarRequerimiento;

    @Autowired
    public ComandoControladorRequerimiento(ManejadorCrearRequerimiento manejadorCrearRequerimiento,
									 ManejadorEliminarRequerimiento manejadorEliminarRequerimiento,
									 ManejadorActualizarRequerimiento manejadorActualizarRequerimiento) {
        this.manejadorCrearRequerimiento = manejadorCrearRequerimiento;
		this.manejadorEliminarRequerimiento = manejadorEliminarRequerimiento;
		this.manejadorActualizarRequerimiento = manejadorActualizarRequerimiento;
    }

    @PostMapping
    @ApiOperation("Crear Requerimiento")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoRequerimiento comandoRequerimiento) {
        return manejadorCrearRequerimiento.ejecutar(comandoRequerimiento);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Requerimiento")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarRequerimiento.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Requerimiento")
	public void actualizar(@RequestBody ComandoRequerimiento comandoRequerimiento,@PathVariable Long id) {
		comandoRequerimiento.setId(id);
		manejadorActualizarRequerimiento.ejecutar(comandoRequerimiento);
	}
}
