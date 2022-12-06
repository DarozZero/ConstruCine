package Funcionalidad;

import ModeloLogin.Sistema;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    
    public static void main(String[] args){
        try {
            Sistema sistema = new Sistema();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
