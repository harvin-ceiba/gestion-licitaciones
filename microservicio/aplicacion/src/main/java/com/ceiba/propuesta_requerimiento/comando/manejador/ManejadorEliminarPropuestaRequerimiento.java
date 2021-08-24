package com.ceiba.propuesta_requerimiento.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.propuesta_requerimiento.servicio.ServicioEliminarPropuestaRequerimiento;

@Component
public class ManejadorEliminarPropuestaRequerimiento {

    private final ServicioEliminarPropuestaRequerimiento servicioEliminarPropuestaRequerimiento;

    public ManejadorEliminarPropuestaRequerimiento(ServicioEliminarPropuestaRequerimiento servicioEliminarPropuestaRequerimiento) {
        this.servicioEliminarPropuestaRequerimiento = servicioEliminarPropuestaRequerimiento;
    }

	public void ejecutar(Long idPropuesta, Long idRequerimiento) {
		this.servicioEliminarPropuestaRequerimiento.ejecutar(idPropuesta, idRequerimiento);
	}

}
