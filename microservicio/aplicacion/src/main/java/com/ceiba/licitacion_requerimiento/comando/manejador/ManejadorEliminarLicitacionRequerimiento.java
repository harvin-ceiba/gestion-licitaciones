package com.ceiba.licitacion_requerimiento.comando.manejador;

import com.ceiba.licitacion_requerimiento.servicio.ServicioEliminarLicitacionRequerimiento;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarLicitacionRequerimiento {

    private final ServicioEliminarLicitacionRequerimiento servicioEliminarLicitacionRequerimiento;

    public ManejadorEliminarLicitacionRequerimiento(ServicioEliminarLicitacionRequerimiento servicioEliminarLicitacionRequerimiento) {
        this.servicioEliminarLicitacionRequerimiento = servicioEliminarLicitacionRequerimiento;
    }

	public void ejecutar(Long idLicitacion, Long idRequerimiento) {
		this.servicioEliminarLicitacionRequerimiento.ejecutar(idLicitacion, idRequerimiento);
	}

}
