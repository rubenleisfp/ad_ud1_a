package teoria.ej207_test_unitarios;

public class Calculadora {
    /**
     * Esta operativa se encarga de sumar a + b
     * @param a
     * @param b
     * @return
     */
    public int sumar(int a, int b) {
        //1. Sumar a +b
        //2. Retorna la variable del punto 1
        int resultado = a+b;
        return resultado;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int a, int b) {
        return a / b;
    }


    public static void main(String [] args) {
        Calculadora c = new Calculadora();
        c.dividir(5,0);
    }
}
