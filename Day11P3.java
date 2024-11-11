/*
You are tasked with building a Student Score Management System that sorts 
students based on their scores. Each student has multiple test scores: 
a coding test score, MCQ test score, and a total score.

The students should be sorted according to the following rules:
	- Primary Sorting: By total score in descending order.
	- Secondary Sorting: If two students have the same total score, 
	  sort them by coding test score in descending order.
	- Tertiary Sorting: If the coding test scores are also the same, 
	  sort them by MCQ test score in descending order.
	
You must use Java Streams to perform the sorting operation.

Sample Input:
-------------
3               //no of students
Alice,80,70     // name, codingScore, mcqScore
Bob,85,60
Charlie,90,60

Sample Output:
--------------
Charlie: 90, 60, 150
Alice: 80, 70, 150
Bob: 85, 60, 145

*/

import java.util.*;
import java.util.stream.*;

class student{
	String name;
	int codingScore;
	int mcqScore;
	student(String name,int codingScore, int mcqScore){
		this.name = name;
		this.codingScore = codingScore;
		this.mcqScore = mcqScore;
	}
	public int getMcqScore() {
		return mcqScore;
	}
	public int getCodingScore() {
		return codingScore;
	}
	public int getTotal(){
		return codingScore+mcqScore;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName() + ": " + getCodingScore() + ", " + getMcqScore() + ", " + getTotal();
	}
}
public class Day11P3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		cin.nextLine();
		List<student> l = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String temp[] = cin.nextLine().split(",");
			l.add(new student(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
		}

		List<student> res = l.stream()
		.sorted(Comparator.comparingInt(student::getTotal).reversed()
		.thenComparing(Comparator.comparingInt(student::getMcqScore).reversed())
		.thenComparing(Comparator.comparingInt(student::getCodingScore).reversed()))
		.collect(Collectors.toList());

		for (student student2 : res) {
			System.out.println(student2);
		}
		cin.close();
    }
}
