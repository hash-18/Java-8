import java.util.Comparator;
import java.util.List;

public class FP04_SortRevOrder {

    public static void main(String[] args) {
        List<String> courses=List.of("Java","C","Python","Spring","Spring Boot","Data Science","Maths");
        sortedinOrder(courses);
        sortedinRevOrder(courses);
        sortedBasedOnLength(courses);
    }



    private static void sortedinOrder(List<String> courses) {
        courses.stream().sorted().forEach(System.out::println);
    }

    private static void sortedinRevOrder(List<String> courses) {
        System.out.println("Reversing using diff impl of comparator in sorted method");
        System.out.println("Way 1");
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("Way 2");
        courses.stream().sorted((i1,i2)->i2.compareTo(i1)).forEach(System.out::println);
    }

    private static void sortedBasedOnLength(List<String> courses) {
        //In comparing we do define the parameter on basis of which comparison needs to be done
        courses.stream().sorted(Comparator.comparing(str->str.length())).forEach(System.out::println);
        System.out.println("Sortung based on length using brute way");
        courses.stream().sorted((i1,i2)->i1.length()-i2.length()).forEach(System.out::println);
        courses.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }


}
