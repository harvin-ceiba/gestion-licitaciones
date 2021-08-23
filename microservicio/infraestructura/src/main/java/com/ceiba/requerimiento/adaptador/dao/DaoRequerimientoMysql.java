package com.ceiba.requerimiento.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.requerimiento.modelo.dto.DtoRequerimiento;
import com.ceiba.requerimiento.puerto.dao.DaoRequerimiento;

import org.springframework.stereotype.Component;

@Component
public class DaoRequerimientoMysql implements DaoRequerimiento {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="requerimiento", value="listar")
    private static String sqlListar;

    public DaoRequerimientoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoRequerimiento> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoRequerimiento());
    }
}
