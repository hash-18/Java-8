import java.util.List;

public class FP03Functional {
    public static void main(String[] args) {
        List<Integer> numbers=List.of(12,9,13,4,6,2,4,12,15);
       int value=SumOfSquaresOfNumber(numbers);
        System.out.println(value);

        DistinctNumbers(numbers);
        SortedNumbers(numbers);
    }

    private static void SortedNumbers(List<Integer> numbers) {
        System.out.println("Starting Sorting");
        numbers.stream().sorted().forEach(System.out::println);
    }

    private static void DistinctNumbers(List<Integer> numbers) {
        System.out.println("Starting Distinct operation");
        numbers.stream().distinct().forEach(System.out::println);
    }

    private static int SumOfSquaresOfNumber(List<Integer> numbers) {
        //Using map+reduce
        return numbers.stream().map(number->number*number).reduce(0,(a,b)->a+b);
      // Using only reduce
        // return numbers.stream().reduce(0,(a,b)->a+b*b);
    }


}
