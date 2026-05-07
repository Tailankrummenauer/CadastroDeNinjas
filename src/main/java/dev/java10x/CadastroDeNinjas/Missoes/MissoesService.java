package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Adicionar missao(Create)
    public MissoesModel criarMissao(MissoesModel missoesModel){
       return missoesRepository.save(missoesModel);
    }

    //Listar todas missoes(READ)
    public List<MissoesModel> listarTodasMissoes(){
        return missoesRepository.findAll();
    }

    //Listar Missoes por id(READ)
    public MissoesModel listarPorId(Long id){
        return missoesRepository.findById(id).orElseThrow(() -> new RuntimeException("Missao nao encontrada"));
    }

    //Deletar Missoes por id(DELETE)
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

    //atualizar missao por id (ATUALIZAR)



}
