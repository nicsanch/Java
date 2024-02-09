/**
 * 
 * Ejercicio 4. Gestión de recursos hídricos.
 * 
 * @author Nicolás Sánchez Pérez
 */
package tarea01;

import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class Ejercicio4 {

    public static void main(String[] args) {

    //----------------------------------------------
    //    Declaración de variables y constantes
    //----------------------------------------------

        // Constantes 
        final double MAX = 2000;
        
        // Variables de entrada 
        double volumen;
        
        // Variables de salida 
        String textoResultado;
        
        // Variables auxiliares
        double porcentaje;
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado= new Scanner (System.in);
        
    //----------------------------------------------
    //               Entrada de datos 
    //----------------------------------------------
        System.out.println("Ejercicio 4. Gestión de recursos hídricos");
        System.out.println("--------------------");
        
        System.out.println("Introduce el volumen actual de agua almacenada en el embalse (hectómetros cúbicos): ");        // mostramos un mensaje sobre la información que vamos a pedir por teclado
        volumen = teclado.nextDouble();                       // a través del Scanner pedimos al usuario que escriba una línea (texto)
        
    //----------------------------------------------
    //                 Procesamiento 
    //----------------------------------------------

        porcentaje = ((volumen * 100) / MAX);
        System.out.println("Faltan " + (MAX - volumen) + " hectómetros cúbicos para llenar completamente el embalse.");
        System.out.println("El embalse está a un " + porcentaje + "% de su capacidad máxima.");
        textoResultado = porcentaje > (95) ? (
                    "Se ha realizado una liberación del 10.0% vaciando un total de " + (volumen*10 / 100) + " hectómetros cúbicos. \n En el embase quedan ahora " + (volumen - (volumen*10 / 100)) + " hectómetros cúbicos, que representan un " + ((volumen - (volumen*10 / 100)) * 100 / MAX) + "% de su capacidad máxima."
                    ) : (
                    "No es necesario considerar la liberación controlada de agua en este momento."
                    );
        
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
