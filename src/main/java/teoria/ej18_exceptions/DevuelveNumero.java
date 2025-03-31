package teoria.ej18_exceptions;
public class DevuelveNumero{
    public static int devuelveNumeroCaso1(int num) {
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
    
    
    public static int devuelveNumeroCaso2(int num) {
        try {
            if (num % 2 == 0) {
                throw new Exception("Lanzando excepcion");
            }
            return 1;
        } catch (Exception ex) {
            return 2;
        }
    }
    
    public static int devuelveNumeroCaso3(int num) throws Exception {
        try {
            if (num % 2 == 0) {
                throw new Exception("Lanzando excepcion");
            }
            return 1;
        } catch (IllegalArgumentException ex) {
            return 2;
        }
    }
    
    public static int devuelveNumeroCaso4(int num) throws Exception {
        try {
            if (num % 2 == 0) {
                throw new IllegalArgumentException("Lanzando excepcion");
            }
            return 1;
        } catch (Exception ex) {
            return 2;
        }
    }
    
    
    
  
}

