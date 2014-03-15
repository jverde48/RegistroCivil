package mx.gob.renapo.registrocivil.util;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: Green4
 * Date: 6/03/14
 * Time: 07:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hasher {
    private static Logger log = Logger.getLogger(Hasher.class);

    /**
     * Convierte un arreglo de bytes a String usando valores hexadecimales
     * @param digest - Arreglo de bytes a convertir
     * @return - String creado a partir de <code>digest</code>
     */
    private static String toHexadecimal(byte[] digest){
        String hash = "";
        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }

        log.info("Digesto de informacion: " + hash);
        return hash;
    }

    /**
     * Encripta la informacion de la cadena mediante algoritmo de encriptacion que se especifica.
     * @param cadena - Informacion a encriptar
     * @param algorithm - Algoritmo de encriptacion, puede ser: MD2, MD5, SHA-1, SHA-256, SHA-384, SHA-512
     * @return - Devuelve un hash dependiendo del algoritmo de encripcion
     */
    public static String getHashDigest(String cadena,
                String algorithm) throws NoSuchAlgorithmException {
        byte[] digest = null;
        byte[] buffer = cadena.getBytes();

        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.reset();
        messageDigest.update(buffer);
        digest = messageDigest.digest();

        return toHexadecimal(digest);
    }
}
