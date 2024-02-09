/**
 * 
 * Ejercicio 2. Operadores aritméticos.
 * 
 * @author Nicolás Sánchez Pérez.
 */
package tarea01;

import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class Ejercicio2 {

    public static void main(String[] args) {

    //----------------------------------------------
    //    Declaración de variables y constantes
    //----------------------------------------------

        // Constantes 
        
        // Variables de entrada 
        int num1;
        int num2;
        int num3;
        
        // Variables de salida 
        String textoResultado1;
        String textoResultado2;
        String textoResultado3;
        String textoResultado4;
        double  resultado1;
        double  resultado2;
        boolean resultado3;
        double  resultado4;
        
        // Variables auxiliares
        int     aux;
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado= new Scanner (System.in);
        
    //----------------------------------------------
    //               Entrada de datos 
    //----------------------------------------------
        System.out.println("Ejercicio 2. Operadores aritméticos");
        System.out.println("--------------------");
        
        System.out.println("Introduce el valor del primer numero:");        // mostramos un mensaje sobre la información que vamos a pedir por teclado
        num1 = teclado.nextInt();                       // a través del Scanner pedimos al usuario que escriba un entero
        
        System.out.println("Introduce el valor del segundo numero:");        // mostramos un mensaje sobre la información que vamos a pedir por teclado
        num2 = teclado.nextInt();                       // a través del Scanner pedimos al usuario que escriba un entero

        System.out.println("Introduce el valor del tercer numero:");        // mostramos un mensaje sobre la información que vamos a pedir por teclado
        num3 = teclado.nextInt();                       // a través del Scanner pedimos al usuario que escriba un entero

        
    //----------------------------------------------
    //                 Procesamiento 
    //----------------------------------------------
        resultado1 = (double)num1 /3 + (double)num3 /2;
        aux = ((num2 + num3)/ 2);
        resultado2 = aux * aux;
        resultado3 = ((num2 + num3 - num1)*3)%2 == 0;
        resultado4 = (double)((num1 + num2)*(num3 - num1))/num2;
        textoResultado1 = "Valor del tercio del primer número más la mitad del tercer número: " + resultado1;
        textoResultado2 = "Valor del cuadrado de la mitad de la suma del segundo número más el tercero: " + resultado2;
        textoResultado3 = "Comprobamos si el triple de la suma del segundo más el tercer número menos el primero es par: " + resultado3;
        textoResultado4 = "Valor de la suma del primero más el segundo, multiplicado por la diferencia del tercero menos el primero y todo ello partido por el segundo número: " + resultado4;

        
        
    //----------------------------------------------
    //              Salida de resultados 
    //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");        
        System.out.println(textoResultado1);
        System.out.println(textoResultado2);
        System.out.println(textoResultado3);
        System.out.println(textoResultado4);
        System.out.println ();
        System.out.println ("Fin del programa.");           
    }
}
