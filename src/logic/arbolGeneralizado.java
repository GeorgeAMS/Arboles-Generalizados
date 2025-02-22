package logic;

public class arbolGeneralizado {
    private String cadena;
    private int index;

    public arbolGeneralizado() {
        this.cadena = "";
        this.index = 0;
    }

    public void insertarDatos(String cadena) {
        this.cadena = cadena;
        this.index = 0;
        Nodo raiz = construir();
        System.out.println("\nÁrbol construido correctamente:");
        imprimir(raiz, "");
    }

    public Nodo construir() {
        Nodo raiz = null;
        Nodo siguiente = null;

        while (index < cadena.length()) {
            char c = cadena.charAt(index);
            index++;

            if (Character.isLetter(c)) {
                Nodo nuevo = new Nodo(c);

                if (raiz == null) {
                    raiz = nuevo;
                } else {
                    siguiente.setLiga(nuevo);
                }
                siguiente = nuevo;
            }
            else if (c == '{') {
                if (siguiente != null) {
                    siguiente.setSubArbol(construir());
                }
            }
            else if (c == '}') {
                return raiz;
            }
        }
        return raiz;
    }

    public void imprimir(Nodo nodo, String prefijo) {
        if (nodo == null) return;
        System.out.println(prefijo + nodo.getDato());

        if (nodo.getSubArbol() != null) {
            imprimir(nodo.getSubArbol(), prefijo + "  ");
        }
        imprimir(nodo.getLiga(), prefijo);
    }
}
