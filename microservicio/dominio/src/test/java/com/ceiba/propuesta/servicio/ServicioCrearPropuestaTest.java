package com.ceiba.propuesta.servicio;

import com.ceiba.propuesta.modelo.entidad.Propuesta;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;
import com.ceiba.propuesta.testdatabuilder.PropuestaTestDataBuilder;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;

public class ServicioCrearPropuestaTest {
	
	private static final String LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA = "La Licitación no existe en el sistema";
    private static final String LA_PROPUESTA_YA_EXISTE_EN_EL_SISTEMA = "La propuesta ya existe en el sistema";

	@Test
    public void validarCreacionPropuestaTest() {
		// arrange
        Propuesta propuesta = new PropuestaTestDataBuilder().build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        Mockito.when(repositorioLicitacion.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        ServicioCrearPropuesta servicioCrearPropuesta = new ServicioCrearPropuesta(repositorioPropuesta, repositorioLicitacion);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioCrearPropuesta.ejecutar(propuesta));
	}
	
	@Test
    public void validarCreacionPropuestaDeLicitacionNoExistenteTest() {
		// arrange
		Propuesta propuesta = new PropuestaTestDataBuilder().build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        Mockito.when(repositorioLicitacion.existe(Mockito.anyLong())).thenReturn(false);
        ServicioCrearPropuesta servicioCrearPropuesta = new ServicioCrearPropuesta(repositorioPropuesta, repositorioLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPropuesta.ejecutar(propuesta), ExcepcionValorInvalido.class, LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA);
	}
	
	@Test
    public void validarCreacionPropuestaExistentePreviamenteTest() {
		// arrange
		Propuesta propuesta = new PropuestaTestDataBuilder().build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        Mockito.when(repositorioLicitacion.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioCrearPropuesta servicioCrearPropuesta = new ServicioCrearPropuesta(repositorioPropuesta, repositorioLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPropuesta.ejecutar(propuesta), ExcepcionDuplicidad.class, LA_PROPUESTA_YA_EXISTE_EN_EL_SISTEMA);
	}
	
}
