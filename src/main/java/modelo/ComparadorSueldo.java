/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Comparator;

/**
 * Clase anónima
 * @author Sasha
 */
public class ComparadorSueldo implements Comparator<Empleado>{

    /**
     *
     * @param e1
     * @param e2
     * @return
     */
    @Override
    public int compare(Empleado e1, Empleado e2) {
        int salida=0;
        float ingresos1, ingresos2;

        ingresos1=e1.ingresos();
        ingresos2=e2.ingresos();

        if(ingresos1<ingresos2){
            salida=-1;
        }
        else if(ingresos1>ingresos2){
            salida=1;
        }

        return salida;
    }
    
}
