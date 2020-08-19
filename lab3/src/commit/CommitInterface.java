package commit;

import java.util.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import archivo.Archivo;

public interface CommitInterface {
    String message = "";
    Date created = new Date();
    List<Archivo> files = new ArrayList<Archivo>();
    Long hash = Instant.now().getEpochSecond();

    long getHash();
    String commitInfo();
}