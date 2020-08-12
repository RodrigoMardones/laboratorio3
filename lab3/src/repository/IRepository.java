package repository;

import workingzone.WorkingZone;
import archivo.Archivo;
import repozone.RepoZone;

public interface IRepository {
    String repoName = "";
    // working directory
    WorkingZone workingDirectory = new WorkingZone();
    WorkingZone indexZone = new WorkingZone();
    RepoZone LocalRepo = new RepoZone();
    RepoZone RemoteRepo = new RepoZone();

    void gitInit(String repoName);
    void gitAdd();
    void gitCommit();
    void gitPush();
    void gitPull();
    void gitStatus();
    void addFileToworkingDirectory(Archivo file);
}