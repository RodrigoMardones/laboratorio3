package workingzone;

import java.util.ArrayList;
import java.util.List;
import archivo.Archivo;

public class WorkingZone implements IWorkingZone {
    private List<Archivo> index;
    
    public WorkingZone(){
        this.index = new ArrayList<Archivo>();
    }
    
    void addFile(Archivo file){
        this.index.add(file);
    }
    
    void addFile(List<Archivo> files){

    }

    List<Archivo> getIndexZone(){
        return this.index;
    }

    void clearZone(){
        this.index.clear();
    }



}