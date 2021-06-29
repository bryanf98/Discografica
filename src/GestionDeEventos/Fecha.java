import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Fecha {

    String dia;
    String mes;
    String ano;

    public  static void seleccionaFecha(String fecha)
    {
        String fechaSinGuion = tokenizarFechas(fecha);
        String[] fechas = obtenerFechas();
        int tamano=contarFechas();
        for(int i=0;i<tamano;i++){
            if(fechas[i].equalsIgnoreCase(fechaSinGuion)){
                JOptionPane.showMessageDialog(null,"Esta fecha está ocupada");
            }
        }
    }

    public  static int contarFechas(){
        File documentoConFechas = null;
        FileReader fr = null;
        BufferedReader br = null;
        int lineas=0;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            documentoConFechas = new File("F:\\Universidad\\6-7\\Metodologias Ágiles\\Discografica\\src\\GestionDeEventos\\fechas.txt");
            fr = new FileReader(documentoConFechas);
            br = new BufferedReader(fr);
            lineas=(int)br.lines().count();
        } catch (Exception e) {
            e.printStackTrace();
        }

    return lineas;
    }

    public static String tokenizarFechas(String linea){
        //Tokenizamos las fechas
        StringTokenizer tokens = new StringTokenizer(linea, "-");
        //Leemos todos los tokens encontrados por linea
        String fechaSinGuion="";
        while(tokens.hasMoreTokens()) {
            fechaSinGuion = fechaSinGuion + tokens.nextToken();
        }

        return fechaSinGuion;
    }

    public  static String[] obtenerFechas() {
        //--ano/mes/dia- 1998/08/05
        File documentoConFechas = null;
        FileReader fr = null;
        BufferedReader br = null;
        int lineas = contarFechas();
        String[] fechas = new String[lineas];
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            documentoConFechas = new File("F:\\Universidad\\6-7\\Metodologias Ágiles\\Discografica\\src\\GestionDeEventos\\fechas.txt");
            fr = new FileReader(documentoConFechas);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;

            int contador=0;
            while ((linea = br.readLine()) != null) {

                String fechaSinGuion=tokenizarFechas(linea);
                //agregamos los tokens a el arreglo de fechas
                fechas[contador]=fechaSinGuion;
                contador++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return fechas;
    }

        public static void main(String [] arg) {

            seleccionaFecha("2021-09-12");
        }
    }


