package com.ceiba.licitacion.servicio;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;

public class ServicioEliminarLicitacionTest {
	
    private static final String LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA = "La licitación no existe en el sistema";

    private static final Long VALOR_ID = 1L;
    
    @Test
    public void validarEliminacionLicitacionTest() {
    	// arrange
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(true);
        ServicioEliminarLicitacion servicioEliminarLicitacion = new ServicioEliminarLicitacion(repositorioLicitacion);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioEliminarLicitacion.ejecutar(VALOR_ID));
    }
    
    @Test
    public void validarEliminacionLicitacionConIdNoExistenteTest() {
		// arrange
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(false);
        ServicioEliminarLicitacion servicioEliminarLicitacion = new ServicioEliminarLicitacion(repositorioLicitacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarLicitacion.ejecutar(VALOR_ID), ExcepcionValorInvalido.class, LA_LICITACION_NO_EXISTE_EN_EL_SISTEMA);
	}
	
}
