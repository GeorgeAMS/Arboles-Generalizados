package logic;
import java.util.Scanner;
import java.util.InputMismatchException;
public class menu {
    public static void main(String[] args) {

        arbolGeneralizado l1 = new arbolGeneralizado();
        Scanner sn = new Scanner(System.in);
        boolean Bandera=false;
        int Valor;

        do{
            System.out.println("""
            -----------------------------------------------------------------------
                    Ingrese el numero de alguna de las siguientes opciones:

                1.  Crear Arbol
                0. Salir
            -------------------------------------------------------------------
            """);
            Valor= sn.nextInt();

            switch (Valor) {

                case 1:
                    System.out.println("""
                            \n Por Favor ingrese el valor con el siguiente formato ==  
                                Padres :         {
                                Hermanos :      ,
                            """);

                    String arbolEnstring = sn.next();
                    l1.insertarDatos(arbolEnstring);
                    break;



                case 0:
                    System.out.println("Saliendo del menu....");
                    Bandera=true;
                    break;


                default:
                    System.out.println("!!!OPCION NO VALIDA!!!");
                    break;
            }

        }while (!Bandera);


    }
}
