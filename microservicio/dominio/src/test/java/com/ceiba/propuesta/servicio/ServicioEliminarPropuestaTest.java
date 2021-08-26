package com.ceiba.propuesta.servicio;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.propuesta.modelo.entidad.Propuesta;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;
import com.ceiba.propuesta.testdatabuilder.PropuestaTestDataBuilder;

public class ServicioEliminarPropuestaTest {
	
	private static final String LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA = "La Licitación no existe en el sistema";
    private static final String LA_PROPUESTA_NO_EXISTE_EN_EL_SISTEMA = "La propuesta no existe en el sistema";

    @Test
    public void validarActualizacionPropuestaTest() {
		// arrange
        Propuesta propuesta = new PropuestaTestDataBuilder().build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarPropuesta servicioEliminarPropuesta = new ServicioEliminarPropuesta(repositorioPropuesta, repositorioLicitacion);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioEliminarPropuesta.ejecutar(propuesta.getLicitacionId(), propuesta.getId()));
    }
    
	@Test
    public void validarActualizacionPropuestaDeLicitacionNoExistenteTest() {
		// arrange
        Propuesta propuesta = new PropuestaTestDataBuilder().build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarPropuesta servicioEliminarPropuesta = new ServicioEliminarPropuesta(repositorioPropuesta, repositorioLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarPropuesta.ejecutar(propuesta.getLicitacionId(), propuesta.getId()), 
        		ExcepcionValorInvalido.class, LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA);
	}
	
	@Test
    public void validarActualizacionPropuestaNoExistenteTest() {
		// arrange
        Propuesta propuesta = new PropuestaTestDataBuilder().build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarPropuesta servicioEliminarPropuesta = new ServicioEliminarPropuesta(repositorioPropuesta, repositorioLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarPropuesta.ejecutar(propuesta.getLicitacionId(), propuesta.getId()), 
        		ExcepcionValorInvalido.class, LA_PROPUESTA_NO_EXISTE_EN_EL_SISTEMA);
	}
	
}
