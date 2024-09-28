package entities;

import data.Algoritmos.BubbleSort;
import data.Aresta;
import data.Grafo;
import data.ListaEncadeada;
import data.No;

public class Biblioteca {
    private static final ListaEncadeada<Livro> livros = new ListaEncadeada<>();

    private Biblioteca() {};

    public static void addLivro(String titulo, String autor, int date, Categoria categoria) {
        livros.addLast(new Livro(titulo, new Autor(autor), date, categoria));
    }

    public static StringBuilder listar() {
        No<Livro> temp = livros.getHead();
        StringBuilder print = new StringBuilder();
        while (temp != null) {
            print.append(temp.getElemento().toString()).append("\n");
            temp = temp.getProx();
        }
        return print;
    }

    public static String buscarTitulo(String titulo) {
        No<Livro> temp = livros.getHead();
        while (temp != null) {
            if (temp.getElemento().getTitulo().equalsIgnoreCase(titulo)) {
                return temp.getElemento().toString();

            }
            temp = temp.getProx();
        }
        return "Livro não encontrado";
    }

    public static StringBuilder buscarCategoria(Categoria categoria){
        No<Livro> temp = livros.getHead();
        StringBuilder print = new StringBuilder();
        while (temp != null) {
            if (temp.getElemento().getCategoria().equals(categoria)){
                print.append(temp.getElemento().toString()).append("\n");
            }
            temp = temp.getProx();
        }
        if (!print.isEmpty()){
            return print;
        }else{
            return new StringBuilder("Nenhum livro dessa categoria");
        }
    }

    public static void ordenarPorBubbleSort(int escolhaOrd) {
        BubbleSort.bubbleSort(livros, escolhaOrd);
    }

    private static Categoria pegarCategoria(String titulo){
        No<Livro> temp = livros.getHead();
        while (temp != null) {
            if (temp.getElemento().getTitulo().equalsIgnoreCase(titulo)) {
                return temp.getElemento().getCategoria();

            }
            temp = temp.getProx();
        }

        return null;
    }

    public static StringBuilder recomendarTitulos(String titulo, Grafo grafo){
        StringBuilder print = new StringBuilder();
        Categoria categoria = pegarCategoria(titulo);

        if (categoria == null){
            return print.append("Livro ou categoria não encontrados");
        }

        ListaEncadeada<Aresta> arestas = grafo.getArestas();
        No<Aresta> tempA = arestas.getHead();

        while (!tempA.getElemento().getOrigem().getCategoria().equals(categoria)) {
            tempA = tempA.getProx();
        }
        return print.append("Se voce gosta de livros de ").append(categoria.getNomeCategoria()).append(", ")
                .append("nossa biblioteca recomenda a categoria de ").append(tempA.getElemento().getDestino().getCategoria().getNomeCategoria()).append(", ")
                .append("segue os livros disponiveis nessa categoria:").append("\n\n").append(buscarCategoria(tempA.getElemento().getDestino().getCategoria()));
    }

}
