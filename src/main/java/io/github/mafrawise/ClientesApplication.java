package io.github.mafrawise;

import io.github.mafrawise.model.entity.Cliente;
import io.github.mafrawise.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {

    /*@Bean
    public CommandLineRunner run(@Autowired ClienteRepository repository){
        return args -> {
            //@Builder Gera uma estância sem precisar do set.
            Cliente cliente = Cliente.builder().cpf("07611172450").nome("Fulano").build();
            repository.save(cliente);
        };
    }*/

    public static void main(String[] args) {
        //método que inicializa a aplicação
        SpringApplication.run(ClientesApplication.class,args);
    }
}
