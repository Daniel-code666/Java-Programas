/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios5;

import java.util.Scanner;
import ejercicios2.Ejercicios2;
import java.io.IOException;
/**
 *
 * @author Daniel
 */
public class Ejercicios5 {
    public static void main(String[] args) throws IOException {
        
        Ejercicios5 ejer = new Ejercicios5();
        
        Scanner sc = new Scanner(System.in);
        
        boolean opt = false;
        
        while(!opt)
        {
            System.out.println("1. Área y perimetro de un circulo\n2. Días a hrs, min y seg\n3. Calificaciones"
                    + "\n4. Operación entre dos números\n5. Número positivo, negativo o cero\n6. Equivalente cualitativo"
                    + "\n7. Crecimiento de la población\n8. Mayor digito en un número\n9. Salir");
            int sel = Integer.parseInt(sc.nextLine());
            
            switch(sel)
            {
                case 1:
                    ejer.areaperim();
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 2:
                    ejer.diastohrsminseg();
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 3:
                    ejer.calificaciones();
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 4:
                    ejer.opNum();
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 5:
                    ejer.numPosNegCero();
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 6:
                    ejer.notasCualitativas();
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 7:
                    ejer.poblacion();
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 8:
                    ejer.digMay();
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 9:
                    System.out.println("Saliendo...");
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
    
    public void areaperim()
    {
        System.out.println("Ingrese el radio: ");
        double r = Double.parseDouble(sc.nextLine());
        
        
        System.out.println("Área: " + (Math.PI * (r * r)) + " Perimetro: " + (2 * Math.PI * r));
    }
    
    public void diastohrsminseg()
    {
        System.out.println("Ingrese el número de días");
        Double dias = Double.parseDouble(sc.nextLine());
        
        System.out.println("Días a hrs: " + dias * 24 + " a minutos: " + dias * 1440 + " segundos: " + dias * 86400);
        
    }
    
    public void calificaciones()
    {
        System.out.println("Ingrese las notas separadas por un espacio y en el "
                + "siguiente orden: matemáticas química biología: ");
        String datos = sc.nextLine();
        
        String[] notas = datos.split(" ");
        
        double mat = Double.parseDouble(notas[0]);
        double quim = Double.parseDouble(notas[1]);
        double bio = Double.parseDouble(notas[2]);
        
        mat += Double.parseDouble(notas[0]) * 0.15; 
        quim += Double.parseDouble(notas[1]) * 0.20;
        
        System.out.println("Promedio de notas: " + ((mat + quim + bio) / notas.length));
    }
    
    public void opNum()
    {
        System.out.println("Ingrese los números separados por un espacio: ");
        String datos = sc.nextLine();
        String[] numeros = datos.split(" ");
        
        if((Integer.parseInt(numeros[0]) + Integer.parseInt(numeros[1])) % 2 == 0)
        {
            System.out.println(Integer.parseInt(numeros[0]) * Integer.parseInt(numeros[1]));
        }else
        {
            if(Integer.parseInt(numeros[0]) == Integer.parseInt(numeros[1]))
            {
                System.out.println("Ambos números son iguales...");
            }
            
            if(Integer.parseInt(numeros[0]) > Integer.parseInt(numeros[1]))
            {
                System.out.println(Integer.parseInt(numeros[1]) * Integer.parseInt(numeros[1]));
            }else
            {
                System.out.println(Integer.parseInt(numeros[0]) * Integer.parseInt(numeros[0]));
            }
        }
    }
    
    public void numPosNegCero()
    {
        System.out.println("Ingrese el número");
        double num = Double.parseDouble(sc.nextLine());
        
        if(num > 0)
        {
            System.out.println("El número " + num + " es positivo");
        }
        
        if(num < 0)
        {
            System.out.println("El número " + num + " es negativa");
        }
        
        if(num == 0)
        {
            System.out.println("El número " + num + " es neutro para la suma");
        }
    }
    
    public void notasCualitativas()
    {
        System.out.println("Ingrese la nota: ");
        Double nota = Double.parseDouble(sc.nextLine());
        
        if(nota > 4.0 && nota < 5.0)
        {
            System.out.println("Excelente");
        }
        if(nota > 3.0 && nota < 3.9)
        {
            System.out.println("Aceptable");
        }
        if(nota > 2.0 && nota < 2.9)
        {
            System.out.println("Regular");
        }
        if(nota > 1.0 && nota < 1.9)
        {
            System.out.println("Deficiente");
        }
    }
    
    public void poblacion()
    {
        double a = 25000000;
        double b = 18900000;
        
        double tasaA = 0.02;
        double tasaB = 0.03;
        
        int cont = 0;
        
        System.out.println("Población A: " + a + "\nPoblación B: " + b);
        
        while(a > b)
        {
            a += (a * tasaA);
            b += (b * tasaB);
            cont++;
        }
        
        System.out.println("La población de B " + b + " superará a la de A " + a + " en el año: " + (2022 + cont));
    }
    
    public void digMay()
    {
        int numMay = 0;
        int residuo;
        
        System.out.println("Ingrese un numero natural");
        int num = Integer.parseInt(sc.nextLine());
        
        int numCopi = num;
        
        while(num != 0)
        {
            residuo = num % 10;
            
            numMay = Math.max(residuo, numMay);
            
            num /= 10;
        }
        
        System.out.println("El dígito mayor del número " + numCopi + " es " + numMay);
    }
}
