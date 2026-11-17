import java.util.ArrayList;
public class Q05ArrayListUpdate {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Delhi"); cities.add("Agra"); cities.add("Jaipur");
        cities.set(1, "Dehradun");
        System.out.println(cities);
    }
}
