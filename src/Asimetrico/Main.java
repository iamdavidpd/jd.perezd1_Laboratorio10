package Asimetrico;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

public class Main {
    private final static String ALGORITMO = "RSA";

    public static void imprimir(byte[] contenido){
        int i = 0;
        for(; i < contenido.length - 1; i++){
            System.out.print(contenido[i] + " ");
        }
        System.out.println(contenido[i] + " ");
    }

    public static void main(String[] args) {
        System.out.println("Escriba un mensaje de texto: ");
        Scanner con = new Scanner(System.in);
        String men = con.nextLine();
        System.out.println("Input en texto plano: " + men);
        System.out.println();

        byte[] menBy = men.getBytes();
        System.out.println("Input en bytes[]: ");
        imprimir(menBy);
        System.out.println();

        try {
            KeyPairGenerator gen = KeyPairGenerator.getInstance(ALGORITMO);
            gen.initialize(1024);
            KeyPair keyPair = gen.genKeyPair();
            PublicKey llavePublica = keyPair.getPublic();
            PrivateKey llavePrivada = keyPair.getPrivate();

            byte[] cifrado = Asimetrico.cifrar(llavePublica, ALGORITMO, men);
            System.out.println("Input cifrado en RSA con Llaves de 1024 bits en byte[]: ");
            imprimir(cifrado);
            System.out.println();

            byte[] descif = Asimetrico.descifrar(llavePrivada, ALGORITMO, cifrado);
            System.out.println("Input descifrado en byte[]: ");
            imprimir(descif);
            System.out.println();

            String claro = new String(descif, StandardCharsets.UTF_8);
            System.out.println("Input descifrado convertido a texto plano: " + claro);
            System.out.println();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        con.close();
    }
}
