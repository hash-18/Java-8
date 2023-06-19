import java.util.List;
import java.util.function.Predicate;

public class FP07_BehavorParameterization {

    public static void main(String[] args) {
        List<Integer> numbers= List.of(1,2,3,4,5,6,7,8,9,10);

        EvenNumbers(numbers);
        OddNumbers(numbers);
        System.out.println("Using Behavioral Parameterization");
        EvenOrOddNumbers(numbers,number -> number % 2 == 0);
        EvenOrOddNumbers(numbers,number -> number % 2 != 0);

    }

    private static void OddNumbers(List<Integer> numbers) {
        numbers
                .stream()
                .filter(number->number%2!=0)
                .forEach(System.out::println);
    }

    private static void EvenNumbers(List<Integer> numbers) {
        numbers
                .stream()
                .filter(number->number%2==0)
                .forEach(System.out::println);
    }

    //Isn't this quite repetetive.? Just one logic changed and so much code had to be repeated again.?
    //What if we pass the predicate as an argyment. So that the method can add accordingly based on the input.?
    private static void EvenOrOddNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers
                .stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
