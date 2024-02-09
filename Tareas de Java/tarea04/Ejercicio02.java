package tarea04;

import java.util.Scanner;
import java.util.Random;

/**
 * Tarea Online 4. Ejercicio 2: Campo de regalos
 *
 * @author Nicolás Sánchez Pérez
 * @version 1.0
 */
public class Ejercicio02 {

    public static void mostrarMapa(int posy, int posx, int[][] Matriz) {
        for (int i = 0; i < Matriz.length; i++) {
            for (int h = 0; h < Matriz[i].length; h++) {
                if (i > posy) {
                    System.out.print(" X ");
                } else {
                    switch (Matriz[i][h]) {
                        case 0:
                            System.out.print(" C ");
                            break;
                        case 3:
                            System.out.print(" A ");
                            break;
                        case 2:
                            System.out.print(" I ");
                            break;
                        case 1:
                            System.out.print(" B ");
                            break;
                        default:
                            System.out.print(Matriz[i][h]);
                            break;
                    }
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        // DEFINICIÓN DE CONSTANTES
        // DEFINICIÓN DE VARIABLES
        // Variable que contiene un objeto tipo Random para generar valores aleatorios
        Random r = new Random();
        // Matriz de enteros para gestionar la partida de juego
        int[][] Matriz;
        // Variable que contiene un objeto tipo Scanner para gestionar la entrada de datos
        Scanner teclado = new Scanner(System.in);

        /* ************************************************************************
         * PROCESAMIENTO
         * ***********************************************************************/
 /* 
         1. Creación de la Matriz
         Creamos una matriz bidimensional de 6x6 que será nuestro mapa, donde
         iremos recorriendo entre los premios
         */
        Matriz = new int[6][6];

        /* 
           2. Generación de Premios 
           Se generan números aleatorios entre 100 y 200, que se asignarán a cada una
           una de las casillas, un premio aleatorio para cada casilla. Debemos recorrer
           la matriz y asignar los premios.
         */
        for (int i = 0; i < Matriz.length; i++) {
            for (int h = 0; h < Matriz[i].length; h++) {
                Matriz[i][h] = r.nextInt(101) + 100;
            }
        }


        /* 
           3. Asignación de CEROS
           A partir de la segunda fila, elegimos aleatoriamente una posición entre 0 y 
            el número de columnas de cada fila. En esa posición para cada fila, 
           sobreescribimos el valor existente y asignamos un cero
         */
        for (int i = 1; i < Matriz.length; i++) {
            Matriz[i][r.nextInt(6)] = 0;
        }

        int posy = 0;
        int posx = 0;
        int premio = 0;

        /*
         4.1 Elección de columna de partida en la primera fila.
         Al igual que antes elegimos una posición aleatoria entre 0 y 
         el número de columnas de esa primera fila.
         */
        posx = r.nextInt(6);

        /*
         4.2 Sumar el premio existente en la casilla elegida a la bolsa de premios
         */
        premio += Matriz[0][posx];

        /*
         4.3 Cambiamos el valor de la casilla elegida "3", para posteriormente 
        poder mostrar una "A" en dicha casilla
         */
        Matriz[0][posx] = 3;

        /* 5. Para realizar la  jugada mostraremos el mapa, así como la posición en la que se encuentra (fila y columna). 
           Posteriormente, se muestra al usuario los posibles movimientos que puede realizar
                - Si se está en la primera columna (0), evidemente sólo se podrá ir de frente o a la derecha
                - Si se está en la úlitma columna (longitud-1), evidemente sólo se podrá ir de frente o a la izquierda
                - Si se está en una columna intermedia, se podrá avanzar a cualquiera de las tres posiciones (frente, derecha o izquierda)
           Se pregunta al usuario la dirección de su avance en función de sus posibilidades.
           Si el desplazamiento introducido no es correcto se volverá a repetir la solicitud de dirección           
         */
 /*
             5.1 Mostrar el mapa actualmente
             Para recorrer el mapa por filas, se irá descubiendo cada una de las casillas
             El valor mostrado dependerá de si la casilla está descubierta o no, 
             presentando dos posibles casos, 
             - si la fila de la casilla es menor o igual a la que estamos mostraremos 
               la información según los cógigos establecidos en el enunciado.
             - Si la fila de la casilla es mayou a que estamos actualmente, mostraremos una "X"
             
         */
        System.out.println("MAPA ACTUAL:");
        mostrarMapa(posy, posx, Matriz);

        /* 5.2 Se muestra el premio actual */
        System.out.println("Tu premio actual es de : " + premio);

        /* 5.3 Se muestra la fila y columnas actuales*/
        System.out.println("Te encuentras en la fila " + (posy + 1) + " y en la posición " + posx);

        /* 5.4 Se genera un bucle para validar la entrada y elegir un valor 
               correcto, entre IZQUIERDA, DERECHA  o FRENTE. Sólo se mostrarán los 
               posibles movimientos en función de las posibilidades*/
        System.out.println("Elige posición en la que quieres avanzar");

        /* 5.4.1 Mostramos las posibilidades según la posición horizontal
                    *  - Si se está en la primera columna (0), evidentemente sólo se podrá ir de frente o a la derecha
                    *  - Si se está en la últi  ma columna (longitud-1), evidentemente sólo se podrá ir de frente o a la izquierda
                    *  - Si se está en una columna intermedia, se podrá avanzar a cualquiera de las tres direcciones (frente, derecha o izquierda)
         */
        boolean correcto;
        correcto = false;
        String movimiento = null;
        String[] posibilidades;
        String avances;
        if (posx == 0) {
            avances = ("Solo puedes avanzar hacia la derecha o de frente (DERECHA o FRENTE)");
            posibilidades = new String[]{"DERECHA", "FRENTE"};
        } else if (posx == Matriz[0].length - 1) {
            avances = ("Puedes avanzar hacia la izquierda o de frente (IZQUIERDA o FRENTE)");
            posibilidades = new String[]{"IZQUIERDA", "FRENTE"};
        } else {
            avances = ("Puedes avanzar hacia la izquierda, derecha o de frente (IZQUIERDA, DERECHA o FRENTE)");
            posibilidades = new String[]{"IZQUIERDA", "DERECHA", "FRENTE"};
        }
        System.out.println(avances);

        /* 5.4.2 Leemos los valores de teclado. Para simplificar errores, 
                   hacemos que la entrada NO sea case sensitive 
         */
        while (correcto == false) {
            movimiento = teclado.nextLine();
            movimiento = movimiento.toUpperCase();
            for (int i = 0; i < posibilidades.length; i++) {
                if (movimiento.compareToIgnoreCase(posibilidades[i]) == 0) {
                    correcto = true;
                }
            }
            if (correcto == false) {
                System.out.println(avances);
            }
        }

        /* 5.4.3 El bucle sólo debe salir si la opción elegida es correcta 
                   en función de la posición
         */
 /* 5.5 Según la elección de desplazamiento, nos posicionamos en 
               casilla correspondiente */

 /*  5.5.1 Si se ha elegido la dirección izquierda, las fila del 
                   mapa se avanza, pero la columna se decrementa en una unidad para
                   desplazarnos hacia nuestra izquierda. 
                   Se debe comprobar si en dicha casilla hay un cero. 
                     -Si hay un cero en la próxima casilla a visitar, debemos poner
                      la bolsa a 0, y asignar en esa casilla un 1, para después 
                      mostrar una "B" en lugar de un 0.
                    - Si no hay un cero en la próxima casilla a visitar, debemos 
                      sumar a nuestra bolsa de premios el valor de dicha casilla, 
                      y asignar en esa casilla un 3, para después mostrar una "A".
                      También debemos ajustar la nueva posición de fila y columna.
                      Actualizamos el valor de la casilla actual a 2, para 
                      después imprimir una "I.
         */
        Matriz[posy][posx] = 2;
        posy++;
        if (movimiento.contentEquals("IZQUIERDA")) {
            posx--;
        }
        if (movimiento.contentEquals("DERECHA")) {
            posx++;
        }
        if (Matriz[posy][posx] == 0) {
            premio = 0;
            Matriz[posy][posx] = 1;
            System.out.println("Has PERDIDO");
            System.out.println("Mapa al FINAL de la PARTIDA");
            mostrarMapa(posy, posx, Matriz);
        } else {
            premio += Matriz[posy][posx];
            Matriz[posy][posx] = 3;

        }
        correcto = false;
        System.out.println("\nMAPA ACTUAL:");
        mostrarMapa(posy, posx, Matriz);
        System.out.println("Tu premio actual es de: " + premio);
        System.out.println("Te encuentras en la fila " + (posy + 1) + " y en la posición " + posx);

        /* 5.5.2 Si se ha elegido la dirección derecha, las fila del mapa se avanza,
                   pero la columna se incrementa en una unidad para desplazarnos hacia 
                   nuestra derecha. 
                   Se debe comprobar si en dicha casilla hay un cero. 
                     -Si hay un cero en la próxima casilla a visitar, debemos poner
                      la bolsa a 0, y asignar en esa casilla un 1, para después 
                      mostrar una "B" en lugar de un 0.
                    - Si no hay un cero en la próxima casilla a visitar, debemos 
                      sumar a nuestra bolsa de premios el valor de dicha casilla, 
                      y asignar en esa casilla un 3, para después mostrar una "A".
                      También debemos ajustar la nueva posición de fila y columna.
                      Actualizamos el valor de la casilla actual a 2, para 
                      después imprimir una "I.
         */
 /*  5.5.3 En cualquier otro caso se avanza de frente, con lo que la
                    fila se incrementa en una unidad, pero la columna se mantiene igual. 
                    Se debe comprobar si en dicha casilla hay un cero. 
                     -Si hay un cero en la próxima casilla a visitar, debemos poner
                      la bolsa a 0, y asignar en esa casilla un 1, para después 
                      mostrar una "B" en lugar de un 0.
                    - Si no hay un cero en la próxima casilla a visitar, debemos 
                      sumar a nuestra bolsa de premios el valor de dicha casilla, 
                      y asignar en esa casilla un 3, para después mostrar una "A".
                      También debemos ajustar la nueva posición de fila y columna.
                      Actualizamos el valor de la casilla actual a 2, para 
                      después imprimir una "I.
         */
        while (posy != 5 & Matriz[posy][posx] != 1) {

            if (posx == 0) {
                avances = ("Solo puedes avanzar hacia la derecha o de frente (DERECHA o FRENTE)");
                posibilidades = new String[]{"DERECHA", "FRENTE"};
            } else if (posx == Matriz[0].length - 1) {
                avances = ("Puedes avanzar hacia la izquierda o de frente (IZQUIERDA o FRENTE)");
                posibilidades = new String[]{"IZQUIERDA", "FRENTE"};
            } else {
                avances = ("Puedes avanzar hacia la izquierda, derecha o de frente (IZQUIERDA, DERECHA o FRENTE)");
                posibilidades = new String[]{"IZQUIERDA", "DERECHA", "FRENTE"};
            }
            System.out.println(avances);
            while (correcto == false) {
                movimiento = teclado.nextLine();
                for (int i = 0; i < posibilidades.length; i++) {
                    if (movimiento.compareToIgnoreCase(posibilidades[i]) == 0) {
                        correcto = true;
                    }
                }
                if (correcto == false) {
                    System.out.println(avances);
                }
            }
            Matriz[posy][posx] = 2;
            posy++;
            if (movimiento.contentEquals("IZQUIERDA")) {
                posx--;
            }
            if (movimiento.contentEquals("DERECHA")) {
                posx++;
            }
            if (Matriz[posy][posx] != 0) {
                premio += Matriz[posy][posx];
                Matriz[posy][posx] = 3;
            } else {

                premio = 0;
                Matriz[posy][posx] = 1;
                System.out.println("\nHas PERDIDO");
                System.out.println("\nMapa al FINAL de la PARTIDA");
                mostrarMapa(posy, posx, Matriz);

            }
            correcto = false;
            if (Matriz[posy][posx] != 1) {
                if (posy != Matriz.length - 1) {
                    System.out.println("\nMAPA ACTUAL:");
                    mostrarMapa(posy, posx, Matriz);
                    System.out.println("Tu premio actual es de: " + premio);
                    System.out.println("Te encuentras en la fila " + (posy + 1) + " y en la posición " + posx);
                } else {
                    System.out.println("\nHas ganado: " + premio + "€");
                    System.out.println("\nMapa al FINAL de la PARTIDA");
                    mostrarMapa(posy, posx, Matriz);
                }
            }
        }

        /* 5.5.4 Incrementamos la fila"*/
 /*
                Se comprueba si la nueva posición obtenida permite seguir jugado o no,
                así como si hemos llegado a la fila final del trayecto.
                Si permite seguir se repetirá el bucle. Sino, saldremos del bucle.
         */
 /* 6. Si se ha llegado a la fila final sin problemas, habremos ganado, 
          en caso contrario se habrá perdido     
         */
 /* 6.1 Imprimir mensaje correspondiente de haber perdido */
 /* 6.2 Imprimir mensaje correspondiente de haber ganado */
 /* 7. Mostrar el mapa FINAL de la PARTIDA */
    }

    /* 7. BIS. Para mostrar el mapa se puede realizar un método estático para ver 
       el mapa de situación. Para mostrar el mapa vamos generando por filas cada  
       uno de los valores de las columnas. A este método estático se le debería pasar
       el número actual de fila, y el array bidimensional, devolviendo un String
            
     */
}
