import java.util.List;
import java.util.function.BinaryOperator;

public class FP06_FunctionalInterface {

        public static void main(String[] args) {
            List<Integer> numbers= List.of(1,2,4,6,8,9);
            int sum= printSumOfNumberUsingReduce(numbers);
            System.out.println(sum);
        }

        private static int printSumOfNumberUsingReduce(List<Integer> numbers) {
            //Using Lambdas
            //return numbers.stream().reduce(0,(a,b)->a+b);
            //Using Enhanced Lambdas
            //   return numbers.stream().reduce(0, Integer::sum);

            //Break down of Lambda into it's Functional Interface
       BinaryOperator<Integer> sum = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a+b;
            }
        };
        return numbers.stream().reduce(0, sum);
        }
    }