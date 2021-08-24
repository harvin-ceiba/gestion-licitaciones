package com.ceiba.licitacion_requerimiento.comando.manejador;

import com.ceiba.licitacion_requerimiento.comando.ComandoLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.comando.fabrica.FabricaLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.modelo.entidad.LicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.servicio.ServicioActualizarLicitacionRequerimiento;
import com.ceiba.manejador.ManejadorComando;

import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarLicitacionRequerimiento implements ManejadorComando<ComandoLicitacionRequerimiento> {

    private final FabricaLicitacionRequerimiento fabricaLicitacionRequerimiento;
    private final ServicioActualizarLicitacionRequerimiento servicioActualizarLicitacionRequerimiento;

    public ManejadorActualizarLicitacionRequerimiento(
    		FabricaLicitacionRequerimiento fabricaLicitacionRequerimiento, 
    		ServicioActualizarLicitacionRequerimiento servicioActualizarLicitacionRequerimiento) {
        this.fabricaLicitacionRequerimiento = fabricaLicitacionRequerimiento;
        this.servicioActualizarLicitacionRequerimiento = servicioActualizarLicitacionRequerimiento;
    }

    public void ejecutar(ComandoLicitacionRequerimiento comandoLicitacionRequerimiento) {
        LicitacionRequerimiento licitacionRequerimiento = this.fabricaLicitacionRequerimiento.crear(comandoLicitacionRequerimiento);
        this.servicioActualizarLicitacionRequerimiento.ejecutar(licitacionRequerimiento);
    }
}
