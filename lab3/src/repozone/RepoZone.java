package repozone;

import java.util.List;
import java.util.ArrayList;
import commit.Commit;

public class RepoZone implements IRepoZone {

    public List<Commit> repo;

    public RepoZone(){
        this.repo = new ArrayList<Commit>();
    }

}