package com.ceiba.requerimiento.servicio;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;

public class ServicioEliminarRequerimientoTest {
	
    private static final String EL_REQUERIMIENTO_NO_EXISTE_EN_EL_SISTEMA = "El requerimiento no existe en el sistema";

    private static final Long VALOR_ID = 1L;
    
    @Test
    public void validarEliminacionRequerimientoTest() {
		// arrange
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        Mockito.when(repositorioRequerimiento.existe(VALOR_ID)).thenReturn(true);
        ServicioEliminarRequerimiento servicioEliminarRequerimiento = new ServicioEliminarRequerimiento(repositorioRequerimiento);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioEliminarRequerimiento.ejecutar(VALOR_ID));
	}
	
	@Test
    public void validarEliminacionRequerimientoNoExistenteTest() {
		// arrange
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        Mockito.when(repositorioRequerimiento.existe(VALOR_ID)).thenReturn(false);
        ServicioEliminarRequerimiento servicioEliminarRequerimiento = new ServicioEliminarRequerimiento(repositorioRequerimiento);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarRequerimiento.ejecutar(VALOR_ID), ExcepcionValorInvalido.class, EL_REQUERIMIENTO_NO_EXISTE_EN_EL_SISTEMA);
	}
	
}
