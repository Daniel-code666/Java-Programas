/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioBiblioteca;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Daniel
 */
public class Biblioteca {
    
    Map<Integer, Libro> listaLibros = new HashMap<>();
    
    protected Map<Integer, Libro> crearBiblioteca()
    {
        listaLibros.put(1, new Libro("Autor1", "Libro1", 100, 10));
        listaLibros.put(2, new Libro("Autor2", "Libro2", 100, 10));
        listaLibros.put(3, new Libro("Autor3", "Libro3", 100, 10));
        listaLibros.put(4, new Libro("Autor4", "Libro4", 100, 10));
        listaLibros.put(5, new Libro("Autor5", "Libro5", 100, 10));
        listaLibros.put(6, new Libro("Autor6", "Libro6", 100, 10));
        listaLibros.put(7, new Libro("Autor7", "Libro7", 100, 10));
        listaLibros.put(8, new Libro("Autor8", "Libro8", 100, 10));
        
        return listaLibros; 
    }
    
    protected boolean prestamo(String nombrePrest, int cantPrest)
    {
        Set set = listaLibros.entrySet();
        
        Iterator i = set.iterator();
        
        boolean cont = false;
        
        while(i.hasNext())
        {
            Map.Entry me = (Map.Entry)i.next();
            Libro l = (Libro) me.getValue();
            
            if(l.libro.equals(nombrePrest) && l.cantDisp > cantPrest)
            {
                l.setCantDisp(l.getCantDisp() - cantPrest);
                l.setCantPres(l.getCantPres() + cantPrest);
                cont = true;
                break;
            }
            else
            {
                cont = false;
            }
        }
        
        return cont;
    }
    
    protected boolean devolucion(String nombrePrest, int cantPrest)
    {
        Set set = listaLibros.entrySet();
        
        Iterator i = set.iterator();
        
        boolean cont = false;
        
        while(i.hasNext())
        {
            Map.Entry me = (Map.Entry)i.next();
            Libro l = (Libro) me.getValue();
            
            if(l.libro.equals(nombrePrest) && l.cantDisp > cantPrest)
            {
                l.setCantDisp(l.getCantDisp() + cantPrest);
                l.setCantPres(l.getCantPres() - cantPrest);
                cont = true;
                break;
            }
            else
            {
                cont = false;
            }
        }
        
        return cont;
    }
    
    protected void showBiblioteca()
    {
        Set set = listaLibros.entrySet();
        
        Iterator i = set.iterator();
        
        while(i.hasNext())
        {
            Map.Entry me = (Map.Entry)i.next();
            Libro l = (Libro) me.getValue();
            
            System.out.println(me.getKey() + ". " + l.toString());
        }
    }
}
