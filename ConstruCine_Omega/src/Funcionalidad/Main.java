package Funcionalidad;

import Interfaces.Cartelera;
import Interfaces.Ticket;
import ModeloLogin.Sistema;
import java.io.IOException;


public class Main {

    
    public static void main(String[] args) throws IOException {
     //////////////////////////////////////////////////////////////////////////////////////////////
     //Inicio del sistema//
    // Sistema sistema = new Sistema();
     //Ticket n = new Ticket();
     Cartelera cartelera = new Cartelera();
     cartelera.setVisible(true);
    }
    
}
