/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea02;

/**
 * 
 * Ejercicio 2. Máquina expendedora.
 * 
 * @author Nicolás Sánchez Pérez
 */

import java.util.Scanner;

public class Ejercicio02 {

    public enum Bebidas {
        COCACOLA, PEPSI, AGUA, ZUMO, OTRO
    };

    public static void main(String[] args) {

         //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Variables de entrada (aquí se definen las variables que recibirán valores, si fueran necesarias)
        int opcion;
        double precio;
        double pago;
        // Variables de salida (aquí se definen las variables que almacenarán resultados y se mostrarán al usuario, si fueran necesarias)
        String seleccion;
        // Clase Scanner para petición de datos al usuario a través del teclado
        
        Scanner scanner = new Scanner(System.in);
        Bebidas miBebida = null;
        precio = 0;
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 2: Máquina expendedora de Bebidas\n");
        System.out.println();      


        System.out.println("Bienvenido a la Máquina Expendedora de Bebidas");      
        System.out.println("Selecciones una bebida:");      
        System.out.println("1. COCACOLA - 1.50€");      
        System.out.println("2. PEPSI - 1.50€");      
        System.out.println("AGUA - 1.00€");     
        System.out.println("ZUMO de naranja - 2.00€");      
        System.out.println("0. Salir");      
        System.out.println();      
        System.out.println("Selecciona una opcion:");      
        opcion = scanner.nextInt();

        // Bloque 1: Sacamos por pantalla el menú de opciones y pedimos que introduzca una.
        //  En caso de introducir una opción inválida, debemos indicarlo y volver a pedirla.
                
        while (opcion < 0 || opcion > 4){
            System.out.println("Opción no válida. Seleccione una bebida válida.");
            opcion = scanner.nextInt();
        }
            
  // Cuando haya introducido una opción válida, llevamos a cabo la acción oportuna
        //  -Si nos indica 'Salir', nos despedimos y terminamos
        //  -Si nos indica un producto
        
        switch (opcion){
            case 0:
                System.out.println("Gracias por usar la Máquina Expendedora. ¡Hasta luego!"); 
                return;
            case 1:
                precio = 1.50;
                miBebida = Bebidas.COCACOLA;
                break;
            case 2:
                precio = 1.50;
                miBebida = Bebidas.PEPSI;
                break;
            case 3:
                precio = 1.00;
                miBebida = Bebidas.AGUA;
                break;
            case 4:
                precio = 2.00;
                miBebida = Bebidas.ZUMO;
                break;
        }
        //      -Decimos el producto seleccionado y su precio

        if (opcion > 0 && opcion < 5){
            seleccion = ("Ha seleccionado " + miBebida + ". El precio es de " + precio + " €");
            System.out.println(seleccion);
        }
        
        //      -Pedimos que introduzca el importe
        
        System.out.println("Ingrese la cantidad de dinero en euros:");
        pago = scanner.nextInt();
        
         //          -Si no, indicamos que el importe es insuficiente 
      
        if (pago < precio)
            System.out.println("Dinero insuficiente. Su dinero será devuelto.");
        
        //          -Si el importe es suficiente
        //               -Imprimimos el producto obtenido (Equivale a la orden de suministrar el producto
        //               -Decimos el importe que ha sobrado

        else        {
            System.out.println("Compra existosa. Su cambio es de " + (pago - precio) + " €");
            System.out.println("Disfrute su " + miBebida);
        }
                
    }
}

