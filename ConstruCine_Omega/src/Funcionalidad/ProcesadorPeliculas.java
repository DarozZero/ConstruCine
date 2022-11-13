
package Funcionalidad;

import java.util.ArrayList;

/**
 *
 * @author daroz
 */
public class ProcesadorPeliculas extends Procesador {
    private ArrayList<String[]> infoOrdenada ;

    public ProcesadorPeliculas(String direccion) {
        setArchivo(direccion);
        
    }
   

    @Override
    public void procesar() {
       ArrayList<String> noProcesada = getArchivo().getInformacionNoProcesada();
       infoOrdenada = new ArrayList<String[]>();
       for(int i=0; i<noProcesada.size();i++){
           String peli = noProcesada.get(i);
           String[] datosSeparados = peli.split("/");
           infoOrdenada.add(datosSeparados);
       }
        
    }

    @Override
    public void imprimir() {
        for(int i=0;i<infoOrdenada.size();i++){
            System.out.println("Pelicula numero: " + infoOrdenada.get(i)[0] + "\nNombre: " 
                    + infoOrdenada.get(i)[1] + "\nSinopsis: " +infoOrdenada.get(i)[2]
                     + "\nIdioma :" + infoOrdenada.get(i)[3] + "\n\n");
        }
    }
    
}