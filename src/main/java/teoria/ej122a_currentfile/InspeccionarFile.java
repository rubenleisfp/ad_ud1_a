package teoria.ej122a_currentfile;

import java.io.File;

/**
 * Hello world!
 *
 */
public class InspeccionarFile
{
    public static void main( String[] args )
    {
        File f = new File("src/main");
        System.out.println("AbsolutePath:" + f.getAbsolutePath());
        System.out.println("Path:" + f.getPath());
        System.out.println("Name:" + f.getName());
        System.out.println("IsDirectory:" + f.isDirectory());
        File[] listFiles = f.listFiles();
        for (File fchild: listFiles) {
            System.out.println("AbsolutePath fchild: " + fchild.getAbsolutePath());
        }
    }
}
