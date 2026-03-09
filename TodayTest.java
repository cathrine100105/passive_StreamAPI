import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TodayTest {
    public static void main(String[] args) {

        //1. Find Second-Highest Number
        System.out.println("Find Second Highest Number: ");
        List<Integer> list = Arrays.asList(10,45,67,23,89,54,89);
        int secondHighest = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondHighest+"\n");

        //2. Find First Non-Repeated Number
        System.out.println("Find First Non-Repeated Number: ");
        List<Integer> nonRepeat=Arrays.asList(4,5,1,2,0,4,5,2);
        int result = nonRepeat.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting())).entrySet().stream()
                .filter(x->x.getValue()==1).findFirst().get().getKey();
        System.out.println(result+"\n");

        //3. Find Duplicate Numbers
        System.out.println("Find Duplicate Numbers: ");
        List<Integer> duplicateValue = Arrays.asList(10,20,30,20,40,10,50,30);
        duplicateValue.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(x->x.getValue()>1).map(Map.Entry::getKey).forEach(System.out::println);
        System.out.println("\n");

        //5. Find Top 3 Highest Numbers
        System.out.println("Find Top 3 Highest Numbers: ");
        List<Integer> highestNo = Arrays.asList(10,80,45,60,30,90,20);
        highestNo.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
        System.out.println("\n");

        //7. Find Numbers Starting With Digit 1
        System.out.println("Find Numbers Starting With Digit 1: ");
        List<Integer> number = Arrays.asList(10,15,23,11,45,19,30);
        number.stream().map(String::valueOf).filter(n->n.startsWith("1")).forEach(System.out::println);
        System.out.println("\n");

        //8. Find Common Elements Between Two Lists
        System.out.println("Find Common Elements Between Two Lists: ");
        List<Integer> list1 =Arrays.asList(10,20,30,40,50);
        List<Integer> list2 =Arrays.asList(30,40,60,70);
        List<Integer> element =list2.stream().filter(list1::contains).collect(Collectors.toList());
        System.out.println(element+"\n");


        // 10. Find Sum of Squares of Even Numbers
        System.out.println("Find Sum of Squares of Even Numbers: ");
        List<Integer> squareValue = Arrays.asList(1,2,3,4,5,6);
        List<Integer> sum = squareValue.stream().filter(n->n%2==0).map(n->n*n).collect(Collectors.toList());
        System.out.println(sum+"\n");

        //6. Partition Numbers into Even and Odd
        System.out.println("Partition Numbers into Even and Odd: ");
        List<Integer> no = Arrays.asList(10,15,20,25,30,35,40);
                Map<Boolean,List<Integer>> resultOfPartition = no.stream().collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println("Even: "+ resultOfPartition.get(true));
        System.out.println("Odd: "+resultOfPartition.get(false));
        System.out.println("\n");

        //9. Group Numbers by Even and Odd
        System.out.println("Group Numbers by Even and Odd: ");
        List<Integer> numberType = Arrays.asList(5,10,15,20,25,30);
        Map<String ,List<Integer>> groupResult = numberType.stream().collect(Collectors.groupingBy(n->n%2==0 ?"Even" : "Odd"));
        System.out.println(groupResult);
        System.out.println("\n");

        //4. Count Frequency of Each Number
        System.out.println("Count Frequency of Each Number: ");
        List<Integer> frequency = Arrays.asList(1,2,3,2,4,1,5,1);
        Map<Integer,Long> count = frequency.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(count);

    }
}
