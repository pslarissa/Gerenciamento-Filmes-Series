package services;

import modulos.Obra;
import modulos.Pessoa;
import repositories.PessoaRepository;

import java.util.List;

public class PessoaService {

    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Pessoa pessoa) {
        Pessoa aux = repository.buscar(pessoa.getId());
        if (aux != null) {
            System.out.println("A pessoa já existe!");
        } else if (pessoa.getNome() == null) {
            System.out.println("Não é possível salvar sem o nome");
        } else if (pessoa.getId() == null) {
            System.out.println("Não é possível cadastrar sem o ID");
        } else {
            repository.cadastrar(pessoa);
            System.out.println("Pessoa cadastrada");
        }
    }

    public Pessoa buscar(Long id) {
        Pessoa pessoa = repository.buscar(id);
        if (pessoa == null) {
            throw new RuntimeException("Não existe essa pessoa no banco");
        }
        return pessoa;
    }

    public boolean atualizar(Long id, Pessoa pessoa){
        Pessoa pessoa1 = repository.buscar(id);
        if (pessoa1 == null){
            throw new RuntimeException("A Pessoa não existe");
        }
        if(pessoa.getNome()!=null){
            pessoa1.setNome(pessoa.getNome());
            repository.atualizar(id, pessoa1);
        }
        return true;
    }

    public void remover(Long id) {
        Pessoa pessoa = repository.buscar(id);

        if (id == null) {
            throw new RuntimeException("Pessoa não encontrada!");
        }

        repository.remover(pessoa.getId());
    }

    public List<Pessoa> listarTodos() {
        return repository.listarpessoas();
    }
}