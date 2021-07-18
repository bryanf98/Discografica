package tests;

import GestionDeEventos.Fisico;
import GestionDeEventos.ListaLugar;
import GestionDeEventos.Lugar;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import static org.junit.Assert.*;

public class ListaLugarTest {

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
        ListaLugar lugar = new ListaLugar();
        assertTrue(lugar.comprobarArchivo(new File("src/main/java/GestionDeEventos/empleados.txt")));
    }

    @Test(timeout = 1)
    public void given_file_when_comprobate_file_exist_then_timeout(){
        ListaLugar lugar = new ListaLugar();
        assertTrue(lugar.comprobarArchivo(new File("src/main/java/GestionDeEventos/empleados.txt")));
    }

    @Test
    public void given_file_when_comprobate_file_not_exist_then_false(){
        ListaLugar lugar = new ListaLugar();
        assertFalse(lugar.comprobarArchivo(new File("src/main/java/GestionDeEventos/empleados.txt")));
    }

    /*@Test
    public void given_when_then(){
        ListaLugar lugar = new ListaLugar();
        assertEquals(1, lugar.cerrarLecturaArchivo(Scanner));
    }*/


}