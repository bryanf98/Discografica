package GestionDeEventos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public  class ListaLugar {
    public ArrayList<Fisico> lugarFisico = new ArrayList<Fisico>();
    public ArrayList<PlataformaDigital> lugarDigital = new ArrayList<PlataformaDigital>();
    public void agregarLugar(Lugar lugar, String tipo)
    {
        if(tipo.equalsIgnoreCase("fisico"))
        {
            lugar=new Fisico();
            Fisico lugarfisico=(Fisico)lugar;
            lugarFisico.add(lugarfisico);
        }
        else
        {
            lugar=new PlataformaDigital();
            PlataformaDigital lugardigital=(PlataformaDigital)lugar;
            lugarDigital.add(lugardigital);
        }

    }
    public void quitarLugar(Lugar lugar, String tipo, String nombre) {
        if (tipo.equalsIgnoreCase("fisico")) {

            lugar = new Fisico();
            Fisico lugarfisico = (Fisico) lugar;
            for (int i = 0; i < this.lugarFisico.size(); i++) {


                if (this.lugarFisico.get(i).nombre.equalsIgnoreCase(nombre)) {
                    this.lugarFisico.remove(i);
                }
            }
        } else {
            lugar = new PlataformaDigital();
            PlataformaDigital lugardigital = (PlataformaDigital) lugar;
            for (int i = 0; i < this.lugarDigital.size(); i++) {
                if (this.lugarDigital.get(i).nombre.equalsIgnoreCase(nombre)) {
                    this.lugarDigital.remove(i);
                }
            }

        }
    }



    public  String[] mostrarLugares()
    {

        int numeroDeLugares=contarLugares();
        String[] eventos= new String[numeroDeLugares];
        int contador =0;

        File fichero = new File("F:\\Universidad\\6-7\\Metodologias Ágiles\\Discografica\\src\\GestionDeEventos\\lugares.txt");
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



    private int contarLugares() {

            File documentoConFechas = null;
            FileReader fr = null;
            BufferedReader br = null;
            int lineas=0;
            try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                documentoConFechas = new File("F:\\Universidad\\6-7\\Metodologias Ágiles\\Discografica\\src\\GestionDeEventos\\lugares.txt");
                fr = new FileReader(documentoConFechas);
                br = new BufferedReader(fr);
                lineas=(int)br.lines().count();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return lineas;
        }

    }