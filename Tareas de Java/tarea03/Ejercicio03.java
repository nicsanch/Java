package tarea03;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;
import java.time.format.TextStyle;



/**
 * Ejercicio 3: Día de cumpleaños
 *
 * @author Nicolás Sänchez Pérez.
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        // Variables de entrada
        int nacimiento = 0;
        int mes = 0;
        int dia = 0;  
        Locale es = new Locale("es", "ES");


        // Variables de salida
        int coincidencias = 0;
        LocalDate fecha;
        String jornada;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Variables auxiliares
        int dias;
        int year;
        DayOfWeek diasemana;
      
        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("DÍA DE CUMPLEAÑOS");
        System.out.println("-----------------");

        // 1. Entrada de datos: lectura de año de nacimiento
        // 1.1.- Leer y comprobar el año de nacimiento (entre 1900 y año actual)
        while (nacimiento < 1900 || nacimiento > LocalDate.now().getYear()) {
            try {
                System.out.println("Introduce año de nacimiento (1900 -" + LocalDate.now().getYear()+ "):");
                nacimiento = teclado.nextInt();
                if (nacimiento < 1900 || nacimiento > LocalDate.now().getYear()) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error de lectura: año incorrecto.");
            }
        }

        // 1.2.- Leer y comprobar el mes de nacimiento 
        while (mes < 1 || mes > 12) {
            try {
                System.out.println("Introduce mes de nacimiento (1 - 12):");
                mes = teclado.nextInt();
                if (mes < 1 || mes > 12) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error de lectura: mes incorrecto.");
            }
        }     


        // 1.3.- Averiguamos cuántos días tiene el mes de nacimiento
        fecha = LocalDate.of(nacimiento, mes, 1);
        dias = fecha.lengthOfMonth();        

        // 1.4.- Leer y comprobar el día de nacimiento 
        while (dia < 1 || dia > dias) {
            try {
                System.out.println("Introduce día de nacimiento (1 - " + dias + "):");
                dia = teclado.nextInt();
                if (dia < 1 || dia > dias) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error de lectura: día incorrecto.");
            }
        }         
        fecha = LocalDate.of(nacimiento, mes, dia);

        //----------------------------------------------
        //    Procesamiento + Salida de resultados  
        //----------------------------------------------
        //2.- Cálculo del día de la semana en que cayó el nacimiento       
        diasemana = fecha.getDayOfWeek();
        jornada = diasemana.getDisplayName(TextStyle.FULL, es);
        System.out.println("El día que naciste fue " + jornada);
        
        // 3.- Recorremos desde el año posterior al año de nacimiento hasta el año actual (bucle)
        System.out.println("\n¿Cuántas veces tu cumpleaños ha caído en " + jornada + "?");
        System.out.println("-------------------------------------");

        // 4.- Mostramos por pantalla el número de coincidencias
        year = fecha.getYear();
        while (++year <= LocalDate.now().getYear())
        {
            fecha = LocalDate.of(year, 1, 1);
            if (fecha.isLeapYear() == false && dia == 29 && mes == 2) 
            {
            
            }
            else
            {                
                fecha = LocalDate.of(year, mes, dia);
                if (fecha.getDayOfWeek() == LocalDate.of(nacimiento, mes, dia).getDayOfWeek())
                    System.out.println(++coincidencias + ". " + fecha.format(formatter));                
            }           
        }
        System.out.println("\nNúmero total de coincidencias: " + coincidencias);            
    }
}
