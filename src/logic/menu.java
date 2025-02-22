package logic;

import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        arbolGeneralizado arbol = new arbolGeneralizado();
        boolean bandera = false;

        while (!bandera) {
            System.out.println("""
            --------------------------------------------
                Ingrese el número de alguna opción:

                1. Crear Árbol
                0. Salir
            --------------------------------------------
            """);

            int opcion = sn.nextInt();
            sn.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("""
                            \n Ingrese el árbol en este formato:
                            Ejemplo: A{BC{E{GH}F}D}
                            """);
                    String arbolEnString = sn.nextLine();
                    arbol.insertarDatos(arbolEnString);
                    break;

                case 0:
                    System.out.println("Saliendo del menú...");
                    bandera = true;
                    break;

                default:
                    System.out.println("!!! OPCIÓN NO VÁLIDA !!!");
            }
        }
        sn.close();
    }
}
