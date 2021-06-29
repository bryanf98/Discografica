package GestionDeEventos;

public class VerificacionDatosDeEmpleado implements VerificacionDatos{

    @Override
    public boolean refresh() {
        return false;
    }

    @Override
    public boolean verificarCompletitudDatos() {
        return false;
    }

    @Override
    public boolean verificarDatos() {
        return false;
    }
}