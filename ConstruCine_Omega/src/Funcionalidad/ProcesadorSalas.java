
package Funcionalidad;

import java.util.ArrayList;

/**
 *
 * @author daroz
 */
public class ProcesadorSalas extends Procesador{
    private ArrayList<String[]> infoOrdenada;
     public ProcesadorSalas(String direccion) {
        setArchivo(direccion);
    }

    public ArrayList<String[]> getInfoOrdenada() {
        return infoOrdenada;
    }
    
    @Override
    public void procesar() {
       ArrayList<String> noProcesada = getArchivo().getInformacionNoProcesada();
       infoOrdenada = new ArrayList<String[]>();
       for(int i=0; i<noProcesada.size();i++){
           String sala = noProcesada.get(i);
           String[] datosSeparados = sala.split("/");
           infoOrdenada.add(datosSeparados);
       }   
    }
    @Override
    public void imprimir() {
        for(int i=0;i<infoOrdenada.size();i++){
            System.out.println("Numero de sala: " + infoOrdenada.get(i)[0] + "\nHorario: " 
                    + infoOrdenada.get(i)[1] + "\nNumero Pelicula: " +infoOrdenada.get(i)[2]
                    + "\n\n");
        }
    }   
}
