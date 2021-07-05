package GestionDeEventos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Artista extends Empleado{

    String generomusical;

    public static File fichero_empleados = new File("src/GestionDeEventos/empleados.txt");

    public void registrarEmpleado(FormularioEmpleados formulario) {

        this.nombreEmpleado = formulario.nombre;
        this.estadoEmpleado = formulario.estado;
        this.cargo = formulario.cargo;
        this.generomusical = formulario.generoMusical;


        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(fichero_empleados.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            //Cuento el número de líneas
            int i = 0;
            try  (Scanner entrada = new Scanner(fichero_empleados)) {
                while (entrada.nextLine()!= null) {
                    i = i+1;
                }
            }          catch (Exception e) {
                System.out.println(e.toString());
            }
            String data = ((i+1)+ "; " + nombreEmpleado + "; " + cargo + "; " + generomusical + "; " + estadoEmpleado +"\n");
            fw.write(data);
            System.out.println("Empleado Registrado Exitosamente");
        } catch (Exception ex) {
            System.out.println("No se puede registrar el empleado");
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
