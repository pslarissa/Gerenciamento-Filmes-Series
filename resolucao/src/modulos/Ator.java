package modulos;

public class Ator extends Pessoa{
    public Ator(String nome, Long id) {
        super(nome, id);
    }
    public Ator(){
    }

    @Override
    public String toString() {
        return   getNome();
    }
}