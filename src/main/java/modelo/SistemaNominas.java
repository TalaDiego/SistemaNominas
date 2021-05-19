/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.EmpleadoDao;
import dao.DaoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author 
 */
public class SistemaNominas {
    private List<Empleado> empleados;
    private EmpleadoDao empleadoDao;

    /**
     *
     */
    public SistemaNominas() {
        empleados=new ArrayList<>();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    
    public EmpleadoDao getEmpleadoDao() {
        return empleadoDao;
    }

    public void setEmpleadoDao(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }
    
    /**
     * Añade un empleado a la lista de empleados.
     * @param empleado Empleado a ser incluido
     * @return true si se ha incluido correctamente, false si no.
     */
    public boolean incluirEmpleado(Empleado empleado){
        boolean incluido=false;
        
        if(!empleados.contains(empleado)){
            empleados.add(empleado);
            incluido=true;
        }
        
        return incluido;
    }
    
    /**
     * Devuelve el empleado correspondiente al dni especificicado.
     * @param dni DNI del empleado a ser devuelto.
     * @return El empleado correspondiente al DNI.
     */
    public Empleado getEmpleado(String dni){
        Empleado empleado=null;
        Iterator<Empleado> iterador=empleados.iterator();
        
        while(iterador.hasNext()){
            empleado=iterador.next();
            if(empleado.getDni().equals(dni)){
                return empleado;
            }
        }
        
        return null;
    }
    
    /**
     * Elimina el empleado especificado de la lista de empleados.
     * @param empleado Empleado a ser eliminado.
     * @return true si se ha eliminado correctamente, false si no.
     */
    public boolean eliminarEmpleado(Empleado empleado){
        return empleados.remove(empleado);
    }
    
    /**
     * Crea una lista de los empleados.
     * @return La lista de empleados.
     */
    public List<Empleado> listarEmpleados(){
        List<Empleado> listado=new ArrayList<>(empleados);
        
        Collections.sort(listado);
        
        return listado;
    }
    
    /**
     * Crea una lista de los empleados, ordenados por sueldo.
     * @return La lista de empleados, ordenada por sueldo.
     */
    public List<Empleado> listarEmpleadosPorSueldo(){
        List<Empleado> listado=new ArrayList<>(empleados);
        Collections.sort(listado, new ComparadorSueldo());
        return listado;
    }
    
    /**
     * Calcula el total de salarios sumando el de cada empleado.
     * @return El total de salarios.
     */
    public float getTotalSalarios(){
        float salida=0;
        Iterator<Empleado> iterador=empleados.iterator();
        
        while(iterador.hasNext()){
            salida+=iterador.next().ingresos();
        }
        
        return salida;
    }
   
    public int guardarEmpleados() throws DaoException{
        if(empleadoDao!=null){
            return empleadoDao.insertar(empleados);
        }
        return 0;
    }
    
    public int cargarEmpleados() throws DaoException, DniException{
        int n=0;
        if(empleadoDao!=null){
            List<Empleado> listado=empleadoDao.listar();
            for(Empleado empleado: listado){
                incluirEmpleado(empleado);
                n++;
            }
        }
        return n;
    }
}
