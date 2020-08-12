package repository;

import java.util.List;
import java.util.ArrayList;
import commit.Commit;

public class Repository implements IRepository {
    public String nameRepo;
    public List<Commit> repo;

    Repository(String newNameRepo){
        this.nameRepo = newNameRepo;
        this.repo = new ArrayList<Commit>();
    }

}