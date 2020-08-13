package workingzone;

import java.util.ArrayList;
import java.util.List;
import archivo.Archivo;

public class WorkingZone implements IWorkingZone {
    private List<Archivo> files;
    
    public WorkingZone(){
        this.files = new ArrayList<Archivo>();
    }
    
    public void add(Archivo file){
        this.files.add(file);
    }
    public void add(List<Archivo> files){
        this.files.addAll(files);
    }

    public List<Archivo> getFilesZone(){
        return this.files;
    }
    public void clearZone(){
        this.files.clear();
    }



}