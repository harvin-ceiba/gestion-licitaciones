package com.ceiba.licitacion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.licitacion.modelo.entidad.Licitacion;
import com.ceiba.licitacion.puerto.repositorio.RepositorioLicitacion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioLicitacionMysql implements RepositorioLicitacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="licitacion", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="licitacion", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="licitacion", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="licitacion", value="existe")
    private static String sqlExiste;
    
    @SqlStatement(namespace="licitacion", value="existeCodigo")
    private static String sqlExisteCodigo;

    @SqlStatement(namespace="licitacion", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;
    
    @SqlStatement(namespace="licitacion", value="publicar")
    private static String sqlPublicar;

    public RepositorioLicitacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Licitacion licitacion) {
        return this.customNamedParameterJdbcTemplate.crear(licitacion, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }
    
    @Override
    public boolean existeId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean existeCodigo(String codigo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("codigo", codigo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCodigo,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Licitacion licitacion) {
        this.customNamedParameterJdbcTemplate.actualizar(licitacion, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String codigo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("codigo", codigo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }
    
    @Override
    public void publicar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlPublicar, paramSource);
    }
}
