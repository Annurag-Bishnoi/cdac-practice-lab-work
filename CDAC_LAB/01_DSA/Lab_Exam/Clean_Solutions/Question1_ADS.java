package src;
import java.util.*;
public class Question1_ADS {
	
	static void addPackageDetails(int size,Package[] p) {
		Scanner sc=new Scanner(System.in);
		
		
		
		for(int i=0;i<size;i++) {
			System.out.println("_____________________Enter Package "+(i+1)+"  Details :_______________________________");
		System.out.println("Enter Package Id : ");
		int pId=sc.nextInt();
		System.out.println("Enter Package Weight : ");
		double weight=sc.nextDouble();
		System.out.println("Enter Package Destination Code : ");
		String dCode=sc.next();
		p[i]=new Package(pId,weight,dCode);
		System.out.println("________________________________________________________________________________________");
		}
		
	}
	
	static void disPackages(Package[] p) {
		System.out.println("                   Packages Details                              ");
		System.out.println("____________________________________________________");
		for(int i=0;i<p.length;i++) {
			
			p[i].displayPackages();
			System.out.println("_____________________________________________________");
		}
		
		
	}
	

	
	
	static void sortPackages(Package[] p,int size) {
	
		for(int i=0;i<size-1;i++) {
			int minindex=i;
			
			for( int j=i+1;j<size;j++) {
				
				if(p[j].weight<p[minindex].weight) {
					minindex=j;
				}  
				
			}
//			Swapping
			Package temp=p[i];
			p[i]=p[minindex];
			p[minindex]=temp;
			
		}
		
		System.out.println("              After Sorting By Weight Packages Details                         ");
		System.out.println("____________________________________________________");
		for(int i=0;i<size;i++) {
			
			p[i].displayPackages();
			System.out.println("_____________________________________________________");
		}
		
	

		
	}
	
	static void searchPackages(Package[] p, int size) {
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter The Package Id For Searching :");
		int packId=sc.nextInt();
		boolean track=false;
		
		for(int i=0;i<size;i++) {
			if(packId==p[i].packageId) {
				System.out.println("Found Your Package ");
				System.out.println("- - - -- - - - - - - - - - - - - -- - - - - - - - - -  - -- - ");
				
			p[i].displayPackages();
			System.out.println("- - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - ");
			track=true;
			
				
			}
			
		}
		if(track==false) {
			System.out.println("!!!! Package Not Found of Package Id  "+packId+" !!!!!!!");
		}
		
	}
	
	
	static void heaviestPackage(Package[] p, int size) {
		int minindex;
		for(int i=0;i<size-1;i++) {
			minindex=i;
			int j;
			for( j=i+1;j<size-1;j++) {
				
				if(p[j].weight<p[minindex].weight) {
					minindex=j;
				}
				
				
			}
//			Swapping
			Package temp=p[j];
			p[j]=p[minindex];
			p[minindex]=temp;
			
		}
		System.out.println("             Heaviest Packages Details                         ");
		System.out.println("____________________________________________________");
			p[0].displayPackages();
		System.out.println("_____________________________________________________");
		
		
		
	}
	
	
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	boolean x= true;
	System.out.println("Enter The No. Of All Packages");
	int size = sc.nextInt();
	Package [] packages=new Package[size];
	while(x) {
		System.out.println();
	System.out.println("========Smart Package Sorting and Tracking System(SPSTS)=================");
	System.out.println("1. Add Package Details ");
	System.out.println("2. Display All Package");
	System.out.println("3. Sort Packages By Weight in Ascending order(Selection Sort)");
	System.out.println("4. Search a Package Using Package Id (Linear Search)");
	System.out.println("5. Display The Heaviest Package ");
	System.out.println("6. Exit");
	int choice =sc.nextInt();
	switch(choice) {
	case 1 :
		
		addPackageDetails(size,packages);
		break;
	case 2 :
		
		disPackages(packages);
		break;
	case 3 :
		sortPackages(packages, size);
		
		break;
	case 4 :
		searchPackages(packages,  size);
		break;
	case 5 :
		heaviestPackage(packages,  size);
		break;
	case 6 :
		x=false;
		System.out.println("Thank You :)");
		break;
		default :
			System.out.println("Invalid Input !!!!");
			break;
	}
	
	}
	
}
}


class Package{
	int packageId;
	double weight;
	String destinationCode;
	Package(int packageId, double weight, String destinationCode){
		this.packageId=packageId;
		this.weight=weight;
		this.destinationCode=destinationCode;
	}
	
	void displayPackages() {
		System.out.println("Package Id :"+packageId);
		System.out.println("Package Weight : "+weight);
		System.out.println("Package Destination Code : "+destinationCode);
		
	}
	
	
	
	
	
	
	
}