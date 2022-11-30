/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloLogin;

import Interfaces.Cartelera;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author studi
 */
public class AdministradorUsuarios {
    private ArrayList<Usuario> usuarios;
    
    public AdministradorUsuarios(ArrayList<String[]> contenido) {
        usuarios = new ArrayList<>();
        contenido.stream().map((array) -> {
            Usuario usuario = new Usuario();
            usuario.setUsuario(array[0]);
            usuario.setContraseña(array[1]);
            return usuario;
        }).forEach((usuario) -> {
            usuarios.add(usuario);
        });
    }
    
    public boolean verificarUsuario(String usuarioIngresado, String contraseñaIngresada) { 
        boolean usuarioVerificado = true;
        Usuario usuario = obtenerUsuario(usuarioIngresado);
        if (!verificarContraseña(usuario, contraseñaIngresada)){ 
            usuarioVerificado = false;
            alertaContraseñaIncorrecta();
        }else{ 
            alertaContraseñaCorrecta();
            Cartelera cartelera = new Cartelera();
            cartelera.setVisible(true);
           
        }
       
        return usuarioVerificado;
    }

    private Usuario obtenerUsuario(String usuarioIngresado) {
        boolean valor = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(usuarioIngresado)) {
                return usuario;
            }else{
                valor = true;
            }  
        }
        if(valor==true){
            JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO","ERROR" ,JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private boolean verificarContraseña(Usuario usuario, String contraseña) {
        String contraseñaDesencriptada;
        boolean igual; 
        Encriptador desencriptador = new Encriptador();
        contraseñaDesencriptada = desencriptador.Desencriptar(usuario.getContraseña());
        igual = contraseñaDesencriptada.equals(contraseña);
        return igual;
    }

    private void alertaContraseñaIncorrecta(){
        JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA","ALERTA", JOptionPane.WARNING_MESSAGE);
    }
    
    private void alertaContraseñaCorrecta(){
        JOptionPane.showMessageDialog(null, "CONTRASEÑA CORRECTA","ENHORABUENA", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
    

