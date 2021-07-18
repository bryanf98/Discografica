package GestionDeEventos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public  class ListaLugar {
    Tokenizador token = new Tokenizador();

    Contador conta = new Contador();
    public ArrayList<Fisico> lugarFisico = new ArrayList<Fisico>();
    public ArrayList<PlataformaDigital> lugarDigital = new ArrayList<PlataformaDigital>();

    //public ArrayList<Lugar> listaLugares;

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



    //public   ArrayList mostrarLugares() este es la definicion de la funcionalidad que no sé
    public   String mostrarLugares()
    {
        String path=  "src/main/java/GestionDeEventos/lugares.txt";
        ArrayList eventos= new ArrayList();
        ArrayList<Lugar> lugares= new ArrayList<Lugar>();
        String lugaresLinea= "";
        File fichero = new File(path);
        Scanner s = null;
        try {
            s = new Scanner(fichero);
            StringTokenizer tokens;
            while (s.hasNextLine()) {
                lugaresLinea=s.nextLine();

                //PRIMERA REFACTORIZACION
                tokens = new StringTokenizer(lugaresLinea, "-");
                ArrayList aux = new ArrayList();
                while (tokens.hasMoreTokens()) {
                    aux.add(tokens.nextToken());
                }
                //ArrayList aux= tokenizar(lugaresLinea);
                //FIN PRIMERA

                //SEGUNDA RECTORIZACION
                Lugar lugar = new Fisico(aux.get(0).toString(),Integer.parseInt(aux.get(1).toString()));
                lugares.add(lugar);
                //addLugarFisico(lugares,aux);
                //FIN SEGUNDA REFACTORIZACION

            }
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            //INICIO TERCERA REFACTORIZACION
            try {
                if (s != null)
                    s.close();
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
            //FINAL TERCERA REFACTORIZACION
            //cerrarLecturaArchivo(s);
        }
        String lugaresARetornar="";

        //INICIO 4 REFACTORIZACION
        for(Lugar lugar:lugares){
            lugaresARetornar+=" " +lugar.mostrarLugar();
        }

        return lugaresARetornar;
        //FIN CUARTA REFACTORTIZACION
        //return lugaresRetorno(lugares,lugaresARetornar);
    }


    //REFACTORIZACION 1 EXTRACT METHOD
    public ArrayList tokenizar(String linea)
    {
        StringTokenizer tokens;
        tokens = new StringTokenizer(linea, "-");
        ArrayList aux = new ArrayList();
        while (tokens.hasMoreTokens()) {
            aux.add(tokens.nextToken());
        }
        return aux;
    }
    //REFACTORIZACION 2 EXTRACT METHOD
    public void addLugarFisico(ArrayList<Lugar> lugares ,ArrayList aux){
        Lugar lugar = new Fisico(aux.get(0).toString(),Integer.parseInt(aux.get(1).toString()));
        lugares.add(lugar);
    }

    //REFACTORIZACION 3 EXTRACT METHOD
    public void cerrarLecturaArchivo(Scanner s){
        try {
            if (s != null)
                s.close();
        } catch (Exception ex2) {
            System.out.println("Mensaje 2: " + ex2.getMessage());
        }
    }

    //REFACTORIZACION 4 EXTRACT METHOD
    public String lugaresRetorno(ArrayList<Lugar> lugares ,String lugaresARetornar ){
        for(Lugar lugar:lugares){
            lugaresARetornar+=" " +lugar.mostrarLugar();
        }

        return lugaresARetornar;
    }


    public   ArrayList mostrarLugaresDisponibles(String fecha){

        ArrayList ocupados=extraerLugaresOcupadoPorFecha(fecha);
        ArrayList disponibles = new ArrayList();
        int tamanoOcupados=ocupados.size();
        int contador=0;
        boolean encontrado=false;
        File inputFile = new File("src/GestionDeEventos/lugares.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));


            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                String lugarTokenizado="";
                if(tamanoOcupados!=0)
                {
                    lugarTokenizado = token.tokenizarLugares(currentLine);
                    String lugaresOcupadosTokenizados=token.tokenizarLugares(ocupados.get(contador).toString());
                    if(!(lugarTokenizado.equalsIgnoreCase(lugaresOcupadosTokenizados))){
                        disponibles.add(lugarTokenizado);
                    }
                    else{
                        contador++;
                        tamanoOcupados--;
                    }
                }
                else
                {
                    lugarTokenizado = token.tokenizarLugares(currentLine);
                    disponibles.add(lugarTokenizado);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return disponibles;
    }


    public  ArrayList extraerLugaresOcupadoPorFecha(String fecha)
    {

        File inputFile = new File("src/GestionDeEventos/eventos.txt");
        ArrayList evento= new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String currentLine;


            while((currentLine = reader.readLine()) != null) {
                if(!currentLine.equalsIgnoreCase("")) {
                    String[] eventoTokenizada = token.tokenizarEventos(currentLine);
                    if (eventoTokenizada[0].equalsIgnoreCase(fecha)) {

                        evento.add(  eventoTokenizada[1]+"-" +eventoTokenizada[0] );
                        continue;
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return evento;
    }

    /*public static void main(String [] arg) {
        mostrarLugares();
    }*/

    }