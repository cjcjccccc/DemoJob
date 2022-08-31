package cjc.myhashmap;

import java.util.HashMap;

/**
 * @author 陈境聪
 * @date 2022年08月16日 19:19
 */

public class Test {
    public static void main(String[] args) {
        MyHashMap<String,String> map = new MyHashMap<>();
        map.put("cjc","java开发");
        map.put("cjc","java开发工程师");
        map.put("aaa","c++开发");
        map.put("bbb","c开发");
        map.put("ccc","c++开发");
        map.put("ddd","c++开发");
        map.put("eeee","c++开发");
        String cjc = map.get("cjc");
        System.out.println(cjc);
        System.out.println(map.size);

        System.out.println("------");
        map.remove("ddd");
        System.out.println(map.size);
        map.print();


        map.put("1","c++开发");
        map.put("2","c++开发");
        map.put("3","c++开发");
        map.put("4","c++开发");
        map.put("5","c++开发");
        map.put("6","c++开发");
        map.put("7","c++开发");
        map.put("8","c++开发");
        map.put("9","c++开发");
        map.put("10","c++开发");
        map.put("11","c++开发");
        map.put("12","c++开发");
        System.out.println("------");
        System.out.println(map.size);
        map.print();

        System.out.println("------");
        map.update("eeee","python开发");
        System.out.println(map.get("eeee"));


        System.out.println("------");
        for (String s : map.Keyset()) {
            System.out.println(s);
        }
        for (String value : map.values()) {
            System.out.println(value);
        }

    }
}
