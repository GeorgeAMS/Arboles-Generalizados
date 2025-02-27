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


               1.  Crear Árbol             (Listo)
               2.  Buscar Nodo             (Listo)
               3.  Insertar dato           (Listo)
               4.  Eliminar dato           (En Proceso)
               5.  Mostrar raíces          (Listo)
               6.  Mostrar hojas           (Listo)
               7.  Altura de un dato       (Falta, En proceso)
               8.  Nivel de un dato        (Listo)
               9.  Imprimir Datos          (Listo)
               10. Mostrar Arbol           (Falta)
               11. Reto 1                  (Falta)
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
                case 3:
                    System.out.print("Ingrese el Valor del nodo padre: ");
                    char Padre = scanner.next().charAt(0);
                    System.out.print("Ingrese el valord del nodo hijo: ");
                    char Hijo = scanner.next().charAt(0);
                    Nodo Insertar = arbol.insertarLetra(Hijo, Padre);
                    if (Insertar != null) {
                        System.out.println("!!!Nodo " + Hijo + " se agrego correctamente!!!");
                    } else {
                        System.out.println("El Nodo padre ingresado no existe.");
                    }
                    break;
                case 5:
                    int C = 1;
                    arbol.mostrarRaices(arbol.getRaiz(), C);
                    break;
                case 6:
                    arbol.mostrarHijos(arbol.getRaiz());
                    break;
                case 7:
                    int alturaTotal = arbol.Altura(arbol.getRaiz());
                    System.out.println("Ingrese el nodo para encontrar su nivel: ");
                    char Da = scanner.next().charAt(0);
                    int NiEncontrado = arbol.nivel(arbol.getRaiz(), Da, 0);
                    if (NiEncontrado != -1) {
                        int altura = alturaTotal - NiEncontrado;
                        System.out.println("La altura del dato "+ Da +" es: " + altura);
                    } else {
                        System.out.println("El valor que ingresaste anteriormente no fue enbcontrado");
                    }
                    break;
                case 8:
                    System.out.println("Ingrese el nodo para encontrar su nivel: ");
                    char D = scanner.next().charAt(0);
                    int nivelEncontrado = arbol.nivel(arbol.getRaiz(), D, 0);
                    if (nivelEncontrado != -1) {
                        System.out.println("El nivel del nodo"+ D +" es: " + nivelEncontrado);
                    } else {
                        System.out.println("El valor que ingresaste anteriormente no fue enbcontrado");
                    }
                    break;
                case 9:
                    System.out.println("Su Arbol es:");
                    arbol.imprimir(arbol.getRaiz(), "");
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