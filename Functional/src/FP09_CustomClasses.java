import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Courses{
    String name;
    String category;
    int ratings;
    int noOfStudents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public Courses(String name, String category, int ratings, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.ratings = ratings;
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", ratings=" + ratings +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}

public class FP09_CustomClasses {

    public static void main(String[] args) {

      List<Courses> courses = List.of(
                new Courses("Spring","Framework",98,5000),
                new Courses("SpringBoot","Framework",99,9000),
                new Courses("Pyhon","Language",95,2000),
                new Courses("Microservices","Microservices",96,25000),
                new Courses("FullStack","FullStack",97,9000),
                new Courses("AWS","Cloud",92,21000));

//        Predicate<Courses> noOfStudentsGreaterThan20000Predicate = course -> course.getNoOfStudents() > 20000;
//        System.out.println(courses.stream().anyMatch(noOfStudentsGreaterThan20000Predicate));
//        System.out.println(courses.stream().allMatch(noOfStudentsGreaterThan20000Predicate));
//        System.out.println(courses.stream().noneMatch(noOfStudentsGreaterThan20000Predicate));
////Sorting based on no of students in Ascending order
//        //Way 1
//        courses.stream().sorted(Comparator.comparing(course->course.getNoOfStudents())).forEach(System.out::println);
//        //Way 2(Enhanced)
//        courses.stream().sorted(Comparator.comparing(Courses::getNoOfStudents)).forEach(System.out::println);
//
//        Comparator<Courses> comparingByNoOFStudentsAndThenRating=Comparator.comparing(Courses::getNoOfStudents).thenComparing(course->course.getRatings()).reversed();
//        courses.stream().sorted(comparingByNoOFStudentsAndThenRating).forEach(System.out::println);
//
//
//        //LIMIT - Select first n elements from the result
//        //SKIP - SKIP first n elements from the result
//        //TakeWhile - Include elements until the conditions are met
//        //dropWhile - Exclude elements until the results are met
//        //max - Takes comparator as Input and returns the last element of the comparator's result
//        //min - Takes comparator as Input and returns the first element of the comparator's result
//        //FindFirst - First element that meets that filter criterial
//        //FindLast
//        //FindAny
//
//        System.out.println("Printing results of LIMIT function");
//        System.out.println();
//        courses.stream().limit(2).forEach(System.out::println);;
//        System.out.println();
//
//        System.out.println("Printing results of SKIP function");
//        System.out.println();
//        courses.stream().skip(2).forEach(System.out::println);;
//        System.out.println();
//
//        System.out.println("Printing results of LIMIT-SKIP combined function");
//        System.out.println();
//        courses.stream().skip(2).limit(3).forEach(System.out::println);;
//        System.out.println();
//
//        System.out.println("Printing results of takeWhile function");
//        System.out.println();
//        //Take while accepts a predicate.
//        courses.stream().takeWhile(course->course.getRatings()>=98).forEach(System.out::println);
//        System.out.println();
//
//        System.out.println("Printing results of dropWhile function");
//        System.out.println();
//        //Drop while accepts a predicate.
//
//        courses.stream().dropWhile(course->course.getRatings()>=98).forEach(System.out::println);
//        System.out.println();
//
//        System.out.println("Printing results of MAX function");
//        System.out.println();
//        //MAX accepts a comparator.
//        //Returns an Optional(Optional.empty if null)
//        System.out.println(courses.stream().max(Comparator.comparing(Courses::getRatings)));
//        System.out.println();
//
//        System.out.println("Printing results of MIN function");
//        System.out.println();
//        //MAX accepts a comparator.
//        //Returns an Optional(Optional.empty if null)
//        System.out.println(courses.stream().min(Comparator.comparing(Courses::getRatings)));
//        System.out.println();
//
//        //Example to demonstrate OrElse and Optional.empty
//
//        System.out.println("Printing results of OrElse and Optional.empty function");
//        System.out.println();
//        //MAX accepts a comparator.
//        //Returns an Optional(Optional.empty if null)
//        System.out.println(
//                courses.stream()
//                        .filter(course->course.getRatings()<90)
//                        .min(Comparator.comparing(Courses::getRatings)));
//        System.out.println();
//
//        System.out.println("Printing results of FIND FIRST function");
//        System.out.println();
//        //MAX accepts a comparator.
//        //Returns an Optional(Optional.empty if null)
//        System.out.println(courses.stream().filter(course->course.getRatings()>98).findFirst());
//        System.out.println();
//
//        System.out.println("Printing results of FIND ANY function");
//        System.out.println();
//        //MAX accepts a comparator.
//        //Returns an Optional(Optional.empty if null)
//        System.out.println(courses.stream().filter(course->course.getRatings()>97).findAny());
//        System.out.println();
//
        //Random - Map a course to it's name and category
//        courses.stream().map(course->course.getName() + " " + course.getCategory()).forEach(System.out::println);


        //Sum, Count, Average

        //Count the no of courses
        System.out.println(courses.stream().count());

        //Print no of students in all courses
        System.out.println(courses.stream().mapToInt(Courses::getNoOfStudents).sum());


        //Get no of students in courses with review greater than 97
        System.out.println(
                courses.stream()
                        .filter(course->course.getRatings()>97)
                        .mapToInt(Courses::getNoOfStudents)
                        .sum()); // we can use sum only if we use map to int


        //Get avg no of students in courses with review greater than 97
        //Retruns Optional incase no condition is filtered out
        System.out.println(
                courses.stream()
                        .filter(course->course.getRatings()>97)
                        .mapToInt(Courses::getNoOfStudents)
                        .average());

        //Get max no of students in any course out of all courses with review greater than 97
        //Retruns Optional
        System.out.println(
                courses.stream()
                        .filter(course->course.getRatings()>97)    //   .filter(course->course.getRatings()>99) will result in OptionalInt.empty
                        .mapToInt(Courses::getNoOfStudents)
                        .max());

    // Get all diff course categories present
        courses.stream().map(Courses::getCategory).distinct().forEach((System.out::println));
    // Count no of categoriues
        System.out.println(courses.stream().map(Courses::getCategory).distinct().count());


        // Grouping courses based on Category - i.e Category will be the key and it's values will be courses mapped to it.

        System.out.println(courses.stream().collect(Collectors.groupingBy(Courses::getCategory)));

//Output -
//        {Language=[Courses{name='Pyhon', category='Language', ratings=95, noOfStudents=2000}],
//        Cloud=[Courses{name='AWS', category='Cloud', ratings=92, noOfStudents=21000}],
//        FullStack=[Courses{name='FullStack', category='FullStack', ratings=97, noOfStudents=9000}],
//        Microservices=[Courses{name='Microservices', category='Microservices', ratings=96, noOfStudents=25000}],
 //       Framework=[Courses{name='Spring', category='Framework', ratings=98, noOfStudents=5000}, Courses{name='SpringBoot', category='Framework', ratings=99, noOfStudents=9000}]}


        //Finding out courses in each category. - i.e Category as key and no of courses in the category as value.
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Courses::getCategory, Collectors.counting())));
//Output - {Language=1, Cloud=1, FullStack=1, Microservices=1, Framework=2}

        //Returning highest reviewed course of each category

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Courses::getCategory,
                                Collectors.maxBy(Comparator.comparing(Courses::getRatings)))));

        //Category and just ust the name of the courses(in the form of list) in each category

        System.out.println(
                courses.stream().collect(Collectors.groupingBy(Courses::getCategory,Collectors.mapping(Courses::getName, Collectors.toList())))

        );













    }


}
