package repozone;

import java.util.ArrayList;
import java.util.List;
import commit.Commit;


public interface RepoZoneInterface {

    List<Commit> repo = new ArrayList<Commit>();

    List <Commit> getCommits();
    void add(Commit commit);
    void add(List<Commit> commits);
    void clearZone();
}