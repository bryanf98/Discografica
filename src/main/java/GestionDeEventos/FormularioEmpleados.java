package GestionDeEventos;

import java.util.ArrayList;
import java.util.Scanner;

public class FormularioEmpleados {

    String nombre;
    String cargo;
    String estado;
    String tipoDeEmpleado;
    String generoMusical;
    int idLugar;
    VerificacionDatos verificador;

    public boolean notificar(String dato){
        boolean verificadorCompletitudDatos=verificador.verificarCompletitudDatos(dato);
        boolean verificadorDatos=verificador.verificarDatos(dato);
        return verificadorCompletitudDatos && verificadorDatos;
    }

    public void obtenerValores(){
        tipoDeEmpleado="No Artista";
        Scanner sc = new Scanner(System.in);
        System.out.println("¿El nuevo empleado es un artista? Responda \"y\" para sí o \"n\" para no");
        String auxiliarTipoDeEmpleado=sc.nextLine();
        notificar(auxiliarTipoDeEmpleado);

        if(auxiliarTipoDeEmpleado.equalsIgnoreCase("y")){
            tipoDeEmpleado="Artista";
            System.out.println("Ingrese el género del artista:");
            generoMusical=sc.nextLine();
        }

        System.out.println("Ingrese el nombre del empleado:");
        nombre=sc.nextLine();
        System.out.println("Ingrese el cargo del empleado:");
        cargo=sc.nextLine();
        estado="Activo";
    }

    public FormularioEmpleados() {
        verificador= new VerificacionDatosDeEmpleado();
    }
    public FormularioEmpleados(String nombre,String cargo,String estado,String tipoDeEmpleado,String generoMusical,int Lugar) {
        verificador= new VerificacionDatosDeEmpleado();
        this.nombre=nombre;
        this.estado=estado;
        this.tipoDeEmpleado=tipoDeEmpleado;
        this.generoMusical=generoMusical;
        this.idLugar=Lugar;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoDeEmpleado() {
        return tipoDeEmpleado;
    }

    public void setTipoDeEmpleado(String tipoDeEmpleado) {
        this.tipoDeEmpleado = tipoDeEmpleado;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
}