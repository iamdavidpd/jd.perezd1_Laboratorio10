import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main3 {

    private final static String ALGORITMO = "AES";

    public static void main(String[] args) {
        
        try {
            KeyGenerator keygen = KeyGenerator.getInstance(ALGORITMO);
            SecretKey k1 = keygen.generateKey();
            FileOutputStream llave = new FileOutputStream("k1Main3");
            ObjectOutputStream oos = new ObjectOutputStream(llave);
            oos.writeObject(k1);
            oos.close();
            llave.close();

            Scanner con = new Scanner(System.in);
            String men = con.nextLine();
            byte[] textoCifrado = Simetrico.cifrar(k1, men);
            FileOutputStream cifrado = new FileOutputStream("cifrado");
            ObjectOutputStream oos1 = new ObjectOutputStream(cifrado);
            oos1.writeObject(textoCifrado);
            oos1.close();
            cifrado.close();
            con.close();

        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }
}
