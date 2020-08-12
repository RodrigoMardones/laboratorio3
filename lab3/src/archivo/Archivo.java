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

    @Override
    public void setContenido(String content) {
        this.contenido = content;
    }

    @Override
    public String getContenido() {
        return this.contenido;
    }

    @Override
    public void setFecha(Date newDate) {
        this.fecha = newDate;
    }

    @Override
    public Date getFecha() {
        return this.fecha;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setNombre(String name) {
        this.nombre = name;
    }
}