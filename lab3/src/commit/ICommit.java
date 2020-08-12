package commit;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import archivo.Archivo;

public interface ICommit {
    String message = "";
    Date created = new Date();
    List<Archivo> files = new ArrayList<Archivo>();

}