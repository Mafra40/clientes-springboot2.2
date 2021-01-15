package io.github.mafrawise.repository;

import io.github.mafrawise.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

//Classe obrigatório para fazer as inserções no banco de DADOS
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
