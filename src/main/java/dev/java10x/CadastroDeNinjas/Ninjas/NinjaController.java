package dev.java10x.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Adicionar ninja(Create)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.adicionarNinja(ninja);
    }

    //Mostrar todos ninjas(READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostrar por ID(READ)
    @GetMapping("listar/{id}")
    public NinjaModel ninjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjaId(id);

    }

    //Alterar(Update)
    @PutMapping("/alterarnome/{id}")
    public NinjaModel alterarNinjaNome(@PathVariable Long id, @RequestBody NinjaModel ninja){
        return ninjaService.atualizarNomeNinja(id, ninja);
    }

    //Deletar ninja(DELETE)
    @DeleteMapping("/deletarid/{id}")
    public void deletarID(@PathVariable Long id){
        ninjaService.deletarNinjaId(id);
    }

}
