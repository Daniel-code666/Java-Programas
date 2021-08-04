/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class Interfaz {
    
    public static void main(String[] args) {
        
        BaseDatosProducto bd = new BaseDatosProducto();
        
        JFrame f;
        JPanel mainPanel, topPanel, textFields, lastPanel;
        JButton addB;
        
        JLabel nombre, precio, cantidad, id;
        JTextField nombreTxt, precioTxt, cantidadTxt, idTxt;
        
        
        f = new JFrame("Reto 3: Inventario");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = (JPanel) f.getContentPane();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        
        textFields = new JPanel();
        textFields.setLayout(new GridLayout(4,2));
        
        lastPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        
        addB = new JButton("Agregar producto");
        
        JScrollPane sc = new JScrollPane(crearTabla(bd.crearTabla()));
        
        id = new JLabel("ID");
        
        idTxt = new JTextField();
        
        nombre = new JLabel("Nombre ");
        
        nombreTxt = new JTextField();
        
        precio = new JLabel("Precio ");
        
        precioTxt = new JTextField();
        
        cantidad = new JLabel("Cantidad ");
        
        cantidadTxt = new JTextField();
        
        textFields.add(id);
        textFields.add(idTxt);
        textFields.add(nombre);
        textFields.add(nombreTxt);
        textFields.add(precio);
        textFields.add(precioTxt);
        textFields.add(cantidad);
        textFields.add(cantidadTxt);
        
        topPanel.add(addB);
        
        lastPanel.add(crearTabla(bd.crearTabla()));
        
        mainPanel.add(textFields);
        mainPanel.add(topPanel);
        mainPanel.add(lastPanel);
        
        f.pack();
        f.setVisible(true);
        
        addB.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(idTxt.getText().isEmpty() || nombreTxt.getText().isEmpty() || precioTxt.getText().isEmpty() || cantidadTxt.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Debe ingresar todos los campos");
                    }else
                    {
                        String[] info = {"","","",""};
                    
                        info[0] =idTxt.getText();

                        info[1] = nombreTxt.getText();

                        info[2] = precioTxt.getText();

                        info[3] = cantidadTxt.getText();

                        bd.add(info);
                    }
                }
            }
        );
    }
    
    public static JTable crearTabla(Map<?,?> listaProductos)
    {
        JTable t = new JTable(toTableModel(listaProductos));
        
        return t;
    }
    
    public static TableModel toTableModel(Map<?,?> map)
    {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] {"ID", "Nombre", "Precio", "Cantidad"}, 0
        );
        
        for(Map.Entry<?, ?> data : map.entrySet())
        {
            Vector<Object> row = new Vector<>(4);
            row.addElement(data.getKey());

            Object[] values = (Object[]) data.getValue();

            for (Object item: values)
            {
                row.addElement(item);
            }

            System.out.println(row);
            model.addRow( row );
        }
        
        return model;
    }
}
