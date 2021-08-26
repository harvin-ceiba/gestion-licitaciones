package com.ceiba.licitacion_requerimiento.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.licitacion_requerimiento.consulta.ManejadorListarLicitacionRequerimientos;
import com.ceiba.licitacion_requerimiento.modelo.dto.DtoLicitacionRequerimiento;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/licitaciones/{idLicitacion}/requerimientos")
@Api(tags={"Controlador consulta de Requerimientos de una Licitacion"})
public class ConsultaControladorLicitacionRequerimiento {

    private final ManejadorListarLicitacionRequerimientos manejadorListarLicitacionRequerimientos;

    public ConsultaControladorLicitacionRequerimiento(ManejadorListarLicitacionRequerimientos manejadorListarLicitacionRequerimientos) {
        this.manejadorListarLicitacionRequerimientos = manejadorListarLicitacionRequerimientos;
    }

    @GetMapping
    @ApiOperation("Listar Requerimientos")
    public List<DtoLicitacionRequerimiento> listar(@PathVariable Long idLicitacion) {
        return this.manejadorListarLicitacionRequerimientos.listar(idLicitacion);
    }
    
}
