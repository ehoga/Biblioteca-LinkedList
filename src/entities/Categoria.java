package entities;

public class Categoria {

    private String nomeCategoria;

    public Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }
    @Override
    public String toString() {
        return nomeCategoria;
    }
}
