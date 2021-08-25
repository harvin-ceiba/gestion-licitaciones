package com.ceiba.requerimiento.controlador;

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
import com.ceiba.requerimiento.comando.ComandoRequerimiento;
import com.ceiba.requerimiento.controlador.testdatabuilder.ComandoRequerimientoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorRequerimiento.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComandoControladorRequerimientoTest {
	
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mocMvc;

	@Test
    public void paso1CrearRequerimientoTest() throws Exception {
        // arrange
        ComandoRequerimiento requerimiento = new ComandoRequerimientoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/requerimientos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requerimiento)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4}"));
    }

	@Test
	public void paso2ActualizarRequerimientoTest() throws Exception {
		// arrange
        Long id = 4L;
        ComandoRequerimiento requerimiento = new ComandoRequerimientoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/requerimientos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requerimiento)))
                .andExpect(status().isOk());
	}
	
    @Test
    public void paso3RequerimientoLicitacionTest() throws Exception {
        // arrange
        Long id = 4L;

        // act - assert
        mocMvc.perform(delete("/requerimientos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
