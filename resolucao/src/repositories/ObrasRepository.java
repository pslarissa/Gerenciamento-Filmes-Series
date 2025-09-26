package repositories;

import modulos.Genero;
import modulos.Obra;

import java.util.List;

public interface ObrasRepository{

    void cadastrar(Obra obra);
    List<Obra> listarObras();
    Obra buscar (Long id);
    List<Obra> buscarPorGenero(Genero genero);
    void remover(Obra obra);
    void remover(Long id);
    void atualizar(Long id, Obra obra);
}