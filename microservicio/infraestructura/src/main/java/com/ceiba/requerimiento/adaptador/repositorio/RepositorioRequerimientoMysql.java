package com.ceiba.requerimiento.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.requerimiento.modelo.entidad.Requerimiento;
import com.ceiba.requerimiento.puerto.repositorio.RepositorioRequerimiento;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRequerimientoMysql implements RepositorioRequerimiento {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="requerimiento", value="crear")
    private static String sqlCrearRequerimiento;

    @SqlStatement(namespace="requerimiento", value="actualizar")
    private static String sqlActualizarRequerimiento;

    @SqlStatement(namespace="requerimiento", value="eliminar")
    private static String sqlEliminarRequerimiento;
    
    @SqlStatement(namespace="requerimiento", value="existe")
    private static String sqlExisteRequerimiento;

    @SqlStatement(namespace="requerimiento", value="existeDescripcion")
    private static String sqlExisteDescripcionRequerimiento;

    @SqlStatement(namespace="requerimiento", value="existeExcluyendoId") 
    private static String sqlExisteRequerimientoExcluyendoId;

    public RepositorioRequerimientoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Requerimiento requerimiento) {
        return this.customNamedParameterJdbcTemplate.crear(requerimiento, sqlCrearRequerimiento);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarRequerimiento, paramSource);
    }
    
    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteRequerimiento,paramSource, Boolean.class);
    }

    @Override
    public boolean existe(String descripcion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("descripcion", descripcion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteDescripcionRequerimiento,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Requerimiento requerimiento) {
        this.customNamedParameterJdbcTemplate.actualizar(requerimiento, sqlActualizarRequerimiento);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String descripcion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("descripcion", descripcion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteRequerimientoExcluyendoId,paramSource, Boolean.class);
    }
}
