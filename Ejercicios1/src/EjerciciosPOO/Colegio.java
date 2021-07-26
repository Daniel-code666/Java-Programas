/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosPOO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Colegio {
    
    public static void main(String[] args) throws IOException {
        
        
        
        Scanner sc = new Scanner(System.in);
        
        Colegio c = new Colegio();
        
        boolean opt = false;
        
        while(!opt)
        {
            System.out.println("1. Agregar profesor\n2. Agregar estudiante\n3. Ingresar como profesor\n4. Ver profesores"
                    + "\n5. Ver estudiantes\n6. Ver notas de estudiante por código\n7. Ver notas globales\n8. Salir");
            int sel = Integer.parseInt(sc.nextLine());
            
            switch(sel)
            {
                case 1:
                    c.addInfo(1);
                    System.out.println("Profesor añadido, presione cualquier tecla para continuar");
                    System.in.read();
                    break;
                case 2:
                    c.addInfo(2);
                    System.out.println("Estudiante añadido, presione cualquier tecla para continuar");
                    System.in.read();
                    break;
                case 3:
                    c.assingNotas();
                    System.out.println("Presione alguna tecla para continuar");
                    System.in.read();
                    break;
                case 4:
                    c.showInfo(1);
                    System.out.println("Presione cualquier tecla para continuar");
                    System.in.read();
                    break;
                case 5:
                    c.showInfo(2);
                    System.out.println("Presione cualquier tecla para continuar");
                    System.in.read();
                    break;
                case 6:
                    c.getGradesById();
                    System.out.println("Presione cualquier tecla para continuar");
                    System.in.read();
                    break;
                case 7:
                    c.gloabalGrades();
                    System.out.println("Presione cualquier tecla para continuar");
                    System.in.read();
                    break;
                case 8:
                    System.out.println("Saliendo");
                    opt = true;
                    break;
                default:
                    System.out.println("Opción inválida");
                    System.in.read();
                    break;
            }
        }
    }
    
    Scanner sc = new Scanner(System.in);
    
    //métodos
    List<Profesor> profesores = new ArrayList<>();
    List<Estudiante> estudiante = new ArrayList<>();
    List<Asignatura> asignatura = new ArrayList<>();
    
    public void addInfo(int opt)
    {
        if(opt == 1)
        {
            System.out.println("Ingrese edad, nombre, rol, número de id y correo");
            String datos = sc.nextLine();

            String[] informacion = datos.split(" ");

            Profesor p = new Profesor(Integer.parseInt(informacion[0]), informacion[1], informacion[2], informacion[3],
                                        informacion[4]);

            profesores.add(p);  
        }else if(opt == 2)
        {
            System.out.println("Ingrese edad, nombre, rol, número de id y código");
            String datos = sc.nextLine();

            String[] informacion = datos.split(" ");

            Estudiante e = new Estudiante(Integer.parseInt(informacion[0]), informacion[1], informacion[2], informacion[3],
                                        informacion[4]);

            estudiante.add(e);
        }
    }
    
    public void showInfo(int opt)
    {
        if(opt == 1)
        {
            profesores.forEach(prof ->{
            System.out.println("Nombre: " + prof.nombre + " Edad: " + prof.edad + " Rol: " + prof.rol + " Número de id: "
            + prof.numId + " Correo: " + prof.correo);});
        }else if(opt == 2)
        {
            estudiante.forEach(est ->{
            System.out.println("Nombre: " + est.nombre + " Edad: " + est.edad + " Rol: " + est.rol + " Número de id: "
            + est.numId + " Correo: " + est.cod);});
        }
    }
    
    private void assingNotas() throws IOException
    {
        showInfo(2);
        System.out.println("Ingresar notas del estudiante: ");
        int est = Integer.parseInt(sc.nextLine());
        
        try {
            System.out.println("Nombre: " + estudiante.get(est).nombre + " edad: " + estudiante.get(est).edad
                    + " núm. de edad: " + estudiante.get(est).numId + " código: " + estudiante.get(est).cod);
            
            System.out.println("Agregar asignatura: ");
            String materia = sc.nextLine();
            
            System.out.println("Ingrese las notas separadas por un espacio: ");
            String datos = sc.nextLine();
            String[] notas = datos.split(" ");
            
            Asignatura asig = new Asignatura(materia, estudiante.get(est).cod, notas);
            
            asignatura.add(asig);
            
        } catch (Exception e) {
            System.out.println("No hay estudiantes registrados");
            System.in.read();
        }
    }
    
    private void getGradesById()
    {
        System.out.println("Ingrese el código del estudiante: ");
        String cod = sc.nextLine();
        
        if(asignatura.isEmpty())
        {
            System.out.println("No hay asignaturas ni notas registradas");
        }else
        {
            asignatura.forEach(iter -> {
                if(iter.codigoEst.equals(cod))
                {
                    estudiante.forEach(iterEst -> {
                        if(iterEst.cod.equals(cod))
                        {
                            System.out.println("Nombre: " + iterEst.nombre);
                            System.out.println("Asignatura: " + iter.nombreAsignatura + " Notas: " + Arrays.toString(iter.notas));
                        }
                    });
                }
            });
        }
    }
    
    private void gloabalGrades()
    {
        asignatura.forEach(iterA -> {
            estudiante.forEach(iterE -> {
                System.out.println("Nombre: " + iterE.nombre + " materia: " + iterA.nombreAsignatura
                        + " notas: " + Arrays.toString(iterA.notas) + " código estudiante: " + iterE.cod);
            });
        });
    }
}

//clases
class Persona{
    protected int edad;
    protected String nombre;
    protected String rol;
    protected String numId;

    public Persona(int edad, String nombre, String rol, String numId) {
        this.edad = edad;
        this.nombre = nombre;
        this.rol = rol;
        this.numId = numId;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    @Override
    public String toString() {
        return "Persona{" + "edad=" + edad + ", nombre=" + nombre + ", rol=" + rol + ", numId=" + numId + '}';
    }
}

class Profesor extends  Persona{

    protected String correo;

    public Profesor(int edad, String nombre, String rol, String numId, String correo) {
        super(edad, nombre, rol, numId);
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Override
    public String toString() {
        return "Profesor{" + "correo=" + correo + '}';
    }
}

class Estudiante extends Persona{
    protected String cod;

    public Estudiante(int edad, String nombre, String rol, String numId, String cod) {
        super(edad, nombre, rol, numId);
        this.cod = cod;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "cod=" + cod + '}';
    }
}

class Asignatura{
    protected String nombreAsignatura;
    protected String codigoEst;
    protected String[] notas;

    public Asignatura(String nombreAsignatura, String codigoEst, String[] notas) {
        this.nombreAsignatura = nombreAsignatura;
        this.codigoEst = codigoEst;
        this.notas = notas;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getCodigoEst() {
        return codigoEst;
    }

    public void setCodigoEst(String codigoEst) {
        this.codigoEst = codigoEst;
    }

    public String[] getNotas() {
        return notas;
    }

    public void setNotas(String[] notas) {
        this.notas = notas;
    }
}

