/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Funcionalidad;


import java.util.ArrayList;
import ModeloLogin.Sistema;
import java.io.IOException;


public class Main {

    
    public static void main(String[] args) {
        System.out.println("Hola soy la clase principal!, un saludo :3");
        
     ProcesadorPeliculas pelis = new ProcesadorPeliculas("peliculas.txt");
     pelis.procesar();
     pelis.imprimir();
     ProcesadorSalas salas = new ProcesadorSalas("salas.txt");
     salas.procesar();
     salas.imprimir();
     Sistema sistema = new Sistema();
     
    }
    
}
