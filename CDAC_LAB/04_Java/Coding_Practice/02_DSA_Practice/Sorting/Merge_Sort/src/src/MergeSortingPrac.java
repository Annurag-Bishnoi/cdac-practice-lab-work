package src;

import java.util.*;

public class MergeSortingPrac {
	
	private static void mergesort(int[] arr, int si, int ei) {
		
		if(si>=ei) {
			return ;
		}
		int mid= si+(ei-si)/2;
		
		mergesort(arr,si,mid);
		mergesort(arr,mid+1,ei);
		
		merge(arr,si,mid,ei);
		
	}

	private static void merge(int[] arr, int si, int mid, int ei) {
		
		int []temp=new int[(ei-si+1)];
		
		int i=si;
		int j=mid+1;
		int k=0;
		
		while(i<=mid && j<=ei) {
			
			if(arr[i]<arr[j]) {
				temp[k]=arr[i];
				
				i++;
			}
			else {
				temp[k]=arr[j];
				
				j++;
			}
			k++;
			
		}
		
		while(i<=mid) {
			temp[k++]=arr[i++];
		}
		while(j<=ei) {
			temp[k++]=arr[j++];
		}
		
		for(int d=0;d<temp.length;d++) {
			arr[d]=temp[d];
		}
		
		
		
	}
	
	static void display(int[] arr,int ei) {
		System.out.print("Merge Sort = [");
		for(int f=0;f<ei;f++) {
			System.out.print(" "+arr[f]+" ");
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
		
		mergesort(arr,0,size-1);
		display(arr,size);
	}


}
