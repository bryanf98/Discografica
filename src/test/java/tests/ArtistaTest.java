package tests;

import GestionDeEventos.*;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArtistaTest extends Empleado {


    @Test
    public void registrar_artista_leer_archivo_then_ok() throws IOException {
        String path="src/main/java/GestionDeEventos/empleados.txt";
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
        String path="src/main/java/GestionDeEventos/empleados.txt";
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
}