package tarea04;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Tarea Online 4. Ejercicio 3: Días Festivos y Puentes
 *
 * @author Nicolás Sánchez Pérez
 * @version 1.0
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        // DEFINICIÓN DE CONSTANTES
        final String CADENA_FESTIVOS = "12,8;12,25;1,1;1,6;5,1;5,18;10,12;11,1;12,6";
        final LocalDate[] FESTIVOS;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("es", "ES"));
        // DEFINICIÓN DE VARIABLES
        int year;
        // Objeto tipo fecha con la fecha de hoy
        LocalDate hoy;

        // Objeto de tipo StringBuilder para mostrar el resultado al final
        StringBuilder resultado = new StringBuilder("");

        /* ************************************************************************
         * PROCESAMIENTO
         * ***********************************************************************/
        // Obtención de la fecha actual (hoy)
        // Si queremos hacer pruebas  podemos descomentar la siguiente línea y cambiar las fechas
        hoy = LocalDate.now();
        year = hoy.getYear();

        /*
            Comprobamos si el día de hoy es posterior al 25 de Diciembre, en tal 
            caso debemos incrementar el año actual en una unidad. Ya que, el último día
            festivo del año es el 25 de Diciembre, y por tanto no tiene sentido calcular
            los festivos hasta final de años, ya que no habría ninguno. 
         */
        if (hoy.getMonthValue() == 12 & hoy.getDayOfMonth() > 24) {
            year++;
        }

        /* Creamos un array con los festivos, para ello, utilizando la clase 
           StringTokenizer, dividimos en  tokens las fechas que nos han entregado 
           con la cadena constante CADENA_FESTIVOS. Por tanto, debemos obtener los
           diferentes tokens para la pareja de fechas día y mes, separados de las otras
           parejas, días y mes mediante ";". Y posteriormente, obtener el día y el mes
           de cada pareja, sabiendo que estos están separados por una coma ","
           Cargaremos cada una de las fechas creadas en el array constante de FESTIVOS
         */
        StringTokenizer fechas = new StringTokenizer(CADENA_FESTIVOS, ";");
        int x = 0;
        FESTIVOS = new LocalDate[fechas.countTokens()];

        while (fechas.hasMoreTokens() == true) {
            StringTokenizer fiestas = new StringTokenizer(fechas.nextToken(), ",");
            FESTIVOS[x] = LocalDate.of(year, Integer.valueOf(fiestas.nextToken()), Integer.valueOf(fiestas.nextToken()));
            x++;
        }

        // Ordenamos el array
        Arrays.sort(FESTIVOS);
        /* 
           Calculamos el próximo día festivo que vamos a tener, para  ello recorremos
           el array de Festivos hasta que encontremos una fecha posterior a la actual
         */
        LocalDate proximo = null;
        for (LocalDate fecha : FESTIVOS) {
            if (fecha.isAfter(hoy) == true) {
                proximo = fecha;
                resultado.append("El próximo festivo es ").append(fecha).append(" y");
                break;
            }
        }

        /* 
           A continuación, queremos saber si ese próximo festivo calculado, se encuentra
           en viernes o lunes, en cuyo caso se generaría un PUENTE
         */
        System.out.println(proximo.getDayOfWeek());
        if (!proximo.getDayOfWeek().equals(DayOfWeek.MONDAY) & !proximo.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            resultado.append(" NO");
        }
        resultado.append(" TENDREMOS PUENTE");
        resultado.append("\nFestivos con puente hasta el año ").append(year);

        // Mostramos los festivos desde el día actual hasta el final de año que generan puente
        // Generamos el formato de fecha que queremos
        for (LocalDate fecha : FESTIVOS) {
            if (fecha.isAfter(hoy) == true) {
                if (fecha.getDayOfWeek().equals(DayOfWeek.MONDAY) | fecha.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    resultado.append("\n* En el festivo ");
                    resultado.append(fecha.format(formato).toUpperCase());
                    resultado.append(" genera PUENTE");
                }
            }
        }

        // Recorremos el array de festivos para ver qué festivos hasta final de año generan puente
        /* ***********************************************************************
         * SALIDA de DATOS 
         *************************************************************************/
        System.out.println(resultado);
    }

}
