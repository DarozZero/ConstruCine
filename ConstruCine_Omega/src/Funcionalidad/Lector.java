/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author daroz
 */
public class Lector {
   private ArrayList<String> informacionNoProcesada;
    

    public Lector(String direccion) {
        File document;
        document = new File(direccion);
        try {
            Scanner unprocessedInfo = new Scanner(document);
            getInfo(unprocessedInfo);
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el archivo");
        }
    }
    
    private void getInfo(Scanner unprocessedInfo){
         this.informacionNoProcesada= new ArrayList<String>();
         while(unprocessedInfo.hasNextLine()){
            informacionNoProcesada.add(unprocessedInfo.nextLine());
         }
    }
    
    
     /*public void imprimirInfo(){//prueba de la informacion no procesada
     while (unprocessedInfo.hasNextLine())
            System.out.println(unprocessedInfo.nextLine());
        }*/

    public ArrayList<String> getInformacionNoProcesada() {
        return informacionNoProcesada;
    }
    
    }
