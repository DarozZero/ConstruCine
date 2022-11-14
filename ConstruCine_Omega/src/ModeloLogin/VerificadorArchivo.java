/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloLogin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author studi
 */
public class VerificadorArchivo {
    
    public boolean verificarExistenciaArchivo(String ruta, String nombre){
        boolean valor = false;
        
        String rutaCompleta = ruta+nombre;
        File file = new File(rutaCompleta);
        
        if(file.exists()){
            return valor=true;
        }
        return valor;
    }
    
    public boolean validarEstructuraArchivo(String ruta, String nombre, String separador){
        File file = null;        
        do{
            try {
                String rutaCompleta = ruta+nombre;
                file = new File(rutaCompleta);
                FileReader fr = new FileReader(file);
                try (BufferedReader br = new BufferedReader(fr)) {
                    String line;
                    String[] tempArr;
                    
                    while ((line = br.readLine()) != null) {
                        tempArr = line.split(separador);
                        System.out.println();
                        if(tempArr.length!=2){
                            JOptionPane.showMessageDialog(null, "NO TIENE LAS COLUMNAS ESPERADAS\nCOLUMNAS ESPERADAS:2"
                                   + "\nCOLUMNAS:"+tempArr.length,"ALERTA",JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                        }
                       
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(VerificadorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }while(!file.exists());  
        return true;   
    }
    
    public ArrayList<String[]> obtenerContenido(String ruta, String nombre) throws IOException{
        ArrayList<String[]> contenido = new ArrayList<>();
        File file = new File(ruta, nombre);
        String line;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                String valores[] = line.split(",");
                contenido.add(valores);
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(VerificadorArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contenido;
    }  
     
}
    
