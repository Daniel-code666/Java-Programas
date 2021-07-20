/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios1;

import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Ejercicios1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese primer número: ");
        int numA = sc.nextInt();
        
        System.out.println("Ingrese segundo número: ");
        int numB = sc.nextInt();
        
        System.out.println("La suma de " + numA + " y " + numB + " es igual a: " + (numA + numB));
    }
    
}
