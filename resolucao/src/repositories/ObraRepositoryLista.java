package repositories;

import modulos.Genero;
import modulos.Obra;

import java.util.ArrayList;
import java.util.List;

public class ObraRepositoryLista implements ObrasRepository {
    private List<Obra> obras;

    public ObraRepositoryLista() {
        this.obras = new ArrayList<>();
    }

    @Override
    public void cadastrar(Obra obra) {
        this.obras.add(obra);
    }

    @Override
    public List<Obra> listarObras() {
        return obras;
    }

    @Override
    public Obra buscar(Long id) {
        Obra obra = null;
        for (int i = 0; i<obras.size();i++){
            if (obras.get(i).getId().equals(id)){
                obra = obras.get(i);
            }
        }
        return obra;
    }

    @Override
    public List<Obra> buscarPorGenero(Genero genero) {
        return List.of();
    }

    @Override
    public void remover(Obra obra) {
        for (int i = 0; i < obras.size(); i++) {
            if (obra.getId().equals(obra)) {
                obra = null;
            }
        }
    }

    @Override
    public void remover(Long id) {
        for (int i = 0; i < obras.size(); i++) {
            if (obras.get(i).getId().equals(id)) {
                obras.remove(i);
                return;
            }
        }
        throw new RuntimeException("Obra não encontrada no repositório.");
    }

    @Override
    public void atualizar(Long id, Obra obra) {
        for (int i =0; i < this.obras.size(); i++) {
            if (obras.get(i).getId().equals(id)) {
                obras.remove(obras.get(i));
                obras.add(obra);

            }
        }
    }
}