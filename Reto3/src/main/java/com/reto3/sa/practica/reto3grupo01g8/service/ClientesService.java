/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.sa.practica.reto3grupo01g8.service;

import com.reto3.sa.practica.reto3grupo01g8.entity.Clientes;
import com.reto3.sa.practica.reto3grupo01g8.repository.ClientesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel
 */

@Service
public class ClientesService {
    
    @Autowired
    private ClientesRepository repo;
    
    // mostrar todos los clientes
    public List<Clientes> listClient(){
        return repo.findAll();
    }
    
    // mostrar cliente por id
    public Clientes listClientById(Clientes cliente){
        return repo.findById(cliente.getId()).orElse(null);
    }
    
    // insert cliente
    public Clientes insertClient(Clientes cliente){
        return repo.save(cliente);
    }
    
    // updt cliente
    public Clientes updtCliente(Clientes cliente){
        Clientes checkIfExist = repo.findById(cliente.getId()).orElse(null);
        
        checkIfExist.setNombre(cliente.getNombre());
        checkIfExist.setCorreo(cliente.getCorreo());
        checkIfExist.setEdad(cliente.getEdad());
        checkIfExist.setPass(cliente.getPass());
        
        return repo.save(checkIfExist);
    }
    
    // eliminar cliente
    public String delCliente(int id){
        repo.deleteById(id);
        
        return "El cliente número " + id + " se ha eliminado";
    }
}
