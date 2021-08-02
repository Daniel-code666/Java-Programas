/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel
 */
public class Reto3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        BaseDatosProducto bd = new BaseDatosProducto();
        
        bd.crearTabla();
        
        String op = scanner.nextLine();
        
        String datos = scanner.nextLine();
                    
        String[] info = datos.split(" ");
        
        if(op.equals("AGREGAR"))
        {
            bd.add(info);
        }
        
        if(op.equals("ACTUALIZAR"))
        {
            bd.updt(info);
        }
        
        if(op.equals("BORRAR"))
        {
            bd.del(info);
        }
    }
}

class BaseDatosProducto{
    
    Map<Integer, Object[]> listaProductos = new HashMap<>();
    
    protected Map<Integer, Object[]> crearTabla()
    {
        listaProductos.put(1, new Object[]{"Manzana", 8000.0, 550});
        listaProductos.put(2, new Object[]{"Limones", 2300.0, 15});
        listaProductos.put(3, new Object[]{"Peras", 2500.0, 38});
        listaProductos.put(4, new Object[]{"Arandanos", 9300.0, 55});
        listaProductos.put(5, new Object[]{"Tomates", 2100.0, 42});
        listaProductos.put(6, new Object[]{"Fresas", 4100.0, 33});
        listaProductos.put(7, new Object[]{"Helado", 4500.0, 41});
        listaProductos.put(8, new Object[]{"Galletas", 500.0, 833});
        listaProductos.put(9, new Object[]{"Chocolates", 3900.0, 999});
        listaProductos.put(10, new Object[]{"Jamon", 17000.0, 10});
        
        return listaProductos;
    }
    
    protected boolean verificarExistencia(int cod)
    {
        return listaProductos.containsKey(cod);
    }
    
    protected void add(String[] info)
    {
        if(!verificarExistencia(Integer.parseInt(info[0])))
        {
            listaProductos.put(Integer.parseInt(info[0]), new Object[]{info[1], Double.parseDouble(info[2]), Integer.parseInt(info[3])});
            operaciones();
        }
        else
        {
            System.out.println("ERROR");
        }
        //listaProductos2.entrySet().forEach(entry -> {System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));});
    }
    
    protected void updt(String[] info)
    {
        if(verificarExistencia(Integer.parseInt(info[0])))
        {
            listaProductos.replace(Integer.parseInt(info[0]), new Object[]{info[1], Double.parseDouble(info[2]), Integer.parseInt(info[3])});
            operaciones();
        }
        else
        {
            System.out.println("ERROR");
        }
        //listaProductos2.entrySet().forEach(entry -> {System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));});
    }
    
    protected void del(String[] info)
    {
        if(verificarExistencia(Integer.parseInt(info[0])))
        {
            listaProductos.remove(Integer.parseInt(info[0]));
            operaciones();
        }
        else
        {
            System.out.println("ERROR");
        }
        //listaProductos2.entrySet().forEach(entry -> {System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));});
    }
    
    protected void operaciones()
    {
        ArrayList<Double> prec = new ArrayList<>();
        ArrayList<Integer> cant = new ArrayList<>();
        ArrayList<String> nombre = new ArrayList<>();
        Map<String, Double> mapTemp = new HashMap<>();
        double prom;
        double sum = 0;
        double tot = 0;
        
        listaProductos.values().forEach(i -> {
            for(Object j : i)
            {
                if(j instanceof String)
                {
                    nombre.add((String) j);
                }
                
                if(j instanceof Double)
                {
                    prec.add((Double) j);
                }
                
                if(j instanceof Integer)
                {
                    cant.add((Integer) j);
                }
            }
            //System.out.println(Arrays.toString(i));
        });
        
        for(int i = 0; i < nombre.size(); i++) {
            mapTemp.put(nombre.get(i), prec.get(i));
        }
        
        List<String> keys = mapTemp.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
        
        System.out.println(keys.get(0) + " " + keys.get(1) + " " + keys.get(2));
        
    }
}

