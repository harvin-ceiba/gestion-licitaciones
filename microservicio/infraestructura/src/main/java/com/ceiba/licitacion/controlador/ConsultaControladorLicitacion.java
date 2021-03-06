package com.ceiba.licitacion.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.licitacion.consulta.ManejadorListarLicitaciones;
import com.ceiba.licitacion.modelo.dto.DtoLicitacion;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/licitaciones")
@Api(tags={"Controlador consulta Licitaciones"})
public class ConsultaControladorLicitacion {

    private final ManejadorListarLicitaciones manejadorListarLicitaciones;

    public ConsultaControladorLicitacion(ManejadorListarLicitaciones manejadorListarLicitaciones) {
        this.manejadorListarLicitaciones = manejadorListarLicitaciones;
    }

    @GetMapping
    @ApiOperation("Listar Licitaciones")
    public List<DtoLicitacion> listar() {
        return this.manejadorListarLicitaciones.listar();
    }
    
    @GetMapping(value = "/{id}")
    @ApiOperation("Buscar Licitacion por Id")
    public DtoLicitacion buscarPorId(@PathVariable Long id) {
        return this.manejadorListarLicitaciones.buscarPorId(id);
    }

}
