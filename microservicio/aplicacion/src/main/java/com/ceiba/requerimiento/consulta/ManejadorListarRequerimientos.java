package com.ceiba.requerimiento.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.requerimiento.modelo.dto.DtoRequerimiento;
import com.ceiba.requerimiento.puerto.dao.DaoRequerimiento;

@Component
public class ManejadorListarRequerimientos {

    private final DaoRequerimiento daoRequerimiento;

    public ManejadorListarRequerimientos(DaoRequerimiento daoRequerimiento){
        this.daoRequerimiento = daoRequerimiento;
    }

    public List<DtoRequerimiento> ejecutar(){ return this.daoRequerimiento.listar(); }
}
