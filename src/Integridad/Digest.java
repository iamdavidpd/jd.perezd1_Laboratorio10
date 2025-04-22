package Integridad;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digest {

    public static byte[] getDigest(String algorithm, byte[] buffer){

        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.update(buffer);
            return digest.digest();

        } catch (Exception e) {
            return null;
        }
    }

    public static void imprimirHexa(byte[] byteArray){
        String out = "";
        for(int i = 0; i < byteArray.length; i++){
            if((byteArray[i] & 0xff) <= 0xf){
                out += "0";
            }
            out += Integer.toHexString(byteArray[i] & 0xff).toLowerCase();
        }
        System.out.println(out);
    }

    public static byte[] getDigestFile(String algorithm, String fileName) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance(algorithm);

            FileInputStream in = new FileInputStream(fileName);
            byte[] buffer = new byte[1024];

            int length;
            while ((length = in.read(buffer)) != -1){
                md.update(buffer, 0, length);
            }

            in.close();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return md.digest();
    }
}
