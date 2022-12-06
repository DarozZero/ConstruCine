/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author daroz
 */
public class ProcesadorLugares extends Procesador{
    private ArrayList<String[]> infoOrdenada ;
    private final String rutaContenedora = "Recursos"+File.separator+"Salas";
    private String carpetaConsulta;
    private String consulta;
    private String endConsulta;

    public ProcesadorLugares(String consulta) {
        this.consulta=consulta;
        LocalDate date = LocalDate.now();
        this.carpetaConsulta = rutaContenedora+File.separator+date;
        verificaCreaCarpeta(rutaContenedora);
        verificaCreaCarpeta(carpetaConsulta);
    }

    public void setCarpetaConsulta(String carpetaConsulta) {
        this.carpetaConsulta = carpetaConsulta;
    }

    public ArrayList<String[]> getInfoOrdenada() {
        return infoOrdenada;
    }
    
    
    @Override
    public void procesar() {
        verificaCreaDocumento(carpetaConsulta +File.separator+ consulta);
        setArchivo(carpetaConsulta +File.separator+ consulta);
        
         ArrayList<String> noProcesada = getArchivo().getInformacionNoProcesada();
             infoOrdenada = new ArrayList<>();
             for(int i=0; i<noProcesada.size();i++){
                String pelicula = noProcesada.get(i);
                String[] datosSeparados = pelicula.split(",");
                infoOrdenada.add(datosSeparados);
       }
        
    }

    @Override
    public void imprimir() {
         for(int i=0;i<infoOrdenada.size();i++){
             for(int j=0;j<10;j++){
                System.out.print(infoOrdenada.get(i)[j] + " "); 
             }
             System.out.println("");
         }
    }
    
    private void verificaCreaCarpeta(String route){
         File carpeta = new File(route);
         if(carpeta.exists()){
             System.out.println("existe carpeta");
         }else{
             System.out.println("creando carpeta");
             carpeta.mkdir();
         }
    }
    private void verificaCreaDocumento(String ruta){
        File texto = new File(ruta);
        if(texto.exists()){
            System.out.println("existe archivo");
        }else{
            try{
            texto.createNewFile();
            escribirTexto(texto);
            System.out.println("Creando Archivo texto");
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, "Error al crear archivo:" + ex.getMessage() );
            }
        }
    }
    
    private void escribirTexto(File file){   
        try {
            FileWriter escritor = new FileWriter(file);
            escritor.write("L,L,L,L,L,L,L,L,L,L");
            for(int i=0; i<5;i++){
                escritor.append("\nL,L,L,L,L,L,L,L,L,L");
            }
            escritor.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al escribir texto" + ex.getMessage());
        }
    }
    
    public void editarTexto(ArrayList<String[]> lista){
       File archivoEditor= new File(carpetaConsulta +File.separator+ consulta);
        try {
            FileWriter escritor = new FileWriter(archivoEditor);
            escritor.write("");
            for(int i=0; i<lista.size();i++){
                for(int j=0; j<lista.get(i).length;j++){
                    if("O".equals(lista.get(i)[j]))
                    escritor.append("R");
                    else
                       escritor.append(lista.get(i)[j]); 
                    if(j!=lista.get(i).length-1) escritor.append(",");
                }
                  if(i!=lista.size()-1)escritor.append("\n");
            }
            escritor.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al escribir: "+ ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        ProcesadorLugares prueba = new ProcesadorLugares("Sala1,10:00.txt");
        prueba.procesar();
        prueba.imprimir();
    }
    
}
