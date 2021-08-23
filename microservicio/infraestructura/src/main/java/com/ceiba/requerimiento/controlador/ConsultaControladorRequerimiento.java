package com.ceiba.requerimiento.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.requerimiento.consulta.ManejadorListarRequerimientos;
import com.ceiba.requerimiento.modelo.dto.DtoRequerimiento;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/requerimientos")
@Api(tags={"Controlador consulta Requerimientos"})
public class ConsultaControladorRequerimiento {

    private final ManejadorListarRequerimientos manejadorListarRequerimientos;

    public ConsultaControladorRequerimiento(ManejadorListarRequerimientos manejadorListarRequerimientos) {
        this.manejadorListarRequerimientos = manejadorListarRequerimientos;
    }

    @GetMapping
    @ApiOperation("Listar los Requerimientos")
    public List<DtoRequerimiento> listar() {
        return this.manejadorListarRequerimientos.ejecutar();
    }

}
