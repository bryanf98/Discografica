package GestionDeEventos;



public class Empleado{

    String nombreEmpleado;
    String cargo;
    String estadoEmpleado;
    int idLugar;

    public Empleado(String nombreEmpleado, String cargo, String estadoEmpleado,int idLugar) {
        this.nombreEmpleado=nombreEmpleado;
        this.cargo=cargo;
        this.estadoEmpleado=estadoEmpleado;
        this.idLugar=idLugar;
    }

    public Empleado(){}


    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getCargo(){
        return cargo;
    }

    public String getEstadoEmpleado(){
        return estadoEmpleado;
    }

    public void setNombreEmpleado(String nombre){
        this.nombreEmpleado = nombre;
    }

    public void setCargo(String puesto){
        this.cargo = puesto;
    }

    public void setEstadoEmpleado(String estado){
        this.estadoEmpleado = estado;
    }

    public boolean registrarEmpleado(FormularioEmpleados formulario){return true;}

    public String toStringComoArrayList(){return "";};

}
