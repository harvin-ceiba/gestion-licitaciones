package com.ceiba.propuesta_requerimiento.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.propuesta_requerimiento.modelo.entidad.PropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.puerto.repositorio.RepositorioPropuestaRequerimiento;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPropuestaRequerimientoMysql implements RepositorioPropuestaRequerimiento {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="propuesta_requerimiento", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="propuesta_requerimiento", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="propuesta_requerimiento", value="existe")
    private static String sqlExiste;

    public RepositorioPropuestaRequerimientoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(PropuestaRequerimiento propuestaRequerimiento) {
        return this.customNamedParameterJdbcTemplate.crear(propuestaRequerimiento, sqlCrear);
    }

    @Override
    public void eliminar(Long propuestaId, Long requerimientoId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("propuestaId", propuestaId);
        paramSource.addValue("requerimientoId", requerimientoId);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long licitacionId, Long requerimientoId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("propuestaId", licitacionId);
        paramSource.addValue("requerimientoId", requerimientoId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

}
