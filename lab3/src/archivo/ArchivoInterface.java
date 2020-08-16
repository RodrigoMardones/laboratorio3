package archivo;
import java.util.Date;

public interface ArchivoInterface {
    // attrs
    String nombre = "";
    Date fecha = new Date();
    String contenido = "";

    //methods
    
    // accesors for Contenido
    void setContenido(String content);
    String getContenido();
    
    // accesors for Fecha
    void setFecha(Date newDate);
    Date getFecha();

    // accessors for nombre
    void setNombre(String name);
    String getNombre();
}   