package src;

import java.util.Scanner;

public class InsertionSorting {
	
	private static void insertionSort(int[] arr, int size) {
		
		for(int i=1;i<size;i++) {
			
			int curr=arr[i];
			int prev=i-1;
			while(prev>=0 && arr[prev]>curr) {
				
				arr[prev+1]=arr[prev];
				prev--;
				}
			
			arr[prev+1]=curr;
			
			
		}
		
		System.out.print("Insertion Sort = [");
		for(int i=0;i<size;i++) {
			System.out.print(" "+arr[i]+" ");
		}
		System.out.println("]");
		
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter the Size of Array");
	int size = sc.nextInt();
	
	int [] arr=new int[size];
	
	for(int i=0;i<size;i++) {
		System.out.println("Enter Element : ");
		arr[i]=sc.nextInt();
	}
	
	insertionSort(arr,size);
}


}
