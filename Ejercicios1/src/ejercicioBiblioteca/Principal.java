/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioBiblioteca;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Principal {
    public static void main(String[] args) throws IOException {
        Biblioteca biblio = new Biblioteca();
        
        Scanner sc = new Scanner(System.in);
        
        biblio.crearBiblioteca();
        
        boolean opt = false;
        
        while(!opt)
        {
            System.out.println("1. Ver biblioteca\n2. Pedir prestamo\n3. Devolver libro\n4. Salir");
            int sel = Integer.parseInt(sc.nextLine());
            
            switch(sel)
            {
                case 1:
                    biblio.showBiblioteca();
                    System.out.println("Presione cualquier tecla para continuar");
                    System.in.read();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del libro y la cantidad de reserva");
                    String datos = sc.nextLine();
                    String[] info = datos.split(" ");
                    if(biblio.prestamo(info[0], Integer.parseInt(info[1])))
                    {
                        System.out.println("Operación correcta");
                    }
                    else
                    {
                        System.out.println("Operación no completada, nombre del libro incorrecto o el número de reserva"
                                + " excede la cantidad disponible");
                    }
                    System.out.println("Presione cualquier tecla para continuar");
                    System.in.read();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del libro y la cantidad de devolución");
                    String datos0 = sc.nextLine();
                    String[] info0 = datos0.split(" ");
                    if(biblio.devolucion(info0[0], Integer.parseInt(info0[1])))
                    {
                        System.out.println("Operación correcta");
                    }
                    else
                    {
                        System.out.println("Operación no completada, nombre del libro incorrecto o el número de reserva"
                                + " excede la cantidad disponible");
                    }
                    System.out.println("Presione cualquier tecla para continuar");
                    System.in.read();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    opt = true;
                    break;
                case 5:
                    System.out.println("Opción inválida");
                    System.out.println("Presione cualquier tecla para continuar");
                    System.in.read();
                    break;
            }
        }
    }
}
