package logic;

public class Nodo {
    private char dato;
    private Nodo subArbol;
    private Nodo liga;

    public Nodo(char dato) {
        this.dato = dato;
        this.subArbol = null;
        this.liga = null;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodo getSubArbol() {
        return subArbol;
    }

    public void setSubArbol(Nodo subArbol) {
        this.subArbol = subArbol;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
}
