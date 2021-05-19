/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import modelo.DniException;
import modelo.Empleado;
import modelo.EmpleadoEventual;
import modelo.EmpleadoFijo;

/**
 *
 * @author daw1
 */
public class EmpleadoCsv implements EmpleadoDao{
    private Path path;

    public EmpleadoCsv(String path) {
        this.path=Paths.get(path);
    }
    
    @Override
    public List<Empleado> listar() throws DaoException, DniException {
        List<Empleado> lista=new ArrayList<>();
        Empleado empleado=null;
        String linea=null;
        String[] tokens;
        try(BufferedReader lector=Files.newBufferedReader(path)){
            linea=lector.readLine();
            while(linea!=null){
                tokens=linea.split(",");
                switch(tokens[0]){
                    case "EmpleadoFijo":
                        empleado=new EmpleadoFijo(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
                        break;
                    case "EmpleadoEventual":
                        empleado=new EmpleadoEventual(tokens[1], tokens[2], Float.parseFloat(tokens[3]), Integer.parseInt(tokens[4]));
                        break;
                    default:
                        throw new DaoException("Formato de archivo incorrecto");
                }
                lista.add(empleado);
                linea=lector.readLine();
            }
        }catch(NoSuchFileException nsfe){
            throw new DaoException("Fichero incorrecto, no existe");
        }catch(NumberFormatException | ArrayIndexOutOfBoundsException ex){
            throw new DaoException("Formato de archivo incorrecto: "+ex.getMessage());
        }catch(IOException ioe){
            throw new DaoException(ioe.getMessage());
        }
        
        return lista;
    }

    @Override
    public int insertar(List<Empleado> listado) throws DaoException {
        
        int num=0;
        try(BufferedWriter escritor=Files.newBufferedWriter(path)){
            for(Empleado empleado: listado){
                escritor.write(empleado.getClass().getSimpleName()+","+empleado.toString());
                escritor.newLine();
                num++;
            }
        } catch (IOException ex) {
            throw new DaoException(ex.toString());
        }
        return num;
    }
    
}
