package com.ceiba.licitacion.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.licitacion.modelo.dto.DtoLicitacion;
import org.springframework.jdbc.core.RowMapper;

public class MapeoLicitacion implements RowMapper<DtoLicitacion>, MapperResult {

    @Override
    public DtoLicitacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {

    	Long id = resultSet.getLong("id");
    	String codigo = resultSet.getString("codigo");
    	String nombre = resultSet.getString("nombre");
    	String descripcion = resultSet.getString("descripcion");
    	double presupuesto = resultSet.getDouble("presupuesto");
    	LocalDate fechaInicio = extraerLocalDate(resultSet, "fecha_inicio");
    	LocalDate fechaFin = extraerLocalDate(resultSet, "fecha_fin");
    	int estado = resultSet.getInt("estado");

        return new DtoLicitacion(id, codigo, nombre, descripcion, presupuesto, fechaInicio, fechaFin, estado);
    }

}
