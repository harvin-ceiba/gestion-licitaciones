package com.ceiba.propuesta_requerimiento.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.ceiba.propuesta_requerimiento.comando.ComandoPropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.controlador.testdatabuilder.ComandoPropuestaRequerimientoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorPropuestaRequerimiento.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComandoControladorPropuestaRequerimientoTest {
	
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
    public void paso1CrearRequerimientoEnPropuestaTest() throws Exception {
        // arrange
		Long idPropuesta = 1L;
		Long idRequerimiento = 3L;
        ComandoPropuestaRequerimiento propuestaRequerimiento = new ComandoPropuestaRequerimientoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/propuestas/{idPropuesta}/requerimientos/{idRequerimiento}", idPropuesta, idRequerimiento)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(propuestaRequerimiento)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

    @Test
    public void paso2EliminarRequerimientoEnPropuestaTest() throws Exception {
        // arrange
    	Long idPropuesta = 1L;
		Long idRequerimiento = 3L;
		
        // act - assert
        mocMvc.perform(delete("/propuestas/{idPropuesta}/requerimientos/{idRequerimiento}", idPropuesta, idRequerimiento)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
