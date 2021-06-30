package GestionDeEventos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class NoArtista extends Empleado{

    public static ArrayList<Empleado> informacion = FormularioEmpleados.datosLeidos;
    public static File fichero_empleados = new File("src/GestionDeEventos/empleados.txt");

    @Override
    public void registrarEmpleado(){
        try {
            //Creación del Bufferwritter para escribir
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero_empleados));
            //Se recorre el array y separo cada atributo por ";" y al final de cada linea se hace un salto
            int i = 0;
            for (Empleado e : informacion) {
                bw.write((i+1)+ "; " + e.getNombreEmpleado() + "; " + e.getCargo() + "; " + e.getEstadoEmpleado() + "\n");
            }
            bw.close();
        } catch (Exception ex) {
            System.out.println("No se puede registrar el empleado");
        }
    }

}
