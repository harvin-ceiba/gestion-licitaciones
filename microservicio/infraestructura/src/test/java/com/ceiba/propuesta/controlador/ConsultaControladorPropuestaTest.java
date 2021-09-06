package com.ceiba.propuesta.controlador;

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
@WebMvcTest(ConsultaControladorPropuesta.class)
public class ConsultaControladorPropuestaTest {

	@Autowired
    private MockMvc mocMvc;
	
	@Test
    public void listarPropuestasTest() throws Exception {
    	// arrange
    	Long idLicitacion = 1L;

        // act - assert
        mocMvc.perform(get("/propuestas", idLicitacion)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].licitacionId", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("PROPUESTA1")))
		    	.andExpect(jsonPath("$[0].descripcion", is("DESCRIPCION1")));
    }

    @Test
    public void listarPropuestasPorIdLicitacionTest() throws Exception {
    	// arrange
    	Long idLicitacion = 1L;

        // act - assert
        mocMvc.perform(get("/licitaciones/{idLicitacion}/propuestas", idLicitacion)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].licitacionId", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("PROPUESTA1")))
		    	.andExpect(jsonPath("$[0].descripcion", is("DESCRIPCION1")));
    }
    
    @Test
    public void buscarPropuestaPorIdTest() throws Exception {
    	// arrange
    	Long idLicitacion = 1L;
    	Long idPropuesta = 1L;

        // act - assert
        mocMvc.perform(get("/propuestas/{idPropuesta}", idLicitacion, idPropuesta)
        		.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.licitacionId", is(1)))
                .andExpect(jsonPath("$.nombre", is("PROPUESTA1")))
		    	.andExpect(jsonPath("$.descripcion", is("DESCRIPCION1")));
    }

}
