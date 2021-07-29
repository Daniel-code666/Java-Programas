/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polimorfismo;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Principal{
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        
        Operaciones msg_suma = new Suma();
        
        Operaciones msg_resta = new Resta();
        
        boolean opt = false;
        
        while(!opt)
        {
            System.out.println("1. Suma\n2. Resta\n3. Salir");
            int sel = Integer.parseInt(sc.nextLine());
            
            switch(sel)
            {
                case 1:
                    msg_suma.DatosIn();
                    msg_suma.Ops();
                    System.out.print("El resultado es: ");
                    msg_suma.ShowResult();
                    System.out.println("Presione cualquier tecla para continuar");
                    System.in.read();
                    break;
                case 2:
                    msg_resta.DatosIn();
                    msg_resta.Ops();
                    System.out.println("El resultado es: ");
                    msg_resta.ShowResult();
                    System.out.println("Presione cualquier tecla para continuar");
                    System.in.read();
                    break;
                case 3:
                    opt = true;
                    break;
                default:
                    System.out.println("Opción inválida...");
                    System.in.read();
                    break;
            }
        }
    }
}
