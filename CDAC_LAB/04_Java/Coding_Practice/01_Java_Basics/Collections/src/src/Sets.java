package src;
import java.util.*;
public class Sets {
public static void main(String[] args) {
//	************************Set*******************************************************************
	Set<Integer> list=new HashSet<>();
	
	list.add(4);
	list.add(null);
	list.add(50);
	list.add(null);
	list.add(50);
	System.out.println(list);
	list.remove(50);
	System.out.println(list);
	list.remove(4);
	list.add(3);
	list.add(8);
	list.add(9);
	System.out.println(list);
	System.out.println(list.contains(4));
	System.out.println(list.size());
	list.clear();
	System.out.println(list);
	list.add(49);
	
	System.out.println(list.isEmpty());
	
//	************************HashSet*******************************************************************

	HashSet<String> fruits=new HashSet<>();
	fruits.add("apple");
	fruits.add("banana");
	fruits.add("papaya");
	fruits.add("apple");
	fruits.add("aaple");
	fruits.add("Apple");
	System.out.println(fruits);
	
//	************************LinkedHashSet*******************************************************************

	LinkedHashSet<String> fruit=new LinkedHashSet<>();
	fruit.add("apple");
	fruit.add("banana");
	fruit.add("papaya");
	fruit.add("apple");
	fruit.add("aaple");
	fruit.add("Apple");
	System.out.println(fruit);
	
	
//	************************TreeSet*******************************************************************

	TreeSet<String> color=new TreeSet<>();
//	color.add(null);
	color.add("pink");
	color.add("pinkki");
	color.add("green");
//	color.add(null);
	color.add("green");
	color.add("Green");
	color.add("5");
	System.out.println(color);
}
}
