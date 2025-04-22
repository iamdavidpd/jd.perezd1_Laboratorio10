import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main2 {
    private final static String ALGORITMO = "AES";

    public static void imprimir(byte[] contenido){
        int i = 0;
        for(; i < contenido.length - 1; i++){
            System.out.print(contenido[i] + " ");
        }
        System.out.println(contenido[i] + " ");
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        try {
            KeyGenerator keygen = KeyGenerator.getInstance(ALGORITMO);
            SecretKey k1 = keygen.generateKey();
            SecretKey k2 = keygen.generateKey();

            System.out.print("Escriba el mensaje a cifrar con k1: ");
            String m1 = con.nextLine();
            System.out.println("Mensaje a cifrar con k1: " + m1);
            byte[] tc1 = Simetrico.cifrar(k1, m1);
            System.out.print("Mensaje tc1 (cifrado con k1): ");
            imprimir(tc1);
            System.out.println();

            System.out.print("Escriba el mensaje a cifrar con k2: ");
            String m2 = con.nextLine();
            System.out.println("Mensaje a cifrar con k2: " + m2);
            byte[] tc2 = Simetrico.cifrar(k2, m2);
            System.out.print("Mensaje tc2 (cifrado con k2): ");
            imprimir(tc2);
            System.out.println();

            byte[] dtc1 = Simetrico.descifrar(k1, tc1);
            String sdtc1 = new String(dtc1, StandardCharsets.UTF_8);
            System.out.println("Mensaje tc1 descifrado con k1: " + sdtc1);

            byte[] dtc2 = Simetrico.descifrar(k2, tc1);
            String sdtc2 = new String(dtc2, StandardCharsets.UTF_8);
            System.out.println("Mensaje tc1 descifrado con k2: " + sdtc2);

        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        con.close();
    }
}
