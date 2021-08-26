package com.ceiba.propuesta.servicio;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.propuesta.modelo.entidad.Propuesta;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;
import com.ceiba.propuesta.testdatabuilder.PropuestaTestDataBuilder;

public class ServicioActualizarPropuestaTest {
	
	private static final String LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA = "La Licitación no existe en el sistema";
    private static final String LA_PROPUESTA_NO_EXISTE_EN_EL_SISTEMA = "La propuesta no existe en el sistema";
    private static final String LA_PROPUESTA_SE_ENCUENTRA_ASOCIADA_A_LICITACION = "La propuesta ya se encuentra asociada a la Licitación";
 
    @Test
    public void validarActualizacionPropuestaTest() {
		// arrange
        Propuesta propuesta = new PropuestaTestDataBuilder().build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioPropuesta.existeExcluyendoId(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        ServicioActualizarPropuesta servicioActualizarPropuesta = new ServicioActualizarPropuesta(repositorioPropuesta, repositorioLicitacion);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioActualizarPropuesta.ejecutar(propuesta));
    }
    
	@Test
    public void validarActualizacionPropuestaDeLicitacionNoExistenteTest() {
		// arrange
        Propuesta propuesta = new PropuestaTestDataBuilder().build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarPropuesta servicioActualizarPropuesta = new ServicioActualizarPropuesta(repositorioPropuesta, repositorioLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarPropuesta.ejecutar(propuesta), ExcepcionValorInvalido.class, LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA);
	}
	
	@Test
    public void validarActualizacionPropuestaNoExistenteTest() {
		// arrange
        Propuesta propuesta = new PropuestaTestDataBuilder().build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarPropuesta servicioActualizarPropuesta = new ServicioActualizarPropuesta(repositorioPropuesta, repositorioLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarPropuesta.ejecutar(propuesta), ExcepcionValorInvalido.class, LA_PROPUESTA_NO_EXISTE_EN_EL_SISTEMA);
	}
	
	@Test
    public void validarActualizacionPropuestaConNombreExistentePreviamenteTest() {
		// arrange
        Propuesta propuesta = new PropuestaTestDataBuilder().build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        RepositorioPropuesta repositorioPropuesta = Mockito.mock(RepositorioPropuesta.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioPropuesta.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioPropuesta.existeExcluyendoId(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarPropuesta servicioActualizarPropuesta = new ServicioActualizarPropuesta(repositorioPropuesta, repositorioLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarPropuesta.ejecutar(propuesta), ExcepcionDuplicidad.class, LA_PROPUESTA_SE_ENCUENTRA_ASOCIADA_A_LICITACION);
	}
}
