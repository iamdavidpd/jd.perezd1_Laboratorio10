import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.crypto.SecretKey;

public class Main4 {

    public static void main(String[] args) {

        try {
            FileInputStream arcLlave = new FileInputStream("k1Main3");
            ObjectInputStream ois = new ObjectInputStream(arcLlave);
            SecretKey llave = (SecretKey) ois.readObject();
            ois.close();
            arcLlave.close();

            FileInputStream arcTex = new FileInputStream("cifrado");
            ObjectInputStream ois1 = new ObjectInputStream(arcTex);
            byte[] textoCifrado = (byte[]) ois1.readObject();
            ois1.close();
            arcTex.close();
            
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
