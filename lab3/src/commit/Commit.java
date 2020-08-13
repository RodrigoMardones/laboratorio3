package commit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import archivo.Archivo;

public class Commit implements ICommit {
    public String message;
    public Date created;
    List<Archivo> files;

    public Commit(String newMessage, List<Archivo> newFiles) {
        this.message = newMessage;
        this.created = new Date();
        this.files = new ArrayList<Archivo>(newFiles);
    }
}