package teoria.ej18_exceptions;

public class IdentificarExcepciones {

	public static void main(String[] args) {
		//caso1();
		caso2();
		//int resultado = caso3(2);
		//System.out.println("resultado:"+ resultado);
	}
	
	public static void caso2() {
		String aux = "hola";
		int aux2 = Integer.parseInt(aux);
		
		System.out.println(aux);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void caso1() {
		String[] array = new String[5];
		array[3].length();
		
		//String arenteiro = null;
		//arenteiro.length();
		
	}



	@SuppressWarnings("finally")
	public static int caso3(int num) {
		try {
			if (num % 2 == 0) {
				throw new Exception("Lanzando excepcion");
			}
			return 1;
		} catch (Exception ex) {
			return 2;
		} finally {
			return 3;
		}
	}

}
