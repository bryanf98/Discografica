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
    public void registrar_artist_when_input_in_formulario_then_ok() throws IOException {
        Empleado artista = new Artista();
        FormularioEmpleados formulario = new FormularioEmpleados("Rivers Cuomo","Guitarrista Principal",
                "Activo","Artista","Surf Rock",1);
        artista.registrarEmpleado(formulario);
        assertEquals(true, false);
    }

    @Test
    public void registrar_artista_leer_archivo_then_ok() throws IOException {
        String path="src/main/java/GestionDeEventos/empleados.txt";
        Artista artista = new Artista();
        artista.setNombreEmpleado("Jonny Greenwood");
        artista.setCargo("Productor");
        artista.setEstadoEmpleado("Activo");
        artista.setGeneromusical("Todos");
        artista.ingresarEnArchivo(artista.getNombreEmpleado(),artista.getEstadoEmpleado(),artista.getCargo(),
                artista.getGeneromusical(),4,new FileWriter("src/main/java/GestionDeEventos/empleados.txt"
                        ,true));

        ListaDeEmpleados lista = new ListaDeEmpleados();
        lista.mostrarEmpleado();
        assertEquals(lista.getListaEmpleados().get(lista.getListaEmpleados().size()-1).toStringComoArrayList(),
                artista.toStringComoArrayList());
    }

    @Test
    public void registrar_noartist_when_input_in_formulario_then_ok() throws IOException {
        Empleado empleado = new NoArtista();
        FormularioEmpleados formulario = new FormularioEmpleados("Juan Pablo","Procutor de Espectáculos",
                "Activo","N","",5);
        empleado.registrarEmpleado(formulario);
        assertEquals(true, false);
    }

    @Test
    public void registrar_noartista_leer_archivo_then_ok() throws IOException {
        String path="src/main/java/GestionDeEventos/empleados.txt";
        NoArtista noArtista = new NoArtista();
        noArtista.setNombreEmpleado("Jonny Greenwood");
        noArtista.setCargo("Productor");
        noArtista.setEstadoEmpleado("Activo");
        noArtista.ingresarEnArchivoNoArtista(new FileWriter("src/main/java/GestionDeEventos/empleados.txt"
                ,true));

        ListaDeEmpleados lista = new ListaDeEmpleados();
        lista.mostrarEmpleado();
        assertEquals(lista.getListaEmpleados().get(lista.getListaEmpleados().size()-1).toStringComoArrayList(),
                noArtista.toStringComoArrayList());
    }
}