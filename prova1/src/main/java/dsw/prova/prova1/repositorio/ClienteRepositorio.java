/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsw.prova.prova1.repositorio;

import dsw.prova.prova1.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 08187832908
 */
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
    
}
