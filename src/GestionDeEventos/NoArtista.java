package GestionDeEventos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class NoArtista extends Empleado{

    public static File fichero_empleados = new File("src/GestionDeEventos/empleados.txt");

    @Override
    public void registrarEmpleado(FormularioEmpleados formulario) {

        ArrayList<String> datosEmpleado = formulario.obtenerValores();
        this.nombreEmpleado = datosEmpleado.get(0);
        this.estadoEmpleado = datosEmpleado.get(1);
        this.cargo = datosEmpleado.get(2);

        try {
            //Creación del Bufferwritter para escribir
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero_empleados));
            //Se recorre el array y separo cada atributo por ";" y al final de cada linea se hace un salto
            //int i = 0;
            //for (String e : datosEmpleado) {
            for (int i=0; i<= datosEmpleado.size(); i++) {
                bw.write((i+1)+ "; " + nombreEmpleado + "; " + estadoEmpleado + "; " + cargo + "\n");
            }
            bw.close();
            System.out.println("Empleado Registrado Exitosamente");
        } catch (Exception ex) {
            System.out.println("No se puede registrar el empleado");
        }

    }

}
