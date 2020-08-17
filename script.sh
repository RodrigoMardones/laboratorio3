#se crea directorio de distribution
mkdir dist
#se compilan las clases para el proyecto
javac -d dist lab3/src/archivo/ArchivoInterface.java lab3/src/archivo/Archivo.java lab3/src/commit/CommitInterface.java lab3/src/commit/Commit.java lab3/src/repozone/RepozoneInterface.java lab3/src/repozone/RepoZone.java lab3/src/workingzone/WorkingZoneInterface.java lab3/src/workingzone/WorkingZone.java lab3/src/repository/RepositoryInterface.java lab3/src/repository/Repository.java lab3/src/main/Main.java
#se corre indicando el main class
java -cp dist main.Main
