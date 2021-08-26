package com.ceiba.licitacion.servicio;

import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.validarIgual;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion_requerimiento.modelo.dto.DtoLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.dao.DaoLicitacionRequerimiento;

public class ServicioPublicarLicitacion {

    private static final String LA_LICITACION_NO_EXISTE = "La licitacion que intenta publicar no existe";
    private static final String LA_LICITACION_NO_SE_PUEDE_PUBLICAR_SIN_REQUERIMIENTOS = "La licitacion no se puede publicar sin requerimientos";
    private static final String LA_SUMATORIA_DE_LOS_PORCENTAJES_DE_LICITACION_DEBE_SER_IGUAL_A = "La licitacion no se puede publicar, el porcentaje de los requerimientos debe ser igual a %s";
    private static final double SUMATORIA_PESO_PORCENTUAL = 100D;
    
    private final RepositorioLicitacion repositorioLicitacion;
    private final DaoLicitacionRequerimiento daoLicitacionRequerimiento;

    public ServicioPublicarLicitacion(
    		RepositorioLicitacion repositorioLicitacion,
    		DaoLicitacionRequerimiento daoLicitacionRequerimiento) {
        this.repositorioLicitacion = repositorioLicitacion;
        this.daoLicitacionRequerimiento = daoLicitacionRequerimiento;
    }

    public void ejecutar(Long id) {
    	validarExistenciaPrevia(id);
    	List<DtoLicitacionRequerimiento> licitacionRequerimientos = listarRequerimientos(id);
    	validarRequerimientos(licitacionRequerimientos);
    	validarRequerimientosPesoPorcentual(licitacionRequerimientos);
        this.repositorioLicitacion.publicar(id);
    }
    
    private void validarExistenciaPrevia(Long idLicitacion) {
    	boolean existe = this.repositorioLicitacion.existe(idLicitacion);
        if(!existe) {
            throw new ExcepcionValorInvalido(LA_LICITACION_NO_EXISTE);
        }
    }
    
    private List<DtoLicitacionRequerimiento> listarRequerimientos(Long idLicitacion) {
    	return this.daoLicitacionRequerimiento.listar(idLicitacion);
    }
    
    private void validarRequerimientos(List<DtoLicitacionRequerimiento> licitacionRequerimientos) {
    	if(licitacionRequerimientos == null || licitacionRequerimientos.isEmpty()) {
            throw new ExcepcionSinDatos(LA_LICITACION_NO_SE_PUEDE_PUBLICAR_SIN_REQUERIMIENTOS);
        }
    }
    
    private void validarRequerimientosPesoPorcentual(List<DtoLicitacionRequerimiento> licitacionRequerimientos) {
    	double sumatoriaPesoPorcentual = licitacionRequerimientos.stream()
    			.mapToDouble(DtoLicitacionRequerimiento::getPesoPorcentual)
    			.sum();
   
    	validarIgual(sumatoriaPesoPorcentual, SUMATORIA_PESO_PORCENTUAL, 
    		String.format(LA_SUMATORIA_DE_LOS_PORCENTAJES_DE_LICITACION_DEBE_SER_IGUAL_A, SUMATORIA_PESO_PORCENTUAL)
    	);
    }

}
