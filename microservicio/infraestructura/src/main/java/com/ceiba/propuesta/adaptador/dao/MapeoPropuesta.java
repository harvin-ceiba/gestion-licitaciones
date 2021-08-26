package com.ceiba.propuesta.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.propuesta.modelo.dto.DtoPropuesta;

import org.springframework.jdbc.core.RowMapper;

public class MapeoPropuesta implements RowMapper<DtoPropuesta>, MapperResult {

    @Override
    public DtoPropuesta mapRow(ResultSet resultSet, int rowNum) throws SQLException {

    	Long id = resultSet.getLong("id");
    	Long licitacionId = resultSet.getLong("licitacion_id");
    	String nombre = resultSet.getString("nombre");
    	String descripcion = resultSet.getString("descripcion");
    	String nombreCliente = resultSet.getString("nombre_cliente");
    	double valor = resultSet.getDouble("valor");
    	LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");
    	LocalDateTime fechaPublicacion = extraerLocalDateTime(resultSet, "fecha_publicacion");
    	int estado = resultSet.getInt("estado");
    	
        return new DtoPropuesta(
        	id, 
        	licitacionId, 
        	nombre, 
        	descripcion, 
        	nombreCliente, 
        	valor, 
        	fechaCreacion, 
        	fechaPublicacion, 
        	estado
        );
    }

}
