/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios1;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Ejercicios1 {

    /**
     * @param args the command line arguments
     */
    Scanner sc = new Scanner(System.in);
    
    public static final String MSG = "Presione ENTER para continuar";
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Ejercicios1 s = new Ejercicios1();
        
        Scanner sc = new Scanner(System.in);
        
        int sel = 1;
        
        while(sel == 1)
        {
            System.out.println("1. Suma enteros\n2. Kilometros a metros y centimetros\n3. Distancia entre dos puntos"
                    + "\n4. Salir\n");
            
            int opt = sc.nextInt();
            
            switch(opt)
            {
                case 1:
                    s.Suma();
                    System.out.println(MSG);
                    System.in.read();
                    break;
                case 2:
                    System.out.println("Ingrese la distancia en Km: ");
                    s.KtoMyC(Float.parseFloat(sc.next()));
                    System.out.println(MSG);
                    System.in.read();
                    break;
                case 3:
                    ArrayList<String> elem = new ArrayList();
                    
                    System.out.println("Ingrese x de punto A: ");
                    elem.add(sc.next());
                    System.out.println("Ingrese y de punto A: ");
                    elem.add(sc.next());
                    
                    System.out.println("Ingrese x de punto B: ");
                    elem.add(sc.next());
                    System.out.println("Ingrese y de punto B: ");
                    elem.add(sc.next());
                    
                    System.out.println(s.EqRecta(elem));
                    
                    System.out.println(MSG);
                    System.in.read();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    sel = 0;
                    break;
                default:
                    System.out.println("No existe esa opción...");
                    System.out.println(MSG);
                    System.in.read();
                    break;
            }
        }
    }
    
    public void Suma()
    {
        System.out.println("Ingrese primer número: ");
        int numA = sc.nextInt();
        
        System.out.println("Ingrese segundo número: ");
        int numB = sc.nextInt();
        
        System.out.println("La suma de " + numA + " y " + numB + " es igual a: " + (numA + numB));
    }
    
    public void KtoMyC(float num)
    {
        float meter = num * 1000;
        
        float centimeter = num * 100000;
        
        System.out.println(num + "Km es igual a: " + meter + "m" + " y " + centimeter + "cm");
    }
    
    public double EqRecta(ArrayList<String> elem)
    {
        BigDecimal bd = new BigDecimal(Math.sqrt(Math.pow(Double.parseDouble(elem.get(2)) - Double.parseDouble(elem.get(0)), 2) + Math.pow((Double.parseDouble(elem.get(3)) - Double.parseDouble(elem.get(1))), 2))).setScale(2, RoundingMode.HALF_EVEN);
        
        return bd.doubleValue();
    }
}
