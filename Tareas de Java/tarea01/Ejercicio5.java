/**
 * 
 * Ejercicio 5. ¡Vamos al parque acuático!
 * 
 * @author Nicolás Sánchez Pérez
 */
package tarea01;

import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner

public class Ejercicio5 {

    public static void main(String[] args) {

    //----------------------------------------------
    //    Declaración de variables y constantes
    //----------------------------------------------

        // Constantes 
        
        // Variables de entrada 
        int adultos;
        int infantiles;
        
        // Variables de salida 
        String textoResultado1;
        String textoResultado2;
        String textoResultado3;
        String textoResultado4;
        String textoResultado5;
        String textoResultado6;
 
        // Variables auxiliares
        double coste;
        double descuento;        
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado= new Scanner (System.in);
        
    //----------------------------------------------
    //               Entrada de datos 
    //----------------------------------------------
        System.out.println("Ejercicio 5. ¡Vamos al parque acuático");
        System.out.println("--------------------");
        
        System.out.println("Introduce la cantidad de entradas DE ADULTO que deseas adquirir: ");        // mostramos un mensaje sobre la información que vamos a pedir por teclado
        adultos = teclado.nextInt();                       
        
        System.out.println("Introduce la cantidad de entradas INFANTILES que deseas adquirir: ");   // mostramos un mensaje sobre la información que vamos a pedir por teclado
        infantiles = teclado.nextInt();                    // a través del Scanner pedimos al usuario que escriba un número entero 

        
    //----------------------------------------------
    //                 Procesamiento 
    //----------------------------------------------
        // se almacena en la variable resultado, el texto completo (recuerda que para unir textos se usa el operador + 
        textoResultado1 = "Se comprarán "+ adultos +" entradas de tipo ADULTO y " + infantiles + " entradas de tipo INFANTIL";
        coste = adultos * 15 + infantiles * 10;
        
        textoResultado2 = "El coste de las entradas antes de aplicar descuentos es de " + coste + " €";
        
        descuento = (coste > 50) ? 5 : 0;
        descuento = (coste > 100) ? 15 : descuento;
        textoResultado3 = (descuento == 0) ? (
                "No procede descuento en esta compra"
                ) : (
                "Se aplicará un descuento del " + descuento +"%");
        
        coste = (coste - (coste * descuento / 100));
        textoResultado4 = "Tras aplicar posibles descuentos el importe total de las entradas (sin IVA) es de " + coste + "€";
        
        coste = (coste + coste*21/100);
        textoResultado5 = "El importe IVA incluido es de " + coste + "€";
        
        textoResultado6 = "La cantidad final a pagar por el cliente es de " + (int)coste + "€";
        
        
        
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
        System.out.println(textoResultado5);
        System.out.println(textoResultado6);
        System.out.println ();
        System.out.println ("Fin del programa.");           
    }
}
