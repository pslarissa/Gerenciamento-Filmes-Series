package modulos;

import java.util.List;

public class Filmes extends Obra {
    private String duracao;

    public Filmes(Long id, String titulo,List<Genero> generos ,String classificacao, String ano, Pessoa diretor, Pessoa ator, String duracao) {
        super(id, titulo,generos, classificacao, ano, diretor, ator);
        this.duracao = duracao;
    }
    public Filmes(){

    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Filmes{" +
                "duracao='" + duracao + '\'' +
                '}';
    }
}