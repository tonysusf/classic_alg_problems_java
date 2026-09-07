import java.util.*;

/*
* javac JavaBasics.java; java JavaBasics
*/

class JavaBasics {

    public static void main(String[] args) {
        // Array
        int[] arr = {1, 2, 8};
        System.out.println("arr is " + Arrays.toString(arr));


        // String
        String s = "hello world";
        System.out.println(s.substring(2, 5));
        System.out.println(s.substring(2));
        System.out.println(s.contains("wo"));
        System.out.println(s.startsWith("he"));
        System.out.println(s.endsWith("ld"));
        System.out.println(s.indexOf("llo"));
        System.out.println(s.lastIndexOf("o"));
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());

        String[] arr2 = s.split(" ");
        System.out.println("split: " + Arrays.toString(arr2));
        System.out.println(s.equals("Hola"));
        System.out.println(s.isEmpty());

        // int
        System.out.println("max int is " + Integer.MAX_VALUE + ", min int is " + Integer.MIN_VALUE);


        // HashMap
        Map<Integer, Integer> lookup = new HashMap();
        lookup.put(1, 100);
        lookup.put(2, 200);
        System.out.println("Map is " + lookup);
        System.out.println(lookup.get(2));

        //Set
        Set<Integer> set = new HashSet<>();
        set.add(4);
        set.add(4);
        set.add(9);
        System.out.println("Set is " + set);
    }
}


