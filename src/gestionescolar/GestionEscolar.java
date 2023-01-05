package gestionescolar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//import java.io.*;

/**
 *
 * @author Jean
 */
public class GestionEscolar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        
        // MÓDULO 1: GENERADOR DE NOMBRES
        
        int aleatorio1, aleatorio2, aleatorio3, aleatorio4;
        int edadAleatoria;
        
        String [] ap1 ={"Hernandez","Garcia","Martinez","Lopez","Gonzalez","Perez","Rodriguez","Sanchez","Ramirez","Cruz",
                        "Flores","Gomez","Morales","Vazquez","Reyes","Jimenez","Torres","Diaz","Gutierrez","Ruiz",
                        "Mendoza","Aguilar","Ortiz","Moreno","Castillo"};
        String [] ap2 ={"Romero","Alvarez","Mendez","Chavez","Rivera","Juarez","Ramos","Dominguez","Herrera","Medina",
                        "Castro","Vargas","Guzman","Velazquez","Rojas","Contreras","Salazar","Luna","Ortega","Santiago",
                        "Guerrero","Estrada","Bautista","Cortes","Soto"};
        String [] nom1 ={"Aike", "Aymar", "Alexis", "Andy", "Aran","Akira","Artis","Cameron","Asuncion","Charlie",
                        "Concepcion","Gili","Cris","Denis","Eider","Francis","Harper","Jade","Jessie","Joss",
                        "Lucian","Marlon","Lujan","Milan","Morgan"};
        String [] nom2 ={"Zuri","Yeray","Santana","Sagrario","Tyler","Trinidad","Robin","Noa","Neftali","Nain",
                        "Arden","Avery","Blair","Dagomar","Dallas","Dani","Darcy","Eden","Jean","Irem",
                        "Jazz","Kai","Mel","Uri","Rain"};
        
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String[] dir = leerDirecciones();
        
        for (int i = 0; i < 500; i++) {
            edadAleatoria = (int)(Math.random()*(10)+18);
            aleatorio1 = (int) (Math.random() * 25);
            aleatorio2 = (int) (Math.random() * 25);
            aleatorio3 = (int) (Math.random() * 25);
            aleatorio4 = (int) (Math.random() * 25);
            
            Alumno alu = new Alumno();
            alu.setNombre1(nom1[aleatorio1]);
            alu.setNombre2(nom2[aleatorio2]);
            alu.setApellido1(ap1[aleatorio3]);
            alu.setApellido2(ap2[aleatorio4]);
            alu.setDireccion(dir[i]);
            alu.setEdad(edadAleatoria);
            alu.calcularIndicadorEsc();
            alu.setNumCuenta(3001+i);   //El numero de cuenta será lineal e irá del 3001 al 3500
            
            alumnos.add(i,alu); 
        }
        
        //Turno(alumnos);
        
        //  IMPRIME ALUMNOS
        /*
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println("\n================================================================");
            System.out.println("\t\t\t( Alumno "+(i+1)+" )");
            System.out.println(alumnos.get(i));
            alumnos.get(i).impTiraMaterias();
        }/**/
        
        
        //MÓDULO 4: CRUD -> crear buscar actualizar borrar 
        System.out.println("\n");
        System.out.println("    ##################################### INICIO #####################################");
        System.out.println("\n");
        int op;
        do{
            System.out.println("          |-------------------------------------------------------------------|");
            System.out.println("          |                         ° MENU PRINCIPAL°                         |");
            System.out.println("          |-------------------------------------------------------------------|");
            System.out.println("          |          Estás por acceder al programa de FI Simulator            |");
            System.out.println("          |                                                                   |");
            System.out.println("          |                        Entrar como:                               |");
            System.out.println("          |                   1. Estudiante                                   |");
            System.out.println("          |                   2. Administración Escolar                       |");
            System.out.println("          |                   3. Salir                                        |");
            System.out.println("          |-------------------------------------------------------------------|");

            Scanner t = new Scanner(System.in);

            System.out.println("Ingrese una opcion: ");
            op = t.nextInt();
        
        
            switch (op) {
                case 1:             
                    Crud a = new Crud();
                    a.menuAlumno(alumnos);
                    break;
                case 2:                    
                    Crud c = new Crud();
                    c.menu(alumnos);
                    break;
                default:
                    System.out.println("Hasta luego usuario!!");
                    break;
            }
        }while(op>0 && op<3);
    }
    
    private static String[] leerDirecciones(){
        // Leer direcciones del txt
        String[] direcciones = new String[505];
        FileReader archivo;
        BufferedReader lector;
        
        try{
            archivo = new FileReader("direcciones.txt");
            if(archivo.ready()){
               lector = new BufferedReader(archivo); 
               String cadena;
               
               int i = 0;
               while(((cadena = lector.readLine()) != null ) && (i < 505)){ //Modificar el tamaño cuando haya mas direcciones
                   //System.out.println(cadena);
                   direcciones[i] = cadena;
                   i++;   
               }
            }else{
                System.out.println("El archino no se puede leer");
            }
            
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return direcciones;
        /* ######################################################################################### */
    }
    
    
}
