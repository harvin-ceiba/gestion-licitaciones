package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion.servicio.ServicioActualizarLicitacion;
import com.ceiba.licitacion.servicio.ServicioCrearLicitacion;
import com.ceiba.licitacion.servicio.ServicioEliminarLicitacion;
import com.ceiba.licitacion.servicio.ServicioPublicarLicitacion;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.servicio.ServicioActualizarLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.servicio.ServicioCrearLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.servicio.ServicioEliminarLicitacionRequerimiento;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;
import com.ceiba.propuesta.servicio.ServicioActualizarPropuesta;
import com.ceiba.propuesta.servicio.ServicioCrearPropuesta;
import com.ceiba.propuesta.servicio.ServicioEliminarPropuesta;
import com.ceiba.propuesta.servicio.ServicioPublicarPropuesta;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;
import com.ceiba.requerimiento.servicio.ServicioActualizarRequerimiento;
import com.ceiba.requerimiento.servicio.ServicioCrearRequerimiento;
import com.ceiba.requerimiento.servicio.ServicioEliminarRequerimiento;

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
    
    
    /* Servicios Módulo de Licitaciones */
    
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
    
    @Bean
    public ServicioPublicarLicitacion servicioPublicarLicitacion(RepositorioLicitacion repositorioLicitacion) {
        return new ServicioPublicarLicitacion(repositorioLicitacion);
    }

    
    /* Servicios Módulo de Requerimientos */
    
    @Bean
    public ServicioCrearRequerimiento servicioCrearRequerimiento(RepositorioRequerimiento repositorioRequerimiento) {
        return new ServicioCrearRequerimiento(repositorioRequerimiento);
    }

    @Bean
    public ServicioEliminarRequerimiento servicioEliminarRequerimiento(RepositorioRequerimiento repositorioRequerimiento) {
        return new ServicioEliminarRequerimiento(repositorioRequerimiento);
    }

    @Bean
    public ServicioActualizarRequerimiento servicioActualizarRequerimiento(RepositorioRequerimiento repositorioRequerimiento) {
        return new ServicioActualizarRequerimiento(repositorioRequerimiento);
    }
    
    /* Servicios Módulo de Requerimientos de las Licitaciones */
    
    @Bean
    public ServicioCrearLicitacionRequerimiento servicioCrearLicitacionRequerimiento(RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento) {
        return new ServicioCrearLicitacionRequerimiento(repositorioLicitacionRequerimiento);
    }

    @Bean
    public ServicioEliminarLicitacionRequerimiento servicioEliminarLicitacionRequerimiento(RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento) {
        return new ServicioEliminarLicitacionRequerimiento(repositorioLicitacionRequerimiento);
    }

    @Bean
    public ServicioActualizarLicitacionRequerimiento servicioActualizarLicitacionRequerimiento(RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento) {
        return new ServicioActualizarLicitacionRequerimiento(repositorioLicitacionRequerimiento);
    }
    
    /* Servicios Módulo de Propuestas */
    
    @Bean
    public ServicioCrearPropuesta servicioCrearPropuesta(RepositorioPropuesta repositorioPropuesta) {
        return new ServicioCrearPropuesta(repositorioPropuesta);
    }

    @Bean
    public ServicioEliminarPropuesta servicioEliminarPropuesta(RepositorioPropuesta repositorioPropuesta) {
        return new ServicioEliminarPropuesta(repositorioPropuesta);
    }

    @Bean
    public ServicioActualizarPropuesta servicioActualizarPropuesta(RepositorioPropuesta repositorioPropuesta) {
        return new ServicioActualizarPropuesta(repositorioPropuesta);
    }
    
    @Bean
    public ServicioPublicarPropuesta servicioPublicarPropuesta(RepositorioPropuesta repositorioPropuesta) {
        return new ServicioPublicarPropuesta(repositorioPropuesta);
    }
    
}
