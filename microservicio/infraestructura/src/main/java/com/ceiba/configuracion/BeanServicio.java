package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.*;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
    
    
    /* Servicios M�dulo de Licitaciones */
    
    @Bean
    public ServicioCrearLicitacion servicioCrearLicitacion(RepositorioLicitacion repositorioLicitacion) {
        return new ServicioCrearLicitacion(repositorioLicitacion);
    }

    @Bean
    public ServicioEliminarLicitacion servicioEliminarLicitacion(RepositorioLicitacion repositorioLicitacion) {
        return new ServicioEliminarLicitacion(repositorioLicitacion);
    }

    @Bean
    public ServicioActualizarLicitacion servicioActualizarLicitacion(RepositorioLicitacion repositorioLicitacion) {
        return new ServicioActualizarLicitacion(repositorioLicitacion);
    }
    
}
