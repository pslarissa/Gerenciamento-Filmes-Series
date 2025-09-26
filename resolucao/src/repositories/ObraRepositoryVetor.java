package repositories;
import modulos.Ator;
import modulos.Genero;
import modulos.Obra;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ObraRepositoryVetor implements ObrasRepository{

    private Obra[] obras;

    public ObraRepositoryVetor() {
        this.obras = new Obra[100];
    }

    @Override
    public void cadastrar(Obra obra) {
        for (int i = 0; i <obras.length ; i++) {
            if(obras[i] == null){
                obras[i] = obra;
                break;
            }
        }
    }

    public Obra buscar (Long id){
        Obra aux = null;
        for(int i = 0; i < obras.length; i++){
            if (obras[i] != null && obras[i].getId().equals(id)){
                aux = obras[i];
            }
        }
        return aux;
    }

    public List<Obra> buscarPorAtor(Ator ator){
        List<Obra> listaObras = new ArrayList<>();

        for(int i =0; i<obras.length; i++){
            if(obras[i].getAtor().equals(ator)){
                listaObras.add(obras[i]);
            }
        }
        return listaObras;
    }

    public void deletar(Long id){
        for (int i = 0; i < obras.length; i++) {
            if (obras[i].getId().equals(id)){
                obras[i]=null;
            }
        }
    }

    @Override
    public List<Obra> listarObras() {
        return Arrays.stream(obras)
                .filter(Objects::nonNull)
                .toList();
    }

    @Override
    public List<Obra> buscarPorGenero(Genero genero) {
        List<Obra> listaObras = new ArrayList<>();

        for(int i =0; i<obras.length; i++){
            if(obras[i].getGeneros().contains(genero)){
                listaObras.add(obras[i]);
            }
        }
        return listaObras;
    }

    @Override
    public void remover(Obra obra) {
        for (int i = 0; i < obras.length; i++) {
            if (obras[i].equals(obra)){
                obras[i]=null;
            }
        }
    }

    @Override
    public void remover(Long id) {
        boolean encontrado = false;
        for (int i = 0; i < obras.length; i++) {
            if (obras[i] != null && obras[i].getId().equals(id)) {
                encontrado = true;
                for (int j = i; j < obras.length - 1; j++) {
                    obras[i] = obras[i + 1] = null;
                    break;
                }
            }
        }
        if (!encontrado) {
            throw new RuntimeException("Obra não encontrada!");
        }
    }


    @Override
    public void atualizar(Long id, Obra obra) {
        for (int i = 0; i < obras.length; i++) {
            if (obras[i] != null && obras[i].getId().equals(id)){
                obras[i]=obra;
                obras[i].setClassificacao(obra.getClassificacao());
                obras[i].setTitulo(obra.getTitulo());
                break;
            }
        }

    }
}