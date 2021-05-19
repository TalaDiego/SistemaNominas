/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author daw1
 */
public class Dni implements Comparable<Dni>, Serializable{
    private static final long serialVersionUID = -3533064359121709969L;
    private String dni;

    public Dni(String dni) throws DniException {
        if(esValido(dni)){
            this.dni = dni;
        }else{
            throw new DniException("DNI incorrecto");
        }
        
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) throws DniException {
        if(esValido(dni)){
            this.dni = dni;
        }else{
            throw new DniException("DNI incorrecto");
        }
    }
    
    

    @Override
    public String toString() {
        return dni;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj!=null){
            if(obj instanceof Dni){
                Dni other=(Dni) obj;
                if(this.dni.equals(other.dni)){
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public int compareTo(Dni o) {
        return dni.compareTo(o.dni);
    }
    
    private static boolean esValido(String dni){
        boolean es=false;
        int resto;
        char letra;
        String letras="TRWAGMYFPDXBNJZSQVHLCKE";
        String er="([0-9]{8})([A-Z])"; /*expresión regular*/
        Pattern p=Pattern.compile(er);
        Matcher m=p.matcher(dni);
        if(m.matches()){
            resto=Integer.parseInt(m.group(1))%23;
            letra=letras.charAt(resto);
            if(letra==dni.charAt(8)){
                es=true;
            }
        }
        return es;
    }
    
}
