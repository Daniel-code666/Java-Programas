/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios3;

import ejercicios2.Ejercicios2;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Ejercicios3 {
    public static void main(String[] args) throws IOException {
        
        Ejercicios3 ejer3 = new Ejercicios3();
        
        Scanner sc = new Scanner(System.in);
        
        boolean opt = false;
        
        while(!opt)
        {
            System.out.println("1. Factorial\n2. Porcentaje de números\n3. Número Armstrong\n4. Salir\n");
            int sel = Integer.parseInt(sc.nextLine());
            
            switch(sel)
            {
                case 1:
                    ejer3.factorial();
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 2:
                    System.out.println("Ingrese los números separados por un espacio:");
                    String datos = sc.nextLine();
                    
                    String[] numeros = datos.split(" ");
                    
                    ejer3.porcentaje(numeros);
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 3:
                    ejer3.armstrong();
                    System.out.println(Ejercicios2.MSG);
                    System.in.read();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    opt = true;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
            
        }
        
    }
    
    public void factorial()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese número para saber el factorial:\n");
        
        int num = Integer.parseInt(sc.nextLine());
        
        int fact = 1;
        
        for(int i = 1; i <= num; i++)
        {
            fact *= i;
        }
        
        System.out.println(fact);
    }
    
    public void porcentaje(String[] numeros)
    {
        int cont0 = 0;
        int contPos = 0;
        int contNeg = 0;
        
        
        for (String numero : numeros) {
            if (Integer.parseInt(numero) == 0) {
                cont0++;
            }
            if (Integer.parseInt(numero) > 0) {
                contPos++;
            }
            if (Integer.parseInt(numero) < 0) {
                contNeg++;
            }
        }
        
        double cont0Porc = (double) cont0 / numeros.length; 
        double contPosPorc = (double) contPos / numeros.length; 
        double contNegPorc = (double) contNeg / numeros.length; 
        
        System.out.println("Ceros: " + (cont0Porc * 100) + "%"
                + "\nPositivos: " + (contPosPorc * 100) + "%" + "\nNegativos: " + (contNegPorc * 100) + "%");
    }
    
    public void armstrong()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el número: ");
        String num = sc.nextLine();
        int numArm;
        int newNum = 0;
        char[] nums = num.toCharArray();
        
        for(int i = 0; i < nums.length; i++)
        {
            numArm = Character.getNumericValue(nums[i]);
            newNum += Math.pow(numArm, nums.length);
        }
        
        if(newNum == Integer.parseInt(num))
        {
            System.out.println("El número " + num + " es un número Armstrong");
        }
        else
        {
            System.out.println("No es número Armstong");
        }
    }
}
