package Integridad;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        System.out.println("Escriba el nombre del archivo: ");
        String arc = con.nextLine();
        System.out.println("Nombre del archivo: " + arc);

        byte[] md = Digest.getDigestFile("MD5", "src/"+arc);
        System.out.print("Digest MD5 obtenido: ");
        Digest.imprimirHexa(md);

        byte[] sh = Digest.getDigestFile("SHA-1", "src/"+arc);
        System.out.print("Digest SHA-1 obtenido: ");
        Digest.imprimirHexa(sh);

        con.close();
    }
}
