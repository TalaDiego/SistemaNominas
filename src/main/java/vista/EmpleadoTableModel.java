/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Dni;
import modelo.Empleado;
import modelo.EmpleadoEventual;
import modelo.EmpleadoFijo;

/**
 *
 * @author daw1
 */
public class EmpleadoTableModel extends AbstractTableModel{
    private String[] columnas;
    private List<Empleado> listado;

    public EmpleadoTableModel() {
        columnas= new String[]{"DNI","NOMBRE","SALARIO","HORAS","INGRESOS"};
        listado=new ArrayList<>();
    }

    public void setListado(List<Empleado> listado) {
        this.listado = listado;
    }
    
    @Override
    public int getRowCount() {
        return listado.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object obj=null;
        Empleado e=listado.get(rowIndex);
        EmpleadoEventual ev=null;
        EmpleadoFijo ef=null;
        
        if(e instanceof EmpleadoFijo){
            ef=(EmpleadoFijo) e;
        }
        else{
            ev=(EmpleadoEventual) e;
        }
        
        switch(columnIndex){
            case 0:
                obj=e.getDni();
                break;
            case 1:
                obj=e.getNombre();
                break;
            case 2:
                if(ef!=null){
                    obj=ef.getSalario();
                }
                else{
                    obj=ev.getSalarioHora();
                }
                break;
            case 3:
                if(ev!=null){
                    obj=ev.getHoras();
                }
                else{
                    obj=0;
                }
                break;
            case 4:
                obj=e.ingresos();
        }
        return obj;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> clase=null;
        switch(columnIndex){
            case 0:
                clase=Dni.class;
                break;
            case 1:
                clase=String.class;
                break;
            case 2:
                clase=Float.class;
                break;
            case 3:
                clase=Integer.class;
                break;
            case 4:
                clase=Float.class;
                break;
        }
        return clase;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    
}
