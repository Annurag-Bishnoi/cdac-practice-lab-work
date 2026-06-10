package base;
import java.util.*;

class Student{
	int id ;
	String name;
	String course;
	int marks;
	
	Student(){
		
	}
	
	 Student(int id, String name, String course, int marks) {

		this.id = id;
		this.name = name;
		this.course = course;
		this.marks = marks;
	}



	void display() {
		System.out.println("Id : "+ id);
		System.out.println("Name : "+name);
		System.out.println("Course : "+course);
		System.out.println("Marks : "+marks);
	}
}




public class OopsBasics {
public static void main(String[] args) {
	Student s1 = new Student(102,"vaibhav","dac",30);
	Student s2=new Student();
	s1.display();
	s1.id=101;
	s1.name="Anurag";
	s1.course="cdac";
	s1.marks=90;
	s1.display();
	s2.display();
}
}
