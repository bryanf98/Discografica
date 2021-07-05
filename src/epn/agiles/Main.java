package epn.agiles;

import GestionDeEventos.*;
import jdk.jfr.Event;

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
            empleado.registrarEmpleado(formulario);
        }


        //registrar un evento
        Evento evento=new Evento();
        FormularioEvento formularioEv = new FormularioEvento();
        formularioEv.obtenerValores();
        evento.crearEvento(formularioEv);
    }


}
