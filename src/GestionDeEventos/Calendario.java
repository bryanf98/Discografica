package GestionDeEventos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Calendario {

    public ArrayList<Evento> eventos = new ArrayList<Evento>();

    public void agregarEvento(Evento evento){
        eventos.add(evento);
    }
    public void quitrEvento(Evento evento){
        eventos.remove(evento);
    }
    public String[] mostrarEventos(){
        int numeroDeEventos= contarEventos();
        String[] eventos= new String[numeroDeEventos];
        int contador =0;

        File fichero = new File("F:\\Universidad\\6-7\\Metodologias Ágiles\\Discografica\\src\\GestionDeEventos\\eventos.txt");
        Scanner s = null;
        try {
            s = new Scanner(fichero);
            while (s.hasNextLine()) {
                eventos[contador]=s.nextLine();
                contador++;
            }

        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (s != null)
                    s.close();
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }

        return eventos;

    }

    private int contarEventos() {

        File documentoConFechas = null;
        FileReader fr = null;
        BufferedReader br = null;
        int lineas=0;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            documentoConFechas = new File("F:\\Universidad\\6-7\\Metodologias Ágiles\\Discografica\\src\\GestionDeEventos\\eventos.txt");
            fr = new FileReader(documentoConFechas);
            br = new BufferedReader(fr);
            lineas=(int)br.lines().count();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lineas;
    }
    public void mostrarEventoSegunFecha(){

    }

}