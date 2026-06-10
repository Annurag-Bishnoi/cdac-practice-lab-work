package src;
import java.util.*;
public class SelectionSorting {

	
	private static void selectionsort(int[] arr,int size) {
		int max=Integer.MAX_VALUE;
		
		for(int i=0;i<size-1;i++) {
			int minindex=i;
			for(int j=i+1;j<size;j++) {
				if(arr[j]<arr[minindex]) {
					minindex=j;
					
				}
			}
//			Swapp
			int temp=arr[i];
			arr[i]=arr[minindex];
			arr[minindex]=temp;
		}
		
		
		
		System.out.print("Selection Sort = [");
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
		
		selectionsort(arr,size);
		
		
	}
}
