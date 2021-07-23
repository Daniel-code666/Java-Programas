/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Reto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String datos = sc.nextLine();
                    
        String[] numeros = datos.split(" ");
        
        double masa = Double.parseDouble(numeros[0]);
        double altura = Double.parseDouble(numeros[1]);
        int edad = Integer.parseInt(numeros[2]);
        
        if(masa > 0 && masa < 150 && altura > 0.1 && altura < 2.5 && edad > 0 && edad < 110)
        {
            double imc = masa / (altura * altura);
        
            BigDecimal bd = new BigDecimal(imc).setScale(1, RoundingMode.FLOOR);

            imc = bd.doubleValue();
            
            if(imc < 22 && edad < 45)
            {
                System.out.println(imc + " " + "Bajo");
            }
            
            if(imc < 22 && edad >= 45)
            {
                System.out.println(imc + " " + "Medio");
            }
            
            if(imc >= 22 && edad < 45)
            {
                System.out.println(imc + " " + "Medio");
            }
            
            if(imc >= 22 && edad >= 45)
            {
                System.out.println(imc + " " + "Alto");
            }
        }else
        {
            System.out.println("ERROR");
        }
    }
}
