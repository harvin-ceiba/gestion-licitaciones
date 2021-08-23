package com.ceiba.requerimiento.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.requerimiento.comando.ComandoRequerimiento;
import com.ceiba.requerimiento.modelo.entidad.Requerimiento;

@Component
public class FabricaRequerimiento {

    public Requerimiento crear(ComandoRequerimiento comandoRequerimiento) {
        return new Requerimiento(
        	comandoRequerimiento.getId(),
        	comandoRequerimiento.getDescripcion(),
        	comandoRequerimiento.getEstado()
        );
    }

}