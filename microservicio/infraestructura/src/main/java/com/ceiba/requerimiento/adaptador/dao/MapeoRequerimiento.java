package com.ceiba.requerimiento.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.requerimiento.modelo.dto.DtoRequerimiento;
import org.springframework.jdbc.core.RowMapper;

public class MapeoRequerimiento implements RowMapper<DtoRequerimiento>, MapperResult {

    @Override
    public DtoRequerimiento mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String descripcion = resultSet.getString("descripcion");
        int estado = resultSet.getInt("estado");

        return new DtoRequerimiento(id, descripcion, estado);
    }

}
