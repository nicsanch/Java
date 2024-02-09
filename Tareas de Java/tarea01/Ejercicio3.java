/**
 * 
 * Ejercicio 3. Palabras circulares.
 * 
 * @author Nicolás Sánchez Pérez
 */
package tarea01;

import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class Ejercicio3 {

    public static void main(String[] args) {

    //----------------------------------------------
    //    Declaración de variables y constantes
    //----------------------------------------------

        // Constantes 
    
        // Variables de entrada 
        String  pal1;
        String pal2;
        String pal3;
          
        // Variables de salida 
        String  respuesta1;
        String  respuesta2;
        String  respuesta3;
        String  respuesta4;
        String  textoResultado1;
        String  textoResultado2;
        String  textoResultado3;
        String  textoResultado4;
        
        // Variables auxiliares
        int size1;
        int size2;
        int size3;
        
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado= new Scanner (System.in);
        
    //----------------------------------------------
    //               Entrada de datos 
    //----------------------------------------------
        System.out.println("Ejercicio 3. Palabras encadenadas");
        System.out.println("--------------------");
        
        System.out.println("Introduce la PRIMERA palabra: ");        // mostramos un mensaje sobre la información que vamos a pedir por teclado
        pal1 = teclado.nextLine();                       // a través del Scanner pedimos al usuario que escriba una línea (texto)
        
        System.out.println("Introduce la SEGUNDA palabra: ");   // mostramos un mensaje sobre la información que vamos a pedir por teclado
        pal2 = teclado.nextLine();                    // a través del Scanner pedimos al usuario que escriba un número entero 
      
        System.out.println("Introduce la TERCERA palabra: ");   // mostramos un mensaje sobre la información que vamos a pedir por teclado
        pal3 = teclado.nextLine();                    // a través del Scanner pedimos al usuario que escriba un número entero 

        
    //----------------------------------------------
    //                 Procesamiento 
    //----------------------------------------------

        size1 = pal1.length(); 
        size2 = pal2.length();
        size3 = pal3.length();
        
        respuesta1 = (size1 + size2 < 6) | (size3 > 8) ? "SI" : "NO";
        textoResultado1 = "La longitud de las dos primeras palabras es menor de 6 o la longitud de la tercera es mayor de 8 caracteres : " + respuesta1;
        
        respuesta2 = ((size2 > size1) & (size2 > size3)) ? "SI" : "NO";
        textoResultado2 = "La segunda palabra es la palabra de mayor longitud : " + respuesta2;
        
        
        respuesta3 = (pal1.charAt(size1 -1) == pal2.charAt(0)) && (pal2.charAt(size2 - 1) == pal3.charAt(0)) ? "SI" : "NO";
        textoResultado3 = "Las tres palabras introducidas son palabras encadenadas: " + respuesta3;

        respuesta4 = (pal1.charAt(size1 -1) == pal2.charAt(0)) && (pal2.charAt(size2 - 1) == pal3.charAt(0)) && (pal3.charAt(size3 - 1) == pal1.charAt(0)) ? "SI" : "NO";
        textoResultado4 = "Las tres palabras introducidas son palabras circulares: " + respuesta4;
    
    //----------------------------------------------
    //              Salida de resultados 
    //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");        
        System.out.println(textoResultado1); // se muestra el contenido de la variable textoResultado
        System.out.println(textoResultado2); // se muestra el contenido de la variable textoResultado
        System.out.println(textoResultado3); // se muestra el contenido de la variable textoResultado
        System.out.println(textoResultado4); // se muestra el contenido de la variable textoResultado

        System.out.println ();
        System.out.println ("Fin del programa.");           
    }
}
