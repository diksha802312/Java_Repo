package Java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,1,2,3,3,3);
        List<Integer> list1 = List.of(9, 7, 3,6,2,1,0);
        System.out.println(countFreq(list));
        System.out.println(getDuplicates(list));
    }

    public static Map<Integer, Long> countFreq(List<Integer> list){
        return list.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));
    }

    public static Set<Integer> getDuplicates(List<Integer> list){
        return list.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()))
                .entrySet().stream().filter(m->m.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toSet());

    }

    public static List<Integer> sortList(List<Integer> list){
        list.sort(Comparator.comparingInt(Integer::intValue));
    }
}
