package repositories;

import modulos.Pessoa;

import java.util.List;

public interface PessoaRepository {
    void cadastrar(Pessoa pessoas);
    Pessoa buscar(Long id);
    void remover(Long id);
    void atualizar(Long id, Pessoa pessoas);
    List<Pessoa> listarpessoas();
}