package teoria.ej122a_currentfile;

public class AppCalcularFactorial {

    public int calcularFactorial(int num) {
        if (num<=1) {
            return num;
        }
        return num * calcularFactorial(num-1);
    }

    public static void main(String[] args) {
        AppCalcularFactorial app = new AppCalcularFactorial();
        int resultado = app.calcularFactorial(1);
        System.out.println(resultado);
        resultado = app.calcularFactorial(2);
        System.out.println(resultado);
        resultado = app.calcularFactorial(3);
        System.out.println(resultado);
        resultado = app.calcularFactorial(4);
        System.out.println(resultado);

    }
}



