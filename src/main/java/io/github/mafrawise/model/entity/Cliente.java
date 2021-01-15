package io.github.mafrawise.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.codec.ClientCodecConfigurer;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data //Lombok Gett e  Setts sem precisar escrever no código.
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{campo.nome.obrigatorio}") //InternacionalizacaoConfig aplica o paramentro do menssages.properties
    private String nome;

    @Column(nullable = false , length =  11)
    @NotNull(message = "{campo.cpf.obrigatario}")
    @CPF(message = "{campo.cpf.invalido}") //valida o CPF
    private String cpf;

    @Column(name = "data_cadastro" , updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }


}
