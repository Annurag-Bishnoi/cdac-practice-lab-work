package arrays;

import java.util.Arrays;

public class arrays {
public static void main(String[] args) {
//	Linear Search
	int[] arr= {2,3,4,5,6,7,45};
	int k=45;
	for(int i=0;i<arr.length;i++) {
		if(k==arr[i]) {
			System.out.println(" found at index"+ i);
		}
	}
	
//	 Largest Number
	int max=Integer.MIN_VALUE;
	for(int i=0;i<arr.length;i++) {
		if(max<arr[i]) {
			max=arr[i];
		}
	}
	System.out.println("Largest "+ max);
	
//	Binary Search 
	
	int start=0;
	int end=arr.length-1;
	int mid=0;
	System.out.println(end);
	while(start<=end) {
		
		 mid=(start+end)/2;
		if(k==arr[mid]) {
			System.out.println("Found at index : "+mid);
			break;
			
		}
		else if(k<arr[mid]){
			end=mid-1;
		}
		else {
			start=mid+1;
		}
		
	}
	 
//	Reveres a Array
	while(start<=end) {
		
		int temp=arr[end];
		arr[end]=arr[start];
		arr[start]=temp;
		start++;
		end--;
	}
	System.out.println("reverse Array :"+Arrays.toString(arr));
	
	
	
}
}
