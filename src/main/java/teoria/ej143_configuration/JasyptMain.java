package teoria.ej143_configuration;

public class JasyptMain {

    public static void main (String [] args) {
        Encriptador encriptador = new Encriptador();
        String cifrado = encriptador.cifrar("4970110000000062");
        System.out.println(cifrado);
        String descifrado = encriptador.descifrar(cifrado);
        System.out.println(descifrado);

        cifrado = encriptador.cifrar("1234");
        System.out.println(cifrado);
        descifrado = encriptador.descifrar(cifrado);
        System.out.println(descifrado);
    }


}
