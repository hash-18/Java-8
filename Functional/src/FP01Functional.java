import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<String> courses = List.of("C","Java","Spring","Python","Data Science");
      //  printNumbersStructured(numbers);
       // printIsEven(numbers);
        // printAllCourses(courses);
     //   printCoursesContainingTheWordSpring(courses);
      //  printCoursesWithFourLetters(courses);
        printSquaresOfEvenNumbers(numbers);
        printNumberOfCharactersInEachCourses(courses);


    }

    private static void printNumberOfCharactersInEachCourses(List<String> courses) {
        courses.stream()
               .map(course->course.length())  //.map(course->course + " " + course.length())  (To print course and course length
                .forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(number->number%2==0)
                .map(number->number*number)
                .forEach(System.out::println);
    }

    private static void printCoursesWithFourLetters(List<String> courses) {
        courses.stream().filter(course-> course.length()>4).forEach(System.out::println);
    }

    private static void printCoursesContainingTheWordSpring(List<String> courses) {
        courses.stream().filter(course->course.contains("Spring")).forEach(System.out::println);
    }

    private static void printAllCourses(List<String> courses) {
        courses.stream().forEach(System.out::println);
    }

    private static boolean even(int number) {
        return  (number % 2 == 0);
    }
    private static void printIsEven(List<Integer> numbers) {
     //   numbers.stream().filter(FP01Functional::even).forEach(System.out::println);
        //better way is using lambda and skipping the creation of another method
        numbers.stream().filter(number->number%2==0).forEach(System.out::println);
    }

    private static void print(int n) {
        System.out.println(n);
    }
    private static void printNumbersStructured(List<Integer> numbers) {
       // numbers.stream().forEach(FP01Functional::print);
        // or simply
        numbers.stream().forEach(System.out::println);

    }
}
