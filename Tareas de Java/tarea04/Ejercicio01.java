package tarea04;

import java.util.Scanner;

/**
 * Tarea Online 4. Ejercicio 1: Nivel de Seguridad de Contraseñas
 *
 * @author Nicolás Sánchez Pérez
 * @version 1.0
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // DEFINICIÓN DE CONSTANTES
        final String[] PATRONES = {
            ".*\\d.*", // Patrón si contiene números
            ".*[a-z].*", // Patrón si contiene letras minúsculas
            ".*[A-Z].*", // Patrón si contiene letras mayúsculas
            ".*[^a-zA-Z0-9].*", // Patrón si contiene caracteres especiales --> Se da si se dan las cuatro anteriores (se comprueba en el bucle)
            // Si contiene al menos un número, una letra minúscula, una letra mayúscula y un carácter especial --> Se da si se dan las cuatro anteriores (se comprueba en el bucle)
            ".*[^aeiouAEIOU\\d]{4}.*", // Si contiene al menos cuatro CONSONANTES juntas
            ".*([a-z][A-Z]|[A-Z][a-z]){2,}.*" // Si contiene dos alternancias entre letras mayúsculas y minúsculas
        };
        final String CONTRASENYAS_USADAS = "password;123456;123456789;guest;qwerty;12345678;111111;12345;col123456;123123;1234567;1234;1234567890;tequiero;555555;666666;123321;654321;7777777;123;D1lakiss;777777;110110jp;1111;987654321;121212;Gizli;abc123;112233;azerty;159753;1q2w3e4r;54321;pass@123;222222;qwertyuiop;qwerty123;qazwsx;vip;asdasd;123qwe;123654;iloveyou;a1b2c3;999999;Groupd2013;1q2w3e;usr;Liman1000;1111111;333333;123123123;9136668099;11111111;1qaz2wsx;password1;mar20lt;987654321;gfhjkm;159357;abcd1234;131313;789456;luzit2000;aaaaaa;zxcvbnm;asdfghjkl;1234qwer;88888888;dragon;987654;888888;qwe123;football;3601;asdfgh;master;samsung;12345678910;killer;1237895;1234561;12344321;daniel;00000;444444;101010;f--;you;qazwsxedc;789456123;super123;qwer1234;123456789a;823477aA;147258369;unknown;98765;q1w2e3r4;232323";
        final String[] DICCIONARIO_CONTRASENYAS;

        // DEFINICIÓN DE VARIABLES
        // Variable para almacenar la password introducida
        String password;
        // Varaible para el nivel de seguridad

        // Variable para almacenar el objeto Scanner para la entrada de datos
        Scanner teclado = new Scanner(System.in);

        /* ************************************************************************
         * ENTRADA DE DATOS
         * ***********************************************************************/
        double nivelSeguridad = 0;

        /* 1. Comprobamos que la contraseña tenga al menos 8 caracteres, no se debe 
         * seguir si la contraseña no presenta al menos 8 caracteres 
         */
        do {
            System.out.println("Introduce la contraseña (NIVEL 0: La contraseña debe tener al menos 8 caracteres)");
            password = teclado.nextLine();
        } // Validación de entrada: Deberíamos comprobar la longitud de la contraseña tiene al menos 8 caracteres.
        while (password.length() < 8);

        /* ************************************************************************
         * PROCESAMIENTO
         * ***********************************************************************/
 /* 2. Realizamos la comprobación de cada uno de los patrones, aumentando el nivel 
        de complejidad de la variable si va superando los patrones
         */
 /* 2.1 En el caso de que hayamos completado los cuatro primeros patrones 
                   y su validación haya sido positiva en todos ellos, se suma un punto
                   al nivel de seguridad
         */
 /* 2.2 Si es uno de los cuatro primeros patrones suman 0.5
                * si el patron analizado es de los siguientes (a partir del cuarto) 
                * suman un punto
         */
        for (int i = 0; i < PATRONES.length; i++) {
            if (i == 4 && nivelSeguridad == 2) {
                System.out.println("Al completarse los cuatro primeros patrones como positivos, añadimos un punto al nivel de seguridad");
                nivelSeguridad += 1;
                System.out.println("Nivel Actual :" + (double) nivelSeguridad);
            }
            System.out.println("Comprobando patrón: Sanchez_Perez_Nicolas_PROG_Tarea04.zip" + (i + 1));
            if (password.matches(PATRONES[i])) {
                if (i < 4) {
                    nivelSeguridad += 0.5; // Patrones del 1 al 4 suman 0.5 puntos
                } else {
                    nivelSeguridad += 1;   // Patrones a partir del 5 suman 1 punto
                }
            }
            System.out.println("Nivel Actual: " + (double) nivelSeguridad);
        }

        // 3. Comprobación de que la palabra se encuentra en el diccionario.
        /* 3.1 A partir de la cadena de contraseñas separadas por ";" que tenemos 
         * en la constante CONTRASENYAS_USADAS, obtenemos un array de palabras que
         * guardamos en DICCIONARIO_CONTRASENYAS
         */
        DICCIONARIO_CONTRASENYAS = CONTRASENYAS_USADAS.split(";");

        /* En este bucle comprobamos si nuestra contraseña es igual que alguna 
           palabra del diccionario, y si nuestra contraseña contiene partes de 
           de contraseñas del diccionario. Una vez encuentra una, no es necesario 
           comprobar si es igual al resto,aunque sí pueden aparecer varias 
           contraseñas del diccionario como partes de la nuestra, por lo que debemos
           incrementar el contador y recorrer el bucle hasta el final
         */
        int counter = 0;

        for (int i = 0; i < DICCIONARIO_CONTRASENYAS.length; i++) {
            if (password.contains(DICCIONARIO_CONTRASENYAS[i]) == true) {
                if (counter == 0 && password.contentEquals(DICCIONARIO_CONTRASENYAS[i])) {
                    nivelSeguridad--;
                }
                counter++;
            }
        }
        /* ************************************************************************
         * SALIDA DE DATOS
         * ***********************************************************************/

        // Se muestra el nivel final de seguridad de nuestra contraseña
        System.out.println("El nivel actual de la contraseña " + password + " es: " + (double) nivelSeguridad);

        // Se muestra la cantidad de contraseñas más utilizadas que forman parte de nuestro password
        System.out.println("Tu contraseña tiene partes de contraseñas más utilizas " + counter + " veces");

    }

}
