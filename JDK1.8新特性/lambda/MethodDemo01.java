package lambda;
import java.util.ArrayList;
import java.util.List;


public class MethodDemo01 {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("java1");
        lists.add("java2");
        lists.add("java3");

        lists.stream().filter(s -> s.startsWith("java")).filter(s -> s=="java1").forEach(System.out::println);
    }
}