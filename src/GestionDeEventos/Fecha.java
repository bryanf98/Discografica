import java.io.*;

public class Fecha {

    String dia;
    String mes;
    String ano;

    public static void seleccionaFecha()
    {
        //--ano/mes/dia- 1998/08/05
        File fechas = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fechas = new File ("F:\\Universidad\\6-7\\Metodologias Ágiles\\Discografica\\src\\GestionDeEventos\\fechas.txt");
            fr = new FileReader (fechas);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }

    }



    public static void main(String [] arg) {
        seleccionaFecha();
    }

}