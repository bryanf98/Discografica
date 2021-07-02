package GestionDeEventos;

import java.util.ArrayList;
import java.util.Scanner;

public class FormularioEmpleados {
    public static ArrayList datosLeidos = new ArrayList();
    private String nombre;
    private String cargo;
    private String estado;
    private int codigoEmpleado;
    private VerificacionDatos verificador;

    public boolean notificar(){
        return true;
    }


    //retorna los valores ingresados en un array
    public ArrayList obtenerValores(){
        //ArrayList datosLeidos = new ArrayList();
        System.out.println("Ingrese el nombre del empleado:");
        Scanner sc = new Scanner(System.in);
        datosLeidos.add(sc.nextLine());
        System.out.println("Ingrese el cargo del empleado:");
        datosLeidos.add(sc.nextLine());

        //Si el cargo es de Artista, debe preguntarse el género músical?? o de donde saco eso?

        datosLeidos.add("Activo");
        return datosLeidos;
    }
}