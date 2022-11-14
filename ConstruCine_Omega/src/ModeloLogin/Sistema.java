/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloLogin;

import Interfaces.Login;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author studi
 */
public final class Sistema {
    private final String nombre = "usuario1.txt";
    private final String ruta = "Recursos" + File.separator; //separador dependiendo del SO
    private final String separador = ",";
    
    public Sistema() throws IOException{
        boolean archivoExiste = verificarArchivoUsuario();  
        if(archivoExiste==true){
            mostrarInterfazUsuario();
            
        }else{
            alertaArchivoUsuarioNoExiste();
        }
    }
    
    public boolean verificarArchivoUsuario() throws IOException {
        VerificadorArchivo verificador = new VerificadorArchivo();
        
        boolean archivoExisteValor = verificador.verificarExistenciaArchivo(ruta, nombre);
        if(archivoExisteValor==true){
            verificador.validarEstructuraArchivo(ruta, nombre, separador);
        }
        return archivoExisteValor;
    }
    
    private void mostrarInterfazUsuario() throws IOException{
        VerificadorArchivo verificador = new VerificadorArchivo();
        AdministradorUsuarios admin = new AdministradorUsuarios(verificador.obtenerContenido(ruta,nombre));
        Login login = new Login(admin);
        login.setVisible(true);     //checar source login
    }
    
    private void alertaArchivoUsuarioNoExiste(){
        JOptionPane.showMessageDialog(null,"PARECE SER QUE EL ARCHIVO NO EXISTE\nO SE ENCUENTRA EN OTRA RUTA\n"
                + "Ruta=> "+ruta+nombre, "ERROR",JOptionPane.ERROR_MESSAGE);
    }
    
}
