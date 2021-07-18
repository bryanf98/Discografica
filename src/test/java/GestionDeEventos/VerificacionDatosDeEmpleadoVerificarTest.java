package GestionDeEventos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class VerificacionDatosDeEmpleadoVerificarTest {
    private String dato;
    private Boolean expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{"CadenaCon!",false});
        objects.add(new Object[]{"Algo",true});
        objects.add(new Object[]{"",true});
        objects.add(new Object[]{"Cadenacon\"",false});
        objects.add(new Object[]{" =  Cadena "  ,false});
        objects.add(new Object[]{"|",false});
        objects.add(new Object[]{". que es ?",false});
        return objects;
    }
    public VerificacionDatosDeEmpleadoVerificarTest(String dato, Boolean expected) {
        this.dato = dato;
        this.expected = expected;
    }
    @Test
    public void give_parameters_when_verificar_then_ok() {
        VerificacionDatosDeEmpleado verificador = new VerificacionDatosDeEmpleado();
        Boolean actual=verificador.verificarDatos(dato);
        assertEquals(expected,actual);
    }
}