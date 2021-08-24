package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import com.ceiba.licitacion.puerto.dao.DaoLicitacion;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import com.ceiba.licitacion.servicio.ServicioActualizarLicitacion;
import com.ceiba.licitacion.servicio.ServicioCrearLicitacion;
import com.ceiba.licitacion.servicio.ServicioEliminarLicitacion;
import com.ceiba.licitacion.servicio.ServicioPublicarLicitacion;
import com.ceiba.licitacion_requerimiento.puerto.dao.DaoLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.servicio.ServicioActualizarLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.servicio.ServicioCrearLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.servicio.ServicioEliminarLicitacionRequerimiento;
import com.ceiba.propuesta.puerto.dao.DaoPropuesta;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;
import com.ceiba.propuesta.servicio.ServicioActualizarPropuesta;
import com.ceiba.propuesta.servicio.ServicioCrearPropuesta;
import com.ceiba.propuesta.servicio.ServicioEliminarPropuesta;
import com.ceiba.propuesta.servicio.ServicioPublicarPropuesta;
import com.ceiba.propuesta_requerimiento.puerto.repositorio.RepositorioPropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.servicio.ServicioCrearPropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.servicio.ServicioEliminarPropuestaRequerimiento;
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
    public ServicioPublicarLicitacion servicioPublicarLicitacion(RepositorioLicitacion repositorioLicitacion, DaoLicitacionRequerimiento daoLicitacionRequerimiento) {
        return new ServicioPublicarLicitacion(repositorioLicitacion, daoLicitacionRequerimiento);
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
    public ServicioCrearLicitacionRequerimiento servicioCrearLicitacionRequerimiento(RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento,
    		RepositorioLicitacion repositorioLicitacion,
    		RepositorioRequerimiento repositorioRequerimiento) {
        return new ServicioCrearLicitacionRequerimiento(repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
    }

    @Bean
    public ServicioEliminarLicitacionRequerimiento servicioEliminarLicitacionRequerimiento(
    		RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento,
    		RepositorioLicitacion repositorioLicitacion,
    		RepositorioRequerimiento repositorioRequerimiento) {
        return new ServicioEliminarLicitacionRequerimiento(repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
    }

    @Bean
    public ServicioActualizarLicitacionRequerimiento servicioActualizarLicitacionRequerimiento(
    		RepositorioLicitacionRequerimiento repositorioLicitacionRequerimiento,
    		RepositorioLicitacion repositorioLicitacion,
    		RepositorioRequerimiento repositorioRequerimiento) {
        return new ServicioActualizarLicitacionRequerimiento(repositorioLicitacionRequerimiento, repositorioLicitacion, repositorioRequerimiento);
    }
    
    /* Servicios Módulo de Propuestas */
    
    @Bean
    public ServicioCrearPropuesta servicioCrearPropuesta(RepositorioPropuesta repositorioPropuesta, RepositorioLicitacion repositorioLicitacion) {
        return new ServicioCrearPropuesta(repositorioPropuesta, repositorioLicitacion);
    }

    @Bean
    public ServicioEliminarPropuesta servicioEliminarPropuesta(RepositorioPropuesta repositorioPropuesta, RepositorioLicitacion repositorioLicitacion) {
        return new ServicioEliminarPropuesta(repositorioPropuesta, repositorioLicitacion);
    }

    @Bean
    public ServicioActualizarPropuesta servicioActualizarPropuesta(RepositorioPropuesta repositorioPropuesta, RepositorioLicitacion repositorioLicitacion) {
        return new ServicioActualizarPropuesta(repositorioPropuesta, repositorioLicitacion);
    }
    
    @Bean
    public ServicioPublicarPropuesta servicioPublicarPropuesta(RepositorioPropuesta repositorioPropuesta, DaoPropuesta daoPropuesta, DaoLicitacion daoLicitacion) {
        return new ServicioPublicarPropuesta(repositorioPropuesta, daoPropuesta, daoLicitacion);
    }
    
    /* Servicios Módulo de Requerimientos de las Propuestas */
    
    @Bean
    public ServicioCrearPropuestaRequerimiento servicioCrearPropuestaRequerimiento(RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento,
    		RepositorioPropuesta repositorioPropuesta,
    		RepositorioRequerimiento repositorioRequerimiento) {
        return new ServicioCrearPropuestaRequerimiento(repositorioPropuestaRequerimiento, repositorioPropuesta, repositorioRequerimiento);
    }

    @Bean
    public ServicioEliminarPropuestaRequerimiento servicioEliminarPropuestaRequerimiento(
    		RepositorioPropuestaRequerimiento repositorioPropuestaRequerimiento,
    		RepositorioPropuesta repositorioPropuesta,
    		RepositorioRequerimiento repositorioRequerimiento) {
        return new ServicioEliminarPropuestaRequerimiento(repositorioPropuestaRequerimiento, repositorioPropuesta, repositorioRequerimiento);
    }

}
