/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.provajessicapetersen.resource;

import com.mycompany.provajessicapetersen.Model.Cliente;
import com.mycompany.provajessicapetersen.dao.ClienteDao;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author 08187832908
 */
@Path("cliente")
public class ClienteResource {
    
    private ClienteDao persistencia = new ClienteDao();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getJson() {
        return persistencia.buscaTodosClientes();
  
    }   
}
