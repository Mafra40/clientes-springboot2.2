package io.github.mafrawise.rest;

import io.github.mafrawise.model.entity.Cliente;
import io.github.mafrawise.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    //Sempre que for consultar;
    private final   ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository pRepository){
        this.repository = pRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)         ////@Valid ATIVA as configurações de msg.properties
    public Cliente salvar(@RequestBody @Valid Cliente pCliente){ //Json para Cliente
        return  repository.save(pCliente);
    }

    @GetMapping("{id}") //Consultar no banco por PK
    public Cliente acharPorId(@PathVariable Integer id){
        return repository
                 .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND ,  "Cliente não encotrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository
                .findById(id)
                .map( cliente -> {
                    repository.delete(cliente);
                    return  Void.TYPE;
                }) //primeiro procura por id e depos da o map.. Depois deleta, se não achar lança o erro
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND ,  "Cliente não encotrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Só atualiza os campos passados no FORM (restfull- json)
    public void atualizar(@PathVariable Integer id , @RequestBody  Cliente pClienteAtualizado){ //@Valid ATIVA as configurações de msg.properties
        repository
                .findById(id)
                .map( cliente -> { // valor do cliente do banco
                    cliente.setNome(pClienteAtualizado.getNome()); //valor passado no FORM
                    cliente.setCpf(pClienteAtualizado.getCpf());
                    return repository.save(cliente); //coloca return pq se o método MAP encontrar null ele vai executar o else
                }) //primeiro procura por id e depos da o map.. Depois deleta, se não achar lança o erro
                .orElseThrow( () -> new ResponseStatusException((HttpStatus.NOT_FOUND)));

    }
}
