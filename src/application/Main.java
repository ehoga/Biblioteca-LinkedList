package application;


import data.Grafo;
import entities.Biblioteca;
import entities.BibliotecaException;
import entities.Categoria;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Categoria c1 = new Categoria("Ficcão Cientifica");
        Categoria c2 = new Categoria("Fantasia");
        Categoria c3 = new Categoria("Terror");
        Categoria c4 = new Categoria("Romance");
        Categoria c5 = new Categoria("Drama");
        Categoria c6 = new Categoria("Suspense");
        Categoria c7 = new Categoria("Ação");
        Categoria[] categorias = {c1, c2, c3, c4, c5, c6, c7};

        grafo.addAresta(c1,c2);
        grafo.addAresta(c2,c1);
        grafo.addAresta(c3,c6);
        grafo.addAresta(c4,c5);
        grafo.addAresta(c5,c4);
        grafo.addAresta(c6,c3);
        grafo.addAresta(c7,c1);

        Biblioteca.addLivro("It", "Stephen King", 2015, c3);
        Biblioteca.addLivro("O iluminado", "Stephen King", 2015, c3);
        Biblioteca.addLivro("Harry Potter", "JK", 2013, c2);
        Biblioteca.addLivro("Senhor dos Aneis", "Tolkien", 2000, c2);
        Biblioteca.addLivro("Trono de Vidro", "Sarah", 2015, c5);
        Biblioteca.addLivro("A Vida é Bela", "Autor", 2000, c4);
        Biblioteca.addLivro("Fahrenheit 451", "Bruno", 2000, c6);
        Biblioteca.addLivro("Duna", "Sarah", 2014, c1);

        int opcao = 0;

        while (opcao != 6) {
            try{
                String opcaoStr = JOptionPane.showInputDialog("""
                Escolha uma opção:

                1 - Adicionar livro
                2 - Listar livros
                3 - Ordenar livros
                4 - Buscar livro
                5 - Recomendação de livros
                6 - Sair""");

                opcao = Integer.parseInt(opcaoStr);

                switch (opcao) {
                    case 1 -> {
                        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                        String autorStr = JOptionPane.showInputDialog("Digite o nome do autor:");
                        String anoPublicacaoStr = JOptionPane.showInputDialog("Digite o ano da publicação");
                        Categoria categoria = (Categoria) JOptionPane.showInputDialog(
                                null,
                                "Selecione a categoria:",
                                "Categoria",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                categorias,
                                categorias[0]
                        );
                        int anoPublicacao = Integer.parseInt(anoPublicacaoStr);
                        Biblioteca.addLivro(titulo, autorStr, anoPublicacao, categoria);
                    }

                    case 2 -> JOptionPane.showMessageDialog(null, Biblioteca.listar());

                    case 3 -> {
                        String[] optionsOrd = {"Titulo", "Autor", "Categoria"};
                        int escolhaOrd = JOptionPane.showOptionDialog(
                                null,
                                "Escolha a forma de ordenação:",
                                "Ordenar Livros",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                optionsOrd,
                                optionsOrd[0]
                        );

                        Biblioteca.ordenarPorBubbleSort(escolhaOrd);

                    }

                    case 4 -> {
                        String[] optionsOrd = {"Titulo", "Categoria"};
                        int escolhaOrd = JOptionPane.showOptionDialog(
                                null,
                                "Escolha a forma da busca:",
                                "Busca",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                optionsOrd,
                                optionsOrd[0]
                        );
                        if (escolhaOrd == 0) {
                            String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                            JOptionPane.showMessageDialog(null, Biblioteca.buscarTitulo(titulo));
                        }else if(escolhaOrd == 1){
                            Categoria categoria = (Categoria) JOptionPane.showInputDialog(
                                    null,
                                    "Selecione a categoria:",
                                    "Categoria",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    categorias,
                                    categorias[0]
                            );
                            JOptionPane.showMessageDialog(null, Biblioteca.buscarCategoria(categoria));
                        }

                    }

                    case 5 -> {
                        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                        JOptionPane.showMessageDialog(null, Biblioteca.recomendarTitulos(titulo, grafo));
                    }

                    case 6 -> JOptionPane.showMessageDialog(null, "Programa fechado");

                    default -> throw new BibliotecaException("Insira uma opção valida");
                }
            }catch (BibliotecaException e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.WARNING_MESSAGE);
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Escolha uma opção", "", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}