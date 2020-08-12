package repozone;

import java.util.ArrayList;
import java.util.List;
import commit.Commit;


public interface IRepoZone {
    String nombreRepo = "";
    List<Commit> repo = new ArrayList<Commit>();
}