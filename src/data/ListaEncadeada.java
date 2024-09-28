package data;

public class ListaEncadeada<T> {

    private No<T> head;

    private int tamanho;

    public void addFirst(T elemento) {
        No<T> novoNo = new No<>(elemento);

        if(head == null) {
            head = novoNo;
        }else {
            No<T> temp = head;
            head = novoNo;
            head.setProx(temp);
        }
        tamanho++;
    }

    public void removeFirst() {
        if(head != null){
            head = head.getProx();
            tamanho--;
        }
    }

    public void addLast(T elemento) {
        No<T> novoNo = new No<>(elemento);

        if(head == null) {
            head = novoNo;
        }else {
            No<T> temp = head;
            while (temp.getProx() != null) {
                temp = temp.getProx();
            }
            temp.setProx(novoNo);
        }
        tamanho++;
    }

    public No<T> getHead() {
        return head;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean existe(T elemento) {
        No<T> atual = head;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProx();
        }
        return false;
    }
}
