package com.ceiba.licitacion.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
@WebMvcTest(ConsultaControladorLicitacion.class)
public class ConsultaControladorLicitacionTest {

	@Autowired
    private MockMvc mocMvc;

    @Test
    public void listarLicitaciones() throws Exception {
    	// arrange

        // act - assert
        mocMvc.perform(get("/licitaciones")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].codigo", is("001")))
                .andExpect(jsonPath("$[0].nombre", is("LICITACION1")))
		    	.andExpect(jsonPath("$[0].descripcion", is("DESCRIPCION1")));
    }
    
    @Test
    public void buscarLicitacionPorId() throws Exception {
    	// arrange
    	Long id = 1L;

        // act - assert
        mocMvc.perform(get("/licitaciones/{id}", id)
        		.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigo", is("001")))
                .andExpect(jsonPath("$.nombre", is("LICITACION1")))
		    	.andExpect(jsonPath("$.descripcion", is("DESCRIPCION1")));
    }

}
