package archivo;

import java.util.Date;
/**
 * 
 * clase de representacion de Archivo dentro de la emulacion
 * 
 */
public class Archivo implements ArchivoInterface{
    public String nombre;
    String contenido;
    Date fecha;
    /**
     * Constructor del Archivi
     * @param nombre : nombre del archivo
     * @param contenido: contenido del archivo
     * @return instancia de Archivo
     */
    public Archivo(String nombre, String contenido){
        this.nombre = nombre;
        this.contenido = contenido;
        this.fecha = new Date();
    }

    /**
     * 
     * @param content setea nuevo contenido dentro de un archivo
     * @return void
     */
    public void setContenido(String content) {
        this.contenido = content;
    }

    /**
     * 
     * @param void
     * @return String contenido
     */
    public String getContenido() {
        return this.contenido;
    }

    /**
     * 
     * @param Date setea fecha para la modificion de un archivo
     * @return void
     */
    public void setFecha(Date newDate) {
        this.fecha = newDate;
    }

    /**
     * 
     * @param void
     * @return Date fecha creacion archivo
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * 
     * @param void
     * @return String nombre del archivo
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * 
     * @param name nombre del archivo para su modificacion
     * @return void
     */
    public void setNombre(String name) {
        this.nombre = name;
    }
}