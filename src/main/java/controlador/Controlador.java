/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DaoException;
import dao.EmpleadoCsv;
import dao.EmpleadoDao;
import dao.EmpleadoJson;
import dao.EmpleadoObj;
import dao.EmpleadoXml;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.DniException;
import modelo.Empleado;
import modelo.EmpleadoEventual;
import modelo.EmpleadoFijo;
import modelo.SistemaNominas;
import vista.Ventana;

/**
 *
 * @author daw1
 */
public class Controlador {
    private final Ventana vista;
    private final SistemaNominas modelo;

    public Controlador(Ventana vista, SistemaNominas modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void crearEmpleado(){
        Empleado e=null;
        String dni, nombre;
        float salario;
        int horas;
        
        try{
            dni=vista.getDni();
            nombre=vista.getNombre();
            salario=vista.getSalario();
            switch(vista.getTipo()){
                case "FIJO":
                    e=new EmpleadoFijo(dni, nombre, salario);
                    break;
                case "EVENTUAL":
                    horas=vista.getHoras();
                    e=new EmpleadoEventual(dni, nombre, salario, horas);
                    break;
            }
            if(modelo.incluirEmpleado(e)){
                vista.mostrarMensaje("EMPLEADO INCLUIDO");
                listarEmpleados();
            }
            else{
                vista.mostrarMensaje("NO SE HA PODIDO INCLUIR EL EMPLEADO");
            }
        } catch (DniException ex) {
            vista.limpiarCampos();
            vista.mostrarMensaje("NO SE HA PODIDO CREAR EL EMPLEADO\n"+ex.getMessage());
        } 
    }
    
    public void buscarEmpleado(){
        Empleado e=null;
        EmpleadoFijo ef=null;
        EmpleadoEventual ev=null;
        String dni=JOptionPane.showInputDialog("Introduzca DNI a buscar: ");
        try{
            e=modelo.getEmpleado(dni);
            vista.mostrarDni(e.getDni());
            vista.mostrarNombre(e.getNombre());
            if(e instanceof EmpleadoFijo){
                ef=(EmpleadoFijo)e;
                vista.mostrarTipo("FIJO");
                vista.mostrarSalario(ef.getSalario());
                vista.mostrarIngresos(ef.getSalario());
            }
            else{
                ev=(EmpleadoEventual)e;
                vista.mostrarTipo("EVENTUAL");
                vista.mostrarSalario(ev.getSalarioHora());
                vista.mostrarIngresos(ev.getSalarioHora()*ev.getHoras());
                vista.mostrarHoras(ev.getHoras());
            }
        } catch (NullPointerException npe){
        }
    }
    
    public void eliminarEmpleado(){
        Empleado e=modelo.getEmpleado(vista.getDni());
        if(modelo.eliminarEmpleado(e)){
            vista.mostrarMensaje("EMPLEADO ELIMINADO");
        }
        else{
            vista.mostrarMensaje("NO SE HA PODIDO ELIMINAR EL EMPLEADO");
        }
        listarEmpleados();
    }
    
    public void modificarEmpleado(){
        Empleado e=modelo.getEmpleado(vista.getDni());
        String nombre=vista.getNombre();
        EmpleadoFijo ef=null;
        EmpleadoEventual ev=null;
        try{
            if(e!=null && !nombre.isEmpty()){
                if(e instanceof EmpleadoFijo){
                    ef=(EmpleadoFijo)e;
                    ef.setSalario(vista.getSalario());
                }
                else{
                    ev=(EmpleadoEventual)e;
                    ev.setHoras(vista.getHoras());
                    ev.setSalarioHora(vista.getSalario());
                }
                e.setNombre(nombre);
                listarEmpleados();
            }
            else{
                vista.mostrarMensaje("No se puede realizar la modificación");
            }
        }catch(NumberFormatException nfe){
            vista.mostrarMensaje("Error en el número");
        }
    }
    
    public void listarEmpleados(){
        List<Empleado> lista=null;
        String orden=vista.getOrden();
        switch(orden){
            case "DNI":
                lista=modelo.listarEmpleados();
                break;
            case "NOMBRE":
                lista=modelo.getEmpleados();
                Collections.sort(lista, new Comparator<Empleado>(){
                    @Override
                    public int compare(Empleado e1, Empleado e2) {
                        return e1.getNombre().compareTo(e2.getNombre());
                    }
                });
                break;
            case "INGRESOS":
                lista=modelo.listarEmpleadosPorSueldo();
                break;
        }
        vista.listarEmpleados(lista);
    }
    
    public void guardarEmpleados(){
        String path=vista.getArchivo();
        int n=0;
        EmpleadoDao empleadoDao=null;
        switch(path.substring(path.indexOf(".")+1)){
            case "csv":
                empleadoDao=new EmpleadoCsv(path);
                break;
            case "obj":
                empleadoDao=new EmpleadoObj(path);
                break;
            case "json":
                empleadoDao=new EmpleadoJson(path);
                break;
            case "xml":
                empleadoDao=new EmpleadoXml(path);
                break;
        }
        modelo.setEmpleadoDao(empleadoDao);
        try{
            n=modelo.guardarEmpleados();
            vista.mostrarMensaje("Se han guardado "+n+" empleados");
        } catch (DaoException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }
    public void cargarEmpleados(){
        String path=vista.getArchivo();
        int n=0;
        EmpleadoDao empleadoDao=null;
        switch(path.substring(path.indexOf(".")+1)){
            case "csv":
                empleadoDao=new EmpleadoCsv(path);
                break;
            case "obj":
                empleadoDao=new EmpleadoObj(path);
                break;
            case "json":
                empleadoDao=new EmpleadoJson(path);
                break;
            case "xml":
                empleadoDao=new EmpleadoXml(path);
                break;
        }
        if(empleadoDao!=null){
            modelo.setEmpleadoDao(empleadoDao);
        }
        else{
            vista.mostrarMensaje("Archivo incorrecto");
        }
        try{
            n=modelo.cargarEmpleados();
            listarEmpleados();
            vista.mostrarMensaje("Se han introducido "+n+" empleados");
        } catch (DaoException | DniException ex) {
            vista.mostrarMensaje(ex.getMessage());
        }
    }
    
    public void iniciar(){
        vista.setVisible(true);
    };
}
