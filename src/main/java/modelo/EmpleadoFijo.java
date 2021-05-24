/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author daw1
 */
public class EmpleadoFijo extends Empleado{
    private static final long serialVersionUID = 8726079477013658090L;
    private float salario;

    /**
     *
     * @param dni
     * @param nombre
     * @param salario
     */
    public EmpleadoFijo(String dni, String nombre, float salario) throws DniException {
        super(dni, nombre);
        if(salario>0){
            this.salario = salario;
        }
        else{
            throw new NumberFormatException("Salario incorrecto");
        }
    }
    
    /**
     *
     * @return
     */
    public float getSalario() {
        return salario;
    }

    /**
     *
     * @param salario
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+","+salario;
    }

    /**
     *
     * @return
     */
    @Override
    public float ingresos() {
        return salario;
    }
    
}
