
 /*
You are tasked with building a Person Management System that processes a list 
of Person objects using Java Streams. Each Person object contains the following 
attributes:
	Name: (String) The name of the person
	Age: (int) The age of the person
	Location: (String) The location where the person lives

Your goal is to sort by age, filter who atre above 20, and group by location 
using Java Stream operation.


Sample Input:
-------------
4                   
Alice,23,New York   
Bob,34,Los Angeles
Charlie,18,New York
David,29,Los Angeles

Sample Output:
-------------
New York => 
Person{name='Alice', age=23, location='New York'}
Los Angeles => 
Person{name='David', age=29, location='Los Angeles'}
Person{name='Bob', age=34, location='Los Angeles'}

*/



import java.util.*;
import java.util.stream.*;

class Person{
    String name;
    int age;
    String Location;
    Person(String name , int age , String Location){
        this.name = name;
        this.age = age;
        this.Location = Location;
    } 
    public int getAge() {
        return age;
    }
    public String getLocation() {
        return Location;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Person{name='"+name+"', age="+age+", location='"+Location+"'}";
    }
}

public class Day11p1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        List<Person> l = new ArrayList<>();
        int n = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < n; i++) {
            String temp[] = cin.nextLine().split(",");
            l.add(new Person(temp[0],Integer.parseInt(temp[1]),temp[2]));
        }
        
        Map<String,List<Person>> res = l.stream()
        .sorted(Comparator.comparingInt(Person::getAge))
        .filter(Person->Person.getAge()>20)
        .collect(Collectors.groupingBy(Person::getLocation));

        // System.out.println(res);
        for (Map.Entry<String,List<Person>> entry : res.entrySet()) {
            System.out.println(entry.getKey()+"=>");
            for (Person person : entry.getValue()) {
                System.out.println(person);   
            }
        }
    }
}
