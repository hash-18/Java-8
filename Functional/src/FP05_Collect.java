import java.util.List;
import java.util.stream.Collectors;

public class FP05_Collect {

    public static void main(String[] args) {
        List<Integer> numbers=List.of(2,4,5,6,7,8);
        List<String> courses=List.of("Java","C","Python","C","Spring","Data Science");
        collectSquaresOfNumberIntoAnotherList(numbers);

        List<Integer> ListOfLengthOfAllTheCOurseTitles= courses.stream().map(course->course.length()).collect(Collectors.toList());
        System.out.println(ListOfLengthOfAllTheCOurseTitles);
    }

    private static void collectSquaresOfNumberIntoAnotherList(List<Integer> numbers) {
        List<Integer> Squares= numbers.stream().map(number->number*number).collect(Collectors.toList());
        System.out.println(Squares);
    }
}
