package lab1p2_uliseslargaespada;

import java.text.*;
import java.util.*;

/**
 * @author ularg
 */
public class Lab1P2_UlisesLargaespada {

  public static void main(String[] args) {
    mainMenu();
  }
  
  public static void mainMenu() {
    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    System.out.println("-- Bienvenido al Laboratorio #1 de Program II --");
    System.out.println("Aqui podrás realizar 3 ejercicios diversos");

    System.out.println("¿Cómo te llamas?");
    String nombre = entry.nextLine();

    System.out.println("Mucho gusto " + nombre + "\n");

    do {
      System.out.println("Elija que opcion deseas: ");
      System.out.println("1 - Torres de Hanoi");
      System.out.println("2 - Fechas en Tokens");
      System.out.println("3 - Calcular Pi de manera recursiva");
      System.out.println("4 - Salir \n");

      System.out.print("Ingrese la opción: ");
      int option = entry.nextInt();

      switch (option) {
        case 1 -> {
          torresDeHanoi(nombre);
        }

        case 2 -> {
          fechasEnTokens(nombre);
        }

        case 3 -> {
          sumatoriaPi(nombre);
        }

        default ->
          System.out.println("Elija una opcion de las anteriores");
      }

      // Salir del programa 
      if (option == 4) {
        break;
      }
    } while (true);
  }
  
  // Ejercicio de las torres de Hanoi
  public static void torresDeHanoi(String nombre) {
    System.out.println("Bienvenido " + nombre + " al ejercicio de las torres de hanoi");
    System.out.println("En este ejercicio vas a resolver el problema de torres de hanoi de manera recursiva");
    System.out.print("Primero, Indica la cantidad de discos para tu ejercicio: ");
    
    // Initialize scanner
    Scanner entry = new Scanner(System.in);
    
    int discos = entry.nextInt();
    
    // Variables de las torres 
    int origen = 1, auxiliar = 2, destino = 3;
    
    // Llamar ejercicio para realizarlo con la cantidad de discos dados
    hanoiT(discos, origen, auxiliar, destino);
    
    System.out.println();
  }
  
  // Ejercicio de hanoi con la cantidad de discos
  public static void hanoiT(int n, int origen, int auxiliar, int destino) {
    
    if(n == 1) {
      System.out.println("Mover disco 1 de " + origen + " a " + destino);
      return;
    } else {
      hanoiT(n-1, origen, destino, auxiliar);
    }
    System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
    hanoiT(n-1, auxiliar, origen, destino);
  }
  
  // Ejercicio de Tokens
  public static void fechasEnTokens(String nombre) {
    System.out.println("Bienvenido " + nombre + " al ejercicio para transformar fechas cortas a largas");
    System.out.println("En este ejercicio buscaras fechas dentro de un string especifico");
    System.out.println("Ingrese una cadena con las palabras separadas por comas: ");
    
    // Initialize scanner
    Scanner entry = new Scanner(System.in);
    
    String prueba = entry.nextLine();
    
    String array[] = transformTokens(prueba);
    
    ArrayList<String> fechasOnly = fechasExtraidas(array);
    
    printValidDate(fechasOnly);
        
    System.out.println();
  }
  
  // Funcion para transformar la cadena ingresada en tokens
  public static String[] transformTokens(String cadena) {
    String tokens[] = cadena.split(",");
    
    return tokens;
  }
  
  // Funcion para extraer del arreglo las fechas
  public static ArrayList fechasExtraidas(String cadenaDividida[]) {
    ArrayList<String> fechasOnly = new ArrayList();
    int j = 0;
    
    for (int i = 0; i < cadenaDividida.length; i++) {
      if(isValidDate(cadenaDividida[i])) {
        fechasOnly.add(cadenaDividida[i]);
        j++;
      }
    }
    
    return fechasOnly;
  }
  
  // Funcion para validar el formato de las fechas
  public static boolean isValidDate(String string) {
    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
    
    try {
      format.parse(string);
      return true;
    }
    catch(ParseException e) {
      return false;
    }
  }
  
  // Funcion para validar si es una fecha valida en el ArrayList e imprimirla en long date
  public static void printValidDate(ArrayList<String> dates) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
    for (int i = 0; i < dates.size(); i++) {
       try {
         System.out.println(dateFormat.parse(dates.get(i)));
       } catch(ParseException e) {
         System.out.println();
       }
       
   }
  }
  
  // Funcion para realizar la sumatoria de pi en modo recursivo
  public static void sumatoriaPi(String nombre) {
    System.out.println("Bienvenido " + nombre + " al ejercicio para realizar la sumatoria de Pi en manera recursiva");
    System.out.print("Ingrese el limite de la sumatoria: ");
    
    // Initialize scanner
    Scanner entry = new Scanner(System.in);
    
    double limite = entry.nextDouble();
    
    System.out.println("El total de pi en esa sumatoria es: " + sumatoriaFinal(limite));    
    System.out.println();
  }
  
  // Funcion para realizar la sumatoria
  public static double sumatoriaFinal(double k) {
    double total = 0;
    if(k == 1) {
      total += (4*(-1/(2+1)));
      return total;
    } else {
      total += sumatoriaFinal(k-1);
    }
    return total;
  }
}
