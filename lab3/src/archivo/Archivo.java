package archivo;

import java.util.Date;

public class Archivo implements IArchivo{
    public String nombre;
    String contenido;
    Date fecha;

    public Archivo(String nombre, String contenido){
        this.nombre = nombre;
        this.contenido = contenido;
        this.fecha = new Date();
    }


    public void setContenido(String content) {
        this.contenido = content;
    }


    public String getContenido() {
        return this.contenido;
    }


    public void setFecha(Date newDate) {
        this.fecha = newDate;
    }


    public Date getFecha() {
        return this.fecha;
    }


    public String getNombre() {
        return this.nombre;
    }


    public void setNombre(String name) {
        this.nombre = name;
    }
}