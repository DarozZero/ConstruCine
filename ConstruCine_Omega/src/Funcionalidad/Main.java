package Funcionalidad;

import Interfaces.Ticket;
import ModeloLogin.Sistema;
import java.io.IOException;


public class Main {

    
    public static void main(String[] args) throws IOException {
        System.out.println("Hola soy la clase principal!, un saludo :3");
       //pruebas del gestor archivos 
     ProcesadorPeliculas pelis = new ProcesadorPeliculas("peliculas.txt");
     pelis.procesar();
     pelis.imprimir();
     ProcesadorSalas salas = new ProcesadorSalas("salas.txt");
     salas.procesar();
     salas.imprimir();
     //////////////////////////////////////////////////////////////////////////////////////////////
     //Inicio del sistema//
     Sistema sistema = new Sistema();
     //Ticket n = new Ticket();
    }
    
}
