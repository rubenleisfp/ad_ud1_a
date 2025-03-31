package teoria.ej143_configuration;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class Encriptador {


    private static final String CLAVE = "14091993";
    StandardPBEStringEncryptor encryptor;

    public Encriptador() {
        encryptor= new StandardPBEStringEncryptor();
        encryptor.setPassword(CLAVE);
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
    }

    public  String cifrar(String data) {
        String encriptedData = encryptor.encrypt(data);
        return encriptedData;
    }

    public  String descifrar(String encryptedData) {
        String descryptData = encryptor.decrypt(encryptedData);
        return descryptData;
    }
}
