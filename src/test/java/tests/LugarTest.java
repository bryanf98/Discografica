package tests;

import GestionDeEventos.*;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LugarTest {

    @Test
    public void given_Empleado_when_read_lugar_then_ok() {
        Lugar lugar = new Fisico("Cuenca",2);
        lugar.mostrarLugar();

        ArrayList<Empleado> expected=new ArrayList<Empleado>();
        expected.add(new Artista("Rock",
                "Tom Yorke",
                "Baterista",
                "Activo",
                2));
        assertEquals(
                expected.get(0).toString(),
                lugar.getListaDeEmpleados().getListaEmpleados().get(0).toString());
    }
}