package teoria.ej18_exceptions;

public class Main {
//	public static void main(String[] args) {
//		Matematicas matematicas = new Matematicas();
//		try {
//			double c = matematicas.dividir(-1.6, 0);
//		} catch (Exception ex) {
//			System.out.println("He capturado la excepcion y hago la gestión que guste" + ex);
//		}
//	}

	public static void main(String[] args) throws Exception {
		Matematicas matematicas = new Matematicas();

		double c = matematicas.dividir(-1.6, 0);
	}

}
