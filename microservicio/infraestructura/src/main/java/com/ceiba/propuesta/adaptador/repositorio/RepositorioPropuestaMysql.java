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
    private static String sqlCrear;

    @SqlStatement(namespace="propuesta", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="propuesta", value="eliminar")
    private static String sqlEliminar;
    
    @SqlStatement(namespace="propuesta", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="propuesta", value="existeLicitacion")
    private static String sqlExisteLicitacion;
    
    @SqlStatement(namespace="propuesta", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;
    
    @SqlStatement(namespace="propuesta", value="publicar")
    private static String sqlPublicar;

    public RepositorioPropuestaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Propuesta propuesta) {
        return this.customNamedParameterJdbcTemplate.crear(propuesta, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }
    
    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean existe(Long licitacionId, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("licitacionId", licitacionId);
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteLicitacion,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Propuesta propuesta) {
        this.customNamedParameterJdbcTemplate.actualizar(propuesta, sqlActualizar);
    }

	@Override
	public boolean existeExcluyendoId(Long id, Long licitacionId, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("licitacionId", licitacionId);
        paramSource.addValue("nombre", nombre);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
	}
	
	@Override
    public void publicar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlPublicar, paramSource);
    }

}
