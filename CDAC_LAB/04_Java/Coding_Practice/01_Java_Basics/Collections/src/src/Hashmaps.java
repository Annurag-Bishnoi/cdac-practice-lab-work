package src;
import java.util.*;
public class Hashmaps {
public static void main(String[] args) {
	HashMap<Integer,Integer> mp=new HashMap<>();
	int[] arr= {3,4,5,6,2,7};
	int key=10;
	
	for(int i=0;i<arr.length;i++) {
		int fin=key-arr[i];
		if(mp.containsKey(fin)) {
			System.out.println(" "+ mp.get(fin)+" "+i);
		}
		mp.put(arr[i], i);
		
	}
	
	
	
	
	
}
}
