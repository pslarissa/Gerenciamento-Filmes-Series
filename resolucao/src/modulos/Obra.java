package modulos;

import java.util.ArrayList;
import java.util.List;

public abstract class Obra {
    private Long id;
    private String titulo;
    private List<Genero> generos;
    private String classificacao;
    private String ano;
    private Pessoa diretor;
    private Pessoa ator;

    public Obra(Long id, String titulo,List<Genero>generos ,String classificacao, String ano, Pessoa diretor, Pessoa ator) {
        this.id = id;
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.ano = ano;
        this.generos = generos;
        this.diretor = diretor;
        this.ator = ator;

    }

    public Obra() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public Pessoa getDiretor() {
        return diretor;
    }

    public void setDiretor(Pessoa diretor) {
        this.diretor = diretor;
    }

    public Pessoa getAtor() {
        return ator;
    }

    public void setAtor(Pessoa ator) {
        this.ator = ator;
    }

    @Override
    public String toString() {
        return "Obra{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", generos=" + generos +
                ", classificacao='" + classificacao + '\'' +
                ", ano='" + ano + '\'' +
                ", diretor=" + diretor +
                ", ator=" + ator +
                '}';
    }
}