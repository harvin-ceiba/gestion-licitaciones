package com.ceiba.licitacion.servicio;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion.servicio.testdatabuilder.DtoLicitacionRequerimientoTestDataBuilder;
import com.ceiba.licitacion_requerimiento.modelo.dto.DtoLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.dao.DaoLicitacionRequerimiento;

public class ServicioPublicarLicitacionTest {

    private static final String LA_LICITACION_NO_EXISTE = "La licitación que intenta publicar no existe";
    private static final String LA_LICITACION_NO_SE_PUEDE_PUBLICAR_SIN_REQUERIMIENTOS = "La licitación no se puede publicar sin requerimientos";
    private static final String LA_SUMATORIA_DE_LOS_PORCENTAJES_DE_LICITACION_DEBE_SER_IGUAL_A = "La licitación no se puede publicar, el porcentaje de los requerimientos debe ser igual a %s";
    
    private static final double PESO_PORCENTUAL_VALIDO_REQUERIMIENTO_1 = 40D;
    private static final double PESO_PORCENTUAL_VALIDO_REQUERIMIENTO_2 = 60D;
    
    private static final double PESO_PORCENTUAL_INFERIOR_REQUERIMIENTO_1 = 20D;
    private static final double PESO_PORCENTUAL_INFERIOR_REQUERIMIENTO_2 = 40D;
    
    private static final double PESO_PORCENTUAL_SUPERIOR_REQUERIMIENTO_1 = 60D;
    private static final double PESO_PORCENTUAL_SUPERIOR_REQUERIMIENTO_2 = 70D;
    
    private static final Long VALOR_ID = 1L;
    private static final double SUMATORIA_PESO_PORCENTUAL = 100D;
    
    @Test
    public void validarPublicacionLicitacionTest() {
		// arrange
    	List<DtoLicitacionRequerimiento> licitacionRequerimientos = new ArrayList<>();
    	DtoLicitacionRequerimiento requerimiento1 = new DtoLicitacionRequerimientoTestDataBuilder()
    			.withPesoPorcentual(PESO_PORCENTUAL_VALIDO_REQUERIMIENTO_1)
    			.build();
    	DtoLicitacionRequerimiento requerimiento2 = new DtoLicitacionRequerimientoTestDataBuilder()
    			.withPesoPorcentual(PESO_PORCENTUAL_VALIDO_REQUERIMIENTO_2)
    			.build();
    	licitacionRequerimientos.add(requerimiento1);
    	licitacionRequerimientos.add(requerimiento2);
    	
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        DaoLicitacionRequerimiento daoLicitacionRequerimiento = Mockito.mock(DaoLicitacionRequerimiento.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoLicitacionRequerimiento.listar(VALOR_ID)).thenReturn(licitacionRequerimientos);
        
        ServicioPublicarLicitacion servicioPublicarLicitacion = new ServicioPublicarLicitacion(repositorioLicitacion, daoLicitacionRequerimiento);
        // act - assert
        Assertions.assertDoesNotThrow(() -> servicioPublicarLicitacion.ejecutar(VALOR_ID));
    }

    @Test
    public void validarPublicacionLicitacionConIdNoExistenteTest() {
		// arrange
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        DaoLicitacionRequerimiento daoLicitacionRequerimiento = Mockito.mock(DaoLicitacionRequerimiento.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(false);
        ServicioPublicarLicitacion servicioPublicarLicitacion = new ServicioPublicarLicitacion(repositorioLicitacion, daoLicitacionRequerimiento);
        // act - assert
        BasePrueba.assertThrows(() -> servicioPublicarLicitacion.ejecutar(VALOR_ID), ExcepcionValorInvalido.class, LA_LICITACION_NO_EXISTE);
	}
    
    @Test
    public void validarPublicacionLicitacionSinRequerimientosTest() {
		// arrange
    	List<DtoLicitacionRequerimiento> licitacionRequerimientos = new ArrayList<>();
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        DaoLicitacionRequerimiento daoLicitacionRequerimiento = Mockito.mock(DaoLicitacionRequerimiento.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoLicitacionRequerimiento.listar(VALOR_ID)).thenReturn(licitacionRequerimientos);
        ServicioPublicarLicitacion servicioPublicarLicitacion = new ServicioPublicarLicitacion(repositorioLicitacion, daoLicitacionRequerimiento);

        // act - assert
        BasePrueba.assertThrows(() -> servicioPublicarLicitacion.ejecutar(VALOR_ID), ExcepcionSinDatos.class, LA_LICITACION_NO_SE_PUEDE_PUBLICAR_SIN_REQUERIMIENTOS);
    }
    
    @Test
    public void validarPublicacionLicitacionConRequerimientosPesoPorcentualInferiorCienTest() {
		// arrange
    	List<DtoLicitacionRequerimiento> licitacionRequerimientos = new ArrayList<>();
    	DtoLicitacionRequerimiento requerimiento1 = new DtoLicitacionRequerimientoTestDataBuilder()
    			.withPesoPorcentual(PESO_PORCENTUAL_INFERIOR_REQUERIMIENTO_1)
    			.build();
    	DtoLicitacionRequerimiento requerimiento2 = new DtoLicitacionRequerimientoTestDataBuilder()
    			.withPesoPorcentual(PESO_PORCENTUAL_INFERIOR_REQUERIMIENTO_2)
    			.build();
    	licitacionRequerimientos.add(requerimiento1);
    	licitacionRequerimientos.add(requerimiento2);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        DaoLicitacionRequerimiento daoLicitacionRequerimiento = Mockito.mock(DaoLicitacionRequerimiento.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoLicitacionRequerimiento.listar(VALOR_ID)).thenReturn(licitacionRequerimientos);
        ServicioPublicarLicitacion servicioPublicarLicitacion = new ServicioPublicarLicitacion(repositorioLicitacion, daoLicitacionRequerimiento);

        // act - assert
        BasePrueba.assertThrows(() -> servicioPublicarLicitacion.ejecutar(VALOR_ID), ExcepcionValorInvalido.class, 
        		String.format(LA_SUMATORIA_DE_LOS_PORCENTAJES_DE_LICITACION_DEBE_SER_IGUAL_A, SUMATORIA_PESO_PORCENTUAL));
    }
    
    @Test
    public void validarPublicacionLicitacionConRequerimientosPesoPorcentualSuperiorCienTest() {
		// arrange
    	List<DtoLicitacionRequerimiento> licitacionRequerimientos = new ArrayList<>();
    	DtoLicitacionRequerimiento requerimiento1 = new DtoLicitacionRequerimientoTestDataBuilder()
    			.withPesoPorcentual(PESO_PORCENTUAL_SUPERIOR_REQUERIMIENTO_1)
    			.build();
    	DtoLicitacionRequerimiento requerimiento2 = new DtoLicitacionRequerimientoTestDataBuilder()
    			.withPesoPorcentual(PESO_PORCENTUAL_SUPERIOR_REQUERIMIENTO_2)
    			.build();
    	licitacionRequerimientos.add(requerimiento1);
    	licitacionRequerimientos.add(requerimiento2);
        RepositorioLicitacion repositorioLicitacion = Mockito.mock(RepositorioLicitacion.class);
        DaoLicitacionRequerimiento daoLicitacionRequerimiento = Mockito.mock(DaoLicitacionRequerimiento.class);
        Mockito.when(repositorioLicitacion.existeId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(daoLicitacionRequerimiento.listar(VALOR_ID)).thenReturn(licitacionRequerimientos);
        ServicioPublicarLicitacion servicioPublicarLicitacion = new ServicioPublicarLicitacion(repositorioLicitacion, daoLicitacionRequerimiento);
        // act - assert
        
        BasePrueba.assertThrows(() -> servicioPublicarLicitacion.ejecutar(VALOR_ID), ExcepcionValorInvalido.class, 
        		String.format(LA_SUMATORIA_DE_LOS_PORCENTAJES_DE_LICITACION_DEBE_SER_IGUAL_A, SUMATORIA_PESO_PORCENTUAL));
    }
    
}
