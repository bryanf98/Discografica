package tests;

import GestionDeEventos.ListaDeEmpleados;
import GestionDeEventos.NotificarSMS;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ListaDeEmpleadosTest {

    @Test
    public void give_notificar_when_is_correct_then_ok() {
        NotificarSMS notificacion = Mockito.mock(NotificarSMS.class);
        ListaDeEmpleados lista = new ListaDeEmpleados(notificacion);
        Mockito.when(notificacion.notificarSMS(Mockito.any())).
                thenReturn(true);
        assertTrue(lista.notificar(lista.mostrarEmpleado()));

    }

    @Test
    public void give_notificar_when_is_wrong_then_error() {
        NotificarSMS notificacion = Mockito.mock(NotificarSMS.class);
        ListaDeEmpleados lista = new ListaDeEmpleados(notificacion);
        Mockito.when(notificacion.notificarSMS(Mockito.any())).
                thenReturn(false);
        assertFalse(lista.notificar(lista.mostrarEmpleado()));

    }
}