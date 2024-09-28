package data;

import entities.Categoria;

public class Grafo {
    ListaEncadeada<Vertice> vertices;
    ListaEncadeada<Aresta> arestas;

    public Grafo() {
        vertices = new ListaEncadeada<>();
        arestas = new ListaEncadeada<>();
    }

    public void addVertice(Categoria nomeCategoria){
        Vertice vertice = new Vertice(nomeCategoria);
        if(!vertices.existe(vertice)){
            vertices.addLast(vertice);
        }
    }

    public void addAresta(Categoria c1, Categoria c2){
        Vertice vertice1 = new Vertice(c1);
        Vertice vertice2 = new Vertice(c2);

        if (!vertices.existe(vertice1)) {
            vertices.addLast(vertice1);
        }
        if (!vertices.existe(vertice2)) {
            vertices.addLast(vertice2);
        }

        Aresta aresta = new Aresta(vertice1, vertice2);
        arestas.addLast(aresta);
    }

    public ListaEncadeada<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ListaEncadeada<Vertice> vertices) {
        this.vertices = vertices;
    }

    public ListaEncadeada<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ListaEncadeada<Aresta> arestas) {
        this.arestas = arestas;
    }
}
