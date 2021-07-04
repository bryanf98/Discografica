package GestionDeEventos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FormularioEvento {
    String nombre;
    String tipoDeEvento;
    String fecha;
    String lugar;
    VerificacionDatos verificador;
    ListaLugar listaLugar;


    public boolean notificar(String dato){
        return verificador.verificarCompletitudDatos(dato) && verificador.verificarDatos(dato);
    }

    public void obtenerValores(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la fecha del evento en el formato DD/MM/AAAA:");
        fecha=sc.nextLine();
        notificar(fecha);

        System.out.println(listaLugar.mostrarLugares().toString()+"\n Escoga el número del lugar disponible:");
        String[] lugaresDisponibles=listaLugar.mostrarLugares();
        String auxiliar="";
        for (int i=0;i<lugaresDisponibles.length;i++) {
            auxiliar+=i+". "+lugaresDisponibles[i]+"\n";
        }
        String lugar=sc.nextLine();
        notificar(lugar);
        System.out.println("Ingrese el nombre del evento:");
        nombre=sc.nextLine();
        notificar(nombre);

        System.out.println("Ingrese el tipo de evento:");
        tipoDeEvento=sc.nextLine();
        notificar(tipoDeEvento);

    }

    public FormularioEvento() {
        verificador=new VerificacionDatosDeEvento();
        this.listaLugar = new ListaLugar();
    }

    //Preguntar este contructor
    public FormularioEvento(ListaLugar listaLugar) {
        this.listaLugar = new ListaLugar();
    }
}