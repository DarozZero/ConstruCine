
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
        File document = new File(direccion);
        try {
            getInfoDelArchivo(new Scanner(document));
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el archivo");
        }
    }
    
    private void getInfoDelArchivo(Scanner unprocessedInfo){
         this.informacionNoProcesada= new ArrayList<String>();
         while(unprocessedInfo.hasNextLine()){
            informacionNoProcesada.add(unprocessedInfo.nextLine());
         }
    }
    public ArrayList<String> getInformacionNoProcesada() {
        return informacionNoProcesada;
    }
    
    }
