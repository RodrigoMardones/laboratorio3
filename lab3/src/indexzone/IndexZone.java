package indexzone;

import java.util.ArrayList;
import java.util.List;
import archivo.Archivo;

public class IndexZone implements IIndexZone {
    private List<Archivo> index;
    
    IndexZone(){
        this.index = new ArrayList<Archivo>();
    }

    void addFile(Archivo A){
        this.index.add(A);
    }

    List<Archivo> getIndexZone(){
        return this.index;
    }

    void clearZone(){
        this.index.clear();
    }



}