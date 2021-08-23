package com.ceiba.requerimiento.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.requerimiento.comando.ComandoRequerimiento;
import com.ceiba.requerimiento.comando.fabrica.FabricaRequerimiento;
import com.ceiba.requerimiento.modelo.entidad.Requerimiento;
import com.ceiba.requerimiento.servicio.ServicioActualizarRequerimiento;

import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarRequerimiento implements ManejadorComando<ComandoRequerimiento> {

    private final FabricaRequerimiento fabricaRequerimiento;
    private final ServicioActualizarRequerimiento servicioActualizarRequerimiento;

    public ManejadorActualizarRequerimiento(FabricaRequerimiento fabricaRequerimiento, ServicioActualizarRequerimiento servicioActualizarRequerimiento) {
        this.fabricaRequerimiento = fabricaRequerimiento;
        this.servicioActualizarRequerimiento = servicioActualizarRequerimiento;
    }

    public void ejecutar(ComandoRequerimiento comandoRequerimiento) {
        Requerimiento requerimiento = this.fabricaRequerimiento.crear(comandoRequerimiento);
        this.servicioActualizarRequerimiento.ejecutar(requerimiento);
    }
}
