/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios4;

import java.util.Scanner;
import ejercicios2.Ejercicios2;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 *
 * @author Daniel
 */
public class Ejercicios4 {
    public static void main(String[] args) throws IOException {
        
        Ejercicios4 ejer = new Ejercicios4();
        
        Scanner sc = new Scanner(System.in);
        
        boolean opt = false;
        
        while(!opt)
        {
            System.out.println("1. Promedio y desv. estándar\n2. Cantidad de vocales\n3. Ciclos varios\n4. Salir");
            int sel = Integer.parseInt(sc.nextLine());
            
            switch(sel)
            {
                case 1:
                    ejer.PromDesvEst();
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 2:
                    ejer.vocales();
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 3:
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 4:
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
    
    public void PromDesvEst()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese los números separados por un espacio:");
        String datos = sc.nextLine();

        String[] numeros = datos.split(" ");
        
        Double sumNum = 0.0;
        Double prom;
        Double dividendo = 0.0;
        Double DesEst;
        
        for (String numero : numeros) 
        {
            sumNum += Double.parseDouble(numero);
        }
        
        prom = sumNum / numeros.length;
        
        for (String numero : numeros) {
            dividendo += Math.pow(Double.parseDouble(numero) - prom, 2);
        }
        
        dividendo /= numeros.length;
        
        DesEst = Math.sqrt(dividendo);
        
        BigDecimal bd = new BigDecimal(DesEst).setScale(2, RoundingMode.FLOOR);
        
        DesEst = bd.doubleValue();
        
        System.out.println("Promedio " + prom + " Desviación estándar " + DesEst);
    }
    
    public void vocales()
    {
        Scanner sc = new Scanner(System.in);
        
        int cont = 0;
        System.out.println("Ingrese cadena:\n");
        String cadena = sc.nextLine();
        
        for (int i=0 ; i < cadena.length(); i++){
         char ch = cadena.charAt(i);
         if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'||ch == ' '){
            cont ++;
         }
      }
        
        System.out.println("La cadena " + cadena + " tiene " + cont + " vocales");
    }
}
