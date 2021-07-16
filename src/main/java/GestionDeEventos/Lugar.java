package GestionDeEventos;

public abstract class Lugar{
    String nombre;
    ListaDeEmpleados listaDeEmpleados;
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
        for(Empleado empleado:listaDeEmpleados.listaEmpleados){
            if(id==empleado.idLugar){
                cadenaDeRetorno+="\n\t"+ empleado.toString();
            }
        }
        return cadenaDeRetorno;
    }
  }