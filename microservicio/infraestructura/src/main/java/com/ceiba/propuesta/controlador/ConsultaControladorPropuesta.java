package com.ceiba.propuesta.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.propuesta.consulta.ManejadorListarPropuestas;
import com.ceiba.propuesta.modelo.dto.DtoPropuesta;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags={"Controlador consulta de Propuestas de una Licitacion"})
public class ConsultaControladorPropuesta {

    private final ManejadorListarPropuestas manejadorListarPropuestas;

    public ConsultaControladorPropuesta(ManejadorListarPropuestas manejadorListarPropuestas) {
        this.manejadorListarPropuestas = manejadorListarPropuestas;
    }
    
    @GetMapping(value="/propuestas")
    @ApiOperation("Listar Propuestas")
    public List<DtoPropuesta> listar() {
        return this.manejadorListarPropuestas.listar();
    }

    @GetMapping(value="/licitaciones/{idLicitacion}/propuestas")
    @ApiOperation("Listar Propuestas por Licitacion")
    public List<DtoPropuesta> listarPorIdLicitacion(@PathVariable Long idLicitacion) {
        return this.manejadorListarPropuestas.listarPorIdLicitacion(idLicitacion);
    }
    
    @GetMapping(value="/propuestas/{idPropuesta}")
    @ApiOperation("Obtener Propuesta")
    public DtoPropuesta buscarPorId(@PathVariable Long idPropuesta) {
        return this.manejadorListarPropuestas.buscarPorId(idPropuesta);
    }
    
}
