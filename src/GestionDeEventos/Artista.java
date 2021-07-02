package GestionDeEventos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Artista extends Empleado {

    String generoMusical;

    public static ArrayList <Empleado> informacion = FormularioEmpleados.datosLeidos;
    public static File fichero_empleados = new File("src/GestionDeEventos/empleados.txt");




    /*registrarEmpleado(FormularioEmpleados form)

    {
        //form= new FormularioEmpleados();
        ArrayList<String> datosEmpleado=form.obtenerValores(); //
        this.nombreEmpleado=datosEmpleado.get(0);
        this.estadoEmpleado=datosEmpleado.get(1);
        this.cargo=datosEmpleado.get(2);
        this.generoMusical=datosEmpleado.get(3);
        System.out.println("Registrado exitosamente");

    }*/


    @Override
    public void registrarEmpleado() {
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