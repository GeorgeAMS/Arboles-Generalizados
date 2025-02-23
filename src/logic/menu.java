package logic;
import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        arbolGeneralizado arbol = new arbolGeneralizado();
        Scanner scanner = new Scanner(System.in);
        boolean bandera = false;
        int opcion;

        do {
            System.out.println("""
            -----------------------------------------------------------------------
                    Ingrese el número de alguna de las siguientes opciones:

                1. Crear Árbol
                2. Buscar Nodo
                0. Salir
            -----------------------------------------------------------------------
            """);

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("""
                            \nPor favor ingrese el árbol con el siguiente formato:
                            Padres: {
                            Hermanos: ,
                            Ejemplo: A{B C{E{G H} F} D}
                            """);

                    scanner.nextLine();
                    String arbolEnString = scanner.nextLine();
                    arbol.insertarDatos(arbolEnString);
                    System.out.println("Árbol construido correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el carácter a buscar: ");
                    char caracter = scanner.next().charAt(0);
                    Nodo resultado = arbol.buscarNodo(arbol.getRaiz(), caracter);
                    if (resultado != null) {
                        System.out.println("Nodo encontrado: " + resultado.getDato());
                    } else {
                        System.out.println("Nodo no encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del menú...");
                    bandera = true;
                    break;

                default:
                    System.out.println("!!! OPCIÓN NO VÁLIDA !!!");
                    break;
            }
        } while (!bandera);

        scanner.close();
    }
}

