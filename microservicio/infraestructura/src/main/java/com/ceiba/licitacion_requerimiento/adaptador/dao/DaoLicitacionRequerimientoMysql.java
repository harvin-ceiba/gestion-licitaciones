package com.ceiba.licitacion_requerimiento.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.licitacion_requerimiento.modelo.dto.DtoLicitacionRequerimiento;
import com.ceiba.licitacion_requerimiento.puerto.dao.DaoLicitacionRequerimiento;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoLicitacionRequerimientoMysql implements DaoLicitacionRequerimiento {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="licitacion_requerimiento", value="listar")
    private static String sqlListarPorLicitacionId;
    
    public DaoLicitacionRequerimientoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoLicitacionRequerimiento> listar(Long licitacionId) {
    	MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("licitacionId", licitacionId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorLicitacionId, mapSqlParameterSource, new MapeoLicitacionRequerimiento());
    }
    
}
