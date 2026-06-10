package src;

import java.util.Scanner;

public class bubblesorting {
	private static void bubblesort(int[] arr,int size) {
		
		for(int i=0;i<size-1;i++) {
			for(int j=0;j<size-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.print("Bubble Sort = [ ");
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("]");
	}
	
	
	
	private static void optimizedBubbleSort(int[] arr,int size) {
		for(int i=0;i<size-1;i++) {
			boolean swapped=false;
			for(int j=0;j<size-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped=true;
				}
			}
			if(swapped==false) {
				break;
			}
		}
		
		System.out.print("Optimized Bubble Sort = [ ");
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("]");
	}
		
	
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter The size of Array");
		int size = sc.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++) {
			System.out.println("Enter Element");
			arr[i]=sc.nextInt();
		}
		bubblesort(arr,size);
		optimizedBubbleSort(arr,size);
	}

	
}
