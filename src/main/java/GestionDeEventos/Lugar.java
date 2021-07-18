package GestionDeEventos;

import java.util.ArrayList;

public abstract class Lugar{
    String nombre;
    ListaDeEmpleados listaDeEmpleados;//empleados del lugar
    boolean estado;
    int id;

    public Lugar(){

    }
    public Lugar(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public abstract void registrarLugar(int aforo, String direccion, String dueno);
    public abstract void modificarLugar(String lugar, String lugarModificado);
    public  String mostrarLugar(){
        String cadenaDeRetorno="\n" ;
        cadenaDeRetorno+=nombre;
        listaDeEmpleados=new ListaDeEmpleados();
        listaDeEmpleados.mostrarEmpleado();
        ArrayList<Empleado> auxiliar = new ArrayList<Empleado>();//auxiliar para setear empleados en este objeto

        for(Empleado empleado:listaDeEmpleados.listaEmpleados){
            if(id==empleado.idLugar){
                cadenaDeRetorno+="\n\t"+ empleado.toString();
                auxiliar.add(empleado);
            }
        }
        listaDeEmpleados.setListaEmpleados(auxiliar);//seteo empleados de este objeto en particular
        return cadenaDeRetorno;
    }

    public ListaDeEmpleados getListaDeEmpleados() {
        return listaDeEmpleados;
    }
}