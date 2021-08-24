package com.ceiba.propuesta_requerimiento.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.propuesta_requerimiento.modelo.dto.DtoPropuestaRequerimiento;

import org.springframework.jdbc.core.RowMapper;

public class MapeoPropuestaRequerimiento implements RowMapper<DtoPropuestaRequerimiento>, MapperResult {

    @Override
    public DtoPropuestaRequerimiento mapRow(ResultSet resultSet, int rowNum) throws SQLException {

    	Long id = resultSet.getLong("id");
    	Long propuestaId = resultSet.getLong("propuesta_id");
    	Long requerimientoId = resultSet.getLong("requerimiento_id");

        return new DtoPropuestaRequerimiento(id, propuestaId, requerimientoId);
    }

}
