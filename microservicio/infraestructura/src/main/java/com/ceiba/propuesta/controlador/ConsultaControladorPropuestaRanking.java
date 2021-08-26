package com.ceiba.propuesta.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.propuesta.consulta.ManejadorListarPropuestas;
import com.ceiba.propuesta.modelo.dto.DtoPropuesta;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/licitaciones/{idLicitacion}/ranking_propuestas")
@Api(tags={"Controlador Ranking de Propuestas de una Licitacion"})
public class ConsultaControladorPropuestaRanking {

    private final ManejadorListarPropuestas manejadorListarPropuestas;

    public ConsultaControladorPropuestaRanking(ManejadorListarPropuestas manejadorListarPropuestas) {
        this.manejadorListarPropuestas = manejadorListarPropuestas;
    }

    @GetMapping
    @ApiOperation("Listar Propuestas")
    public List<DtoPropuesta> listar(@PathVariable Long idLicitacion) {
        return this.manejadorListarPropuestas.listarPropuestasEnviadas(idLicitacion);
    }
    
}
