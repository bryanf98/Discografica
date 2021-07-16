package epn.agiles;

import GestionDeEventos.*;
import jdk.jfr.Event;

import java.io.*;

public class Discográfica {

    public static void main(String [] arg) {
        //Caso de prueba 3 mostrar lugares con empleados
        ListaLugar lugar = new ListaLugar();
        System.out.println(lugar.mostrarLugares());

/*


        //Caso de prueba 1 registrar un empleado
	//¿El empleado es artista?:"n"
	//Nombre:"Rick Rubin"
	//Cargo:"Ingeniero de Sonido"

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


        //Caso de prueba 2 regisrtar un evento
	//Ingreso de datos:
	//Fecha: "2021/09/22"
	//Lugar:"2"
	//Nombre de evento:"Concierto Radiohead Segunda Fecha"
	//Tipo de Evento:"Concierto"
        Evento evento=new Evento();
        FormularioEvento formularioEv = new FormularioEvento();
        formularioEv.obtenerValores();
        evento.crearEvento(formularioEv);



 */
    }


}
