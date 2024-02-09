package tarea03;
import libtarea3.Dado;

/**
 * Ejercicio 2: Uso de la clase Dado
 *
 * @author Nicolás Sánchez Pérez
 */
public class Ejercicio02 {

    public static void main(String[] args) {
       
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        //Constantes
        
        // Variables de entrada (dados y puntuación máxima)
        Dado unDado;
        Dado dosDado;
        Dado tresDado;        
        int max_puntos;

        // Variables de salida        
        String lanzamientos = "";
        Dado ganadorDado = null;
        int nganador = 0;  
        String serie = "";
        
        // Variables auxiliares
        long puntos = 0;
        int tirada1 = 0;
        int tirada2 = 0;
        int tirada3 = 0;    
        
        // Clase Scanner para petición de datos de entrada (no es necesario)
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //En realidad no hay entrada de datos como tal, pero podemos considerar
        //el número máximo como información de entrada ya que variará el
        //comportamiento del programa.

        //1. Cálculo del número aleatorio de puntos (entre 30 y 60)
        max_puntos = (int)(Math.random()*30 + 30);

        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------  

        //2. Creación de 3 dados (jugadores) de 6 caras
        
        unDado = new Dado(6);
        dosDado = new Dado(6);
        tresDado = new Dado(6);
        
        //3. Lanzamiento de los dados y acumulación de las puntuaciones
        
            //3.1 Lanzamos cada uno de los dados y mostramos las puntuaciones
            //Utilizamos los métodos de la clase para contar los lanzamientos

          while (puntos < max_puntos)
        {      
            tirada1 = unDado.lanzar();
            tirada2 = dosDado.lanzar();
            tirada3 = tresDado.lanzar();
            String resultado = String.format("\nLanzamiento nº : " + unDado.getNumeroLanzamientos()+ "\t  " 
                    + tirada1 + "\t  " + tirada2 + "\t  " + tirada3);
            lanzamientos = lanzamientos + resultado;
            //3.2 Utilizando los métodos de la clase, acumulamos las puntuaciones
            //de todos los dados en todos los lanzamientos.
            puntos = unDado.getSumaPuntuacionHistorica() + dosDado.getSumaPuntuacionHistorica() + tresDado.getSumaPuntuacionHistorica();
        }                 
                      
        //4. Comprobación de cuál de los dados ha sido el ganador y consulta de
        //todas sus tiradas -->> Las tiradas no las consulto, llamo el metodo que me da su serie de tiradas al imprimir por pantalla.
        ganadorDado = unDado;       
        if (tirada1 >= tirada2 && tirada1 >= tirada3) 
        {
            nganador = 1;
        } else if (tirada2 > tirada1 && tirada2 >= tirada3)
        {
            tirada1 = tirada2;
            nganador = 2;
            ganadorDado = dosDado;

        } else if (tirada3 > tirada1 && tirada3 > tirada2)
        {
            tirada1 = tirada3;
            nganador = 3;
            ganadorDado = tresDado;
        }
        
        //----------------------------------------------
        //      Salida de resultados
        //----------------------------------------------
        System.out.println("LANZAMIENTO DE DADOS");
        System.out.println("----------------------------------------");
        System.out.println("Número máximo de puntos: " + max_puntos);
        System.out.println("");
        System.out.printf("\t\t\tDADO1\tDADO2\tDADO3\n");
        System.out.println(lanzamientos);
        System.out.println("\nJuego Terminado: La suma de los lanzamientos es: " + puntos + ".");
        System.out.printf("El ganador es el dado %d con %d en la última jugada.\n", nganador, tirada1);
        System.out.printf("El valor %d ha salido %d veces en todo el juego y se han realizado un total de %d lanzamientos.\n", tirada1, Dado.getNumeroVecesCaraGlobal(tirada1), Dado.getNumeroLanzamientosGlobal());
        System.out.printf("Todos los lanzamientos del dado %d: %s.\n", nganador, ganadorDado.getSerieHistoricaLanzamientos());
    }
}
