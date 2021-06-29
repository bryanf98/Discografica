package GestionDeEventos;

public abstract class Lugar{
    String nombre;
    //ListaDeEmpleados listaDeEmpleados;
    boolean estado;

    public abstract void registrarLugar();
    public abstract void modificarLugar();
  }