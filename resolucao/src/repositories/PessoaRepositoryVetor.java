package repositories;

import modulos.Pessoa;

import java.util.List;

import java.util.Arrays;

import java.util.Objects;

public class PessoaRepositoryVetor implements PessoaRepository {

    private Pessoa[] pessoas;

    public PessoaRepositoryVetor() {
        this.pessoas = new Pessoa[100];
    }

    @Override
    public void cadastrar(Pessoa pessoa) {
        for (int i = 0; i < pessoas.length ; i++) {
            if (pessoas[i] == null) {
                //pessoa.setId((long)i);
                pessoas[i] = pessoa;
                break;
            }
        }
    }

    @Override
    public Pessoa buscar(Long id) {
        Pessoa aux = null;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getId().equals(id)) {
                aux = pessoas[i];
            }
        }
        return aux;
    }

    @Override
    public void remover(Long id) {
        boolean encontrado = false;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getId().equals(id)) {
                encontrado = true;
                for (int j = i; j < pessoas.length - 1; j++) {
                    pessoas[j] = pessoas[j + 1];
                }
                pessoas[pessoas.length - 1] = null;
                break;
            }
        }

        if (!encontrado) {
            throw new RuntimeException("Pessoa não encontrada!");
        }
    }

    @Override
    public void atualizar(Long id, Pessoa pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getId().equals(id)) {
                pessoas[i] = pessoa;
                pessoas[i].setNome(pessoa.getNome());
                break;
            }
        }
    }
    @Override
    public List<Pessoa> listarpessoas() {
        return Arrays.stream(pessoas)
                .filter(Objects::nonNull)
                .toList();
    }
}