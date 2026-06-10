package base;
import java.util.*;

class Employee{
	int id;
	String name ;
	int salary;
	Employee(int id,String name ,int salary){
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	void displayDetail() {
		System.out.println("Id : "+id);
		System.out.println("Name : "+name);
		System.out.println("Salary : "+salary);
		
	}
}
class Manager extends Employee{
	String department;
	Manager(int id ,String name ,int salary,String department){
		super(id,name,salary);
		this.department=department;
	}
	void displayDetail() {
		System.out.println("Id : "+id);
		System.out.println("Name : "+name);
		System.out.println("Salary : "+salary);
		System.out.println("Department : "+department);
	}
}
class Developer extends Employee{
	String programmingLang;
	Developer (int id,String name,int salary,String programmingLang){
		super(id,name,salary);
		this.programmingLang=programmingLang;
	}	
	void displayDetail() {
		System.out.println("Id : "+id);
		System.out.println("Name : "+name);
		System.out.println("Salary : "+salary);
		System.out.println("Programming Language : "+programmingLang);
	}
}

public class OopsMiniPracticle {
public static void main(String[] args) {
	
	Employee e1=new Manager(1,"amit",6000,"HR");
	Employee e2 =new Developer(2,"rahul",5930,"Java");
	e1.displayDetail();
	e2.displayDetail();
}
}
