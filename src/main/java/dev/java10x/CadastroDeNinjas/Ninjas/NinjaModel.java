package dev.java10x.CadastroDeNinjas.Ninjas;


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

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    //@ManytoOne um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id", nullable = true)//foreing key ou chave estrangeira
    private MissoesModel missoes;




}
