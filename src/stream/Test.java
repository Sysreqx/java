package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("qqqq");
        list.add("wewewweew");
        list.add("3wwer");
        list.add("4rwerw");
        list.add("5werqwerqwe");

        List<Integer> list2 = list.stream().map(elem -> elem.length()).collect(Collectors.toList());
        System.out.println(list2);
    }
}
