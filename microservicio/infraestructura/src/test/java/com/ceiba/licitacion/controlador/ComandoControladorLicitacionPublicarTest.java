package com.ceiba.licitacion.controlador;

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
@WebMvcTest(ComandoControladorLicitacionPublicar.class)
public class ComandoControladorLicitacionPublicarTest {
	
	@Autowired
	private MockMvc mocMvc;

	@Test
    public void publicarLicitacionExistente() throws Exception {
		// arrange
        Long id = 1L;

        // act - assert
        mocMvc.perform(put("/licitaciones/{id}/publicar", id)
        		.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
	
	@Test
    public void publicarLicitacionNoExistente() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(put("/licitaciones/{id}/publicar", id)
        		.contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
    
}
