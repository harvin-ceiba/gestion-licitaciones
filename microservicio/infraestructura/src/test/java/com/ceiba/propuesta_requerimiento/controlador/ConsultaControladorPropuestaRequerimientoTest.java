package com.ceiba.propuesta_requerimiento.controlador;

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
@WebMvcTest(ConsultaControladorPropuestaRequerimiento.class)
public class ConsultaControladorPropuestaRequerimientoTest {

	@Autowired
    private MockMvc mocMvc;

    @Test
    public void listarRequerimientosDeLicitacionTest() throws Exception {
    	// arrange
    	Long idPropuesta = 1L;
    	
        // act - assert
        mocMvc.perform(get("/propuestas/{idPropuesta}/requerimientos", idPropuesta)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].propuestaId", is(1)))
                .andExpect(jsonPath("$[0].requerimientoId", is(1)));
    }
    
}
