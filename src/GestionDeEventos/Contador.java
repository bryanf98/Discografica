package GestionDeEventos;
import java.io.*;


public class Contador {

    public int contarLineas(String path) {

        File documento = null;
        FileReader fr = null;
        BufferedReader br = null;
        int lineas=0;
        try {

            documento = new File(path);
            fr = new FileReader(documento);
            br = new BufferedReader(fr);
            lineas=(int)br.lines().count();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lineas;
    }

}
