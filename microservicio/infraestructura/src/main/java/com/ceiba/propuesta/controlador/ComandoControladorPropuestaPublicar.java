package com.ceiba.propuesta.controlador;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.propuesta.comando.manejador.ManejadorPublicarPropuesta;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/propuestas/{idPropuesta}/publicar")
@Api(tags={"Controlador publicacion de Propuesta de una Licitacion"})
public class ComandoControladorPropuestaPublicar {

    private final ManejadorPublicarPropuesta manejadorPublicarPropuesta;

    public ComandoControladorPropuestaPublicar(ManejadorPublicarPropuesta manejadorPublicarPropuesta) {
        this.manejadorPublicarPropuesta = manejadorPublicarPropuesta;
    }

    @PutMapping
    @ApiOperation("Publicar Propuesta")
    public void ejecutar(@PathVariable Long idPropuesta) {
        manejadorPublicarPropuesta.ejecutar(idPropuesta);
    }
    
}
