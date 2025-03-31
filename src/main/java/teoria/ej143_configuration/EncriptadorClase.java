package teoria.ej143_configuration;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncriptadorClase {

    public static void main(String[] args) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        String privateData = "DATOS A CIFRAR";

        encryptor.setPassword("11031997");
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");

        String encryptedText = encryptor.encrypt(privateData);
        System.out.println(encryptedText);

        String plainText = encryptor.decrypt(encryptedText);
        System.out.println(plainText);

    }
}
