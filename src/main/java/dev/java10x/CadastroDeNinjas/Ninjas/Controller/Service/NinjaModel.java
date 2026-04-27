package dev.java10x.CadastroDeNinjas.Ninjas.Controller.Service;


import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Entity transforma uma classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data //Getters e Setters sozinho pelo LOMBOK

public class NinjaModel {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;


    //@ManytoOne um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")//foreing key ou chave estrangeira
    private MissoesModel missoes;


}
