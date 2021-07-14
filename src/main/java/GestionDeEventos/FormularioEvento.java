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
        boolean verificadorCompletitudDatos=verificador.verificarCompletitudDatos(dato);
        boolean verificadorDatos=verificador.verificarDatos(dato);
        return verificadorCompletitudDatos && verificadorDatos;
    }

    public void obtenerValores(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la fecha del evento en el formato AAAA/MM/DD:");
        fecha=sc.nextLine();
        notificar(fecha);

        System.out.println(listaLugar.mostrarLugares().toString()+"\n Escoga el número del lugar disponible:");
        ArrayList lugaresDisponibles=listaLugar.mostrarLugaresDisponibles(fecha);
        System.out.println(obtenerListaEnStringPresentacion(lugaresDisponibles));
        String lugarElegido=sc.nextLine();
        notificar(lugarElegido+"");
        lugar=lugaresDisponibles.get(Integer.parseInt(lugarElegido)).toString();

        System.out.println("Ingrese el nombre del evento:");
        nombre=sc.nextLine();
        notificar(nombre);

        System.out.println("Ingrese el tipo de evento:");
        tipoDeEvento=sc.nextLine();
        notificar(tipoDeEvento);

    }

    private String obtenerListaEnStringPresentacion(ArrayList lugaresDisponibles) {
        String auxiliar="";
        for (int i = 0; i< lugaresDisponibles.size(); i++) {
            auxiliar +=i+". "+ lugaresDisponibles.get(i).toString()+"\n";
        }
        return auxiliar;
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