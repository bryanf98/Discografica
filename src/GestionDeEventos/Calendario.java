package GestionDeEventos;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Calendario {
    Tokenizador token = new Tokenizador();
    Contador conta = new Contador();
    public ArrayList<Evento> eventos = new ArrayList<Evento>();

    public void agregarEvento(Evento evento){
        eventos.add(evento);
    }
    public void quitrEvento(Evento evento){
        eventos.remove(evento);
    }
    public String[] mostrarEventos(){
        int numeroDeEventos=conta.contarEventos();
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

    /*public int contarEventos() {

        File documentoConFechas = null;
        FileReader fr = null;
        BufferedReader br = null;
        int lineas=0;
        try {

            documentoConFechas = new File("F:\\Universidad\\6-7\\Metodologias Ágiles\\Discografica\\src\\GestionDeEventos\\eventos.txt");
            fr = new FileReader(documentoConFechas);
            br = new BufferedReader(fr);
            lineas=(int)br.lines().count();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lineas;
    }*/

    public  void mostrarEventoSegunFecha(String fecha){

            boolean encontrado=false;
            File inputFile = new File("F:\\Universidad\\6-7\\Metodologias Ágiles\\Discografica\\src\\GestionDeEventos\\eventos.txt");
            
            try {
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));


                String currentLine;
                String evento = "";

                while((currentLine = reader.readLine()) != null) {
                    String fechaTokenizada = token.tokenizarEventosTomarFecha(currentLine);
                    if(fechaTokenizada.equalsIgnoreCase(fecha)){
                        encontrado=true;
                        evento=currentLine.trim();
                        break;
                    }
                }
                if(encontrado==true)
                {
                    System.out.println(evento);
                }
                else
                {
                    System.out.println("No existe eventos en esa fecha");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    /*public  String tokenizarEventosTomarFecha(String linea){
        //Tokenizamos las fechas
        StringTokenizer tokens = new StringTokenizer(linea, "-");
        //Leemos todos los tokens encontrados por linea
        String fecha="";
        for(int i=0;i<1;i++){
            fecha = fecha + tokens.nextToken();
        }

        return fecha;
    }*/

}