/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polimorfismo;

import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public abstract class Operaciones {
    Scanner sc = new Scanner(System.in);
    
    protected double val1, val2, resul;
    
    public void DatosIn()
    {
        System.out.println("Ingrese dos valores separados por un espacio: ");
        String datos = sc.nextLine();
        
        String[] valores = datos.split(" ");
        
        val1 = Double.parseDouble(valores[0]);
        val2 = Double.parseDouble(valores[1]);
        
    }
    
    public abstract void Ops();
    
    public void ShowResult()
    {
        System.out.println(resul);
    }
}
