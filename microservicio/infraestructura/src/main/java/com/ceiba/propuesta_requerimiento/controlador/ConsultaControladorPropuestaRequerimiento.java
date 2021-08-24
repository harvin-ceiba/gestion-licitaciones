package com.ceiba.propuesta_requerimiento.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.propuesta_requerimiento.consulta.ManejadorListarPropuestaRequerimientos;
import com.ceiba.propuesta_requerimiento.modelo.dto.DtoPropuestaRequerimiento;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/propuestas/{idPropuesta}/requerimientos")
@Api(tags={"Controlador consulta de Requerimientos de una Propuesta"})
public class ConsultaControladorPropuestaRequerimiento {

    private final ManejadorListarPropuestaRequerimientos manejadorListarPropuestaRequerimientos;

    public ConsultaControladorPropuestaRequerimiento(ManejadorListarPropuestaRequerimientos manejadorListarPropuestaRequerimientos) {
        this.manejadorListarPropuestaRequerimientos = manejadorListarPropuestaRequerimientos;
    }

    @GetMapping
    @ApiOperation("Listar Requerimientos")
    public List<DtoPropuestaRequerimiento> listar(@PathVariable Long idPropuesta) {
        return this.manejadorListarPropuestaRequerimientos.listar(idPropuesta);
    }
    
}
