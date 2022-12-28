package gestionescolar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jean
 */
public class Crud {
    
    public void menu(ArrayList<Alumno> alumnos){
        int op;
        do{
            System.out.println("          |-------------------------------------------------------------------|");
            System.out.println("          |                           MENU ADMIN ESCOLAR                      |");
            System.out.println("          |-------------------------------------------------------------------|");
            System.out.println("          |                        1. Agregar estudiante                      |");
            System.out.println("          |                        2. Mostrar Alumno                          |");
            System.out.println("          |                        3. Actualizar datos de un estudiante       |");
            System.out.println("          |                        4. Eliminar registro de un estudiante      |");
            System.out.println("          |                        5. Generar CSV                             |");
            System.out.println("          |                        6. Mostrar lista de alumnos                |");
            System.out.println("          |                        7. Salir                                   |");
            System.out.println("          |-------------------------------------------------------------------|");

            Scanner t = new Scanner(System.in);
            
            System.out.println("Ingrese una opcion");
            op = t.nextInt();

            switch(op){
                case 1: 
                    insertarAlumno(alumnos);
                    break; 
                case 2:
                    int pos = buscarAlumno(alumnos);
                    if(pos != -1)
                        mostrarAlumno(alumnos.get(pos));
                    else
                        System.out.println("=== No. cuenta no existe ====");
                    break;
                case 3:
                    modificarAlumno(alumnos);
                    break;
                case 4:
                    eliminarAlumno(alumnos);
                    break;
                case 5:
                    salidaCsv(alumnos);
                    break;
                case 6:
                    mostrarAlumnos(alumnos);
                    break;
                default:
                    System.out.println("Hasta luego Admin!!");
                    break;
            }
        }while(op>0 && op<7);
    }
    
    public void insertarAlumno(ArrayList<Alumno> alumnos) {
                
        int edadAleatoria;
        String dir,nom1,nom2,ap1,ap2;
        Scanner s = new Scanner(System.in);
        
        edadAleatoria = (int)(Math.random()*(10)+18);
        
        Alumno nuevoAlu = new Alumno();
        int nuevoNumCuenta = (alumnos.get(alumnos.size()-1).getNumCuenta())+1;
              
        System.out.println("Ingrese el primer nombre del alumno: ");
        nom1 = s.nextLine();
        System.out.println("Ingrese el segundo nombre del alumno: ");
        nom2 = s.nextLine();
        System.out.println("Ingrese el primer apellido del alumno: ");
        ap1 = s.nextLine();
        System.out.println("Ingrese el segundo apellido del alumno: ");
        ap2 = s.nextLine();
        System.out.println("Ingrese la direccion del alumno (Sin comas): ");
        dir = s.nextLine();
        nuevoAlu.setNombre1(nom1);
        nuevoAlu.setNombre2(nom2);
        nuevoAlu.setApellido1(ap1);
        nuevoAlu.setApellido2(ap2);
        nuevoAlu.setDireccion(dir);
        nuevoAlu.setEdad(edadAleatoria);
        nuevoAlu.calcularNumInscri();
        nuevoAlu.setNumCuenta(nuevoNumCuenta);   //El numero de cuenta será lineal y empezará desde el utimo numCuenta creado 
        
        alumnos.add(nuevoAlu); //Lo incerta en la ultima posición
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("    Alumno Creado:");
        mostrarAlumno(nuevoAlu);
        
    }
    
    public void mostrarAlumno(Alumno alu){
        
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("    No. Cuenta: " + alu.getNumCuenta());
        alu.nomCompleto();
        System.out.println("    Edad: " + alu.getEdad());
        System.out.println("    Direccion: " + alu.getDireccion());
        System.out.println("    Semeste: " + alu.getSemestreIdeal());
        System.out.println("    Materias inscritas en Ordi: "+alu.getNumAsigInscriOrdi());
        System.out.println("    Promedio: " + alu.getPromedio());
        System.out.println("    Numero de inscripcion: " + alu.getNumInscrip() );
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println(alu.getTiraMate());
    }

    public void mostrarAlumnos(ArrayList<Alumno> alumnos){
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            System.out.println("    No. Cuenta: " + alumnos.get(i).getNumCuenta());
            alumnos.get(i).nomCompleto();
            System.out.println("    Edad: " + alumnos.get(i).getEdad());
            System.out.println("    Direccion: " + alumnos.get(i).getDireccion());
            System.out.println("    Semeste: " + alumnos.get(i).getSemestreIdeal());
            System.out.println("    Promedio: " + alumnos.get(i).getPromedio());
            System.out.println("    Creditos: " +alumnos.get(i).getCredActual()+ " / " +alumnos.get(i).getCredIngreso());
            System.out.println("    Numero de inscripcion: " + alumnos.get(i).getNumInscrip() );
            System.out.println("-------------------------------------------------------------------------------------------------------------");
        }
    }
    
    public void modificarAlumno(ArrayList<Alumno> alumnos) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        Scanner s4 = new Scanner(System.in);
        Scanner s5 = new Scanner(System.in);
        int numListaMod;
        System.out.println("    Ingrese el numero de cuenta del alumno a modificar: ");
        numListaMod = s.nextInt();
        int pos = posicion(alumnos, numListaMod);
        if(pos != -1){
            String nom1;
            String nom2;
            String ap1;
            String ap2;
            String dir;
            System.out.println("    Ingrese el primer nombre del alumno: ");
            nom1 = s1.nextLine();
            System.out.println("    Ingrese el segundo nombre del alumno: ");
            nom2 = s2.nextLine();
            System.out.println("    Ingrese el primer apellido del alumno: ");
            ap1 = s3.nextLine();
            System.out.println("    Ingrese el segundo apellido del alumno: ");
            ap2 = s4.nextLine();
            System.out.println("    Ingrese la direccion del alumno: ");
            dir = s5.nextLine();

            int edad = alumnos.get(pos).getEdad();
            int semestre = alumnos.get(pos).getSemestreIdeal();
            float promedio = alumnos.get(pos).getPromedio();
            int credIngreso = alumnos.get(pos).getCredIngreso();
            int credActual = alumnos.get(pos).getCredActual();
            int numAsigInscriOrdi = alumnos.get(pos).getNumAsigInscriOrdi();
            float numInscrip = alumnos.get(pos).getNumInscrip();
            float escolaridad = alumnos.get(pos).getEscolaridad();
            float velocidad = alumnos.get(pos).getVelocidad();
            int numCuenta = alumnos.get(pos).getNumCuenta();
            int numAsigApOrdi = alumnos.get(pos).getNumAsigApOrdi();
            
            Alumno nuevoAlu = new Alumno(nom1,nom2,ap1,ap2,edad,numCuenta,quitarComasDir(dir),promedio,credIngreso,
                                    credActual,numAsigInscriOrdi,numInscrip,numAsigApOrdi,semestre,
                                    escolaridad,velocidad);
            nuevoAlu.tiraMaterias();
            alumnos.set(pos, nuevoAlu);
            mostrarAlumno(nuevoAlu); 
        }
        else
            System.out.println("    Numero de cuenta no existe");
    }

    public void eliminarAlumno(ArrayList<Alumno> alumnos) {
        Scanner s = new Scanner(System.in);
        int numCuentaElim;
        System.out.println("Ingrese el numero de cuenta del alumno a eliminar: ");
        numCuentaElim = s.nextInt();
        int pos = posicion(alumnos, numCuentaElim);
        if(pos != -1){
            System.out.println("    Datos del Alumno eliminado:");
            mostrarAlumno(alumnos.remove(pos));
        }
        else
            System.out.println("    Numero de cuenta no existe");
    }

    public void salidaCsv(ArrayList<Alumno> alumnos) {
        //  ========= FileWriter ========
        DecimalFormat frmt = new DecimalFormat();
        frmt.setMaximumFractionDigits(2);
        try {
            FileWriter fw;
            fw = new FileWriter("listaAlumnos.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            
            salida.println("No.Cuenta,Apellido P,Apellido M,Primer Nombre,Segundo Nombre,Edad,Direccion,Promedio,Semestre,Creditos,"
                    + "Asignaturas inscritas en Ordi,Asignaturas aprobadas en Ordi,No. Inscripción,Velocidad,Escolaridad");
            for(int i=0;i<alumnos.size();i++){
                salida.println(""+alumnos.get(i).getNumCuenta()+","+alumnos.get(i).getApellido1()+","+alumnos.get(i).getApellido2()+
                        ","+alumnos.get(i).getNombre1()+","+alumnos.get(i).getNombre2()+","+alumnos.get(i).getEdad()+
                        ","+quitarComasDir(alumnos.get(i).getDireccion())+","+frmt.format(alumnos.get(i).getPromedio())+","+alumnos.get(i).getSemestreIdeal()+
                        ","+alumnos.get(i).getCredActual()+" de "+alumnos.get(i).getCredIngreso()+","+alumnos.get(i).getNumAsigInscriOrdi()+
                        ","+alumnos.get(i).getNumAsigApOrdi()+","+alumnos.get(i).getNumInscrip()+","+alumnos.get(i).getVelocidad()+
                        ","+alumnos.get(i).getEscolaridad());
            }
                        
            salida.close();
            System.out.println("=-=-=-=-=-=-=-=- CSV GENERADO EXITOSAMENTE =-=-=-=-=-=-=-=-=-=-");
        } catch (IOException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String quitarComasDir(String dir){
        //========= FileReader ========
        
        String direccion = "";
        ArrayList<String> Datos = new ArrayList<>();

        //======= StringTokenizer ==========="
        StringTokenizer tokenizador = new StringTokenizer(dir,",");
        while(tokenizador.hasMoreTokens()){
            String token = tokenizador.nextToken();
            Datos.add(token);
        }
        for (int i = 0; i < Datos.size(); i++) {
            direccion += Datos.get(i);
        }
        
        return direccion;
    }
    
    public int posicion(ArrayList<Alumno> alumno, int numCuentaBuscar){
        int posicion = -1;
        for (int i = 0; i < alumno.size(); i++) {
            if (alumno.get(i).getNumCuenta() == numCuentaBuscar) {
                posicion = i;
            }
        }
        return posicion;
    }
    
    public int buscarAlumno(ArrayList<Alumno> alumno){
        Scanner s = new Scanner(System.in);   
        int pos;
        int numCuentaBuscar;
        System.out.println("Ingresa numero de cuenta: ");
        numCuentaBuscar = s.nextInt();
        pos = posicion(alumno, numCuentaBuscar);
        
        return pos;
    }
    
    public void menuAlumno(ArrayList<Alumno> alumnos){
        int op;
        do{
            System.out.println("          |-------------------------------------------------------------------|");
            System.out.println("          |                           MENU ALUMNO                             |");
            System.out.println("          |-------------------------------------------------------------------|");
            System.out.println("          |                        1. Buscar tira de materias                 |");
            System.out.println("          |                        2. Ver Historial Académico                 |");
            System.out.println("          |                        3. Generar CSV                             |");
            System.out.println("          |                        4. Salir                                   |");
            System.out.println("          |-------------------------------------------------------------------|");

            Scanner t = new Scanner(System.in);


            System.out.println("Ingrese una opcion");
            op = t.nextInt();
       
            switch(op){
                case 1: 
                    tiraMateriaSemestral(alumnos);
                    break; 
                case 2:
                    verHistorialAcadem(alumnos);
                    break;
                case 3: 
                    salidaCsv(alumnos);
                    break;

                default:
                    System.out.println("Hasta luego Ingeniero!!");
                    break;
            } 
        }while(op>0 && op<4);
    }
    
    public void tiraMateriaSemestral(ArrayList<Alumno> alumnos){
        int pos = buscarAlumno(alumnos);
        if(pos != -1){            
            System.out.println("-------------------------------------------------------------------------------");
            alumnos.get(pos).nomCompleto();
            System.out.println("    Creditos: "+alumnos.get(pos).getCredActual()+"/"+alumnos.get(pos).getCredIngreso());
            System.out.println("    Semestre: "+alumnos.get(pos).getSemestreIdeal());
            System.out.println("    Materias inscritas: "+alumnos.get(pos).getNumAsigInscriOrdi());
            System.out.println("    Promedio: "+alumnos.get(pos).getPromedio());
            alumnos.get(pos).impTiraMaterias();
        }
        else
            System.out.println("Numero de cuenta erroneo");        
    }
    
    private void verHistorialAcadem(ArrayList<Alumno> alumnos){
        int pos = buscarAlumno(alumnos);
        if(pos != -1)
           alumnos.get(pos).historialAcadem();
        else
            System.out.println("Numero de cuenta erroneo"); 
        
        
    }
    
}
