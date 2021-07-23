/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Ejercicios2 {
    
    public static final String MSG = "Presione ENTER para continuar";
    
    public static void main(String[] args) throws IOException {
        //1. cuadrante de un punto
        //2. leer tres números e imprimir el mayor
        //3. leer dos números enteros y determinar si la diferencia entre ambos 
        //es un divisor exacto de alguno de los dos números
        ArrayList<String> pto = new ArrayList();
        
        Scanner sc = new Scanner(System.in);
        
        Ejercicios2 ejer = new Ejercicios2();
        
        int opt = 1;
        
        while(opt == 1)
        {
            System.out.println("1. Cuadrante de un punto\n2. Mayor de tres números\n3. Modulo diferencia\n4. Salir\n");
            int sel = Integer.parseInt(sc.nextLine());
            
            switch(sel)
            {
                case 1:
                    int comp = 1;
                    System.out.println("Ingrese componentes del punto\n");
                    for(int i = 0; i < 2; i++)
                    {
                        if(comp == 1)
                        {
                            System.out.println("Ingrese componente x: ");
                            pto.add(sc.nextLine());
                            comp++;
                        }else
                        {
                            System.out.println("Ingrese componente y: ");
                            pto.add(sc.nextLine());
                        }
                    }
                    
                    System.out.println(ejer.Cuadrante(pto));
                    
                    pto.clear();
                    
                    System.out.println(MSG);
                    System.in.read();
                    break;
                case 2:
                    System.out.println("Ingrese los números separados por un espacio:");
                    String datos = sc.nextLine();
                    
                    String[] numeros = datos.split(" ");
                    
                    System.out.println(ejer.NumMay(numeros));
                    
                    System.out.println(MSG);
                    System.in.read();
                    break;
                case 3:
                    System.out.println("Ingrese los números separados por un espacio:");
                    String datos1 = sc.nextLine();
                    
                    String[] numeros1 = datos1.split(" ");
                    
                    System.out.println(ejer.DifMod(numeros1));
                    
                    System.out.println(MSG);
                    System.in.read();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    opt++;
                    break;
                default:
                    System.out.println("Opción inválida");
                    System.out.println(MSG);
                    System.in.read();
                    break;
            }
        }
    }
    
    public String Cuadrante(ArrayList<String> pto)
    {
        double x = Double.parseDouble(pto.get(0));
        
        double y = Double.parseDouble(pto.get(1));
        
        if(x > 0 && y > 0)
        {
            return "El punto: " + pto + " está ubicado en el cuadrante I";
        }else if(x < 0 && y > 0)
        {
            return "El punto: " + pto + " está ubicado en el cuadrante II";
        }else if(x < 0 && y < 0)
        {
            return "El punto: " + pto + " está ubicado en el cuadrante III";
        }else if(x > 0 && y < 0)
        {
            return "El punto: " + pto + " está ubicado en cuadrante IV";
        }
        return "";
    }
    
    public String NumMay(String[] numeros)
    {   
        if(Integer.parseInt(numeros[0]) > Integer.parseInt(numeros[1]) && Integer.parseInt(numeros[0]) > Integer.parseInt(numeros[2]))
        {
            return "El número mayor es " + numeros[0];
        }else if(Integer.parseInt(numeros[1]) > Integer.parseInt(numeros[2]))
        {
            return "El número mayor es " + numeros[1];
        }else
        {
            return "El número mayor es " + numeros[2];
        }
    }
    
    public String DifMod(String[] numeros1)
    {
        float dif = Float.parseFloat(numeros1[0]) - Float.parseFloat(numeros1[1]);
        
        dif = Math.abs(dif);
        
        if(Float.parseFloat(numeros1[0]) % dif == 0 && Float.parseFloat(numeros1[1]) % dif == 0)
        {
            return "La diferencia entre " + numeros1[0] + " y " + numeros1[1] + " es igual a " + dif
                    + "\n El número " + dif + " es multiplo de " + numeros1[0] + " y " + numeros1[1];
        }else if(Float.parseFloat(numeros1[0]) % dif == 0)
        {
            return "La diferencia entre " + numeros1[0] + " y " + numeros1[1] + " es igual a " + dif
                    + "\n El número " + dif + " es multiplo de " + numeros1[0];
        }else if(Float.parseFloat(numeros1[1]) % dif == 0)
        {
            return "La diferencia entre " + numeros1[0] + " y " + numeros1[1] + " es igual a " + dif
                    + "\n El número " + dif + " es multiplo de " + numeros1[1];
        }else
        {
            return "La diferencia entre " + numeros1[0] + " y " + numeros1[1] + " es igual a " + dif
                    + "\n El número " + dif + " no es múltiplo de ningún número";
        }
    }
}
