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

}