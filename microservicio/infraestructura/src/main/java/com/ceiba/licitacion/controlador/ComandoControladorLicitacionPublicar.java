package com.ceiba.licitacion.controlador;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.licitacion.comando.manejador.ManejadorPublicarLicitacion;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/licitaciones/{id}/publicar")
@Api(tags={"Controlador Publicación de una Licitación"})
public class ComandoControladorLicitacionPublicar {

    private final ManejadorPublicarLicitacion manejadorPublicarLicitacion;

    public ComandoControladorLicitacionPublicar(ManejadorPublicarLicitacion manejadorPublicarLicitacion) {
        this.manejadorPublicarLicitacion = manejadorPublicarLicitacion;
    }

    @PutMapping
    @ApiOperation("Publicar Licitación")
    public void ejecutar(@PathVariable Long id) {
    	manejadorPublicarLicitacion.ejecutar(id);
    }
    
}
