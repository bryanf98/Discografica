package GestionDeEventos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NoArtista extends Empleado{

    public NoArtista(String nombreEmpleado, String cargo, String estadoEmpleado) {
        super(nombreEmpleado,cargo,estadoEmpleado);
    }
    public NoArtista(){}


    public static File fichero_empleados = new File("src/GestionDeEventos/empleados.txt");

    public void registrarEmpleado(FormularioEmpleados formulario) {
        this.nombreEmpleado = formulario.nombre;
        this.estadoEmpleado = formulario.estado;
        this.cargo = formulario.cargo;
        escribirDatosNoArtista();
    }

    private void escribirDatosNoArtista() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(fichero_empleados.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            ingresarEnArchivoNoArtista(fw);
        } catch (Exception ex) {
            System.out.println("No se puede registrar el empleado");
        } finally {
            try {
                cerrarArchivosNoArtista(bw, fw);
            } catch (Exception ex) {
                ex.printStackTrace();}
        }
    }

    private void cerrarArchivosNoArtista(BufferedWriter bw, FileWriter fw) throws IOException {
        if (bw != null)
            bw.close();
        if (fw != null)
            fw.close();
    }

    private void ingresarEnArchivoNoArtista(FileWriter fw) throws IOException {
        //Cuento el número de líneas
        int i = 0;
        try  (Scanner entrada = new Scanner(fichero_empleados)) {
            while (entrada.nextLine()!= null) {
                i = i+1;
            }
        }          catch (Exception e) {
            System.out.println(e.toString());
        }
        String data = ((i+1)+ "; " + nombreEmpleado + "; " + cargo + "; " + estadoEmpleado +"\n");
        fw.write(data);
        System.out.println("Empleado Registrado Exitosamente");
    }

    @Override
    public String toString() {
        return "NoArtista{" +
                "nombreEmpleado='" + nombreEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", estadoEmpleado='" + estadoEmpleado + '\'' +
                '}';
    }
}
