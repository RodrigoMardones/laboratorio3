package repozone;

import java.util.List;
import java.util.ArrayList;
import commit.Commit;

public class RepoZone implements IRepoZone {
    public String nameRepo;
    public List<Commit> repo;

    RepoZone(String newNameRepo){
        this.nameRepo = newNameRepo;
        this.repo = new ArrayList<Commit>();
    }

}