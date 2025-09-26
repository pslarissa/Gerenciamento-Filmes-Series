package services;

import modulos.Genero;
import modulos.Obra;
import repositories.ObrasRepository;

import java.util.List;

public class ObraService {

    private ObrasRepository repository;

    public ObraService(ObrasRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Obra obra) {
        Obra aux = repository.buscar(obra.getId());
        if (aux != null) {
            System.out.println("Obra ja cadastrada");
        } else if (obra.getAtor() == null) {
            System.out.println("Não é possível cadastrar obra sem o ator");
        } else if (obra.getGeneros() == null) {
            System.out.println("Obra sem genero");
        } else if (obra.getTitulo() == null) {
            System.out.println("Obra sem titulo");
        } else if (obra.getId() == null) {
            System.out.println("Sem o ID não é possível cadastrar");
        } else if (obra.getDiretor() == null) {
            System.out.println("Obra sem diretor");
        } else if (obra.getAno() == null) {
            System.out.println("Obra sem data de lançamento");
        } else if (obra.getClassificacao() == null) {
            System.out.println("Obra sem classificação indicativa");
        } else {
            System.out.println("Obra cadastrada");
            repository.cadastrar(obra);
        }
    }

    public Obra buscar(Long id) {
        Obra obra = repository.buscar(id);
        if (obra == null) {
            throw new RuntimeException("Não existe essa obra  no banco");
        }
        return obra;
    }

    public List<Obra> buscarGenero(Genero genero) {
        return repository.buscarPorGenero(genero);
    }

    public void remover(Long id) {
        Obra obra = repository.buscar(id);
        if (obra == null) {
            throw new RuntimeException("Obra não encontrada!");
        }
        repository.remover(obra.getId());
    }

    public void atualizar(Long id, Obra obra){
        Obra obra1 = repository.buscar(id);
        if (obra.getClassificacao()!=null){
            obra1.setClassificacao(obra.getClassificacao());
        }
        if (obra.getTitulo()!=null) {
            obra1.setTitulo(obra.getTitulo());
        }
        repository.atualizar(id,obra1);
    }

    public List<Obra> listarObras() {
        return repository.listarObras();
    }
}