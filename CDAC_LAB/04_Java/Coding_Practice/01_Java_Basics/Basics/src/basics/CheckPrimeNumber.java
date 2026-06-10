package basics;
import java.util.*;
public class CheckPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
	System.out.println("Enter a Number : ");
	int val=sc.nextInt();
	
	boolean isPrime=true;
	
	if(val==1||val==0) {
		System.out.println("0 and 1 are neither prime nor composite numbers");
		return;
	}
	
	if(val<0) {
		System.out.println("Number Cannot be Negative !!!");
		return;
	}
	
	for(int i =2;i<=val/2;i++) {
		if(val%i==0) {
			System.out.println("Number is Not Prime "+val);
			isPrime=false;
			break;
		}
	}
	if(isPrime) {
	System.out.println("Number is  Prime ");
	
	}		
	}

}
