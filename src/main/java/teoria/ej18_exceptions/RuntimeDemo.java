package teoria.ej18_exceptions;

public class RuntimeDemo {

	public static void main(String[] args) {
		RuntimeDemo runtimeDemo = new RuntimeDemo();
		runtimeDemo.mainMethod();
	}

	/**
	 * Método principal
	 * 
	 * Prueba a comentar y descomentar estas lineas para ver la ejecución de cada metodo de manera individual
	 * 
	 */
	public void mainMethod() {
		//dividir(5, 0);
		//methodThrowsRuntimeException();
		methodThrowsRuntimeException2();
	}

	/**
	 * La division puede lanzar una unchecked exception, ya que arithmeticException hereda de RuntimeException
	 * 
	 * https://docs.oracle.com/javase/8/docs/api/java/lang/ArithmeticException.html 
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private int dividir(int a,int b) {
		int result=a/b;
		return result;
	}

	/**
	 * Este método lanzará una excepción de tipo runtime no declarada en su firma
	 */
	public void methodThrowsRuntimeException() {
		throw new ExampleRuntimeException();
	}

	/**
	 * Este método lanzará una excepción de tipo runtime está declarada en su firma
	 * (no es obligación) pero deja mas claro al desarrollador las excepciones que
	 * debería manejar con la API.
	 * 
	 * @throws ExampleRuntimeException en caso de error
	 */
	public void methodThrowsRuntimeException2() throws ExampleRuntimeException {
		throw new ExampleRuntimeException();
	}

	/**
	 * Clase de error tipo Runtime
	 * 
	 * Al heredar de runtime es una unchecked excepcion
	 */
	public class ExampleRuntimeException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ExampleRuntimeException() {
			super();
		}
	}
}
