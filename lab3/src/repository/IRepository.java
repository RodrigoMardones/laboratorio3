package repository;

import java.util.ArrayList;
import java.util.List;
import commit.Commit;


public interface IRepository {
    String nombreRepo = "";
    List<Commit> repo = new ArrayList<Commit>();
}