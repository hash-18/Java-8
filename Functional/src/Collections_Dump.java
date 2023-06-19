import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Collections_Dump {

    public static void main(String[] args)
    {
        Col.printMap();
        Col.concurrentMap();
        Col.synchronizedMap();
        Col.iteratingOverMap();
    }
}

class Col
{

    public static void printMap()
    {
        HashMap<Integer,String> map=new HashMap<>();
        map.put(1,"Mac");
        System.out.println(map);
    }

    public static void concurrentMap()
    {
        ConcurrentMap<Integer,String> cMap=new ConcurrentHashMap(new HashMap<>());
        cMap.put(1,"Mac");
        System.out.println(cMap);
    }

    public static void synchronizedMap()
    {
        Map<Integer,String> sMap= Collections.synchronizedMap(new HashMap<>())   ;

        sMap.put(1,"Mac");
        System.out.println(sMap);
    }

    public static void iteratingOverMap()
    {
        HashMap<Integer,String> map=new HashMap<>();
        map.put(1,"Mac");
        map.put(2,"Pac");
        map.put(3,"Tac");

        //Returns a set of entry ofmapp []
        System.out.println(map.entrySet());

        //Iterating over map
      /* Iterator itr=map.entrySet().iterator();
       while(itr.hasNext())
       {
           System.out.println(itr.next());
       }*/

        Iterator itr=map.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry entry=(Map.Entry)itr.next();
            System.out.println("Key : "+entry.getKey()+ " Value : "+entry.getValue());

        }

        Iterator<Map.Entry<Integer,String>> itr1=map.entrySet().iterator();
        while(itr1.hasNext())
        {
           Map.Entry<Integer, String> entry1= (Map.Entry<Integer, String>) itr1.next();
            System.out.println("Key : "+entry1.getKey()+ " Value : "+entry1.getValue());

        }


    }

}
