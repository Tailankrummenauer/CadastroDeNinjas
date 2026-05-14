package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class NinjaService {

    //@Autowired ----  fazer isso apenas para injecao de dependencia(fazer o uso de uma classe\interface), mas uma boa pratica é usar o construtor
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar ninjas por ID
    public NinjaDTO listarNinjaId(Long id){
       Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    //Adicionar novo ninja
    public NinjaDTO adicionarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar novo ninja, tem que ser metodo VOID
    public void deletarNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }

    //Atualizar novo ninja, passa id como busca e nome como edição
    public NinjaDTO atualizarNomeNinja(Long id, NinjaDTO ninja) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninja);
            ninjaAtualizado.setId(id);
            ninjaAtualizado = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaAtualizado);
        }
        return null;
    }
}
