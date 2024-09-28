package data.Algoritmos;

import data.ListaEncadeada;
import data.No;
import entities.Livro;

public class BubbleSort {
        public static void bubbleSort(ListaEncadeada<Livro> livros, int ordenarTitulo) {
            if (livros.getHead() == null) {
                return;
            }

            boolean trocado;
            No<Livro> atual;
            No<Livro> prev = null;

            do {
                trocado = false;
                atual = livros.getHead();

                while (atual.getProx() != prev) {
                    No<Livro> proximo = atual.getProx();
                    boolean trocar = isTrocar(ordenarTitulo, atual, proximo);

                    if (trocar) {
                        Livro temp = atual.getElemento();
                        atual.setElemento(proximo.getElemento());
                        proximo.setElemento(temp);
                        trocado = true;
                    }
                    atual = atual.getProx();
                }
                prev = atual;
            } while (trocado);
        }

    private static boolean isTrocar(int ordenarTitulo, No<Livro> atual, No<Livro> proximo) {
        boolean trocar = false;

        if (ordenarTitulo == 0){
            trocar = atual.getElemento().getTitulo().trim().compareToIgnoreCase(proximo.getElemento().getTitulo()) > 0;
        }else if (ordenarTitulo == 1){
            trocar = atual.getElemento().getAutor().getNome().compareToIgnoreCase(proximo.getElemento().getAutor().getNome()) > 0;
        }else if (ordenarTitulo == 2){
            trocar = atual.getElemento().getCategoria().getNomeCategoria().compareToIgnoreCase(proximo.getElemento().getCategoria().getNomeCategoria()) > 0;
        } return trocar;
    }
}
