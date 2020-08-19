package repository;

import java.util.List;
import archivo.Archivo;
import commit.Commit;
import repozone.RepoZone;
import workingzone.WorkingZone;

public class Repository implements RepositoryInterface{

    String repoName;
    private WorkingZone workingDirectory;
    private WorkingZone indexZone;
    private RepoZone localRepo;
    private RepoZone remoteRepo;
    
    /**
     * @param void
     * @return intancia de repositorio
     */
    public Repository(){
        this.workingDirectory = new WorkingZone();
        this.indexZone = new WorkingZone();
        this.localRepo = new RepoZone();
        this.remoteRepo = new RepoZone();
    }
    /**
     * @param newRepoName nombre del repo para inicializar
     *
     */
    public void gitInit(String newRepoName) {
        this.repoName = newRepoName;
    }

    /**
     * 
     * @param void
     * @return void, pasa los archivos del working directory al index
     */
    public void gitAdd() {
        List<Archivo> workingFiles = this.workingDirectory.getFilesZone();
        if(workingFiles.size() == 0){
            System.out.println("no hay archivos para agregar \n");
            return;
        }
        this.indexZone.add( workingFiles );
        this.workingDirectory.clearZone();
    }

    /**
     * @param message recibe un mensaje para crear un commit y agregarlo Local Repository
     * @return void
     */
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

    /**
     * 
     * @param void
     * @return void, pasa los commits actualizados de local repository al remote repository
     * 
     */
    public void gitPush() {        
        //revisar si remote esta vacia
        List <Commit> remoteCommits = this.remoteRepo.getCommits();
        List <Commit> localCommits = this.localRepo.getCommits();
        if(localCommits.size() == 0){
            System.out.println("Noy hay cambios locales para subir a remoto \n");
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
                System.out.println("Push realizado con exito ! \n");
            }else{
                System.out.println("Remoto mas avanzado que local \n");
            }
        }

    }
    /**
     * 
     * @param void
     * @return void, trae los cambios del remote repository al local repository
     */
    public void gitPull() {
        List <Commit> remoteCommits = this.remoteRepo.getCommits();
        List <Commit> localCommits = this.localRepo.getCommits();
        if(remoteCommits.size() == 0){
            System.out.println("No hay cambios remotos para traer \n");
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
                System.out.println("Pull realizado con exito ! \n");
            }else{
                System.out.println("local mas avanzado que remoto \n");
            }
        }
    }
    /**
     * 
     * @param void
     * @return void, despliega en pantalla el estatus de todas las zonas de trabajo
     * 
     */
    public void gitStatus() {
        // tes para revisar estado de working directory
        System.out.println("----workingDirectory files----");
        
        List<Archivo> workinfiles = this.workingDirectory.getFilesZone();
        System.out.println("cantidad de Archivos en Index: " + workinfiles.size());
        for(int i = 0; i < workinfiles.size() ;i++){
            System.out.println(workinfiles.get(i).nombre);
        }
        System.out.println("\n");
        System.out.println("----Index files----\n");
        List<Archivo> indexfiles = this.indexZone.getFilesZone();
        System.out.println("cantidad de Archivos en Index: " + indexfiles.size());
        for(int i = 0; i < indexfiles.size() ;i++){
            System.out.println(indexfiles.get(i).nombre);
        }
        System.out.println("\n");
        System.out.println("----LocalRepository----\n");
        List<Commit> local = this.localRepo.getCommits();
        System.out.println("cantidad de commits en Local Repository: " + local.size());
        for(int i = 0; i < local.size() ;i++){
            System.out.println(local.get(i).commitInfo());
        }
        System.out.println("\n");
        System.out.println("----RemoteRepository----\n");
        List<Commit> remote = this.remoteRepo.getCommits();
        System.out.println("cantidad de commits en Remote Repository: " + remote.size());
        for(int i = 0; i < remote.size() ;i++){
            System.out.println(remote.get(i).commitInfo());
        }
        System.out.println("----end----");
        System.out.println("\n");
    }
    /**
     * 
     * 
     * @param file agrega un archivo al working directory para su trabajo dentro del area
     * @return void
     */
    public void addFileToworkingDirectory(Archivo file){
        this.workingDirectory.add(file);
    }
}