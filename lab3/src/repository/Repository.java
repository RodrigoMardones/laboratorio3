package repository;

import java.util.List;
import archivo.Archivo;
import repozone.RepoZone;
import workingzone.WorkingZone;

public class Repository implements IRepository {

    String repoName;
    WorkingZone workingDirectory;
    WorkingZone indexZone;
    RepoZone localRepo;
    RepoZone remoteRepo;
    
    
    public Repository(){
        this.workingDirectory = new WorkingZone();
        this.indexZone = new WorkingZone();
        this.localRepo = new RepoZone();
        this.remoteRepo = new RepoZone();
    }

    public void gitInit(String newRepoName) {
        this.repoName = newRepoName;
        
    }

    @Override
    public void gitAdd() {
        // TODO Auto-generated method stub

    }

    @Override
    public void gitCommit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void gitPush() {
        // TODO Auto-generated method stub

    }

    @Override
    public void gitPull() {
        // TODO Auto-generated method stub

    }

    @Override
    public void gitStatus() {
        // tes para revisar estado de working directory
        List<Archivo> workinfiles = this.workingDirectory.getFilesZone();
        for(int i = 0; i < workinfiles.size() ;i++){
            System.out.println(workinfiles.get(i).nombre);
        }
    }
    @Override
    public void addFileToworkingDirectory(Archivo file){
        this.workingDirectory.addFile(file);
    }
}