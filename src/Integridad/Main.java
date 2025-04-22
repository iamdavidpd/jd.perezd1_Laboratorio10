package Integridad;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Escriba un mensaje de texto: ");
        Scanner con = new Scanner(System.in);
        String men = con.nextLine();
        System.out.println("Mensaje de entrada: " + men);
        byte[] menBy = men.getBytes();
        byte[] md = Digest.getDigest("MD5", menBy);
        System.out.print("Digest MD5 obtenido: ");
        Digest.imprimirHexa(md);

        byte[] sh = Digest.getDigest("SHA-1", menBy);
        System.out.print("Digest SHA-1 obtenido: ");
        Digest.imprimirHexa(sh);

        con.close();
    }

}
