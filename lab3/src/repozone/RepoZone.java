package repozone;

import java.util.List;
import java.util.ArrayList;
import commit.Commit;

public class RepoZone implements RepoZoneInterface {

    private List<Commit> repo;

    public RepoZone(){
        this.repo = new ArrayList<Commit>();
    }
    public void add(Commit commit){
        this.repo.add(commit);
    }
    public void add(List<Commit> commits){
        this.repo.addAll(commits);
    }
    public List<Commit> getCommits(){
        return this.repo;
    }
    public void clearZone(){
        this.repo.clear();
    }

}