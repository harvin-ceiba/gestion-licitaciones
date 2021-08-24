package com.ceiba.licitacion.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.modelo.entidad.Licitacion;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;

public class ServicioActualizarLicitacion {
	
    private static final String LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA = "La licitación no existe en el sistema";
    private static final String CODIGO_LICITACION_YA_EXISTE_EN_EL_SISTEMA = "Código licitación ya existe en el sistema";

    private final RepositorioLicitacion repositorioLicitacion;

    public ServicioActualizarLicitacion(RepositorioLicitacion repositorioLicitacion) {
        this.repositorioLicitacion = repositorioLicitacion;
    }

    public void ejecutar(Licitacion licitacion) {
    	validarExistenciaId(licitacion.getId());
        validarExistenciaPrevia(licitacion);
        this.repositorioLicitacion.actualizar(licitacion);
    }
    
    private void validarExistenciaId(Long idPropuesta) {
    	boolean existe = this.repositorioLicitacion.existeId(idPropuesta);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPrevia(Licitacion licitacion) {
        boolean existe = this.repositorioLicitacion.existeExcluyendoId(licitacion.getId(), licitacion.getCodigo());
        if(existe) {
            throw new ExcepcionDuplicidad(CODIGO_LICITACION_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
