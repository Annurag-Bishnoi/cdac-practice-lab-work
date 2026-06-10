package src;
import java.util.*;

public class Lists {
	public static void main(String[] args) {
		List <Integer> l1=new ArrayList<>();
		l1.add(3);
		l1.add(null);
		l1.add(0);
		l1.add(2);
		
		System.out.println(l1);
		l1.add(1,4);
		System.out.println(l1);
		l1.set(2, 5);
		System.out.println(l1);
		l1.remove(2);
		
		
		System.out.println(l1);
		System.out.println(l1.contains(9));
//		System.out.println(l1.size());
		System.out.println();
		l1.sort(null);
		System.out.println(l1);
	}

}
