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
public class EmpleadoEventual extends Empleado{
    private static final long serialVersionUID = -1588630860168668720L;
    private float salarioHora;
    private int horas;

    /**
     *
     * @param dni
     * @param nombre
     * @param salarioHora
     * @param horas
     */
    public EmpleadoEventual(String dni, String nombre, float salarioHora, int horas) throws DniException {
        super(dni, nombre);
        if(salarioHora>0 && horas>0){
            this.salarioHora = salarioHora;
            this.horas = horas;
        }
        else{
            throw new NumberFormatException("Error en el salario y/u horas");
        }
        
    }

    /**
     *
     * @return
     */
    public float getSalarioHora() {
        return salarioHora;
    }

    /**
     *
     * @param salarioHora
     */
    public void setSalarioHora(float salarioHora) {
        this.salarioHora = salarioHora;
    }

    /**
     *
     * @return
     */
    public int getHoras() {
        return horas;
    }

    /**
     *
     * @param horas
     */
    public void setHoras(int horas) {
        this.horas = horas;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+","+salarioHora+","+horas;
    }
    
    /**
     *
     * @return
     */
    @Override
    public float ingresos() {
        return salarioHora*horas;
    }
}
