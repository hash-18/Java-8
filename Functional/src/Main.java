import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public class Main {
    public static void main(String[] args) {

        List<Student> students=new ArrayList<>(List.of(new Student(1,"Mac"), new Student(2,"Tam"), new Student(3,"Pac"), new Student(4,"Mac")));
        System.out.println(students);

        List<String> names= students.stream().map(student->student.getName()).collect(Collectors.toList());
        Map<String, Long> frequencyMap = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequencyMap);

        Set<String> duplicates=frequencyMap.entrySet().stream().filter(ele->ele.getValue()>1).map(ele->ele.getKey()).collect(Collectors.toSet());
        frequencyMap.entrySet().stream().filter(ele->ele.getValue()>1).map(ele->ele.getKey()).forEach(System.out::println);
        System.out.println(duplicates);

        //Return the name if it is present. Return Anonymous if name is null
        Employee e1=new Employee(null,7);
        Employee e2=new Employee("Flak",8);
           String nameForId7= Optional.ofNullable(e1.getName()).orElse("Anonymous");
        String nameForId8= Optional.ofNullable(e2.getName()).orElse("Anonymous");
        System.out.println(nameForId7);
        System.out.println(nameForId8);

        List<Integer> randomNumbers=List.of(1,2,1,4,1,2,1,4,5,6,7,8,9,6,10);
        Map<Integer, Long> totalCount = randomNumbers.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
System.out.println(totalCount);

    }
}


class Student
{
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}