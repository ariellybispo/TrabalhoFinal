package Blog.TrabalhoFinal.model;

import java.time.LocalDate;

public class Publicacao {

    private int id;
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private String texto;

    public Publicacao() {}

    public Publicacao(int id, String titulo, String autor, LocalDate dataPublicacao, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.texto = texto;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public LocalDate getDataPublicacao() { return dataPublicacao; }
    public void setDataPublicacao(LocalDate dataPublicacao) { this.dataPublicacao = dataPublicacao; }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
}
