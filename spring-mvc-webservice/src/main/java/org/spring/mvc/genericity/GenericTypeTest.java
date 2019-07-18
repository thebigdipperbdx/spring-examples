package org.spring.mvc.genericity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019-07-18 16:58
 */
public class GenericTypeTest {
    public static void main(String[] args){
        List<Integer> list=Arrays.asList(1, 2, 3, 4);
        int sum=0;
        for (int i=0;i<list.size();i++) {
            sum+=list.get(i);
        }
        System.out.println(sum);
    }

    public static void testGenericType(){
        Map<String, String> map=new HashMap<String, String>();
        map.put("hello", "Jack");
        map.put("how are you?", "fine");

        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }
}
