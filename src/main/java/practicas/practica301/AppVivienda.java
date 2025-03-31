package practicas.practica301;



import practicas.practica301.dao.InstalacionElectrica;
import practicas.practica301.dao.impl.EnergiaNuclear;
import practicas.practica301.dao.impl.GasNatural;
import practicas.practica301.dao.impl.PanelSolar;
import practicas.practica301.dao.impl.PropertiesHandler;
import practicas.practica301.service.CocinaService;

import java.util.Scanner;

public class AppVivienda {

    CocinaService cocinaService;

    public static void main(String[] args) {
//       PropertiesHandler propertiesHandler = new PropertiesHandler("src/main/resources/practica301/reforma.properties");
         PropertiesHandler propertiesHandler = new PropertiesHandler();
        String user = propertiesHandler.getPropertyString("USER");
        System.out.println(user);


//        String receta = obtenerDatosUsuario();
//        AppVivienda appVivienda = new AppVivienda();
//        appVivienda.cfg();
//        appVivienda.run(receta);
    }

    private static String obtenerDatosUsuario() {
        System.out.println("Dime tu receta");
        Scanner sc = new Scanner(System.in);
        String receta = sc.nextLine();
        boolean esRecetaValida = esRecetaValida(receta);

        if (!esRecetaValida) {
            throw new IllegalArgumentException("La receta no es valida");
        }
        sc.close();
        return receta;

    }

    private void cfg() {
        PropertiesHandler propertiesHandler = new PropertiesHandler();
        String tipoInstalacion = propertiesHandler.getPropertyString("TIPO_INSTALACION_ELECTRICA");

        InstalacionElectrica instalacionElectrica;
        if (tipoInstalacion.equals("GAS_NATURAL")) {
            instalacionElectrica= new GasNatural();
        } else if  (tipoInstalacion.equals("PANEL_SOLAR")) {
            instalacionElectrica = new PanelSolar();
        } else if  (tipoInstalacion.equals("ENERGIA_NUCLEAR")) {
            instalacionElectrica = new EnergiaNuclear();
        } else {
            throw new IllegalArgumentException("Properties para el tipo de instalacion mal configurado");
        }

        cocinaService = new CocinaService(instalacionElectrica);
    }

    private static boolean esRecetaValida(String receta) {
        return receta.toUpperCase().equals("TORTILLA") || receta.toUpperCase().equals("PAELLA");
    }

    private void run(String receta)  {
        cocinaService.cocinar(receta);
    }


}
