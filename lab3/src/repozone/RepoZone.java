package repozone;

import java.util.List;
import java.util.ArrayList;
import commit.Commit;

public class RepoZone implements RepoZoneInterface {

    private List<Commit> repo;

    public RepoZone(){
        this.repo = new ArrayList<Commit>();
    }
    public void add(Commit c){
        this.repo.add(c);
    }
    public void add(List<Commit> commits){
        this.repo.addAll(commits);
    }
    public List<Commit> getCommits(){
        return this.repo;
    }

}