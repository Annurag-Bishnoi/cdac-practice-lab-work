package basics;
import java.util.*;
public class Fibonacci {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

		System.out.println("Enter a Value: ");
		int val=sc.nextInt();
		
		ArrayList<Integer> res= new ArrayList<>();
		int count =0;
		for(int i=1;i<=val;i++) {
			 count = i+(i-1);
			res.add(i,count);
		}
		
		
		for(int i =0;i<res.size();i++) {
			System.out.print(res.get(i)+" ");
		}

}
}
