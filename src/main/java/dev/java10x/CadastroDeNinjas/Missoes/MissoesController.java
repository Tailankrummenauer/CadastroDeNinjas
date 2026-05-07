package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/adicionarmisssao")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missoesService.criarMissao(missao);
    }

    @GetMapping("/listarmissoes")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarTodasMissoes();
    }

    @GetMapping("/listarmissoesid/{id}")
    public MissoesModel listarMissoesId(@PathVariable Long id){
        return missoesService.listarPorId(id);
    }

    @DeleteMapping("/deletarmissoes/{id}")
    public void deletarMissao(@PathVariable Long id){
     missoesService.deletarMissao(id);
    }
}
