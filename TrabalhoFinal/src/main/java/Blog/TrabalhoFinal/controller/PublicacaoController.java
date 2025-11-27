package Blog.TrabalhoFinal.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Blog.TrabalhoFinal.model.Publicacao;
import Blog.TrabalhoFinal.repository.PublicacaoRepository;

@Controller
public class PublicacaoController {

    @Autowired
    private PublicacaoRepository repo;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("publicacoes", repo.listar());
        return "index";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("publicacao", new Publicacao());
        return "form-novo";
    }

    @PostMapping("/salvar")
    public String salvar(@RequestParam String titulo,
                         @RequestParam String autor,
                         @RequestParam String dataPublicacao,
                         @RequestParam String texto,
                         Model model) {

        if (titulo.isBlank() || autor.isBlank() || texto.length() < 10) {
            model.addAttribute("erro", "Preencha todos os campos corretamente!");
            return "form-novo";
        }

        Publicacao p = new Publicacao();
        p.setTitulo(titulo);
        p.setAutor(autor);
        p.setTexto(texto);
        p.setDataPublicacao(LocalDate.parse(dataPublicacao));

        repo.adicionar(p);

        model.addAttribute("msg", "Publicação salva com sucesso!");
        model.addAttribute("publicacoes", repo.listar());
        return "index";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("publicacao", repo.buscar(id));
        return "form-editar";
    }

    @PostMapping("/atualizar")
    public String atualizar(@RequestParam int id,
                            @RequestParam String titulo,
                            @RequestParam String autor,
                            @RequestParam String dataPublicacao,
                            @RequestParam String texto,
                            Model model) {

        Publicacao p = new Publicacao(id, titulo, autor, LocalDate.parse(dataPublicacao), texto);
        repo.atualizar(p);

        model.addAttribute("msg", "Alterado com sucesso!");
        model.addAttribute("publicacoes", repo.listar());
        return "index";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id, Model model) {
        repo.excluir(id);
        model.addAttribute("msg", "Publicação excluída com sucesso!");
        model.addAttribute("publicacoes", repo.listar());
        return "index";
    }
}
