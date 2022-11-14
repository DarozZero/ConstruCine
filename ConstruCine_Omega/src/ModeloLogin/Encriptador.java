/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloLogin;

import java.util.Base64;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author studi
 */
public class Encriptador {
    private String llave = "MOtomamiR'0salia";
    
    private SecretKeySpec crearClave(String llave) {
        try {
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
            return secretKeySpec;
        } catch (Exception e) {
            return null;
        }
    }

    public String Desencriptar(String desencriptar) {
        try {
            SecretKeySpec secretKeySpec = crearClave(llave);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] cadena = Base64.getDecoder().decode(desencriptar);
            byte[] desencriptacioon = cipher.doFinal(cadena);
            String cadena_desencriptada = new String(desencriptacioon);
            return cadena_desencriptada;

        } catch (Exception e) {
            return "";
        }
    }
}
