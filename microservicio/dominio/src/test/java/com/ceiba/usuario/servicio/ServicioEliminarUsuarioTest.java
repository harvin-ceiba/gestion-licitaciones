package com.ceiba.usuario.servicio;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioEliminarUsuarioTest {

    @Test
    public void validarEliminarUsuarioTest() {
    	// arrange
    	RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
    	ServicioEliminarUsuario servicioEliminarUsuario = new ServicioEliminarUsuario(repositorioUsuario);
    	// act - assert
    	Assertions.assertDoesNotThrow(() -> servicioEliminarUsuario.ejecutar(Mockito.anyLong()));
	}
}
