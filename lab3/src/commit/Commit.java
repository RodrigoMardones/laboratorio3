package commit;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import archivo.Archivo;

public class Commit implements CommitInterface {
    public String message;
    public Date created;
    List<Archivo> files;
    private long hash;

    public Commit(String newMessage, List<Archivo> newFiles) {
        this.message = newMessage;
        this.created = new Date();
        this.files = new ArrayList<Archivo>(newFiles);
        this.hash = Instant.now().getEpochSecond();
    }
    public long getHash(){
        return this.hash;
    }
}