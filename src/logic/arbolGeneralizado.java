package logic;

public class arbolGeneralizado {
    private Nodo raiz;

    public arbolGeneralizado() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void construirDesdeCadena(String cadena) {
        int[] index = {0};
        this.raiz = construir(cadena, index);
    }

    private Nodo construir(String cadena, int[] index) {
        Nodo raizLocal = null;
        Nodo siguiente = null;

        while (index[0] < cadena.length()) {
            char c = cadena.charAt(index[0]);
            index[0]++;

            if (Character.isLetter(c)) {
                Nodo nuevo = new Nodo(c);
                if (raizLocal == null) {
                    raizLocal = nuevo;
                } else {
                    siguiente.setLiga(nuevo);
                }
                siguiente = nuevo;
            } else if (c == '{') {
                if (siguiente != null) {
                    siguiente.setSubArbol(construir(cadena, index));
                }
            } else if (c == '}') {
                return raizLocal;
            }
        }
        return raizLocal;
    }

    // Método único para buscar un nodo
    public Nodo buscarNodo(Nodo p, char valor) {
        while (p != null) {
            if (p.getDato() == valor) {
                return p;
            }

            if (p.getSubArbol() != null) {
                Nodo encontrado = buscarNodo(p.getSubArbol(), valor);
                if (encontrado != null) {
                    return encontrado;
                }
            }

            p = p.getLiga();
        }
        return null;
    }
}
