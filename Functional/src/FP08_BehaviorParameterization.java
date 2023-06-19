import java.util.List;
import java.util.function.Function;

public class FP08_BehaviorParameterization {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        //Earlier we were using map to print squares, cubes and other operations ona given value using diff methods.
        //That was too much redundancy. We'll use behavioral parameterization to get over that
        System.out.println("Without Ysung BEHAVIORAL PARAMETERIZATION");
        operationsonnumbers(numbers);

        System.out.println("Ysung BEHAVIORAL PARAMETERIZATION");
        FunctionParameterization(numbers, number -> number * 5);
        System.out.println("Square Ysung BEHAVIORAL PARAMETERIZATION");
        FunctionParameterization(numbers, number -> number * number);
        System.out.println("Cube Ysung BEHAVIORAL PARAMETERIZATION");
        FunctionParameterization(numbers, number -> number * number * number);

    }

    private static void operationsonnumbers(List<Integer> numbers) {
        //Printing square
        numbers
                .stream()
                .map(number -> number * number)
                .forEach(System.out::println);
        //Printing cubes
        numbers
                .stream()
                .map(number -> number * number * number)
                .forEach(System.out::println);
        //Printing number*5
        numbers
                .stream()
                .map(number -> number * 5)
                .forEach(System.out::println);

        //You can see we just changed the code inside map and rest were redundant copy paste.
        //To optimize we can pass the lambda in map as a parameter itself. And the map will act accordingly based
        //on the parameter passed


    }

    private static void FunctionParameterization(List<Integer> numbers, Function<Integer, Integer> operation) {
        numbers
                .stream()
                .map(operation)
                .forEach(System.out::println);
    }
}