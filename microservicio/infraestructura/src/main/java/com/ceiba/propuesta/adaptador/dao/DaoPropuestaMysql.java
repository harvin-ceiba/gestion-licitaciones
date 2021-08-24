package com.ceiba.propuesta.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.propuesta.modelo.dto.DtoPropuesta;
import com.ceiba.propuesta.puerto.dao.DaoPropuesta;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoPropuestaMysql implements DaoPropuesta {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="propuesta", value="listar")
    private static String sqlListar;
    
    @SqlStatement(namespace="propuesta", value="buscarPorId")
    private static String sqlBuscarPorId;
    
    public DaoPropuestaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPropuesta> listar(Long licitacionId) {
    	MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("licitacionId", licitacionId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, mapSqlParameterSource, new MapeoPropuesta());
    }

	@Override
	public DtoPropuesta buscarPorId(Long id) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId, mapSqlParameterSource, new MapeoPropuesta());
    }
    
}
