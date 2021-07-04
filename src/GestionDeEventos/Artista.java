package GestionDeEventos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Artista extends Empleado {

    String generoMusical;

    public static File fichero_empleados = new File("src/GestionDeEventos/empleados.txt");


    @Override
    public void registrarEmpleado(FormularioEmpleados formulario) {

        //ArrayList<String> datosEmpleado = formulario.obtenerValores();
        this.nombreEmpleado = formulario.nombre;
        this.estadoEmpleado = formulario.estado;
        this.cargo = formulario.cargo;
        this.generoMusical = formulario.generoMusical;

        try {
            //Creación del Bufferwritter para escribir
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero_empleados));
            //Se recorre el array y separo cada atributo por ";" y al final de cada linea se hace un salto
            //int i = 0;
            //for (String e : datosEmpleado) {


            bw.write((2)+ "; " + nombreEmpleado + "; " + estadoEmpleado + "; " + cargo + "; " + generoMusical + "\n");


            bw.close();
            System.out.println("Empleado Registrado Exitosamente");
        } catch (Exception ex) {
            System.out.println("No se puede registrar el empleado");
        }

    }
}