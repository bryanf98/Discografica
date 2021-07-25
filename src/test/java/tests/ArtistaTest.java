package tests;

import GestionDeEventos.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArtistaTest extends Empleado {


    @Test
    public void registrar_artista_leer_archivo_then_ok() throws IOException {
        String path="src/resources/empleados.txt";
        Artista artista = new Artista();
        artista.setNombreEmpleado("Jonny Greenwood");
        artista.setCargo("Productor");
        artista.setEstadoEmpleado("Activo");
        artista.setGeneromusical("Todos");
        artista.setIdLugar(4);
        artista.escribirDatosArtista(artista.getNombreEmpleado(),artista.getEstadoEmpleado(),artista.getCargo(),
                artista.getGeneromusical(),4);

        ListaDeEmpleados lista = new ListaDeEmpleados();
        lista.mostrarEmpleado();
        assertEquals(artista.toStringComoArrayList(),
                lista.getListaEmpleados().get(lista.getListaEmpleados().size()-1).toStringComoArrayList());
    }


    @Test
    public void registrar_noartista_leer_archivo_then_ok() throws IOException {
        String path="src/resources/empleados.txt";
        NoArtista noArtista = new NoArtista();
        noArtista.setNombreEmpleado("Juan Pablo");
        noArtista.setCargo("Productor de Espectáculos");
        noArtista.setEstadoEmpleado("Activo");
        noArtista.setIdLugar(5);
        noArtista.escribirDatosNoArtista();

        ListaDeEmpleados lista = new ListaDeEmpleados();
        lista.mostrarEmpleado();
        assertEquals(noArtista.toStringComoArrayList(),
                lista.getListaEmpleados().get(lista.getListaEmpleados().size()-1).toStringComoArrayList());
    }

    @Test
    public void give_autorizar_when_is_correct_then_ok() {
        AutorizadorDeArtista autorizacion = Mockito.mock(AutorizadorDeArtista.class);
        Artista artista = new Artista(autorizacion);
        Mockito.when(autorizacion.autorizar(Mockito.any())).
                thenReturn(true);
        artista.setNombreEmpleado("Benito Martinez");
        artista.setCargo("Percusión");
        artista.setEstadoEmpleado("No Activo");
        artista.setGeneromusical("Post-Rock/Reggaeton");
        artista.setIdLugar(2);
        assertTrue(artista.preguntarPorAutorizacion(artista.toString()));

    }
}