package uebungen;

import dataStructurs.basic.Student;

public class Aufgabe7
{
	public static void main(String[] args)
	{
		LectureWithSortAlgorithms lecture = new LectureWithSortAlgorithms("DAP1", 6);
		
		lecture.add(new Student("D", "Inf", 1));
		lecture.add(new Student("B", "Inf", 2));
		lecture.add(new Student("A", "Inf", 3));
		lecture.add(new Student("B", "Mathe", 4));
		lecture.add(new Student("C", "Inf", 5));
		
		lecture.show();
		
		System.out.println("------------------------------");
		
		lecture.swapSortByName();
		
		lecture.show();
		
		
	}
}
