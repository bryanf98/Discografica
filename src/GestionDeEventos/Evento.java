package GestionDeEventos;
import GestionDeEventos.Lugar;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Evento {

     Fecha  fecha ;
    Lugar lugar;
     String tipoDeEvento;

    public  void crearEvento(String fecha1, int aforo, String direccion, String dueno,String tipoDeEvento1 )
    {
        fecha =new Fecha();
        if(fecha.seleccionaFecha(fecha1)==true)
        {
            insertarEvento(fecha1,aforo,direccion,dueno,tipoDeEvento1);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"La fecha está reservada, intenta con otra");
        }

    }

    public  void insertarEvento(String fecha1, int aforo, String direccion, String dueno,String tipoDeEvento1)
    {
        String evento = fecha1+"-"+aforo+"-"+direccion+"-"+dueno+"-"+tipoDeEvento1;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("F:\\Universidad\\6-7\\Metodologias Ágiles\\Discografica\\src\\GestionDeEventos\\eventos.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(evento);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }



    public  void mostrarEvento(String fecha1, int aforo, String direccion, String dueno,String tipoDeEvento1)
    {
        String evento = fecha1+"-"+aforo+"-"+direccion+"-"+dueno+"-"+tipoDeEvento1;
        // Fichero del que queremos leer
        File fichero = new File("F:\\Universidad\\6-7\\Metodologias Ágiles\\Discografica\\src\\GestionDeEventos\\eventos.txt");
        Scanner s = null;

        try {

            s = new Scanner(fichero);
            while (s.hasNextLine()) {
                if(s.nextLine().equalsIgnoreCase(evento))
                System.out.println(evento);
                else
                {
                    System.out.println("No está registrado tal evento");
                }
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
    }



    /*public static void main(String [] arg) {

        insertarEvento("2020/07/11",1200,"Guayas","Lopez Juan","Lanzamiento");
        }*/
}