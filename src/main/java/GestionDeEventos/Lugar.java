package GestionDeEventos;

public abstract class Lugar{
    String nombre;
    ListaDeEmpleados listaDeEmpleados;
    boolean estado;

    public abstract void registrarLugar(int aforo, String direccion, String dueno);
    public abstract void modificarLugar(String lugar, String lugarModificado);
  }