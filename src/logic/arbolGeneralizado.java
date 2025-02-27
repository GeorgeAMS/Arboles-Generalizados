package logic;
import java.util.Scanner;
public class arbolGeneralizado {
    private String cadena;
    private int index;
    private Nodo raiz;
    private int con;
    public arbolGeneralizado() {
        this.cadena = "";
        this.index = 0;
        this.con = 0;
        this.raiz = null;
    }
    public Nodo getRaiz() {
        return raiz;
    }
    public void insertarDatos(String cadena) {
        this.cadena = cadena;
        this.index = 0;
        this.con = 0;
        this.raiz = construir();
        System.out.println("\nÁrbol construido correctamente:");
        imprimir(raiz, "");
    }


    //Caso#1:   Crear arbol
    public Nodo construir() {
        Nodo raiz = null;
        Nodo siguiente = null;


        while (index < cadena.length()) {
            char c = cadena.charAt(index);


            index++;
            con++;
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
                    if (con == 2  ) {
                        siguiente.setSubArbol(construir());
                    }
                    else {
                        Nodo p = new Nodo(siguiente.getDato());
                        siguiente.setSubArbol(p);
                        p.setLiga(construir());
                    }
                }
            }
            else if (c == '}') {
                return raiz;
            }
        }
        return raiz;
    }


    //Caso#2: Buscar Dato
    public Nodo buscarNodo(Nodo nodo, char valor) {
        Nodo p = nodo;
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


    //Caso#3:   Insertar Dato como hijo
    public Nodo insertarLetra(char Hijo, char padre) {
        Nodo NPapa = buscarNodo(raiz, padre);
        if (NPapa == null) {
            System.out.println("El padre ingresado no existe.");
            return null;
        }


        Nodo NHijo = new Nodo(Hijo);
        //Caso NPapa tenia hijos
        if (NPapa.getSubArbol() == null) {
            Nodo NPapa2 = new Nodo(NPapa.getDato());
            NPapa.setSubArbol(NPapa2);
            NPapa2.setLiga(NHijo);
        }
        //Caso NPapa no tenia hijos
        else {
            Nodo NTemporal = NPapa.getSubArbol();
            while (NTemporal.getLiga() != null) {
                NTemporal = NTemporal.getLiga();
            }
            NTemporal.setLiga(NHijo);
        }
        return NHijo;
    }


    //Caso#5: Mostrar Raices
    public void mostrarRaices(Nodo nodo, int C) {
        if (nodo == null) return;
        if(nodo.getSubArbol() != null){
            System.out.println("Raiz Numero: "+C+", es: "+nodo.getDato());
            C++;
        }
        mostrarRaices(nodo.getSubArbol(), C);
        mostrarRaices(nodo.getLiga(), C);
    }


    //Caso#6: Mostrar Hijos
    public void mostrarHijos(Nodo nodo) {
        if (nodo == null) return;
        if (nodo.getSubArbol() == null) {
            System.out.println("El Nodo Hijo es: " + nodo.getDato());
        }
        if (nodo.getSubArbol() != null) {
            mostrarHijos(nodo.getSubArbol().getLiga());
        }
        mostrarHijos(nodo.getLiga());
    }


    //Caso#7: Altura de un Dato
    //Caso#7: Altura de un Dato
    public int encontrarAltura(Nodo nodo, char valor) {
        Nodo encontrado = buscarNodo(nodo, valor);
        if (encontrado == null) {
            System.out.println("El nodo no fue encontrado.");
            return -1;
        }
        return obtenerAltura(encontrado) - 1;
    }

    public int obtenerAltura(Nodo nodo) {
        if (nodo == null) return 0;
        int alturaHijo = obtenerAltura(nodo.getSubArbol());
        return 1 + alturaHijo;
    }


    //Caso#8: Nivel De un Dato
    public void nivel(Nodo nodo, char Dato, int Nivel) {
        if (nodo == null) return;
        if(nodo.getDato() == Dato){
            System.out.println("El nivel del nodo es: " +Nivel);
            if (nodo.getSubArbol() != null) return;
        }
        nivel(nodo.getSubArbol(), Dato, Nivel+1);
        nivel(nodo.getLiga(), Dato, Nivel);
    }


    //Caso#9:   Imprimir Arbol
    public void imprimir(Nodo nodo, String prefijo) {
        if (nodo == null) return;
        System.out.println(prefijo + nodo.getDato());


        if (nodo.getSubArbol() != null) {
            imprimir(nodo.getSubArbol(), prefijo + "  ");
        }
        imprimir(nodo.getLiga(), prefijo);
    }
}
