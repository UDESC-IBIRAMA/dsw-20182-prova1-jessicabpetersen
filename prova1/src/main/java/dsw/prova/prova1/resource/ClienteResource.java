/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsw.prova.prova1.resource;

import dsw.prova.prova1.model.Cliente;
import dsw.prova.prova1.repositorio.ClienteRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 08187832908
 */
@RestController
@RequestMapping("/clientes")
public class ClienteResource {
    
    @Autowired
    private ClienteRepositorio repositorio;
    
    @GetMapping(value= "/lista")
    public @ResponseBody Iterable<Cliente> listaVeiculos() {
	Iterable<Cliente> lista = repositorio.findAll();
	return lista;
    }
    
    
    @PostMapping(value= "/cadastro")
    public void cadastrar(Cliente cliente){
        repositorio.save(cliente);
    }
    
    @PutMapping(value= "/atualizar/{id}")
    public  void atualizar(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Optional<Cliente> busca = repositorio.findById(id);
        
        if(busca.isPresent()){
            Cliente c = new Cliente();
            c.setId(cliente.getId());
            c.setDataCadastro(cliente.getDataCadastro());
            c.setNome(cliente.getNome());
            repositorio.save(c);
        }
    }
    
    
    
}
