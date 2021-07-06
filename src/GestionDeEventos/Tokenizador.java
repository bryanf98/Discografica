package GestionDeEventos;

import java.util.StringTokenizer;

public class Tokenizador {

    public String tokenizarFechas(String linea) {
        //Tokenizamos las fechas
        StringTokenizer tokens = new StringTokenizer(linea, "/");
        //Leemos todos los tokens encontrados por linea
        String fechaSinGuion = "";
        while (tokens.hasMoreTokens()) {
            fechaSinGuion = fechaSinGuion + tokens.nextToken();
        }

        return fechaSinGuion;
    }

    public String[] tokenizarEventos(String linea) {
        //Tokenizamos las fechas
        StringTokenizer tokens = new StringTokenizer(linea, "-");
        //Leemos todos los tokens encontrados por linea
        String fecha[] = new String[2];

        try {
            for (int i = 0; i < 2; i++) {
                if (tokens.hasMoreTokens() != false) {
                    fecha[i] = tokens.nextToken();
                }

            }
        } catch (ArithmeticException excepcion) {
            System.out.println("error de indece");
        }

        return fecha;
    }

    public String tokenizarLugares(String linea) {
        //Tokenizamos las fechas
        StringTokenizer tokens = new StringTokenizer(linea, "-");
        //Leemos todos los tokens encontrados por linea
        String fecha = "";

        try {
            for (int i = 0; i < 1; i++) {
                if (tokens.hasMoreTokens() != false) {
                    fecha = fecha + tokens.nextToken();
                }

            }
        } catch (ArithmeticException excepcion) {
            System.out.println("error de indece");
        }

        return fecha;
    }

    public String tokenizarEventosTomarFecha(String linea) {
        //Tokenizamos las fechas
        StringTokenizer tokens = new StringTokenizer(linea, "-");
        //Leemos todos los tokens encontrados por linea
        String fecha = "";
        for (int i = 0; i < 1; i++) {
            fecha = fecha + tokens.nextToken();
        }

        return fecha;

    }
}
