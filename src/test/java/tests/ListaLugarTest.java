package tests;

import GestionDeEventos.Fisico;
import GestionDeEventos.ListaLugar;
import GestionDeEventos.Lugar;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import static org.junit.Assert.*;

public class ListaLugarTest {

    String path = "src/main/java/GestionDeEventos/empleados.txt";
    String nopath = "src/main/java/GestionDeEventos/empleados1.txt";
    ListaLugar lugar = new ListaLugar();

    @Test
    public void given_mostrarLugares() {
    }


    @Test
    public void mostrar_lugares_test_fail(){

                ListaLugar listalugar = new ListaLugar();
                listalugar.mostrarLugares();
                fail("Con fail(), digo que quiero que falle mi metodo, en este caso fallará en la linea 35");
    }

    @Test
    public void given_file_when_comprobate_file_exist_then_true(){
        assertTrue(lugar.comprobarArchivo(new File(path)));
    }

    @Test(timeout = 1)
    public void given_file_when_comprobate_file_exist_then_timeout(){
        assertTrue(lugar.comprobarArchivo(new File(path)));
    }

    @Test
    public void given_file_when_comprobate_file_not_exist_then_false(){
        assertFalse(lugar.comprobarArchivo(new File(nopath)));
    }

    @Test
    public void given_File_when_close_file_then_ok() throws FileNotFoundException {
        assertEquals(1, lugar.cerrarLecturaArchivo(new Scanner(new File(path))));
    }

    @Test
    public void given_return_places_when_know_places_then_no_equals(){
        ArrayList<Lugar> lugares = new ArrayList<>();
        String lugaresARetornar = "";
        assertNotEquals("",lugar.lugaresRetorno(lugares ,lugaresARetornar));
    }

    @Test
    public void given_date_when_return_places_then_ok(){
        assertEquals(true, lugar.validarFecha("19/02/2021"));
    }
}