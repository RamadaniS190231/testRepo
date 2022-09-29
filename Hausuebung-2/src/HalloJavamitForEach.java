import java.util.ArrayList;
import java.util.List;

public class HalloJavamitForEach {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Noah ");
        list.add("Schmolz ");
        list.add("Shaban ");
        list.add("Ramani");

        list.forEach((s) -> System.out.print(s));
        System.out.println();
        list.forEach(System.out::print);
        System.out.println();

    }
}
