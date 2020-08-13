package repository;

import java.util.List;
import archivo.Archivo;
import commit.Commit;
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
        List<Archivo> workingFiles = this.workingDirectory.getFilesZone();
        if(workingFiles.size() == 0){
            System.out.println("no hay archivos para agregar");
            return;
        }
        this.indexZone.add( workingFiles );
        this.workingDirectory.clearZone();
    }

    @Override
    public void gitCommit(String message) {

        List <Archivo> indexFiles = this.indexZone.getFilesZone();
        if(indexFiles.size() == 0){
            System.out.println("no hay cambios para crear un commit");
            return;
        }
        Commit newCommit = new Commit(message, this.indexZone.getFilesZone());
        this.localRepo.add(newCommit);
        this.indexZone.clearZone();
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
        System.out.println("----workingDirectory files----");
        for(int i = 0; i < workinfiles.size() ;i++){
            System.out.println(workinfiles.get(i).nombre);
        }
        System.out.println("----Index files----");
        List<Archivo> indexfiles = this.indexZone.getFilesZone();
        for(int i = 0; i < indexfiles.size() ;i++){
            System.out.println(indexfiles.get(i).nombre);
        }
        System.out.println("----LocalRepository----");
        List<Commit> local = this.localRepo.getCommits();
        for(int i = 0; i < local.size() ;i++){
            System.out.println(local.get(i).message);
        }
        System.out.println("----end----");
    }
    @Override
    public void addFileToworkingDirectory(Archivo file){
        this.workingDirectory.add(file);
    }
}