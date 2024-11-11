/*
You are given a list of Student objects, where each Student has the following fields:
	name (String): The name of the student
	subject (String): The subject the student is studying
	grade (double): The student’s grade
	school (String): The school the student belongs to

Tasks to Perform:
	Filter: Select students with a grade greater than 75.
	Map: Add 5 points bonus to their grades.
	GroupBy: Group the students by their school.
	Reduce/Aggregate: Calculate the average grade for each school.
	Aggregator: Identify the student with the highest grade in each school.


Sample Input:
-------------
5					// number of students
Alice Math 80 HPS	// each student infomation.
Bob Science 60 DPS 
Charlie Math 75 HPS
David Science 85 DPS 
Eva Math 95 HPS
	
Sample Output:
--------------
HPS: Eva with grade 100.0
DPS: David with grade 90.0

*/

import java.util.*;
import java.util.stream.*;

class Student{
    String name;
    String subject;
    double grade;
    String school;
    Student(
        String name,
        String subject,
        double grade,
        String school
    ){
        this.name = name;
        this.subject = subject;
        this.grade = grade;
        this.school = school;
    }

    public double getGrade() {
        return grade;
    }
    public String getSchool() {
        return school;
    }
    public String getName() {
        return name;
    }
    public String getSubject() {
        return subject;
    }
    public void addBonus(double grade) {
        this.grade += grade;
    }

}
public class Day12P2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        List<Student> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String inp[] = cin.nextLine().split(" ");
            l.add(new Student(inp[0],inp[1], Double.parseDouble(inp[2]), inp[3]));
        }   
        Map<String,Optional<Student>> res = l.stream()
        .filter(Student->Student.getGrade()>75)
        .peek(Student->Student.addBonus(5))
        .collect(Collectors.groupingBy(
            Student::getSchool,
            Collectors.maxBy(Comparator.comparingDouble(Student::getGrade))
        ));

        res.forEach((school,student)->{
            if(student.isPresent()){
                Student topStudent = student.get();
                System.out.println(topStudent.school+": "+topStudent.getName()+" with grade "+topStudent.getGrade());
            }
        });

        cin.close();
    }
}
