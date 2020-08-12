package repository;

import workingzone.WorkingZone;
import repozone.RepoZone;

public interface IRepository {
    String reponame = "";
    // working directory
    WorkingZone workingDirectory = new WorkingZone();
    WorkingZone indexZone = new WorkingZone();
    RepoZone LocalRepo = new RepoZone("master");
    RepoZone RemoteRepo = new RepoZone("master");

    void gitInit(String repoName);
    void gitAdd();
    void gitCommit();
    void gitPush();
    void gitPull();
    void gitStatus();
}