package com.ceiba.propuesta_requerimiento.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.propuesta_requerimiento.modelo.dto.DtoPropuestaRequerimiento;
import com.ceiba.propuesta_requerimiento.puerto.dao.DaoPropuestaRequerimiento;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class DaoPropuestaRequerimientoMysql implements DaoPropuestaRequerimiento {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="propuesta_requerimiento", value="listar")
    private static String sqlListarPorPropuestaId;
    
    public DaoPropuestaRequerimientoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPropuestaRequerimiento> listar(Long propuestaId) {
    	MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("propuestaId", propuestaId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorPropuestaId, mapSqlParameterSource, new MapeoPropuestaRequerimiento());
    }
    
}
