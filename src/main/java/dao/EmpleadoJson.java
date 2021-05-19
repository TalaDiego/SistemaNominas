/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import java.io.*;
import java.lang.reflect.Type;
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
public class EmpleadoJson implements EmpleadoDao{
    private Path path;

    public EmpleadoJson(String path) {
        this.path=Paths.get(path);
    }

    @Override
    public List<Empleado> listar() throws DaoException, DniException {
        List<Empleado> lista=new ArrayList<>();
        String linea=null;
        
        /*Definición del tipo para poder trabajar con colecciones*/
        Type tipo=new TypeToken<List<Empleado>>(){}.getType();
        
        //Registro de clases hijas, dado que hay herencia
        RuntimeTypeAdapterFactory<Empleado> empleadoAdapter=RuntimeTypeAdapterFactory.of(Empleado.class, "type");
        empleadoAdapter.registerSubtype(EmpleadoFijo.class, "EmpleadoFijo");
        empleadoAdapter.registerSubtype(EmpleadoEventual.class, "EmpleadoEventual");
        
        //Contrucción del creador json mediante la creación de un objeto de la clase Gson:
        GsonBuilder builder=new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(empleadoAdapter);
        Gson gson=builder.create();
        
        //Lectura del archivo;
        try(BufferedReader lector=Files.newBufferedReader(path)){
            lista=gson.fromJson(lector, tipo);
        }catch(NoSuchFileException nsfe){
            throw new DaoException("Fichero incorrecto, no existe");
        }catch(JsonParseException jse){
            throw new DaoException("Formato de archivo incorrecto");
        }catch (IOException ex) {
            throw new DaoException(ex.getMessage());
        }
        return lista;
    }

    @Override
    public int insertar(List<Empleado> listado) throws DaoException {
        /*Definición del tipo para poder trabajar con colecciones*/
        Type tipo=new TypeToken<List<Empleado>>(){}.getType();
        
        //Registro de clases hijas, dado que hay herencia
        RuntimeTypeAdapterFactory<Empleado> empleadoAdapter=RuntimeTypeAdapterFactory.of(Empleado.class, "type");
        empleadoAdapter.registerSubtype(EmpleadoFijo.class, "EmpleadoFijo");
        empleadoAdapter.registerSubtype(EmpleadoEventual.class, "EmpleadoEventual");
        
        //Contrucción del creador json mediante la creación de un objeto de la clase Gson:
        GsonBuilder builder=new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(empleadoAdapter);
        Gson gson=builder.create();
        
        //Escritura del archivo;
        int n=listado.size();
        try(BufferedWriter escritor = Files.newBufferedWriter(path)){
            gson.toJson(listado, tipo, escritor);
        } catch (IOException ex) {
            throw new DaoException(ex.getMessage());
        }
        
        return n;
    }
    
    
}
