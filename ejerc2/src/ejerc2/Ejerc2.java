
package ejerc2;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.Random;
public class Ejerc2 {
    public static void main (String [] args) {
        Scanner entrada = new Scanner (System.in);
        Random rnd = new Random();
        int respuesta = 0;
        Set<Hotel> listaCompleta = new HashSet <Hotel>();
        SortedSet<Hotel> listaPlaya = new TreeSet<Hotel>();
        SortedSet<Hotel> listaMontana = new TreeSet<Hotel>();
        SortedSet<Hotel> listaRural = new TreeSet<Hotel>();
        for (int i=0; i<12; i++) {
            int precio = rnd.nextInt(111)+40;
            int numR = rnd.nextInt(3);
            if (numR==0) {Hotel hotel = new Hotel (i+1, "playa", precio);
                listaCompleta.add(hotel);
                listaPlaya.add(hotel);
            }
            else if (numR==1) {Hotel hotel = new Hotel (i+1, "montaña", precio);
                listaCompleta.add(hotel);
                listaMontana.add(hotel);
            }
            else {Hotel hotel = new Hotel (i+1, "rural", precio);
                listaCompleta.add(hotel);
                listaRural.add(hotel);
            }           

        }           
        System.out.println ("Conjunto de hoteles disponibles: ");
        System.out.println(listaCompleta);
        System.out.println ("Elige el tipo de zona donde quieres reservar el hotel.");
        System.out.println ("(1) Playa. (2) Montaña. (3) Rural.");
        respuesta= entrada.nextInt();
        switch (respuesta) {
            case 1: System.out.println ("Hoteles en el conjunto para la sección playa ordenados por precio: "+listaPlaya); break;
            case 2: System.out.println ("Hoteles en el conjunto para la sección montaña ordenados por precio: "+listaMontana); break;
            case 3: System.out.println ("Hoteles en el conjunto para la sección rural ordenados por precio: "+listaRural); break;
        }
    }
}
