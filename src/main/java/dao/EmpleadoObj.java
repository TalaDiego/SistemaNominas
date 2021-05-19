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

/**
 *
 * @author daw1
 */
public class EmpleadoObj implements EmpleadoDao{
    private Path path;

    public EmpleadoObj(String path) {
        this.path =Paths.get(path);
    }

    @Override
    public List<Empleado> listar() throws DaoException, DniException {
        List<Empleado> lista=new ArrayList<>();
        Empleado empleado=null;
        try(InputStream is=Files.newInputStream(path);
            ObjectInputStream lector=new ObjectInputStream(is)){
            while(is.available() > 0){
                empleado=(Empleado)lector.readObject();
                lista.add(empleado);
            }
        } catch(NoSuchFileException nsfe){
            throw new DaoException("Fichero incorrecto, no existe");
        }catch (IOException ex) {
            throw new DaoException(ex.toString());
        } catch (ClassNotFoundException ex) {
            throw new DaoException("Error en la clase");
        }
        return lista;
    }

    @Override
    public int insertar(List<Empleado> listado) throws DaoException {
        int n=0;
        try(ObjectOutputStream escritor=new ObjectOutputStream(Files.newOutputStream(path))){
            for(Empleado empleado: listado){
                escritor.writeObject(empleado);
                n++;
            }
        } catch (IOException ex) {
            throw new DaoException(ex.toString());
        }
        return n;
    }
}
