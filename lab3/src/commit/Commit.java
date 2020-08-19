package commit;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import archivo.Archivo;

public class Commit implements CommitInterface {
    public String message;
    public Date created;
    List<Archivo> files;
    private long hash;

    /**
     * 
     * @param newMessage mensaje para la creacion del commit
     * @param newFiles lista de archivos que se agregaran al commit
     * @return instancia de Commit
     */
    public Commit(String newMessage, List<Archivo> newFiles) {
        this.message = newMessage;
        this.created = new Date();
        this.files = new ArrayList<Archivo>(newFiles);
        this.hash = Instant.now().getEpochSecond();
    }
    /**
     * 
     * @param void
     * @return long hash creado por commit
     */
    public long getHash(){
        return this.hash;
    }
    /**
     * 
     * 
     * @param void
     * @return String que representa la info de un commit
     */
    public String commitInfo(){
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateToString = formatter.format(this.created);
        return message + ": creado el " + dateToString;
    }
}