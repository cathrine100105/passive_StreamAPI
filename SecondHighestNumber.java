import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondHighestNumber {
    public static void main(String[] args) {

        // 1. Find Second Highest Number
        List<Integer> numbers = Arrays.asList(10 ,45 ,67 ,23 ,89 ,54 ,89);
        Integer secondHighest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondHighest);

        System.out.println("\n");

        //3. Find Duplicate Numbers
        List<Integer> dup = Arrays.asList(10, 20, 30, 20, 40, 10, 50, 30);
        dup.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey).forEach(System.out::println);

        System.out.println("\n");

        //5. Find Top 3 Highest Numbers
        List<Integer> highest = Arrays.asList(10, 80, 45, 60, 30, 90, 20);
        List<Integer> valueNumb = highest.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println(valueNumb);

        System.out.println("\n");

        //6. Partition Numbers into Even and Odd
        List<Integer> partition = Arrays.asList(10, 15, 20, 25, 30, 35, 40);
        Map<Boolean,List<Integer>> partitionValue = partition.stream().collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println("Even: "+ partitionValue.get(true));
        System.out.println("Odd: "+partitionValue.get(false));

        System.out.println("\n");

        //7. Find Numbers Starting With Digit 1
        List<Integer> list = Arrays.asList(10, 15, 23, 11, 45, 19, 30);
        list.stream().map(String::valueOf).filter(f->f.startsWith("1")).toList().forEach(System.out::println);


        System.out.println("\n");

        //8.Find Common Elements Between Two Lists
        List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> list2 = Arrays.asList(30, 40, 60, 70);
        list1.stream().filter(list2::contains).forEach(System.out::println);

        System.out.println("\n");

        //9. Group Numbers by Even and Odd
        List<Integer> num = Arrays.asList(5 ,10, 15 ,20, 25 ,30);
        Map<String,List<Integer>> numberDet = num.stream().collect(Collectors.groupingBy(n->(n%2==0 ?"Even/true":"Odd/false")));
        System.out.println(numberDet);

        System.out.println("\n");

        //10. Find Sum of Squares of Even Numbers
        List<Integer> square = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> sum = square.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n).collect(Collectors.toList());
        System.out.println(sum);

        System.out.println("\n");

        //2. Find First Non-Repeated Number
        List<Integer> nonRepeated = Arrays.asList(4, 5, 1, 2, 0, 4, 5, 2);
        Optional<Integer> find = nonRepeated.stream().distinct().filter(n->Collections.frequency(nonRepeated,n)==1).findFirst();
        System.out.println(find);

        System.out.println("\n");


        //4. Count Frequency of Each Number
        List<Integer> fre = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 1);
        Map<Object, Long> frequencyCount = fre.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
        System.out.println(frequencyCount);
    }
}
