package test.perfomance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pingping on 4/26/18.
 */
public class ArrayListTest {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

//        Map<String,String> map  = null;
        Map<String,String> map = new HashMap<String, String>(400000);
        for(int i=0;i<400000;i++){
            map.put("a"+i,"a"+i);
        }

//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(0).equals(list.get(1)));
        System.out.println(map.size());

        System.out.println(System.currentTimeMillis() - start);
    }


}
