package com.ceiba.licitacion_requerimiento.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.licitacion_requerimiento.comando.ComandoLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.controlador.testdatabuilder.ComandoLicitacionRequerimientoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorLicitacionRequerimiento.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComandoControladorLicitacionRequerimientoTest {
	
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
    public void paso1CrearRequerimientoEnLicitacionTest() throws Exception {
        // arrange
		Long idLicitacion = 1L;
		Long idRequerimiento = 3L;
        ComandoLicitacionRequerimiento licitacionRequerimiento = new ComandoLicitacionRequerimientoTestDataBuilder()
        		.withPesoPorcentualId(10D).build();

        // act - assert
        mocMvc.perform(post("/licitaciones/{idLicitacion}/requerimientos/{idRequerimiento}", idLicitacion, idRequerimiento)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(licitacionRequerimiento)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

	@Test
	public void paso2ActualizarRequerimientoEnLicitacionTest() throws Exception {
		// arrange
		Long idLicitacion = 1L;
		Long idRequerimiento = 3L;
        ComandoLicitacionRequerimiento licitacionRequerimiento = new ComandoLicitacionRequerimientoTestDataBuilder()
        		.withPesoPorcentualId(50D).build();

        // act - assert
        mocMvc.perform(put("/licitaciones/{idLicitacion}/requerimientos/{idRequerimiento}", idLicitacion, idRequerimiento)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(licitacionRequerimiento)))
                .andExpect(status().isOk());
	}
	
    @Test
    public void paso3EliminarRequerimientoEnLicitacionTest() throws Exception {
        // arrange
    	Long idLicitacion = 1L;
		Long idRequerimiento = 3L;
		
        // act - assert
        mocMvc.perform(delete("/licitaciones/{idLicitacion}/requerimientos/{idRequerimiento}", idLicitacion, idRequerimiento)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
