/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Productos;
import Modelo.RepositorioProducto;
import Vista.GUI;
import Vista.UpdtDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */

public class Controlador implements ActionListener{
    
    RepositorioProducto repoProd;
    
    Productos prod = Productos.addProd();
    
    GUI vista;
    
    DefaultTableModel model = new DefaultTableModel();
    
    UpdtDialog diag = new UpdtDialog(vista, true);
    
    private int id;
    
    public Controlador()
    {
        super();
    }
    
    public Controlador(RepositorioProducto repo, GUI gui)
    {
        super();
        this.repoProd = repo;
        this.vista = gui;
        addEvents();
        vista.setVisible(true);
    }
    
    private void addEvents()
    {
        vista.getAddProdButton().addActionListener(this);
        vista.getUpdtProdButton().addActionListener(this);
        vista.getDelProdButton().addActionListener(this);
        vista.getInfoProdButton().addActionListener(this);
        diag.getjButton1().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.getAddProdButton())
        {
            addAction(e);
        }
        
        if(e.getSource()==vista.getUpdtProdButton())
        {
            updtAction(e);
        }
        
        if(e.getSource()==vista.getDelProdButton())
        {
            delAction(e);
        }
        
        if(e.getSource()==vista.getInfoProdButton())
        {
            infoAction(e);
        }
        
        if(e.getSource()==diag.getjButton1())
        {
            updateInfo(e);
        }
    }
    
    public void infoAction(ActionEvent e)
    {
        NumberFormat formatter = new DecimalFormat("#0.0");
        
        double totInvNum = 0;
        double prom = 0;
        
        for(double num : repoProd.totInv())
        {
            totInvNum = num;
        }
        
        for(double num : repoProd.avgTot())
        {
            prom = num;
        }
        
        JOptionPane.showMessageDialog(null,"Producto con precio mayor: " + repoProd.mayPrec() + "\nProducto con precio menor: " + repoProd.minPrec()
                + "\nPromedio precios: " + formatter.format(prom) + "\nTotal inventario: " + formatter.format(totInvNum));
    }
    
    public void delAction(ActionEvent e)
    {
        try{
            Productos p = repoProd.findById(vista.getSelRow()).get();
            
            repoProd.deleteById(p.getCodigo());
        
            refreshTable();

            listProd();

            JOptionPane.showMessageDialog(null, "Producto eliminado");
        }catch(Exception msg)
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto de la tabla");
        }
    }
    
    
    
    public void updtAction(ActionEvent e)
    {
        try
        {
            Productos p = repoProd.findById(vista.getSelRow()).get();
            
            id = p.getCodigo();
            
            diag.getjTextField1().setText(p.getNombre());
            diag.getjTextField2().setText(String.valueOf(p.getPrecio()));
            diag.getjTextField3().setText(String.valueOf(p.getInventario()));
            diag.setVisible(true);
            
    //        repoProd.save(p);
    //        
    //        listProd();
        }catch(Exception msg)
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto de la tabla");
        }
    }
    
    public void updateInfo(ActionEvent e)
    {
        Productos p = repoProd.findById(id).get();
        
        if(diag.getjTextField1().getText().isEmpty() || diag.getjTextField2().getText().isEmpty() || diag.getjTextField3().getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        }
        else
        {
            p.setNombre(diag.getjTextField1().getText());
            p.setPrecio(Double.parseDouble(diag.getjTextField2().getText()));
            p.setInventario(Integer.parseInt(diag.getjTextField3().getText()));

            repoProd.save(p);

            refreshTable();

            listProd();

            JOptionPane.showMessageDialog(null, "Producto actualizado");

            diag.dispose();
        }
    }
    
    public void addAction(ActionEvent e)
    {
        JTextField nombre = vista.getNombre();
        JTextField precio = vista.getPrice();
        JTextField inventario = vista.getInventory();
        
        if(nombre.getText().isEmpty() || precio.getText().isEmpty() || inventario.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        }
        else
        {
            String name = nombre.getText();
            double price = Double.parseDouble(precio.getText());
            int inventory = Integer.parseInt(inventario.getText());

            Productos p = Productos.addProd(name, price, inventory);

            repoProd.save(p);

            nombre.setText("");
            precio.setText("");
            inventario.setText("");

            refreshTable();

            listProd();
        }
    }
    
    public void listProd()
    {
        JTable tabla = vista.getjTable1();
        
        Iterable<Productos> lista = repoProd.findAll();
        
        model = (DefaultTableModel) tabla.getModel();
        
        for (Productos lista1 : lista) {
            Vector<Object> fila = new Vector<>(4);
            
            fila.add(lista1.getCodigo());
            fila.add(lista1.getNombre());
            fila.add(lista1.getPrecio());
            fila.add(lista1.getInventario());
            
            model.addRow(fila);
        }
    }
    
    public void refreshTable()
    {
        JTable tabla = vista.getjTable1();
        
        model = (DefaultTableModel) tabla.getModel();
        
        model.setRowCount(0);
    }
}
