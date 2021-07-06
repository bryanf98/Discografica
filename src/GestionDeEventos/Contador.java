package GestionDeEventos;
import java.io.*;


public class Contador {

    public int contarEventos() {

        File documentoConFechas = null;
        FileReader fr = null;
        BufferedReader br = null;
        int lineas=0;
        try {

            documentoConFechas = new File("src/GestionDeEventos/eventos.txt");
            fr = new FileReader(documentoConFechas);
            br = new BufferedReader(fr);
            lineas=(int)br.lines().count();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lineas;
    }
    public int contarLugares() {

        File documentoConFechas = null;
        FileReader fr = null;
        BufferedReader br = null;
        int lineas=0;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            documentoConFechas = new File("src/GestionDeEventos/lugares.txt");
            fr = new FileReader(documentoConFechas);
            br = new BufferedReader(fr);
            lineas=(int)br.lines().count();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lineas;
    }
}
