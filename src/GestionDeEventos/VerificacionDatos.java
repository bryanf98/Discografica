package GestionDeEventos;

public interface VerificacionDatos {
    public abstract boolean refresh();
    public abstract boolean verificarCompletitudDatos(String dato);
    public abstract boolean verificarDatos(String dato);

}