package com.ceiba.licitacion.comando.manejador;

import com.ceiba.licitacion.comando.ComandoLicitacion;
import com.ceiba.licitacion.comando.fabrica.FabricaLicitacion;
import com.ceiba.licitacion.modelo.entidad.Licitacion;
import com.ceiba.licitacion.servicio.ServicioActualizarLicitacion;
import com.ceiba.manejador.ManejadorComando;

import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarLicitacion implements ManejadorComando<ComandoLicitacion> {

    private final FabricaLicitacion fabricaLicitacion;
    private final ServicioActualizarLicitacion servicioActualizarLicitacion;

    public ManejadorActualizarLicitacion(FabricaLicitacion fabricaLicitacion, ServicioActualizarLicitacion servicioActualizarLicitacion) {
        this.fabricaLicitacion = fabricaLicitacion;
        this.servicioActualizarLicitacion = servicioActualizarLicitacion;
    }

    public void ejecutar(ComandoLicitacion comandoLicitacion) {
        Licitacion licitacion = this.fabricaLicitacion.crear(comandoLicitacion);
        this.servicioActualizarLicitacion.ejecutar(licitacion);
    }
}
