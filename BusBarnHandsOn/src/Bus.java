/**
 * Creates Bus objects with a unique bus number starting at 1 and
 * their associated route numbers in the range 100 - 130:
 * A Collection of Bus objects can be sorted since the Comparable Interface
 * is implemented
 * <Bus Number> <Bus Route>
 *     8           101
 */
public class Bus implements Comparable<Bus>{
    // static class field
    private static int nextID = 1;

    // instance variables / fields
    private int number;
    private int route;

    public Bus() {
       this(100);
    }

    public Bus(int route){
        this.number = nextID++;
        this.route = route;
    }

    public int getNumber() {
        return this.number;
    }

    public int getRoute() {
        return this.route;
    }

    public int compareTo(Bus other){
        return this.number - other.number;
    }
    public void setRoute(int route) {
        this.route = route;
    }

    public String toString() {
        return "BUS #" + this.number + " traveling ROUTE #" + this.route;
    }
}