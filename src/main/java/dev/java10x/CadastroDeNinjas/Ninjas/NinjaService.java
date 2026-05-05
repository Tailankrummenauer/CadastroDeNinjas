package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NinjaService {

    //@Autowired ----  fazer isso apenas para injecao de dependencia(fazer o uso de uma classe\interface), mas uma boa pratica é usar o construtor
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //Listar ninjas por ID
    public NinjaModel listarNinjaId(Long id){
        return ninjaRepository.findById(id).orElseThrow(() -> new RuntimeException("Ninja não encontrado"));
    }

    //Adicionar novo ninja
    public NinjaModel adicionarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }
    //Deletar novo ninja, tem que ser metodo VOID
    public void deletarNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }

    //Atualizar novo ninja, passa id como busca e nome como edição
    public NinjaModel atualizarNomeNinja(Long id, NinjaModel ninja) {
        if (ninjaRepository.existsById(id)) {
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        return null;
    }
}
