package GestionDeEventos;

import java.util.*;
import java.io.*;

public class ListaDeEmpleados {
    public ArrayList<Empleado> empleados;

    public void agregarEmpleado()
    {

    }

    public void mostrarEmpleado()
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero
            archivo = new File ("C:\\empleados.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
        }
        catch(Exception e){
            System.out.println("No se pueden mostrar los empleados");
        }
    }

}
