package com.ceiba.propuesta.controlador;

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
import com.ceiba.propuesta.comando.ComandoPropuesta;
import com.ceiba.propuesta.servicio.testdatabuilder.ComandoPropuestaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorPropuesta.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComandoControladorPropuestaTest {
	
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
    public void paso1CrearPropuestaTest() throws Exception {
        // arrange
		Long idLicitacion = 1L;
        ComandoPropuesta propuesta = new ComandoPropuestaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/licitaciones/{idLicitacion}/propuestas", idLicitacion)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(propuesta)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

	@Test
	public void paso2ActualizarPropuestaTest() throws Exception {
		// arrange
		Long idLicitacion = 1L;
    	Long idPropuesta = 2L;
        ComandoPropuesta propuesta = new ComandoPropuestaTestDataBuilder().build();
        
        // act - assert
        mocMvc.perform(put("/licitaciones/{idLicitacion}/propuestas/{idPropuesta}", idLicitacion, idPropuesta)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(propuesta)))
                .andExpect(status().isOk());
	}
	
    @Test
    public void paso3EliminarLicitacionTest() throws Exception {
        // arrange
    	Long idLicitacion = 1L;
    	Long idPropuesta = 2L;
        
        // act - assert
        mocMvc.perform(delete("/licitaciones/{idLicitacion}/propuestas/{idPropuesta}", idLicitacion, idPropuesta)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
