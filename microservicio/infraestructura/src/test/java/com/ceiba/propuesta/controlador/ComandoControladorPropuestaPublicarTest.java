package com.ceiba.propuesta.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorPropuestaPublicar.class)
public class ComandoControladorPropuestaPublicarTest {
	
	@Autowired
	private MockMvc mocMvc;

	@Test
    public void publicarPropuestaNoExistenteTest() throws Exception {
        // arrange
    	Long idPropuesta = 2L;

        // act - assert
        mocMvc.perform(put("/propuestas/{idPropuesta}/publicar", idPropuesta)
        		.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
	
	@Test
    public void publicarPropuestaExistenteTest() throws Exception {
		// -- 1. Inicialmente se publica la licitación asociada
		// arrange
        Long idLicitacion = 1L;

        // act - assert
        mocMvc.perform(put("/licitaciones/{idLicitacion}/publicar", idLicitacion)
        		.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
		
        // -- 2. Se publica la propuesta
        // arrange
    	Long idPropuesta = 1L;

        // act - assert
        mocMvc.perform(put("/propuestas/{idPropuesta}/publicar", idPropuesta)
        		.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
	
}
