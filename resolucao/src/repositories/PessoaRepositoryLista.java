package repositories;

import modulos.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepositoryLista implements PessoaRepository {
    private List<Pessoa> pessoas;

    public PessoaRepositoryLista(){
        this.pessoas = new ArrayList<>();
    }

    @Override
    public void cadastrar(Pessoa pessoas) {
        this.pessoas.add(pessoas);
    }

    @Override
    public Pessoa buscar(Long id) {
        Pessoa pessoa = null;
        for(int i = 0; i < pessoas.size();i++){
            if (pessoas.get(i).getId().equals(id)){
                pessoa = pessoas.get(i);
            }
        }
        return pessoa;
    }

    @Override
    public void remover(Long id) {
        for (int i = 0; i < pessoas.size(); i++){
            if (pessoas.get(i).getId().equals(id)){
                pessoas.remove(i);
                break;
            }
        }
    }

    @Override
    public void atualizar(Long id, Pessoa pessoa) {
        for (int i =0; i < this.pessoas.size(); i++) {
            if (pessoas.get(i).getId().equals(id)) {
                pessoas.remove(pessoas.get(i));
                pessoas.add(pessoa);
            }
        }
    }

    @Override
    public List<Pessoa> listarpessoas() {
        return pessoas;
    }
}