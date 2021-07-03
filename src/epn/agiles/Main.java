package epn.agiles;

import GestionDeEventos.Artista;
import GestionDeEventos.Empleado;
import GestionDeEventos.FormularioEmpleados;

import java.io.*;

public class Main {

    public static void main(String [] arg) {
        //registrar un empleado
        Empleado empleado;
        FormularioEmpleados formulario = new FormularioEmpleados();
        formulario.obtenerValores();
        if(formulario.getTipoDeEmpleado().equals("Artista")){
            empleado=new Artista();
            empleado.registrarEmpleado(formulario);
        }
        else{
            empleado=new NoArtista();
            //empleado.registrarEmpleado(formulario);
        }
        //registrar un evento

    }
}
