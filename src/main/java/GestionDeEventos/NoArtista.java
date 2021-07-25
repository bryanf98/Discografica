package GestionDeEventos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NoArtista extends Empleado{

    public NoArtista(String nombreEmpleado, String cargo, String estadoEmpleado,int idLugar) {
        super(nombreEmpleado,cargo,estadoEmpleado,idLugar);
    }
    public NoArtista(){}


    public static File fichero_empleados = new File("src/main/java/GestionDeEventos/empleados.txt");

    public boolean registrarEmpleado(FormularioEmpleados formulario) {
        this.nombreEmpleado = formulario.nombre;
        this.estadoEmpleado = formulario.estado;
        this.cargo = formulario.cargo;
        if(escribirDatosNoArtista())
            return true;
        return false;
    }

    public boolean escribirDatosNoArtista() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(fichero_empleados.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            if(ingresarEnArchivoNoArtista(fw)==1){
                System.out.println("Empleado Registrado Exitosamente");
            }
        } catch (Exception ex) {
            System.out.println("No se puede registrar el empleado");
            return false;
        } finally {
            try {
                cerrarArchivosNoArtista(bw, fw);
            } catch (Exception ex) {
                ex.printStackTrace();}
            return true;
        }
    }

    private void cerrarArchivosNoArtista(BufferedWriter bw, FileWriter fw) throws IOException {
        if (bw != null)
            bw.close();
        if (fw != null)
            fw.close();
    }

    public int ingresarEnArchivoNoArtista(FileWriter fw) throws IOException {

            try {
                int numeroDeLineas = contarLineas(fichero_empleados.getPath());
                String data = ((numeroDeLineas + 1) + ";" + nombreEmpleado + ";" + cargo + ";" + estadoEmpleado + ";" + idLugar + ";" + "N" + "\n");
                fw.write(data);
                System.out.println("Empleado Registrado Exitosamente");
                return 0;
            } catch (Exception e) {
                System.out.println(e.toString());
                return 1;
            }


    }

    public int contarLineas(String path) {

        File documento = null;
        FileReader fr = null;
        BufferedReader br = null;
        int lineas=0;
        try {
            documento = new File(path);
            fr = new FileReader(documento);
            br = new BufferedReader(fr);
            lineas=(int)br.lines().count();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lineas;
    }

    @Override
    public String toString() {
        return "NoArtista{" +
                "nombreEmpleado='" + nombreEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", estadoEmpleado='" + estadoEmpleado + '\'' +
                ", idLugar=" + idLugar +
                '}';
    }

    public String toStringComoArrayList() {
        return "[" +
                "nombreEmpleado='" + nombreEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", estadoEmpleado='" + estadoEmpleado + '\'' +
                ", idLugar=" + idLugar +
                "]";
    }
}
