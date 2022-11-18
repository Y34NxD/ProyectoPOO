package proyectopoo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EquipoD
 */
public class ProyectoPOO {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int edad;
        edad = (int)(Math.random()*(10)+18);
        Alumno alu = new Alumno();
        alu.setEdad(edad);
        System.out.println(alu.getEdad());
        System.out.println(alu.getSemestre());
        System.out.println(alu.getListaMaterias(alu.getSemestre()));
        
        //int i = 0;
        //String nomMaterias[] = null;
        
         /*   FileReader fr;
        try {
            fr = new FileReader("ListaMaterias.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            
            //  String Tokinizer
            //StringTokenizer tokenizador = new StringTokenizer(linea,"\n");
            while(linea != null){
                //String token = tokenizador.nextToken();
                //System.out.println(token);
                System.out.println(""+(i+1)+" "+linea);
                linea = br.readLine();
                //nomMaterias[i] = token;
                i++;
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProyectoPOO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProyectoPOO.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
            
        
        
        
        
        
        
        
    }
    
}
