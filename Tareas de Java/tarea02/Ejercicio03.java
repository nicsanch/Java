/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea02;

import java.util.Scanner;

/**
 * 
 * Ejercicio 3. Formación romana a partir del número de soldados.
 * 
 * @author Nicolás Sánchez Pérez
 */
public class Ejercicio03 {


    public static void main(String args[]) {
        //----------------------------------------------
        //               Declaración de variables y constantes
        //----------------------------------------------
        
        int soldados;
        int lado;
        String formacion;
        int sobras;
        
        Scanner scanner = new Scanner(System.in);
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        sobras = 0;
        System.out.println("Ejercicio03: Formación romana a partir de un número de soldados.");
        System.out.println("----------------------------------------------------");
        // Bloque 1. Solicitud del número de soldados
        do{
            System.out.println("Introduce el número de elementos de la formación (debe ser mayor que cero");
            soldados = scanner.nextInt();
        }
        // Validación de entrada: Deberíamos comprobar que es mayor o igual que uno. En caso contrario volvemos solicitar el número de soldados
        while (soldados < 1);
        // 
        // Bloque 2. Solicitud del tipo de formación. 
        // Indicaremos que tiene que ser LINEA, CUADRADO o TRIANGULO
        // Leemos una cadena, puede que no sea una de las anteriores.
        System.out.println("Introduce el tipo de formación (LINEA, CUADRADO o TRIANGULO)");
        formacion = teclado.nextLine();
        if (!formacion.equalsIgnoreCase("CUADRADO") && !formacion.equalsIgnoreCase("TRIANGULO") && !formacion.equalsIgnoreCase("LINEA")){
            System.out.println("Opción NO CORRECTA");
            return;
        }
        
        //COMPROBAMOS LA FORMACION PEDIDA, LA PINTAMOS Y CALCULAMOS SOBRAS SI ES NECESARIO.
        switch (formacion){
            case "LINEA": {
                while (soldados > 0){
                    System.out.print("*");
                    soldados--;
                }
                break;
            }
            case "CUADRADO":{
                lado = (int) Math.sqrt(soldados);
                sobras = (int) (soldados % lado);
                for (int j=0; j<lado; j++){
                    for (int i= 0; i < lado; i++){
                      System.out.print("*");                      
                    }
                    System.out.println("");
                }
                break;
            }
            case "TRIANGULO":{
                lado = (int) ((Math.sqrt(1 + 8 * soldados) - 1) / 2);
                for (int i=0; i<=lado; i++){
                    for (int k = i + 1; k>0; k--){
                        System.out.print(" ");
                    }
                    for(int j=lado - i; j>0; j--){
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
                for (int h = lado; h>0; h--){
                    sobras = sobras + h;
                }
                sobras = soldados - sobras;
                break;
            }
        }
        
        // Si el tipo de formación que nos han indicado y que hemos leído como String no coincide con una de las contempladas, indicamos este error almacenando el mensaje oportuno en el String resultado

        if (sobras != 0){
            System.out.println("De los " + soldados + " asignados, una vez hecha la mayor formación posible del tipo indicado, sobran " + sobras + " soldados.");
        }   
    }
}
