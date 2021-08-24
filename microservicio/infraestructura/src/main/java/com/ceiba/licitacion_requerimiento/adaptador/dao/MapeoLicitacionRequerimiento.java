package com.ceiba.licitacion_requerimiento.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.licitacion_requerimiento.modelo.dto.DtoLicitacionRequerimiento;

import org.springframework.jdbc.core.RowMapper;

public class MapeoLicitacionRequerimiento implements RowMapper<DtoLicitacionRequerimiento>, MapperResult {

    @Override
    public DtoLicitacionRequerimiento mapRow(ResultSet resultSet, int rowNum) throws SQLException {

    	Long id = resultSet.getLong("id");
    	Long licitacionId = resultSet.getLong("licitacion_id");
    	Long requerimientoId = resultSet.getLong("requerimiento_id");
    	double pesoPorcentual = resultSet.getDouble("peso_porcentual");

        return new DtoLicitacionRequerimiento(id, licitacionId, requerimientoId, pesoPorcentual);
    }

}
