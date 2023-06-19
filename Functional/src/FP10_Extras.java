import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class CreateEmployee{

    // Class to create employees with names and age
    public List<Employee> employeeList() {
        List<Employee> employees = List.of(
                 new Employee("John",21),
                 new Employee("Martin",19),
                 new Employee("Mary",31),
                 new Employee("Stephan",27),
                new Employee("John",23),
                 new Employee("Gary",31));

        return employees;
    }

    //  List<Employee> employees2=new ArrayList<Employee>();
    //  employees.add(new Employee("James", 37)); - This line throws Immutable Collection error because when we create any list
    //with list.of method - > it gives us an immutable list.
}
public class FP10_Extras {

    public static void main(String[] args) {

        CreateEmployee createEmployeeObject=new CreateEmployee();
        List<Employee> employees= createEmployeeObject.employeeList();
    // Prints the list
        System.out.println(employees);

 //---------------------------------------------------------------------------------------------------------------------//
//Find third highest age
 //employees.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).skip(2).limit(1).forEach(System.out::println);
//Find third highest age - Another way
       // System.out.println(employees.stream().sorted((emp1,emp2)-> emp2.getAge()-emp1.getAge()).skip(2).findFirst().map(Employee::getName).get());

        //Find Average age
        System.out.println("Average age=");
        OptionalDouble average = employees.stream().mapToInt(Employee::getAge).average();
        System.out.println(average);

       // ------------------------------------------------------------------------------------------------------------------------------

    //    1. Given a list of employees, you need to filter all the employee whose age is greater than 20 and print the employee names.(Java 8 APIs only)
 employees.stream().filter(employee->employee.getAge()>20).map(Employee::getName).forEach(System.out::println);

//2.  Given the list of employees, count number of employees with age 25?

 System.out.println(employees.stream().filter(employee->employee.getAge()>25).count());

 //3.  Given the list of employees, find the employee with name “Mary”.
 System.out.println(employees.stream().filter(employee->employee.getName().equalsIgnoreCase("Mary")).collect(Collectors.toList()));

 //4. Given a list of employee, find maximum age of employee and print ?
System.out.println(employees.stream().max(Comparator.comparing(Employee::getAge)));
//Another way
System.out.println(employees.stream().mapToInt(Employee::getAge).max());

//5. Given a list of employees, sort all the employee on the basis of age?
 employees.stream().sorted(Comparator.comparing(Employee::getAge)).forEach(System.out::println);
 //nother way of representing map
employees.stream().sorted(Comparator.comparing(employee -> employee.getAge())).forEach(System.out::println);

//6.  Join the all employee names with “,”
 List<String> joinEmployee=employees.stream().map(Employee::getName).collect(Collectors.toList());
 String str=String.join(",");
 System.out.println(str);

//Given the list of employee, group them by employee name
System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getName)));

//Displaying counting of each category
System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting())));

//Display category and names in each category.
System.out.println(employees.stream()
        .collect(Collectors.groupingBy(Employee::getName, Collectors.mapping(Employee::getName,Collectors.toList()))));

//Given a list of numbers, square them and filter the numbers which are greater 10000 and then print the squares.
List<Integer> numbers=List.of(1,4,6,8,10,5,15,16,18,20,2);
numbers.stream().map(number->number*number).filter(number->number>100).forEach(System.out::println);

//Given a list of numbers, square them and filter the numbers which are greater 10000 and then print those numbers.
        System.out.println(numbers.stream()
                .map(number->number*number).filter(number->number>100).map(number->(int)Math.sqrt(number))
                .collect(Collectors.toList()));

//Given a list of numbers, square them and filter the numbers which are greater 10000 and then find average of the squares
 System.out.println(numbers.stream()
         .map(number->number*number).filter(number->number>100).mapToInt(number->number).average());

//Given a list of numbers, square them and filter the numbers which are greater 10000 and then find average of those nos

        System.out.println(numbers.stream()
                .map(number->number*number).filter(number->number>100).mapToInt(number->(int)Math.sqrt(number)).average());

//
//
//
//
    }
//
}































