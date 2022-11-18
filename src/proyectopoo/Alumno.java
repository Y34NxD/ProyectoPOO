package proyectopoo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Equipo D
 */
public class Alumno {
    private Nombre nombre;
    private int edad;
    private int semestre;
    private ArrayList<Materia> listaMaterias = new ArrayList<Materia>();
    //private Direccion direccion;
    private int numCuenta;
    //private Historial historialAcademico;

    public Alumno() {
    }

    public Alumno(Nombre nombre, int edad, int semestre, int numCuenta) {
        this.nombre = nombre;
        this.edad = edad;
        this.semestre = semestre;
        this.numCuenta = numCuenta;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
        int numSemestre;
        if(edad==18 || edad==19){
            numSemestre = (int)(Math.random()*(2)+1);
            setSemestre(numSemestre);
        }
        if(edad==20 || edad==21){
            numSemestre = (int)(Math.random()*(2)+3);
            setSemestre(numSemestre);
        }
        if(edad==22 || edad==23){
            numSemestre = (int)(Math.random()*(2)+5);
            setSemestre(numSemestre);
        }
        if(edad==24 || edad==25){
            numSemestre = (int)(Math.random()*(2)+7);
            setSemestre(numSemestre);
        }
        if(edad>=26){
            numSemestre = (int)(Math.random()*(2)+9);
            setSemestre(numSemestre);
        }
 
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
        setListaMaterias(semestre);
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public ArrayList<Materia> getListaMaterias(int semestre) {
        MateriasCursando(semestre);
        return listaMaterias;
    }

    public void setListaMaterias(int semestre) {
        //this.materias = materias;//This es de clase
        int i = 0;
        try {
            FileReader fr = new FileReader("ListaMaterias.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            
            while(linea != null  && i < (5*semestre)){
                //System.out.println(linea);
                linea = br.readLine();
                
                //System.out.println("HOLAAAAA "+linea);
                Materia nomMateria = new Materia(); //Creamos una clase materia para poder guardarla
                //  String Tokinizer
                StringTokenizer tokenizador = new StringTokenizer(linea,"\n");
                while(tokenizador.hasMoreTokens()){
                    String token = tokenizador.nextToken();
                    nomMateria.setNombre(token);
                    this.listaMaterias.add(nomMateria);
                    
                }
                i++;
            }
   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void MateriasCursando(int semestre){
        for(int i=(5*semestre)-1;i<semestre;i++){
            System.out.println(listaMaterias.get(i));
        }
    }
    
    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + 
                ", \nedad=" + edad + 
                ", \nsemestre=" + semestre + 
                ", \nlistaMaterias=" + listaMaterias + 
                ", \nnumCuenta=" + numCuenta + '}';
    }

    
    
 
}
