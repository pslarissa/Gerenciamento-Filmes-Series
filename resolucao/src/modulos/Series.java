package modulos;

import java.util.List;

public class Series extends Obra {
    private String episodios;
    private String temporadas;
    //private Pessoa diretor;
    //private Pessoa ator;


    public Series(Long id, String titulo, List<Genero> generos,String classificacao, String ano, Pessoa diretor, Pessoa ator, String episodios, String temporadas) {
        super(id, titulo, generos,classificacao, ano, diretor, ator);
        this.episodios = episodios;
        this.temporadas = temporadas;
    }

    public Series(){
    }

    public String getEpisodios() {
        return episodios;
    }

    public void setEpisodios(String episodios) {
        this.episodios = episodios;
    }

    public String getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(String temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public String toString() {
        return "Series{" +
                "episodios='" + episodios + '\'' +
                ", temporadas='" + temporadas + '\'' +
                '}';
    }
}