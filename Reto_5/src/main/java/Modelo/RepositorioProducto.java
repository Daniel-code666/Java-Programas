/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniel
 */
@Repository
public interface RepositorioProducto extends CrudRepository<Productos, Integer>{
    @Query("select nombre from productos p where precio = (select max(precio) from productos p)")
    public List<String> mayPrec();
    
    @Query("select nombre from productos p where precio = (select min(precio) from productos p)")
    public List<String> minPrec();
    
    @Query("select avg(precio) from productos p")
    public List<Double> avgTot();
    
    @Query("select sum(precio * inventario) from productos p")
    public List<Double> totInv();
}
