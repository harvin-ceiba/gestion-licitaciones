package com.ceiba.requerimiento.servicio;

import com.ceiba.requerimiento.modelo.entidad.Requerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;
import com.ceiba.requerimiento.servicio.testdatabuilder.RequerimientoTestDataBuilder;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearRequerimientoTest {
	
    private static final String EL_REQUERIMIENTO_YA_EXISTE_EN_EL_SISTEMA = "El requerimiento ya existe en el sistema";
	
	@Test
    public void validarCreacionRequerimientoTest() {
		// arrange
        Requerimiento requerimiento = new RequerimientoTestDataBuilder().build();
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearRequerimiento servicioCrearRequerimiento = new ServicioCrearRequerimiento(repositorioRequerimiento);
        
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioCrearRequerimiento.ejecutar(requerimiento));
	}
	
	@Test
    public void validarCreacionRequerimientoExistenciaPreviaTest() {
		// arrange
		Requerimiento requerimiento = new RequerimientoTestDataBuilder().build();
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearRequerimiento servicioCrearRequerimiento = new ServicioCrearRequerimiento(repositorioRequerimiento);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearRequerimiento.ejecutar(requerimiento), ExcepcionDuplicidad.class, EL_REQUERIMIENTO_YA_EXISTE_EN_EL_SISTEMA);
	}
	
}
