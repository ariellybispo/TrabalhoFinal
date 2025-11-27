package Blog.TrabalhoFinal.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Blog.TrabalhoFinal.model.Publicacao;

@Repository
public class PublicacaoRepository {

    private List<Publicacao> lista = new ArrayList<>();
    private int contador = 1;

    public PublicacaoRepository() {
        lista.add(new Publicacao(contador++, "Alunos talentosos", "Adriana Oliveira ",
                LocalDate.of(2025, 10, 31), "Ser um bom estudante universitário é menos sobre um talento inato e mais sobre cultivar uma mentalidade e um ritmo de vida propícios à absorção do saber. Não se trata de acumular notas altas por si só, mas de construir uma fundação sólida de compreensão crítica e autodisciplina."));

        lista.add(new Publicacao(contador++, "Como ser rico?", "Neymar Jr.",
                LocalDate.of(2025, 12, 2), "Apenas nasça com talento."));
    }



    public List<Publicacao> listar() { return lista; }

    public Publicacao buscar(int id) {
        return lista.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void adicionar(Publicacao p) {
        p.setId(contador++);
        lista.add(p);
    }

    public void atualizar(Publicacao p) {
        excluir(p.getId());
        lista.add(p);
    }

    public void excluir(int id) {
        lista.removeIf(p -> p.getId() == id);
    }
}
