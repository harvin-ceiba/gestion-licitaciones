package com.ceiba.licitacion.servicio;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.modelo.entidad.Licitacion;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion.servicio.testdatabuilder.LicitacionTestDataBuilder;

public class ServicioActualizarLicitacionTest {
	
    private static final String LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA = "La licitación no existe en el sistema";
    private static final String CODIGO_LICITACION_YA_EXISTE_EN_EL_SISTEMA = "Código licitación ya existe en el sistema";
    
    private static final Long VALOR_ID = 1L;

    @Test
    public void validarActualizacionLicitacionTest() {
		// arrange
        Licitacion licitacion = new LicitacionTestDataBuilder().withId(VALOR_ID).build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        Mockito.when(repositorioLicitacion.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioLicitacion.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        ServicioActualizarLicitacion servicioActualizarLicitacion = new ServicioActualizarLicitacion(repositorioLicitacion);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioActualizarLicitacion.ejecutar(licitacion));
    }
    
	@Test
    public void validarActualizacionLicitacionConIdNoExistenteTest() {
		// arrange
        Licitacion licitacion = new LicitacionTestDataBuilder().withId(VALOR_ID).build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        Mockito.when(repositorioLicitacion.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarLicitacion servicioActualizarLicitacion = new ServicioActualizarLicitacion(repositorioLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarLicitacion.ejecutar(licitacion), ExcepcionValorInvalido.class, LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA);
	}
	
	@Test
    public void validarActualizacionLicitacionConCodigoExistenteTest() {
		// arrange
        Licitacion licitacion = new LicitacionTestDataBuilder().withId(VALOR_ID).build();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        Mockito.when(repositorioLicitacion.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioLicitacion.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarLicitacion servicioActualizarLicitacion = new ServicioActualizarLicitacion(repositorioLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarLicitacion.ejecutar(licitacion), ExcepcionDuplicidad.class, CODIGO_LICITACION_YA_EXISTE_EN_EL_SISTEMA);
	}
}
