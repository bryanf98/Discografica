package GestionDeEventos;



public class Empleado{

    String nombreEmpleado;
    String cargo;
    String estadoEmpleado;

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

    public void registrarEmpleado(FormularioEmpleados formulario){

    }

}
