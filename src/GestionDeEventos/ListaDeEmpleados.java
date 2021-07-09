package GestionDeEventos;

import java.util.*;
import java.io.*;

public class ListaDeEmpleados {
    public ArrayList<Empleado> empleados;

    public void agregarEmpleado(Empleado trabajador)
    { empleados.add(trabajador);
    }

    public void mostrarEmpleado()
    {
        File archivo;
        FileReader fr;
        BufferedReader br;
        try {
            leerArchivo();
        }
        catch(Exception e){
            System.out.println("No se pueden mostrar los empleados");
        }
    }

    private void leerArchivo() throws IOException {
        BufferedReader br;
        File archivo;
        FileReader fr;
        // Apertura del fichero
        archivo = new File ("src/GestionDeEventos/empleados.txt");
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);

        // Lectura del fichero
        String linea;
        while((linea=br.readLine())!=null)
            System.out.println(linea);
    }

}
