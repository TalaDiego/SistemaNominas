/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.DniException;
import modelo.Empleado;

/**
 *
 * @author daw1
 */
public interface EmpleadoDao {
    List<Empleado> listar() throws DaoException, DniException;
    int insertar(List<Empleado> listado) throws DaoException;
}
