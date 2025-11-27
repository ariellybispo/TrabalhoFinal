package Blog.TrabalhoFinal.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Blog.TrabalhoFinal.model.Publicacao;

@Repository
public class PublicacaoRepository {

    private List<Publicacao> lista = new ArrayList<>();
    private int contador = 1;

  public PublicacaoRepository() {
    
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
