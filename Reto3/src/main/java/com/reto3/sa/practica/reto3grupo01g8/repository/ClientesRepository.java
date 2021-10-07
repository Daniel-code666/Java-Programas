/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.sa.practica.reto3grupo01g8.repository;

import com.reto3.sa.practica.reto3grupo01g8.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Daniel
 */
public interface ClientesRepository extends JpaRepository<Clientes, Integer>{
    
}
