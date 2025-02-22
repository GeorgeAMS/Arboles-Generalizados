package logic;

public class nodos {
    public class nodo {
        private char dato;
        private nodo subArbol;
        private nodo liga;

        public char getDato() {
            return dato;
        }

        public void setDato(char dato) {
            this.dato = dato;
        }

        public nodo getSubArbol() {
            return subArbol;
        }

        public void setSubArbol(nodo subArbol) {
            this.subArbol = subArbol;
        }

        public nodo getLiga() {
            return liga;
        }

        public void setLiga(nodo liga) {
            this.liga = liga;
        }
    }
}


