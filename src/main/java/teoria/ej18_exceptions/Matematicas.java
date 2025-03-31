package teoria.ej18_exceptions;
public class Matematicas {
    public double dividir(double a, double b) throws Exception {
        if (b == 0) {
            throw new Exception("El argumento b no puede ser 0");
        }
 
        return a / b;
    }
}