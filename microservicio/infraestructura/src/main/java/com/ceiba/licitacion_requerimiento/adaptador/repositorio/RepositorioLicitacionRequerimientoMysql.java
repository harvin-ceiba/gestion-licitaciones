package com.ceiba.licitacion_requerimiento.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.licitacion_requerimiento.modelo.entidad.LicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.repositorio.RepositorioLicitacionRequerimiento;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioLicitacionRequerimientoMysql implements RepositorioLicitacionRequerimiento {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="licitacion_requerimiento", value="crear")
    private static String sqlCrearLicitacionRequerimiento;

    @SqlStatement(namespace="licitacion_requerimiento", value="actualizar")
    private static String sqlActualizarLicitacionRequerimiento;

    @SqlStatement(namespace="licitacion_requerimiento", value="eliminar")
    private static String sqlEliminarLicitacionRequerimiento;

    @SqlStatement(namespace="licitacion_requerimiento", value="existe")
    private static String sqlExisteLicitacionRequerimiento;

    public RepositorioLicitacionRequerimientoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(LicitacionRequerimiento licitacionRequerimiento) {
        return this.customNamedParameterJdbcTemplate.crear(licitacionRequerimiento, sqlCrearLicitacionRequerimiento);
    }

    @Override
    public void eliminar(Long licitacionId, Long requerimientoId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("licitacionId", licitacionId);
        paramSource.addValue("requerimientoId", requerimientoId);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarLicitacionRequerimiento, paramSource);
    }

    @Override
    public boolean existe(Long licitacionId, Long requerimientoId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("licitacionId", licitacionId);
        paramSource.addValue("requerimientoId", requerimientoId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteLicitacionRequerimiento,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(LicitacionRequerimiento licitacionRequerimiento) {
        this.customNamedParameterJdbcTemplate.actualizar(licitacionRequerimiento, sqlActualizarLicitacionRequerimiento);
    }

}
