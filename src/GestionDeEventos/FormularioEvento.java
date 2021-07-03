package GestionDeEventos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FormularioEvento {
    String nombre;
    String tipoDeEvento;
    String fecha;
    VerificacionDatos verificador;
    ListaLugar listaLugar;


    public boolean notificar(){
        return true;
    }

    public void obtenerValores(){
        System.out.println("Ingrese el nombre del evento:");
        Scanner sc = new Scanner(System.in);
        nombre=sc.nextLine();
        System.out.println("Ingrese el tipo de evento:");
        tipoDeEvento=sc.nextLine();
        System.out.println("Ingrese la fecha del evento en el formato DD/MM/AAAA:");
        fecha=sc.nextLine();
        System.out.println(listaLugar.mostrarLugares().toString()+"\n Escoga el número del lugar disponible:");
        datosLeidos.add(sc.nextLine());
    }

    public FormularioEvento(ListaLugar listaLugar) {
        this.listaLugar = new ListaLugar();
    }
}