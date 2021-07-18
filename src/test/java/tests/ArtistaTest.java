package tests;

import GestionDeEventos.Artista;
import GestionDeEventos.Empleado;
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
    public void give_artist_data_when_input_in_file_then_ok() throws IOException {
        Artista artista = new Artista();
        int expected = 1;
        int actual = artista.ingresarEnArchivo("David", "Activo", "Cantante", "Opera", new FileWriter(new File("src/main/java/GestionDeEventos/empleados.txt"), true));
        assertEquals(expected, actual);
    }


    /*@Test
    public void given_artist_data_when_write_data_then_ok(){
        Artista artista = new Artista();
        String expected = "true";
        String actual = artista.escribirDatosArtista("Francisco", "Inactivo", "Compositor", "Electrónica");
        assertTrue(expected, actual);
    }*/

}