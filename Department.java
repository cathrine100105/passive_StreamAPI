import javax.naming.Name;
import java.util.*;
import java.util.stream.Collectors;

public class Department {
    private String deptName;
    private String name;
    private double percentage;
    private int year;

    public String  getDeptName(){
        return deptName;
    }
    public String  getname(){
        return name;
    }
    public Double getPercentage(){
        return percentage;
    }
    public Integer getYear(){
        return year;
    }

    public Department(String deptName, String name, double percentage, int year){
        this.deptName=deptName;
        this.name=name;
        this.percentage=percentage;
        this.year=year;
    }

    @Override
    public String toString() {
        return "Department Name: " + deptName+"  " +" Name: " + name+"  " +" Percentage: "+ percentage+"  " +" Year: "+ year;
    }

    public static void main(String[] args) {
        List<Department> details = new ArrayList<>();
        details.add(new Department("ECE","Madhu",87.7,2021));
        details.add(new Department("CSE","Mahindra",80.0,2022));
        details.add(new Department("ECE","Cathrine",90.6,2022));
        details.add(new Department("Civil","Allen",95.8,2025));
        details.add(new Department("Mech","Sarah",80.9,2024));
        details.add(new Department("CSBS","Sandra",88.0,2029));

        Map<String, Double> percentageCalculation = details.stream().max(Comparator.comparingDouble(Department::getPercentage)).stream().collect(Collectors.toMap(d->d.getDeptName(), d->d.getPercentage()));
        System.out.println(percentageCalculation);

    }
}
