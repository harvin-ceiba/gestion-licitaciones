package com.ceiba.propuesta.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.propuesta.modelo.entidad.Propuesta;
import com.ceiba.propuesta.puerto.repositorio.RepositorioPropuesta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPropuestaMysql implements RepositorioPropuesta {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="propuesta", value="crear")
    private static String sqlCrearPropuesta;

    @SqlStatement(namespace="propuesta", value="actualizar")
    private static String sqlActualizarPropuesta;

    @SqlStatement(namespace="propuesta", value="eliminar")
    private static String sqlEliminarPropuesta;
    
    @SqlStatement(namespace="propuesta", value="existe")
    private static String sqlExistePropuesta;

    @SqlStatement(namespace="propuesta", value="existeLicitacion")
    private static String sqlExisteIncluyendoIdLicitacion;
    
    @SqlStatement(namespace="propuesta", value="existeExcluyendoId") 
    private static String sqlExistePropuestaExcluyendoId;
    
    @SqlStatement(namespace="propuesta", value="publicar")
    private static String sqlPublicarPropuesta;

    public RepositorioPropuestaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Propuesta propuesta) {
        return this.customNamedParameterJdbcTemplate.crear(propuesta, sqlCrearPropuesta);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarPropuesta, paramSource);
    }
    
    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePropuesta,paramSource, Boolean.class);
    }

    @Override
    public boolean existeIncluyendoIdLicitacion(Long licitacionId, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("licitacionId", licitacionId);
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteIncluyendoIdLicitacion,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Propuesta propuesta) {
        this.customNamedParameterJdbcTemplate.actualizar(propuesta, sqlActualizarPropuesta);
    }

	@Override
	public boolean existeExcluyendoId(Long id, Long licitacionId, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("licitacionId", licitacionId);
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePropuestaExcluyendoId,paramSource, Boolean.class);
	}
	
	@Override
    public void publicar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlPublicarPropuesta, paramSource);
    }

}
