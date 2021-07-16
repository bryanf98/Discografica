package GestionDeEventos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Artista extends Empleado{

    String generomusical;

    public Artista(String generomusical,String nombreEmpleado, String cargo, String estadoEmpleado,int idLugar) {
        super(nombreEmpleado,cargo,estadoEmpleado,idLugar);
        this.generomusical=generomusical;
    }

    public Artista(){}


    public static File fichero_empleados = new File("src/GestionDeEventos/empleados.txt");

    public void registrarEmpleado(FormularioEmpleados formulario) {
        this.nombreEmpleado = formulario.nombre;
        this.estadoEmpleado = formulario.estado;
        this.cargo = formulario.cargo;
        this.generomusical = formulario.generoMusical;
        escribirDatosArtista(nombreEmpleado, estadoEmpleado, cargo, generomusical);
    }

    private static void escribirDatosArtista(String nombre, String estado, String cargo, String genero) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(fichero_empleados.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            ingresarEnArchivo(nombre, estado, cargo, genero, fw);
        } catch (Exception ex) {
            System.out.println("No se puede registrar el empleado");
        } finally {
            try {
                cerrarArchivo(bw, fw);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void cerrarArchivo(BufferedWriter bw, FileWriter fw) throws IOException {
        //Cierra instancias de FileWriter y BufferedWriter
        if (bw != null)
            bw.close();
        if (fw != null)
            fw.close();
    }

    private static void ingresarEnArchivo(String nombre, String estado, String cargo, String genero, FileWriter fw) throws IOException {
        //Cuento el número de líneas
        int i = 0;
        try  (Scanner entrada = new Scanner(fichero_empleados)) {
            while (entrada.nextLine()!= null) {
                i = i+1;
            }
        }          catch (Exception e) {
            System.out.println(e.toString());
        }
        String data = ((i+1)+ "; " + nombre + "; " + cargo + "; " + genero + "; " + estado +"\n");
        fw.write(data);
        System.out.println("Empleado Registrado Exitosamente");
    }

    @Override
    public String toString() {
        return "Artista{" +
                "generomusical='" + generomusical + '\'' +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", estadoEmpleado='" + estadoEmpleado + '\'' +
                '}';
    }
}
