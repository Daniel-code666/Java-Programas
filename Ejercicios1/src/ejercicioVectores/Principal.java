/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioVectores;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Principal {
    public static void main(String[] args) throws IOException {
        Vector v = new Vector();
        
        Scanner sc = new Scanner(System.in);
        
        boolean opt = false;
        
        while(!opt)
        {
            System.out.println("1. Ver punto\n2. Ingresar punto\n3. Ver el cuadrante del punto\n4. Vector entre dos puntos\n5. Salir");
            int sel = Integer.parseInt(sc.nextLine());
            
            switch(sel)
            {
                case 1:
                    System.out.println(v.toString());
                    System.out.println("Presione cualquier letra para continuar");
                    System.in.read();
                    break;
                case 2:
                    System.out.println("Ingrese las coordenadas del punto: ");
                    String dato = sc.nextLine();
                    
                    String[] info = dato.split(" ");
                    
                    v.setX(Double.parseDouble(info[0]));
                    v.setY(Double.parseDouble(info[1]));
                    
                    System.out.println("Punto guardado A(" + v.getX() + "," + v.getY()
                    + ") presione cualquier tecla para continuar");
                    
                    System.in.read();
                    break;
                case 3:
                    System.out.println("El punto A(" + v.getX() + "," + v.getY() + ") " + v.cuadrante());
                    System.out.println("Presione cualquier letra para continuar");
                    System.in.read();
                    break;
                case 4:
                    System.out.println("Ingrese las coordenadas del punto: ");
                    dato = sc.nextLine();
                    
                    info = dato.split(" ");
                    
                    System.out.println(v.vectorResult(info));;
                    
                    System.out.println("Presione cualquier letra para continuar");
                    System.in.read();
                    break;
                case 5:
                    opt = true;
                    break;
                default:
                    System.out.println("Opción inválida");
                    System.in.read();
                    break;
            }
        }
        
    }
}
