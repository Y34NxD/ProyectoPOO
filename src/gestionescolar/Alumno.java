package gestionescolar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jean
 */
public class Alumno {
    private String nombre1;       
    private String nombre2;       
    private String apellido1;     
    private String apellido2;     
    private int edad;             
    private int numCuenta;
    private String direccion;    
    private ArrayList<Asignatura> tiraMate = new ArrayList<Asignatura>(); 
    private float promedio;      
    private int credIngreso; 
    private int credActual; 
    private int numAsigInscriOrdi; 
    private float indicadorEsc; 
    private int numAsigApOrdi; 
    private int semestreIdeal; 
    private float escolaridad=0; 
    private float velocidad=0;      
    private int numInscrip=0; 

    public Alumno() {
    }

    public Alumno(String nombre1, String nombre2, String apellido1, String apellido2, int edad,int numCuenta, String direccion,float promedio, int credIngreso, int credActual, int numAsigInscriOrdi, float indicadorEsc, int numAsigApOrdi, int semestreIdeal, float escolaridad, float velocidad, int numInscrip) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.numCuenta = numCuenta;
        this.direccion = direccion;
        this.promedio = promedio;
        this.credIngreso = credIngreso;
        this.credActual = credActual;
        this.numAsigInscriOrdi = numAsigInscriOrdi;
        this.indicadorEsc = indicadorEsc;
        this.numAsigApOrdi = numAsigApOrdi;
        this.semestreIdeal = semestreIdeal;
        this.escolaridad = escolaridad;
        this.velocidad = velocidad;
        this.numInscrip = numInscrip; 
    }
    
    public String getNombre1() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public int getNumCuenta() {
        return numCuenta;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public float getPromedio() {
        return promedio;
    }

    public int getCredIngreso() {
        return credIngreso;
    }

    public int getCredActual() {
        return credActual;
    }

    public int getNumAsigInscriOrdi() {
        return numAsigInscriOrdi;
    }


    public int getNumAsigApOrdi() {
        return numAsigApOrdi;
    }

    public int getSemestreIdeal() {
        return semestreIdeal;
    }

    public float getEscolaridad() {
        return escolaridad;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public float getIndicadorEsc() {
        return indicadorEsc;
    }
    
    public int getNumInscrip() {
        return numInscrip;
    }

    public void setNumInscrip(int numInscrip) {
        this.numInscrip = numInscrip;
    }
    
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEdad(int edad) {         //1
        this.edad = edad;
        setNumAsigInscriOrdi(edad);         // 2    numAsigIncriOrdi
        calcularSemestreIdeal(edad);        //3     SemestreIdeal, credIngreso
        tiraMaterias();                     //4,     tiraMate,credActual,promedio,numAsigApOrdi. 
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public void setCredIngreso(int credIngreso) {
        this.credIngreso = credIngreso;
    }

    public void setCredActual(int credActual) {
        this.credActual = credActual;
    }

    public void setNumAsigInscriOrdi(int edad) {            // 2    numAsigIncriOrdi
        //this.numAsigInscriOrdi = numAsigInscriOrdi;
        if(edad == 18){
            this.numAsigInscriOrdi = 5;
        }
        if(edad == 19){
            int numMaterias = (int)(Math.floor(Math.random()*(10-5+1)+5));
            numAsigInscriOrdi = numMaterias;
        }
        if(edad == 20){
            int numMaterias= (int) (Math.floor(Math.random()*(15-10+1)+10));
            numAsigInscriOrdi = numMaterias;
        }
        if(edad == 21){
            int numMaterias= (int) (Math.floor(Math.random()*(20-15+1)+15));
            numAsigInscriOrdi = numMaterias;
        }
        if(edad == 22){
            int numMaterias= (int) (Math.floor(Math.random()*(25-20+1)+20));
            numAsigInscriOrdi = numMaterias;
        }
        if(edad == 23){
            int numMaterias= (int) (Math.floor(Math.random()*(30-25+1)+25));
            numAsigInscriOrdi = numMaterias;
        }
        if(edad == 24){
            int numMaterias= (int) (Math.floor(Math.random()*(35-30+1)+30));
            numAsigInscriOrdi = numMaterias;
        }
        if(edad == 25){
            int numMaterias= (int) (Math.floor(Math.random()*(40-35+1)+35));
            numAsigInscriOrdi = numMaterias;
        }
        if(edad == 26){
            int numMaterias= (int) (Math.floor(Math.random()*(45-40+1)+40));
            numAsigInscriOrdi = numMaterias;
        }
        if(edad == 27){
            int numMaterias= (int) (Math.floor(Math.random()*(50-45+1)+45));
            numAsigInscriOrdi = numMaterias;
        }
    }
    
    public void setNumAsigApOrdi(int numAsigApOrdi) {
        this.numAsigApOrdi = numAsigApOrdi;
    }

    public void setSemestreIdeal(int semestreIdeal) {
        this.semestreIdeal = semestreIdeal;
    }

    public void setEscolaridad() { 
        escolaridad =((float)(numAsigApOrdi)/(float)(numAsigInscriOrdi));
        setVelocidad();  
    }

    public void setVelocidad() {
        velocidad = ((float)(credActual)/(float)(credIngreso));
        calcularIndicadorEsc();
    }
    
    public void tiraMaterias(){ 
        
        int i=0;
        int suma = 0;
        int cred = 0;
       
        try {
            FileReader fr;
            fr = new FileReader("ListaMaterias.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            
            while(linea != null  && i < (numAsigInscriOrdi)){
                
                linea = br.readLine();
                Asignatura materia = new Asignatura(); //Creamos una clase Asignatura para poder guardarla
                
                int calificacion = (int) Math.floor(Math.random()*(10-5+1)+5);
                materia.setClave(101+i);
                materia.setCalif(calificacion);
                suma += materia.getCalif();
                
                if(materia.getCalif() != 5)
                    cred += 1;
                
                materia.setNombre(linea);
                this.tiraMate.add(materia);  
                
                i++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        credActual = 2*cred;
        promedio = (float)suma / (float)numAsigInscriOrdi;
        numAsigApOrdi = cred;
        
        DecimalFormat frmt = new DecimalFormat();
        frmt.setMaximumFractionDigits(2);
        setEscolaridad();
    }
    
    public void calcularSemestreIdeal(int edad){        //3     SemestreIdeal, credIngreso
        if(edad == 18){
            semestreIdeal = 1;
            credIngreso = 2*5;
        }
        if(edad == 19){
            semestreIdeal = 2;
            credIngreso = 2*10;
        }    
        if(edad == 20){
            semestreIdeal = 3;
            credIngreso = 2*15;
        }
        if(edad == 21){
            semestreIdeal = 4;
            credIngreso = 2*20;
        }
        if(edad == 22){
            semestreIdeal = 5;
            credIngreso = 2*25;
        }
        if(edad == 23){
            semestreIdeal = 6;
            credIngreso = 2*30;
        }
        if(edad == 24){
            semestreIdeal = 7;
            credIngreso = 2*35;
        }
        if(edad == 25){
            semestreIdeal = 8;
            credIngreso = 2*40;
        }
        if(edad == 26){
            semestreIdeal = 9;
            credIngreso = 2*45;
        }
        if(edad == 27){
            semestreIdeal = 10;
            credIngreso = 2*50;
        }
    }
    
    public void calcularIndicadorEsc(){
        indicadorEsc = (float)((promedio)*(escolaridad)*(velocidad));
    }
    
    public ArrayList<Asignatura> getTiraMate() {
        return tiraMate;
    }
    
    public void nomCompleto(){
        System.out.println("    Nombre del alumno: " +apellido1+ " " +apellido2+ 
                            " " +nombre1+ " " +nombre2);
    }
    
    public void impTiraMaterias(){
        DecimalFormat frmt = new DecimalFormat();
        frmt.setMaximumFractionDigits(2);
        System.out.println("-------------------------------------------------------------------------------");
        for (int i = (semestreIdeal-1)*5; i < tiraMate.size(); i++) {
            System.out.println(tiraMate.get(i));
        }
        System.out.println("-------------------------------------------------------------------------------");
        
    }
    
    public void historialAcadem(){
        DecimalFormat frmt = new DecimalFormat();
        frmt.setMaximumFractionDigits(2);
        System.out.println("-------------------------------------------------------------------------------");
        nomCompleto();
        System.out.println("    Semestre: "+getSemestreIdeal());
        System.out.println("    Promedio: "+frmt.format(promedio));
        System.out.println("    No. materias inscritas en Ordinario: "+getNumAsigInscriOrdi());
        System.out.println("    No. materias Aprobadas Ordinario: "+getNumAsigApOrdi());
        System.out.println("    Creditos: " +getCredActual()+ " / " +getCredIngreso());
        System.out.println("    No. Inscripcion: "+ getNumInscrip());
        System.out.println("-------------------------------------------------------------------------------");

        for (int i = 0; i < tiraMate.size(); i++) {
            System.out.print(tiraMate.get(i));
        }
    }
    
    @Override
    public String toString(){
        DecimalFormat frmt = new DecimalFormat();
        frmt.setMaximumFractionDigits(2);
        return "-Nombre: " + nombre1 + " " + nombre2 + 
                " " + apellido1 + " "+apellido2 +
                "\n-num Cuenta: " + numCuenta +
                "\n-Edad: " + edad + 
                "\n-Direccion: " + direccion + 
                "\n-Promedio: " + frmt.format(promedio) + 
                "\n-Creditos de ingreso: " + credIngreso + 
                "\n-Creditos actuales: " + credActual + 
                "\n-numAsigInscriOrdi: " + numAsigInscriOrdi + 
                "\n-indicador Esc: " + indicadorEsc + 
                "\n-numAsigApOrdi: " + numAsigApOrdi + 
                "\n-Semestre ideal: " + semestreIdeal + 
                "\n-Escolaridad: " + escolaridad + 
                "\n-Velocidad: " + velocidad ;
    }
     
}