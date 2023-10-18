import java.util.*;
import java.io.*;

/**
 * BusBarnEngine.java
 * Loads the buses and routes, and prints them
 *
 * @author Levi Miller
 * @version 1.0
 */
public class BusBarnEngine {

    public static void main(String[] args) {
        // construct objects
        Random gen = new Random();
        Set<Bus> barn = new TreeSet<>();
        Map<Integer, String> routes = new TreeMap<>();

        // construct and add barns to the set
        addBuses(barn, gen);

        // populate the routes map with file contents
        setRoutes(routes, "data/routes.txt");

        // print out buses in the set
        printBarn(barn);

        // print out buses and their routes 
        printBarnRoutes(barn, routes);
    }

    /**
     * This method creates a random number of buses from 1-10
     * adds them to a set with a random route number from 100-130
     *
     * @param barn set of bus objects
     * @param r    random number generator
     */
    public static void addBuses(Set<Bus> barn, Random r) {
        for (int i = r.nextInt(10); i < 10; i++) {

            barn.add(new Bus(r.nextInt(31)+100));
        }

    }

    /**
     * This method prints out the Bus objects in the Set
     */
    public static void printBarn(Set<Bus> barn) {
        System.out.println("\nBuses at the Bus Barn");
        System.out.println("=====================");
        for (Bus b : barn) {
            System.out.println(b);
        }
        if (barn.isEmpty()) {
            System.out.println("The bus barn is empty!");
        }
    }

    /**
     * This method populates a routes map with bus route numbers as a key and the route description
     * as a value using the information from the file
     * @param routes route numbers mapped to route descriptions
     * @param fileName file holding route numbers and descriptions
     */
    public static void setRoutes(Map<Integer, String> routes, String fileName) {
        try (Scanner fileIn = new Scanner(new File(fileName))) {
             while(fileIn.hasNextLine()){
                 String route = fileIn.nextLine();
                 String description = fileIn.nextLine();
                 routes.put(Integer.parseInt(route),description);
             }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        System.out.println("Routes = " + routes);

    }
    /**
     * This method prints out the buses and their routes,
     * including a description of the route,
     * if available from the routes map
     * @param barn - set of bus objects
     * @param routes - Map with route numbers as keys and description text as values
     */
    public static void printBarnRoutes(Set<Bus> barn, Map<Integer, String> routes) {
        System.out.println("\nBuses and Routes at the Bus Barn");
        System.out.println("=====================");

        for (Bus bus : barn) {
            String route = routes.get(bus.getRoute());
            if (route == null) {
                System.out.println(bus);
            } else {
                System.out.println(bus + " " + route);
            }
        }

        if (barn.isEmpty()) {
            System.out.println("The bus barn is empty!");
        }
    }


}