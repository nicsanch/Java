package tarea03;
import libtarea3.Teatro;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Ejercicio 1: Trabajo con teatros.
 * @author Nicolás Sánchez Pérez
 */

public class Ejercicio01 {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // 1.2. Declaración de constante para dar formato de fecha hora 
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");        
        // 1.1. Declaración de tres variables referencia a objetos instancia de la clase Teatro
        Teatro unTeatro;
        Teatro dosTeatro;
        Teatro tresTeatro;

        // Clase Scanner para petición de datos de entrada (no es necesario)
        
        //----------------------------------------------
        //              Presentación
        //----------------------------------------------
        System.out.println("TRABAJO CON TEATROS");
        System.out.println("--------------------");
        System.out.println();

        //----------------------------------------------
        //               Análisis inicial
        //----------------------------------------------        
        // 2. Consulta de valores iniciales
        System.out.println("1.-CONSULTA INICIAL DE VALORES GLOBALES");
        System.out.println("---------------------------------------");
        System.out.println();

        // 2.1. Número de teatros creados hasta el momento
        System.out.printf("Número de teatros creados hasta el momento: %d\n", Teatro.getTeatrosTotales());

        // 2.2. Número de obras que se están represenando en este momento en todos los teatros
        System.out.printf("Número de obras que se están representando en este momento: %d\n", Teatro.getObrasActivas());
        //2.3. Número de entradas vendidas en todos los teatros y para todas las obras que se han representado hasta el momento
        System.out.printf("Número de entradas vendidas hasta el momento: %d\n", Teatro.getEntradasVendidasTotales());
             
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // En realidad no hay entrada de datos como tal dado que la información 
        // de entrada es fija y siempre la misma
        System.out.println("\n2.-CREACIÓN Y USO DE TEATROS");
        System.out.println("------------------------------\n");

        // 3.- Instanciación de tres objetos Teatro

        System.out.println("Creación de teatros (constructores)");
        System.out.println("-------------------------------------");

        // 3.1.- Intento de crear un teatro con un aforo inferior (hay que gestionar la posible excepción)
        try{
            System.out.println("Intentando crear un teatro con un aforo inferior...");
            unTeatro = new Teatro("Teatro poco aforado", 299);
        }catch (IllegalArgumentException e){
        System.err.println("Error: " + e.getMessage() + "\n");            
        }

        // 3.2.- Intento de crear un teatro con un aforo superior (hay que gestionar la posible excepción)
        try{
            System.out.println("Intentando crear un teatro con un aforo superior...");
            unTeatro = new Teatro("Teatro poco aforado", 1001);
        }catch (IllegalArgumentException e){
        System.err.println("Error: " + e.getMessage() + "\n");            
        }
              
        // 3.3.- Intento de crear un teatro con un nombre de teatro vacío y aforo por defecto
        try{
            System.out.println("Intentando crear un teatro con un nombre vacío y aforo por defecto...");
            unTeatro = new Teatro("");
        }catch (IllegalArgumentException e){
        System.err.println("Error: " + e.getMessage());            
        }
        
        // 3.4.- Creación de un primer teatro usando el constructor de dos parámetros   
            System.out.println("\nCreando teatro con aforo válido con un constructor con dos parámetros...");
            unTeatro = new Teatro ("Teatro Cervantes", 900);
            System.out.println( "Teatro 1 creado, estado: " + unTeatro.toString() );           

        
        // 3.5.- Creación de un segundo teatro con un aforo por defecto usando el constructor de un parámetro        
            System.out.println("\nCreando teatro con aforo por defecto usando un constructor con un parámetro...");
            dosTeatro = new Teatro ("Teatro Apolo");
            System.out.println( "Teatro 2 creado, estado: " + dosTeatro.toString() );           
        
        // 3.6.- Creación de un tercer teatro usando el constructor sin parámetros        
            System.out.println("\nCreando teatro con valores por defecto usando un constructor sin parámetros...");
            tresTeatro = new Teatro ();
            System.out.println( "Teatro 3 creado, estado: " + tresTeatro.toString() );           
                 
        
        //----------------------------------------------
        //       Procesamiento + Salida de Resultados
        //----------------------------------------------
        // Dado que se va a ir mostrando información de salida a la vez que 
        // se van realizando operaciones, podemos considerar en este caso
        // que el procesamiento y la salida de resultado van unidos y "mezclados"
        
        // 4.- Operaciones con teatros
        
        System.out.println("\nManipulación de teatros (métodos)");
        System.out.println("-----------------------------------");
        
        // 4.1.- Intento de terminar de representar una obra a un teatro que no tiene obra asignada (debemos capturar el error)
        try{
            System.out.println("\nTerminando de representar obra en el primer teatro...");
            unTeatro.terminarObra();
        }catch (IllegalStateException e){
            System.err.println("Error: " + e.getMessage());            
        }          
        
        //4.2.- Asignamos una obra al teatro1 y lo llenamos (debemos comprobar antes si podemos asignarla)
        try{
            System.out.println("\nAsignando una obra de teatro...");
            unTeatro.asignarObra("La vida es sueño");
        }catch (IllegalStateException e){
            System.err.println("Error: " + e.getMessage());            
        }finally{
            System.out.printf("Se ha asignado la obra '%s' al teatro '%s'", unTeatro.getObra(), unTeatro.getNombreTeatro());
            unTeatro.llenarTeatro();
            System.out.printf("\nTeatro lleno. Se han vendido %d entradas.\n", unTeatro.getEntradasVendidas());
        }          
        
        //4.3.- Devolvemos 50 entradas del teatro1 (puesto que acabamos de llenar el teatro, no es necesario comprobar si podemos devolver entradas)
        unTeatro.devolverEntradas(50);
               
        //4.4.- Intentamos traspasar la representación de la obra del teatro1 al teatro2 (hay que gestionar la posible excepción)
        
        try{
            System.out.println("\nIntentando traspasar obra...");
            unTeatro.traspasarObra(dosTeatro);
            System.out.println("Obra traspasada");
        }catch (IllegalStateException e){
            System.err.println("Error: " + e.getMessage());            
        }
        
        //4.5.- Devolvemos otras 50 entradas del teatro1 (no es necesario comprobar si podemos devolver entradas)
        unTeatro.devolverEntradas(50);      
        
        //4.6.- Volvemos a intentar traspasar la obra del teatro1 al teatro2 (ahora no debe dar excepción)
        try{
            System.out.println("\nIntentando traspasar obra...");
            unTeatro.traspasarObra(dosTeatro);
            System.out.printf("'%s' traspasada del '%s' al '%s'\n", dosTeatro.getObra(), unTeatro.getNombreTeatro(), dosTeatro.getNombreTeatro());
        }catch (IllegalStateException e){
            System.err.println("Error: " + e.getMessage());            
        }          
        
        //4.7.- Devolver una entrada del teatro2
        dosTeatro.devolverEntrada();
               
         //5.- Obtención de información del segundo teatro creado
        System.out.println ("\nPrueba de los getters del segundo teatro creado:");
        System.out.println ("----------------------------------------------------");
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        System.out.printf("Fecha de realización de la prueba: %s\n\n", fechaHoraActual.format(formato));
        System.out.println("Teatro 2");
        System.out.printf("\tCódigo del teatro: %s\tNombre del teatro: \"%s\"\n", dosTeatro.getCodigoTeatro(), dosTeatro.getNombreTeatro());
        System.out.printf("\tEstado:\n");
        if (dosTeatro.getObra() != null)
        {
            System.out.printf("\t\tSe esta representando la obra de teatro: \"%s\"", dosTeatro.getObra());
        }
        else
        {
            System.out.printf("\t\tNo se está representando ninguna obra de teatro.");
        }
        System.out.printf("\n \t\tEntradas vendidas: %d\n\n", dosTeatro.getEntradasVendidas());
        

        
        //----------------------------------------------
        //               Análisis Final
        //----------------------------------------------        
        // 6. Consulta de valores finales
        System.out.println("3.-CONSULTA FINAL DE VALORES GLOBALES");
        System.out.println("-------------------------------------");
        System.out.println();

        // 6.1. Número de teatros creados hasta el momento
        System.out.printf("Número de teatros creados hasta el momento: %d\n", Teatro.getTeatrosTotales());        

        // 6.2. Número de obras que se están represenando en este momento en todos los teatros
        System.out.printf("Número de obras que se están representando en este momento: %d\n", Teatro.getObrasActivas());        
        
        //6.3. Número de entradas vendidas en todos los teatros y para todas las obras que se han representado hasta el momento
        System.out.printf("Número de entradas vendidas hasta el momento: %d\n\n", Teatro.getEntradasVendidasTotales());      
        
    }
    
}