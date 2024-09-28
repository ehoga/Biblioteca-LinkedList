package entities;

public class Livro {
    private String titulo;
    private Autor autor;
    private int ano;
    private Categoria categoria;

    public Livro(String titulo, Autor autor, int ano, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "'" + titulo + '\'' +
                " - Autor=" + autor.getNome() +
                ", Ano=" + ano +
                ", Categoria=" + categoria;
    }
}
