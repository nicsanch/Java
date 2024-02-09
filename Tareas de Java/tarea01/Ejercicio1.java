/**
 * 
 * Ejercicio 1. Cálculo del volumen de un cilindro.
 * 
 * @author Nicolás Sánchez Pérez
 */
package tarea01;

import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class Ejercicio1 {

    public static void main(String[] args) {

    //----------------------------------------------
    //    Declaración de variables y constantes
    //----------------------------------------------

        // Constantes 
        
        final double PI = 3.1415927;
        
        // Variables de entrada 
        
        double radio;
        double altura;
        
        // Variables de salida 
        
        String textoResultado;
        double volumen;
        
        // Variables auxiliares
        
        String volumenFormateado;
        
        // Clase Scanner para petición de datos al usuario a través del teclado
        
        Scanner teclado= new Scanner (System.in);
        
    //----------------------------------------------
    //               Entrada de datos 
    //----------------------------------------------
        System.out.println("Ejercicio 1. Cálculo del volumen de un cilindro");
        System.out.println("--------------------");
        
        System.out.println("Introduce el radio del cilindro:");        // mostramos un mensaje sobre la información que vamos a pedir por teclado
        radio = teclado.nextDouble();                       // a través del Scanner pedimos al usuario que escriba un número.
        
        System.out.println("Introduce la altura del cilindro:");   // mostramos un mensaje sobre la información que vamos a pedir por teclado
        altura = teclado.nextDouble();                    // a través del Scanner pedimos al usuario que escriba un número .

        
    //----------------------------------------------
    //                 Procesamiento 
    //----------------------------------------------
        volumen = PI * (radio * radio) * altura; // se multiplica PI por el radio del cilindro al cuadrado por la altura del cilindro
        volumenFormateado = String.format("%.2f", volumen);//  para recoger solo dos decimales de la variable resultado en un string.
        textoResultado = "El volumen de un cilindro de radio " + radio + " y altura " + altura + " es " + volumenFormateado;
        
        
    //----------------------------------------------
    //              Salida de resultados 
    //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");        
        System.out.println(textoResultado); // se muestra el contenido de la variable textoResultado
        System.out.println ();
        System.out.println ("Fin del programa.");           
    }
}
