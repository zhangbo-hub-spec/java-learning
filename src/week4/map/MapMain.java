package week4.map;

import java.util.HashMap;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {

        Map<String, String> map = createMap(99);

        System.out.println(map.get("key20"));

        System.out.println(map.get(new Object()));
        System.out.println(map.get("key999"));


        map.put(null, "value of null key");
        map.put("testnull", null);

        System.out.println("null key value:" + map.get(null));
        System.out.println("null value support:" + map.get("testnull"));


        System.out.println("--------------删除key--------------");

        String keyToRemove = "key9";
        System.out.println(keyToRemove + "对应的值是：" + map.get(keyToRemove));
        map.remove(keyToRemove);
        System.out.println("执行删除操作后，" + keyToRemove + "对应的值是：" + map.get(keyToRemove));

        System.out.println("--------------遍历key和value--------------");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key为：" + entry.getKey() + "，value为：" + entry.getValue());
        }

        System.out.println("--------------遍历value--------------");

        for (String value : map.values()) {
            System.out.println(value);
        }

        System.out.println("--------------遍历key--------------");

        for (String key : map.keySet()) {
            System.out.println(key);
        }

    }


    private static Map<String, String> createMap(int size) {
        Map<String, String> ret = new HashMap<>();
        for (int i = 0; i < size; i++) {
            // TODO put的第一个为key，第二个为value
            ret.put("key" + i, String.valueOf(Math.random()));
        }
        return ret;
    }

}