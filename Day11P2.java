
/*
You are required to build an Employee Management System that processes a list 
of Employee objects to group them by their department and calculate the average 
salary for each department. Each Employee object has the following attributes:
    - Name: (String) The name of the employee
    - Department: (String) The department in which the employee works
    - Salary: (double) The salary of the employee
    
Your task is to group employees by their department and find the average salary 
for each department using Java Streams.

Sample Input:
-------------
4                   //no of employees
Alice,IT,60000      //name, department,salary
Bob,HR,50000
Charlie,IT,70000
David,HR,55000

Sample Output:
-------------
HR : 52500.00
IT : 65000.00

*/
import java.util.*;
import java.util.stream.*;

class Person{
    String name;
    String department;
    double salary;
    Person(String name , String department , double salary){
        this.name = name;
        this.salary = salary;
        this.department = department;
    } 
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Person{name='"+name+"', salary="+salary+", department='"+department+"'}";
    }
}

public class Day11P2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        List<Person> l = new ArrayList<>();
        int n = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < n; i++) {
            String temp[] = cin.nextLine().split(",");
            l.add(new Person(temp[0],temp[1],Double.parseDouble(temp[2])));
        }
        
        Map<String,Double> res = l.stream()
        .collect(Collectors.groupingBy(Person::getDepartment, Collectors.averagingDouble(Person::getSalary)));

        for (Map.Entry<String, Double> entry : res.entrySet()) {
            System.out.printf("%s : %.2f%n", entry.getKey(), entry.getValue());
        }
        cin.close();
    }
}
