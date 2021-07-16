package GestionDeEventos;

import java.util.*;
import java.io.*;

public class ListaDeEmpleados {

    public ListaDeEmpleados(){
        listaEmpleados = new ArrayList();
    }

    public ArrayList<Empleado> listaEmpleados;

    public void agregarEmpleado(Empleado trabajador)
    { listaEmpleados.add(trabajador);
    }

    public String mostrarEmpleado()
    {

        try {
            String cadenaDeRetorno="";
            //Leer archivo lo que va a hacer es leer empleados e instanciarlos, agregandolos al atributo listaEmpleados(ArrayList)
            leerArchivo();
            for(Empleado empleado:listaEmpleados){
                cadenaDeRetorno+=empleado.toString();
            }
            return cadenaDeRetorno;
        }
        catch(Exception e){
            System.out.println("No se pueden mostrar los empleados");
        }

    }

    private  void leerArchivo() throws IOException {
        BufferedReader br;
        File archivo;
        FileReader fr;
        // Apertura del fichero
        archivo = new File ("src/main/java/GestionDeEventos/empleados.txt");
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);

        // Lectura del fichero
        String linea;
        Empleado empleado =null;
        StringTokenizer tokens = null;
        while((linea=br.readLine())!=null) {

            tokens = new StringTokenizer(linea, ";");
            ArrayList aux = new ArrayList();
            while (tokens.hasMoreTokens()) {
                aux.add(tokens.nextToken());

            }
            //System.out.println(aux.toString());
            int ultimo = aux.size()-1;
            if(aux.get(ultimo).equals("A")){
               empleado = new Artista( aux.get(3).toString(), aux.get(1).toString(), aux.get(2).toString(), aux.get(4).toString());
            }
            else
            {
                empleado = new NoArtista(aux.get(1).toString(), aux.get(2).toString(), aux.get(3).toString());
            }
            this.agregarEmpleado(empleado);
            //System.out.print(listaEmpleados.get(0).toString());
            //System.out.println(this.listaEmpleados.get(1).toString());
        }

    }

    /*public static void main(String [] arg) {
        try{
             ListaDeEmpleados lista = new ListaDeEmpleados();
            lista.leerArchivo();
            //System.out.println(lista.listaEmpleados.);
        }
        catch(Exception e){
            System.out.println("No se pueden mostrar los empleados");
        }

    }*/

}
