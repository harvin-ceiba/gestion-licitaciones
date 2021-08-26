package com.ceiba.licitacion_requerimiento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

public abstract class ServicioGenericoLicitacionRequerimiento {

	protected static final String EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION = "El Requerimiento no se encuentra asociado a la Licitación";
	protected static final String LA_LICITACION_NO_EXISTE = "La Licitación no existe en el sistema";
	protected static final String EL_REQUERIMIENTO_NO_EXISTE = "El Requerimiento no existe en el sistema";
    
	protected final RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento;
	protected final RepositorioLicitacion repositorioLicitacion;
	protected final RepositorioRequerimiento repositorioRequerimiento;

	protected ServicioGenericoLicitacionRequerimiento(RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento,
			RepositorioLicitacion repositorioLicitacion,
			RepositorioRequerimiento repositorioRequerimiento) {
		this.repositorioLicitacionRequerimiento = repositorioLicitacionRequerimiento;
		this.repositorioLicitacion = repositorioLicitacion;
		this.repositorioRequerimiento = repositorioRequerimiento;
	}

	protected void validarExistenciaPrevia(Long licitacionId, Long requerimientoId) {
		boolean existe = this.repositorioLicitacionRequerimiento.existe(licitacionId, requerimientoId);
		if(!existe) {
			throw new ExcepcionValorInvalido(EL_REQUERIMIENTO_NO_EXISTE_EN_LA_LICITACION);
		}
	}

	protected void validarExistenciaLicitacion(Long licitacionId) {
		boolean existe = this.repositorioLicitacion.existe(licitacionId);
		if(!existe) {
			throw new ExcepcionValorInvalido(LA_LICITACION_NO_EXISTE);
		}
	}

	protected void validarExistenciaRequerimiento(Long requerimientoId) {
		boolean existe = this.repositorioRequerimiento.existe(requerimientoId);
		if(!existe) {
			throw new ExcepcionValorInvalido(EL_REQUERIMIENTO_NO_EXISTE);
		}
	}
}
