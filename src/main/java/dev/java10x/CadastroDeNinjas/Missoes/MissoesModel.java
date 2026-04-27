package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.Controller.Service.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tabela_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Character rank;


    //Uma Missao pode ter muitos ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

    //all args
    public MissoesModel(String nome, Character rank, List<NinjaModel> ninjas) {
        this.nome = nome;
        this.rank = rank;
        this.ninjas = ninjas;
    }

    //Noargs
    public MissoesModel() {
    }
}
