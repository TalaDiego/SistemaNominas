/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author 
 */
public abstract class Empleado implements Comparable<Empleado>, Serializable{
    private static final long serialVersionUID = -5200850935463934505L;
    private Dni dni;
    private String nombre;

    /**
     *
     * @param dni
     * @param nombre
     */
    public Empleado(String dni, String nombre) throws DniException{
        this.dni=new Dni(dni);
        if(!nombre.isEmpty() && !nombre.isBlank()){
            this.nombre = nombre;
        }
        else{
            throw new IllegalArgumentException("Nombre incorrecto");
        }
        
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return dni + "," + nombre;
    }

    /**
     *
     * @return
     */
    public String getDni() {
        return dni.getDni();
    }

    /**
     *
     * @param dni
     */
    public void setDni(String dni) throws DniException {
        this.dni.setDni(dni);
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!this.dni.equals(other.dni)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param empleado
     * @return
     */
    @Override
    public int compareTo(Empleado empleado) {
        return this.dni.compareTo(empleado.dni);
    }
    
    /**
     *
     * @return
     */
    public abstract float ingresos();
    
    
}
