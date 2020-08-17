package repository;

import java.util.List;
import archivo.Archivo;
import commit.Commit;
import repozone.RepoZone;
import workingzone.WorkingZone;

public class Repository implements RepositoryInterface{

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
            System.out.println("no hay archivos para agregar \n");
            return;
        }
        this.indexZone.add( workingFiles );
        this.workingDirectory.clearZone();
    }

    @Override
    public void gitCommit(String message) {
        if(this.workingDirectory.getFilesZone().size() > 0){
            System.out.println("hay cambios no confirmados !");
            return;
        }
        List <Archivo> indexFiles = this.indexZone.getFilesZone();
        if(indexFiles.size() == 0){
            System.out.println("no hay cambios para crear un commit");
            return;
        }
        Commit newCommit = new Commit(message, indexFiles);
        this.localRepo.add(newCommit);
        this.indexZone.clearZone();
    }

    @Override
    public void gitPush() {        
        //revisar si remote esta vacia
        List <Commit> remoteCommits = this.remoteRepo.getCommits();
        List <Commit> localCommits = this.localRepo.getCommits();
        if(localCommits.size() == 0){
            System.out.println("Noy hay cambios locales para subir a remoto");
            return;
        }
        if(remoteCommits.size() == 0){
            this.remoteRepo.add(localCommits);
        }else{
            Commit lastLocal = localCommits.get(localCommits.size() - 1);
            Commit lastRemote = remoteCommits.get(remoteCommits.size() -1);
            // comparar los hash de tiempo
            if(lastLocal.getHash() > lastRemote.getHash()){
                this.remoteRepo.clearZone();
                this.remoteRepo.add(this.localRepo.getCommits());
            }else{
                System.out.println("Remoto mas avanzado que local");
            }
        }

    }

    public void gitPull() {
        List <Commit> remoteCommits = this.remoteRepo.getCommits();
        List <Commit> localCommits = this.localRepo.getCommits();
        if(remoteCommits.size() == 0){
            System.out.println("No hay cambios remotos para traer ");
            return;
        }
        if(localCommits.size() == 0){
            this.localRepo.add(remoteCommits);
        }else{
            Commit lastLocal = localCommits.get(localCommits.size() - 1);
            Commit lastRemote = remoteCommits.get(remoteCommits.size() -1);
            if(lastRemote.getHash() >= lastLocal.getHash()){
                this.localRepo.clearZone();
                this.localRepo.add(remoteCommits);
            }else{
                System.out.println("local mas avanzado que remoto");
            }
        }
    }

    @Override
    public void gitStatus() {
        // tes para revisar estado de working directory
        List<Archivo> workinfiles = this.workingDirectory.getFilesZone();
        System.out.println("----workingDirectory files----");
        for(int i = 0; i < workinfiles.size() ;i++){
            System.out.println(workinfiles.get(i).nombre);
        }
        System.out.println("\n");
        System.out.println("----Index files----");
        List<Archivo> indexfiles = this.indexZone.getFilesZone();
        for(int i = 0; i < indexfiles.size() ;i++){
            System.out.println(indexfiles.get(i).nombre);
        }
        System.out.println("\n");
        System.out.println("----LocalRepository----");
        List<Commit> local = this.localRepo.getCommits();
        for(int i = 0; i < local.size() ;i++){
            System.out.println(local.get(i).message);
        }
        System.out.println("\n");
        System.out.println("----RemoteRepository----");
        List<Commit> remote = this.remoteRepo.getCommits();
        for(int i = 0; i < remote.size() ;i++){
            System.out.println(remote.get(i).message);
        }
        System.out.println("----end----");
        System.out.println("\n");
    }
    @Override
    public void addFileToworkingDirectory(Archivo file){
        this.workingDirectory.add(file);
    }
}