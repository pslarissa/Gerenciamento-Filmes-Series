package modulos;

public class Diretor extends Pessoa{
    private String obrasDirigidas;
    public Diretor(String nome, Long id, String obrasDirigidas) {
        super(nome, id);
        this.obrasDirigidas = obrasDirigidas;
    }

    public Diretor() {
    }

    public String getObrasDirigidas() {
        return obrasDirigidas;
    }

    public void setObrasDirigidas(String obrasDirigidas) {
        this.obrasDirigidas = obrasDirigidas;
    }

    @Override
    public String toString() {
        return  getNome();
    }
}