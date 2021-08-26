package com.ceiba.requerimiento.servicio;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.requerimiento.modelo.entidad.Requerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;
import com.ceiba.requerimiento.servicio.testdatabuilder.RequerimientoTestDataBuilder;

public class ServicioActualizarRequerimientoTest {
	
    private static final String EL_REQUERIMIENTO_NO_EXISTE_EN_EL_SISTEMA = "El requerimiento no existe en el sistema";
    private static final String EL_NOMBRE_DEL_REQUERIMIENTO_YA_EXISTE_EN_EL_SISTEMA = "El requerimiento ya existe en el sistema";

	@Test
    public void validarActualizacionRequerimientoTest() {
		// arrange
        Requerimiento requerimiento = new RequerimientoTestDataBuilder().build();
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioRequerimiento.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        ServicioActualizarRequerimiento servicioActualizarRequerimiento = new ServicioActualizarRequerimiento(repositorioRequerimiento);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioActualizarRequerimiento.ejecutar(requerimiento));
	}
	
	@Test
    public void validarActualizacionRequerimientoNoExistenteTest() {
		// arrange
		Requerimiento requerimiento = new RequerimientoTestDataBuilder().build();
		RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
		Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(false);
		ServicioActualizarRequerimiento servicioActualizarRequerimiento = new ServicioActualizarRequerimiento(repositorioRequerimiento);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarRequerimiento.ejecutar(requerimiento), ExcepcionValorInvalido.class, EL_REQUERIMIENTO_NO_EXISTE_EN_EL_SISTEMA);
	}

	@Test
    public void validarActualizacionRequerimientoConDescripcionExistentePreviamenteTest() {
		// arrange
		Requerimiento requerimiento = new RequerimientoTestDataBuilder().build();
        RepositorioRequerimiento repositorioRequerimiento = Mockito.mock(RepositorioRequerimiento.class);
        Mockito.when(repositorioRequerimiento.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioRequerimiento.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarRequerimiento servicioActualizarRequerimiento = new ServicioActualizarRequerimiento(repositorioRequerimiento);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarRequerimiento.ejecutar(requerimiento), ExcepcionDuplicidad.class, EL_NOMBRE_DEL_REQUERIMIENTO_YA_EXISTE_EN_EL_SISTEMA);
	}
}
