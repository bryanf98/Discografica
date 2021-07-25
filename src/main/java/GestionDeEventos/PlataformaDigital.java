package GestionDeEventos;

import GestionDeEventos.Lugar;

import javax.swing.*;
import java.io.*;

public class PlataformaDigital extends Lugar {

    public PlataformaDigital(String nombre, int id) {
        super(nombre, id);
    }
    public PlataformaDigital(){
        super();
    }


    @Override
    public void registrarLugar(int aforo, String direccion, String dueno) {

        String lugar = aforo+"-"+direccion+"-"+dueno;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("src/resources/plataformas.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(lugar);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }


    @Override
    public void modificarLugar(String lugar, String lugarModificado) {
        String lineaABorrar=lugar;
        boolean encontrado=false;
        File inputFile = new File("src/resources/plataformas.txt");
        File outputFile = new File("src/resources/plataformasModificar.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                if(currentLine.trim().equalsIgnoreCase(lineaABorrar)){
                    encontrado=true;
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            if(encontrado==true)
            {
                writer.write(lugarModificado);
                writer.close();
                reader.close();
                copiarLugaresModificados();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No se ha encontrado el lugar para modificarlo");
                writer.close();
                reader.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copiarLugaresModificados(){

        String sourceFile="src/resources/plataformasModificar.txt" ;
        String destinationFile="src/resources/plataformas.txt";

        try {
            File inFile = new File(sourceFile);
            File outFile = new File(destinationFile);

            FileInputStream in = new FileInputStream(inFile);
            FileOutputStream out = new FileOutputStream(outFile);

            int c;
            while( (c = in.read() ) != -1)
                out.write(c);

            in.close();
            out.close();
        } catch(IOException e) {
            System.err.println("Hubo un error de entrada/salida!!!");
        }
    }


}