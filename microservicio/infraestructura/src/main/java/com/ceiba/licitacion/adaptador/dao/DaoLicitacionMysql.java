package com.ceiba.licitacion.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.licitacion.modelo.dto.DtoLicitacion;
import com.ceiba.licitacion.puerto.dao.DaoLicitacion;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoLicitacionMysql implements DaoLicitacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="licitacion", value="listar")
    private static String sqlListar;
    
    @SqlStatement(namespace="licitacion", value="buscarPorId")
    private static String sqlBuscarPorId;

    public DaoLicitacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoLicitacion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoLicitacion());
    }

	@Override
	public DtoLicitacion buscarPorId(Long id) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId, mapSqlParameterSource, new MapeoLicitacion());
	}
}
