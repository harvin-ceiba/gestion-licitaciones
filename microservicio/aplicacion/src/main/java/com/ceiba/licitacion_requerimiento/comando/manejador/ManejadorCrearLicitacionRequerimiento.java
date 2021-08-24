package com.ceiba.licitacion_requerimiento.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.licitacion_requerimiento.comando.ComandoLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.comando.fabrica.FabricaLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.modelo.entidad.LicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.servicio.ServicioCrearLicitacionRequerimiento;
import com.ceiba.manejador.ManejadorComandoRespuesta;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearLicitacionRequerimiento implements ManejadorComandoRespuesta<ComandoLicitacionRequerimiento, ComandoRespuesta<Long>> {

    private final FabricaLicitacionRequerimiento fabricaLicitacionRequerimiento;
    private final ServicioCrearLicitacionRequerimiento servicioCrearLicitacionRequerimiento;

    public ManejadorCrearLicitacionRequerimiento(
    		FabricaLicitacionRequerimiento fabricaLicitacionRequerimiento, 
    		ServicioCrearLicitacionRequerimiento servicioCrearLicitacionRequerimiento) {
        this.fabricaLicitacionRequerimiento = fabricaLicitacionRequerimiento;
        this.servicioCrearLicitacionRequerimiento = servicioCrearLicitacionRequerimiento;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoLicitacionRequerimiento comandoLicitacionRequerimiento) {
        LicitacionRequerimiento licitacionRequerimiento = this.fabricaLicitacionRequerimiento.crear(comandoLicitacionRequerimiento);
        return new ComandoRespuesta<>(this.servicioCrearLicitacionRequerimiento.ejecutar(licitacionRequerimiento));
    }
}
