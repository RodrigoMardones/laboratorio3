package main;

import java.util.Scanner;
import archivo.Archivo;
import repository.Repository;

/**
 *
 * @author rodrigomardones
 */
public class Main {


    public static void main(final String[] args) {

        Repository git = new Repository();
        do {
            System.out.println("### SIMULADOR DE GIT ###");
            System.out.println("Escoja su opcion: ");
            System.out.println("1. add");
            System.out.println("2. commit");
            System.out.println("3. pull");
            System.out.println("4. push");
            System.out.println("5. status");
            System.out.println("6. crear archivo");
            System.out.println("0. salir");
            Scanner val = new Scanner(System.in);
            int option = val.nextInt();
            
            switch(option){
                case 1:
                    
                    git.gitAdd(); 
                    break;
                
                case 2:
                    System.out.println("ingrese un mensaje para su commit : ");
                    Scanner in = new Scanner(System.in);
                    String msg = in.nextLine();
                    git.gitCommit(msg);
                    break;
                
                case 5:
                    git.gitStatus();
                    break;

                case 6:
                    System.out.println("ingrese nombre de archivo: ");
                    Scanner in2 = new Scanner(System.in);
                    String name = in2.nextLine();
                    System.out.println("ingrese datos de archivo: ");
                    String data = in2.nextLine();
                    git.addFileToworkingDirectory(new Archivo(name,data));
                    break;
                     
                case 0:
                    return;

                default:
                    System.out.println("opcion no implementada");
                    break;
            }
        } while (true);
    }

}
