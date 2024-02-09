/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea02;

import java.util.Random;

/**
 * 
 * Ejercicio 4. Simulador de Máquina Tragaperras.
 * 
 * @author Nicolás Sánchez Pérez
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        //----------------------------------------------
        //               Declaración de variables
        //----------------------------------------------
        // Variables de entrada (aquí se definen las variables que recibirán valores, si fueran necesarias)
        
        // Variables de salida (aquí se definen las variables que almacenarán resultados y se mostrarán al usuario, si fueran necesarias)
        int fruta;
        int counter;
        int anterior;
        int lote;
        boolean premio;
        char letra;
        
        /* La clase Random es una clase de Java que nos sirve para generar elementos aleatorios
            en este caso el objeto "r", consigue a través de su método nextInt(número), generar
            un número aleatorio entero entre 0 y número-1, por ejemplo r.nextInt(5), generará 
            un número entero entre 0 y 4, es decir, podrá devolver 0,1,2,3 o 4 cada vez que se 
            utilice.
         */
        //Iniciamos valores de las variables para no tener problemas a la hora de hacer comprobaciones con ellas.
        letra = '0';
        lote = 0;
        counter = 1;
        Random r = new Random();
        //----------------------------------------------
        //              Entrada de datos
        //----------------------------------------------
        // En este caso no hay entrada de datos. 
        System.out.println("Ejercicio 4. Simulador de Máquina Tragaperras.");
        System.out.println("----------------------------------------------------"); 
        // Imprimimos el mensaje para empezar el ejercicio:
        System.out.println("Voy a generar secuencias de 3 frutas entre Plátano, Fresa, Naranja, Manzana y Cereza hasta conseguir 3 iguales y te diré que premio has conseguido de los cinco:");
        // Todo lo que biene se hara tantas veces como sea necesario hasta que frutas iguales = 3 con lo que ganariamos el premio
        do {
            System.out.print("\n" + counter + "-");
            premio = false;
            // Seteamos la variable anterior en -1, para que nunca sume en frutas iguales con el primer slot. Seteamos las frutas iguales en 1. Para contar los aciertos para cada una de las tiradas.
            anterior = -1;
            int frutasIguales = 1; // Contador para frutas iguales
            // Por cada jugada, movemos 3 ranuras.
            for (int slot = 0; slot < 3; slot++) {
                fruta = r.nextInt(5);
            //En caso de que la fruta sea = que la anterior sumamos 1 en frutas iguales.
                if (fruta == anterior) {
                    frutasIguales++;
                }
            //Para cada tirada en cada ranura, seteamos el valor de la fruta y el premio o "lote" asociado.
                switch (fruta) {
                    case 0:
                        letra = 'P';
                        lote = 1;
                        break;
                    case 1:
                        letra = 'F';
                        lote = 2;
                        break;
                    case 2:
                        letra = 'M';
                        lote = 3;
                        break;
                    case 3:
                        letra = 'N';
                        lote = 4;
                        break;
                    case 4:
                        letra = 'C';
                        lote = 5;
                        break;
                }
            //imprimimos el valor de la fruta y actualizamos el valor de la fruta anterior.
                System.out.print(letra);
                anterior = fruta;
            //En caso de 3 frutas iguales... BINGO! Tenemos premio, cambiamos la condicion de premio a true para salir del bucle.
                if (frutasIguales == 3) {
                    premio = true;
                }
            }
            // Sumamos a counter++ para llevar la cuenta de los intentos que llevamos.
            counter++;
        } while (!premio);
        // Imprimimos el mensaje del premio conseguido.
        System.out.println("\nHas conseguido el premio " + lote + " en el intento " + (counter - 1) + " con la secuencia: " + letra + letra + letra);
    }
}

