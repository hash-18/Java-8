import java.util.List;

public class FP01Structured {

    public static void main(String[] args) {

        printNumbersStructured(List.of(1,2,3,4));
    }

    private static void printNumbersStructured(List<Integer> numbers) {
        //How to loop.?
        for(int i:numbers)
            System.out.println(i);

    }
}
