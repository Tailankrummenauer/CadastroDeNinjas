package dev.java10x.CadastroDeNinjas.Ninjas;
import org.springframework.data.jpa.repository.JpaRepository;



//JPA literalmente é tudo que é feito no banco em SQL mas em shortcut dentro do java em metodos
public interface NinjaRepository extends JpaRepository<NinjaModel,Long> {
}
