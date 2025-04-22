import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main {
    private final static String ALGORITMO = "AES";

    public static void imprimir(byte[] contenido){
        int i = 0;
        for(; i < contenido.length - 1; i++){
            System.out.print(contenido[i] + " ");
        }
        System.out.println(contenido[i] + " ");
    }

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        System.out.print("Escriba el texto que desea cifrar: ");
        String mensaje = consola.nextLine();
        System.out.println(mensaje);
        System.err.println("Mensaje de entrada en texto claro: " + mensaje);

        System.out.print("Texto claro: ");
        imprimir(mensaje.getBytes());

        try {
        KeyGenerator keygen = KeyGenerator.getInstance(ALGORITMO);
        SecretKey secretKey = keygen.generateKey();
        
        long tiemIni = System.nanoTime();
        byte[] cif = Simetrico.cifrar(secretKey, mensaje);
        System.out.print("Texto cifrado: ");
        imprimir(cif);

        byte[] descif = Simetrico.descifrar(secretKey, cif);
        long tiemFin = System.nanoTime();
        System.out.print("Texto descifrado: ");
        imprimir(descif);

        long tiempo = tiemFin - tiemIni;

        String desciString = new String(descif, StandardCharsets.UTF_8);
        System.out.print("Texto descrifrado: ");
        System.out.print(desciString);
        System.out.println();

        System.out.println("Tiempo de cifrado y descrifrado: " + tiempo);

        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        consola.close();
    }
}
