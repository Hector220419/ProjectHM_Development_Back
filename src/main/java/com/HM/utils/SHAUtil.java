package com.HM.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class SHAUtil {
    public static String salt="palabraSecreta";
    public static String createHash(String value) {
        String res = value+salt;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(res.getBytes());
            byte[] resultado = md.digest();
            int max = resultado.length;
            String tmp;
            res ="";
            for (int i=0; i<max; i++) {
                tmp = Integer.toHexString(0xFF & resultado[i]);
                res += (tmp.length()<2)?0+tmp:tmp;
            }// for i
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }//catch
        return res;
    }//crateHash


    //Metodo para verificar el Hash (string original, string ingresado)
    public static boolean verifyHash(String original, String hash) {
        String res = createHash(original);
        return res.equalsIgnoreCase(hash);
    }//verifyHash

    //verifyHash: Toma una cadena “original” y un hash (cadena cifrada) y devuelve verdadero si el hash del valor original
    //es igual al hash proporcionado. Este método utiliza el método “createHash” para generar el hash del valor original y lo comparar con el hash proporcionado.


    //Metodo para crear la contrasena con hash con una contrasena de texto plano
    public static boolean verifyPasswd(String original, String newPasswd) {
        return createHash(original).equalsIgnoreCase(createHash(newPasswd));
    }//verifyPasswd

    //verifyPasswd: Toma una contraseña de texto plano “original” y una nueva contraseña “newPasswd” y
    //devuelve verdadero si el hash de ambas contraseñas es igual. Este método utiliza el método “createHash” para generar el hash de ambas contraseñas y las compara.

}