package com.ceiba.licitacion.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.licitacion.comando.ComandoLicitacion;
import com.ceiba.licitacion.comando.fabrica.FabricaLicitacion;
import com.ceiba.licitacion.modelo.entidad.Licitacion;
import com.ceiba.licitacion.servicio.ServicioCrearLicitacion;
import com.ceiba.manejador.ManejadorComandoRespuesta;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearLicitacion implements ManejadorComandoRespuesta<ComandoLicitacion, ComandoRespuesta<Long>> {

    private final FabricaLicitacion fabricaLicitacion;
    private final ServicioCrearLicitacion servicioCrearLicitacion;

    public ManejadorCrearLicitacion(FabricaLicitacion fabricaLicitacion, ServicioCrearLicitacion servicioCrearLicitacion) {
        this.fabricaLicitacion = fabricaLicitacion;
        this.servicioCrearLicitacion = servicioCrearLicitacion;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoLicitacion comandoLicitacion) {
        Licitacion licitacion = this.fabricaLicitacion.crear(comandoLicitacion);
        return new ComandoRespuesta<>(this.servicioCrearLicitacion.ejecutar(licitacion));
    }
}
