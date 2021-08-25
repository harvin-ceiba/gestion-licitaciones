package com.ceiba.licitacion.controlador;

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
import com.ceiba.licitacion.comando.ComandoLicitacion;
import com.ceiba.licitacion.controlador.testdatabuilder.ComandoLicitacionTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorLicitacion.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComandoControladorLicitacionTest {
	
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
    public void paso1CrearLicitacionTest() throws Exception {
        // arrange
        ComandoLicitacion licitacion = new ComandoLicitacionTestDataBuilder().withCodigo("002").build();

        // act - assert
        mocMvc.perform(post("/licitaciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(licitacion)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

	@Test
	public void paso2ActualizarLicitacionTest() throws Exception {
		// arrange
        Long id = 2L;
        ComandoLicitacion licitacion = new ComandoLicitacionTestDataBuilder().withCodigo("002").build();
        // act - assert
        mocMvc.perform(put("/licitaciones/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(licitacion)))
                .andExpect(status().isOk());
	}
	
    @Test
    public void paso3EliminarLicitacionTest() throws Exception {
        // arrange
        Long id = 2L;
        // act - assert
        mocMvc.perform(delete("/licitaciones/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
