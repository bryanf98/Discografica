package tests;

import GestionDeEventos.VerificacionDatosDeEmpleado;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(value = Parameterized.class)
public class VerificacionDatosDeEmpleadoTestCompletitud {
    private String dato;
    private Boolean expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{"",false});
        objects.add(new Object[]{"Algo",true});
        return objects;
    }

    public VerificacionDatosDeEmpleadoTestCompletitud(String dato, Boolean expected) {
        this.dato = dato;
        this.expected = expected;
    }

    @Test
    public void give_parameters_when_verificarCompletitud_then_ok() {
        VerificacionDatosDeEmpleado verificador = new VerificacionDatosDeEmpleado();
        Boolean actual=verificador.verificarCompletitudDatos(dato);
        assertEquals(expected,actual);
    }


}