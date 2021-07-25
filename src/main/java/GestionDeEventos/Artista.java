package GestionDeEventos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Artista extends Empleado{

    String generomusical;

    public Artista(String generomusical,String nombreEmpleado, String cargo, String estadoEmpleado,int idLugar) {
        super(nombreEmpleado,cargo,estadoEmpleado,idLugar);
        this.generomusical=generomusical;
    }

    public Artista(){}


    public static File fichero_empleados = new File("src/main/java/GestionDeEventos/empleados.txt");


    public boolean registrarEmpleado(FormularioEmpleados formulario) {
        this.nombreEmpleado = formulario.nombre;
        this.estadoEmpleado = formulario.estado;
        this.cargo = formulario.cargo;
        this.generomusical = formulario.generoMusical;
        this.idLugar=formulario.idLugar;
        if(escribirDatosArtista(nombreEmpleado, estadoEmpleado, cargo, generomusical,idLugar))
            return true;
        return false;
    }

    public boolean escribirDatosArtista(String nombre, String estado, String cargo, String genero,int lugar) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(fichero_empleados.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            if(ingresarEnArchivo(nombre, estado, cargo, genero, lugar,fw)==0){
                System.out.println("Empleado Registrado Exitosamente");
            }
        } catch (Exception ex) {
            System.out.println("No se puede registrar el empleado");
            return false;
        } finally {
            cerrarArchivo(bw, fw);
            return true;
        }
    }

    private void cerrarArchivo(BufferedWriter bw, FileWriter fw) {
        //Cierra instancias de FileWriter y BufferedWriter
        try {
        if (bw != null)
            bw.close();
        if (fw != null)
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int ingresarEnArchivo(String nombre, String estado, String cargo, String genero, int lugar,FileWriter fw) throws IOException {
        //Cuento el número de líneas
        int mensaje = 0;
        int i = 1;
        try  {
            Scanner entrada = new Scanner(fichero_empleados);
            while (entrada.nextLine()!= null) {
                if(entrada.hasNextLine()){
                    i = i+1;
                    mensaje = 1;
                }
                else{
                    break;
                }
            }
            String data = ((i+1)+ ";" + nombre + ";" + cargo + ";" + genero + ";" + estado +";"+idLugar+";"+"A"+"\n");
            fw.write(data);
        }catch (Exception e) {
            System.out.println(e.toString());
            mensaje=0;
        }
        return mensaje;
    }

    public String getGeneromusical() {
        return generomusical;
    }

    public void setGeneromusical(String generomusical) {
        this.generomusical = generomusical;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "generomusical='" + generomusical + '\'' +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", estadoEmpleado='" + estadoEmpleado + '\'' +
                ", idLugar=" + idLugar +
                '}';
    }

    public String toStringComoArrayList() {
        return "[" +
                "generomusical='" + generomusical + '\'' +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", cargo='" + cargo + '\'' +
                ", estadoEmpleado='" + estadoEmpleado + '\'' +
                ", idLugar=" + idLugar +
                "]";
    }


}
