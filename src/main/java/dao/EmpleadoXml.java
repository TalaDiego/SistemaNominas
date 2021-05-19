/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import modelo.DniException;
import modelo.Empleado;
import modelo.EmpleadoEventual;
import modelo.EmpleadoFijo;
import org.xml.sax.SAXParseException;

/**
 *
 * @author daw1
 */
public class EmpleadoXml implements EmpleadoDao{
    private Path path;

    public EmpleadoXml(String path) {
        this.path =Paths.get(path);
    }

    @Override
    public List<Empleado> listar() throws DaoException, DniException {
        List<Empleado> lista=null;
        //Crear objeto;
        XStream xstream=new XStream(new DomDriver());
        
        //Configurar objeto;
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypeHierarchy(EmpleadoFijo.class);
        xstream.allowTypeHierarchy(EmpleadoEventual.class);
        
        try(BufferedReader lector=Files.newBufferedReader(path)){
            lista=(List<Empleado>) xstream.fromXML(lector);
        } catch(NoSuchFileException nsfe){
            throw new DaoException("Fichero incorrecto, no existe");
        }catch (IOException ex) {
            throw new DaoException(ex.getMessage());
        }
        
        return lista;
    }

    @Override
    public int insertar(List<Empleado> listado) throws DaoException {
        int n=0;
        //Crear objeto;
        XStream xstream=new XStream(new DomDriver());
        
        //Configurar objeto;
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypeHierarchy(EmpleadoFijo.class);
        xstream.allowTypeHierarchy(EmpleadoEventual.class);
        
        n=listado.size();
        try(BufferedWriter escritor=Files.newBufferedWriter(path)){
            xstream.toXML(listado, escritor);
        } catch (IOException ex) {
            throw new DaoException(ex.getMessage());
        }
        
        return n;
        
    }
    
    
}
