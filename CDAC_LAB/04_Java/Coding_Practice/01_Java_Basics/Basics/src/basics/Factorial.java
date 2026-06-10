package basics;
import java.util.*;
public class Factorial {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter a Number : ");
	int val = sc.nextInt();
	if(val==0|| val<0) {
		System.out.println("0 or Negative Number Didnt have Factorial ");
		return;
	}
	int res=1;
	for(int i =1;i<=val;i++) {
		res=res*i;
	}
	System.out.println("Factorial : "+res);
}
}
