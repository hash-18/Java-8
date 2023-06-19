import java.util.*;
import java.util.stream.Collectors;

public class Collection_Dump2 {

    public static void main(String[] args) {

        List<Integer> l=List.of(1,2,9,3,1,4,3,2,1,5,7);
        ArrayList<Integer> al=new ArrayList<>(l);
        System.out.println(al);
//       Collections.sort(al,Comparator.reverseOrder());
//
//        System.out.println(al);
//        Set<Integer> s= new HashSet<>(al);
//        System.out.println(s);

        System.out.println(al.stream().distinct());

        List<Integer> collect = al.stream().distinct().collect(Collectors.toList());

        HashMap<String,Integer> h1=new HashMap<>();
        h1.put("",10);
        h1.put("",20);
        h1.put("",30);
        System.out.println(h1);
    }

}
