package workingzone;

import java.util.ArrayList;
import java.util.List;
import archivo.Archivo;

public class WorkingZone implements WorkingZoneInterface {
    private List<Archivo> files;
    
    /**
     * @param void
     * @return intancia de WorkinZone
     */
    public WorkingZone(){
        this.files = new ArrayList<Archivo>();
    }
    /**
     * 
     * @param file archivo para agregar a la zona de trabajo
     * @return void
     */
    public void add(Archivo file){
        this.files.add(file);
    }
    /**
     * 
     * @param files archivos para agregar a la zona de trabajo
     * @return void
     */
    public void add(List<Archivo> files){
        this.files.addAll(files);
    }

    /**
     * 
     * @return lista de archivos concentrados en la zona de trabajo
     */
    public List<Archivo> getFilesZone(){
        return this.files;
    }
    /**
     * 
     * @return void, limpia la zona de trabajo 
     */
    public void clearZone(){
        this.files.clear();
    }
}