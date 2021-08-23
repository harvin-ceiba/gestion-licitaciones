package com.ceiba.requerimiento.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.requerimiento.comando.ComandoRequerimiento;
import com.ceiba.requerimiento.comando.fabrica.FabricaRequerimiento;
import com.ceiba.requerimiento.modelo.entidad.Requerimiento;
import com.ceiba.requerimiento.servicio.ServicioCrearRequerimiento;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearRequerimiento implements ManejadorComandoRespuesta<ComandoRequerimiento, ComandoRespuesta<Long>> {

    private final FabricaRequerimiento fabricaRequerimiento;
    private final ServicioCrearRequerimiento servicioCrearRequerimiento;

    public ManejadorCrearRequerimiento(FabricaRequerimiento fabricaRequerimiento, ServicioCrearRequerimiento servicioCrearRequerimiento) {
        this.fabricaRequerimiento = fabricaRequerimiento;
        this.servicioCrearRequerimiento = servicioCrearRequerimiento;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoRequerimiento comandoRequerimiento) {
        Requerimiento requerimiento = this.fabricaRequerimiento.crear(comandoRequerimiento);
        return new ComandoRespuesta<>(this.servicioCrearRequerimiento.ejecutar(requerimiento));
    }
}
