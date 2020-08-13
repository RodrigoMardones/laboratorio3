/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import archivo.Archivo;
import repository.Repository;

/**
 *
 * @author rodrigomardones
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Repository git = new Repository();
        Archivo a1 = new Archivo("saludo.txt", "esto es un saludo contenido dentro del archivo");
        Archivo a2 = new Archivo("saludo2.txt", "esto es un saludo contenido dentro del archivo");
        Archivo a3 = new Archivo("saludo3.txt", "esto es un saludo contenido dentro del archivo");

        git.gitInit("master");
        git.addFileToworkingDirectory(a1);
        git.addFileToworkingDirectory(a2);
        git.addFileToworkingDirectory(a3);
        
        git.gitStatus();
        git.gitAdd();

        System.out.println("\n");
        git.gitStatus();
        git.gitCommit("first Commit ! by Rodrigo Mardones");
        System.out.println("\n");
        git.gitStatus();

    }
    
}
