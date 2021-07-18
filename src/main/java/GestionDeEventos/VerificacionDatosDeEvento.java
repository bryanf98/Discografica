package GestionDeEventos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificacionDatosDeEvento implements VerificacionDatos{

    @Override
    public boolean refresh() {
        return false;
    }

    @Override
    public boolean verificarCompletitudDatos(String dato) {

        return !dato.equals("");
    }

    @Override
    public boolean verificarDatos(String dato) {
        Pattern pattern = Pattern.compile("[!¡=@#$%^&*(),.?\":{}|<>]");
        Matcher matcher = pattern.matcher(dato);
        return  !matcher.find();

    }
}