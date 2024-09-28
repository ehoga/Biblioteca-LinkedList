package data;

public class No<T> {

    private T elemento;
    private No<T> prox;

    public No(T elemento) {
        this.elemento = elemento;
        this.prox = null;
    }

    public No(T elemento, No<T> prox) {
        this.elemento = elemento;
        this.prox = prox;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No<T> getProx() {
        return prox;
    }

    public void setProx(No<T> prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento=" + elemento +
                '}';
    }
}
