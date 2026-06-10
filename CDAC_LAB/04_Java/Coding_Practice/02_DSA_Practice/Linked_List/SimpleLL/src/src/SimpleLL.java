package src;
import java.util.Scanner;

class Node{
	int data;
	Node next ;
	Node(int data){
		this.data=data;
		this.next=null;
	}
}
public class SimpleLL {
	
	
	static Node head=null;
	
	static void insertAtStart(int data) {
		Node newnode=new Node(data);
		if(head==null) {
			head=newnode;
			return;
		}
		newnode.next=head;
		head=newnode;
		
	}
	
	static void insertAtEnd(int data) {
		Node newnode=new Node(data);
		if(head==null) {
			head=newnode;
			return;
		}
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newnode;
		
	}
	
	static void insertAtPos(int data,int pos) {
		Node newnode=new Node(data);
		if(head==null) {
			System.out.println("Array Is Empty");
			return;
		}
		if(pos<=0) {
			System.out.println("Invalid Input");
			return;
		}
		if(pos==1) {
			insertAtStart(data);
			return;
		}
		Node temp=head;
		for(int i=1;i<pos-1&&temp!=null;i++) {
			temp=temp.next;
		}
		if(temp==null) {
			System.out.println("Out of Range Position");
			return;
		}
		if(temp.next==null) {
			insertAtEnd(data);
			return;
		}
		newnode.next=temp.next;
		temp.next=newnode;
		
	}
	static void delFromStart() {
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		head=head.next;
	}
	static void delFromEnd() {
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		if(head.next==null) {
			head=null;
			return;
		}
		Node temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		temp.next=null;
		

	}
	
	static void delFromPos(int pos) {
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		if(pos<=0) {
			System.out.println("Invalid Position");
			return;
		}
		if(pos==1) {
			delFromStart();
			return;
		}
		Node temp=head;
		for(int i=1;i<pos-1&&temp!=null;i++) {
			temp=temp.next;
		}
		if(temp==null) {
			System.out.println("Out Of Range");
			return;
		}
		temp.next=temp.next.next;
	}
	
	
	static void delByValue(int value) {
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		if(head.data==value) {
			delFromStart();
			return;
		}
		Node temp=head;
		while(temp.next!=null&&temp.next.data!=value) {
			temp=temp.next;
		}
		if(temp.next==null) {
			System.out.println("Not Found");
			return;
		}
	temp.next=	temp.next.next;
		
		
	}
	
	
	
	static void searching(int value) {
		int count=1;
		if(head==null) {
			System.out.println("List is Empty....");
			return;
		}
		if(head.data==value) {
			System.out.println("Found Value At Starting "+ count);
			return;
		}
		
		Node temp=head;
		while(temp!=null) {
			if(temp.data==value) {
				System.out.println("Found Vlaue At Index "+ count);
				return;
				
			}
			temp=temp.next;
			count++;
		}
		
		System.out.println("Value Not Found in LinkedList");
		
		
		
		
	}
	static void display() {
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		Node temp=head;
		System.out.print("[");
		while(temp!=null) {
			System.out.print(" "+temp.data+" => ");
			temp=temp.next;
		}
		System.out.println("null ]");
	}
	
	
	
	public static void reverse() {
     
		Node curr=head;
		Node next=null;
		Node prev=null;
		
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			
			prev=curr;
			curr=next;
		}
		
		head=prev;
		System.out.println("Linked List Reveresed Successfully");
		
		
    }
	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		int data;
		boolean x= true;
		while(x) {
			System.out.println("==================================Linked List ================================");
			System.out.println("1. Insert at begning");
			System.out.println("2. Insert at end");
			System.out.println("3. Insert at  position");
			System.out.println("4. Delete from Begning");
			System.out.println("5. Delete From End");
			System.out.println("6. Delete From Position");
			System.out.println("7. Delete By Value");
			System.out.println("8. Search a Key");
			System.out.println("9. Display Linked List ");
			System.out.println("10. Reverse Linked List");
			System.out.println("11. Exit");
			int choice=	sc.nextInt();
			
			
			switch (choice) {
			case 1 :
				System.out.println("Enter The Value : ");
				data =sc.nextInt();
				insertAtStart(data);
				display();
				break;
			case 2 :
				System.out.println("Enter The Value : ");
				data =sc.nextInt();
				insertAtEnd(data);
					display();
				break;
			case 3 :
				System.out.println("Enter Position : ");
				int pos =sc.nextInt();
				System.out.println("Enter The Value : ");
				data =sc.nextInt();
				insertAtPos(data,pos);
				display();
				break;
				
			case 4 :
				delFromStart();
				display();
				break;
			case 5 :
				delFromEnd();
				display();
				break;
			case 6 :
				System.out.println("Enter Position : ");
				int dpos =sc.nextInt();
				delFromPos( dpos);
					display();
				break;
			case 7 :
				System.out.println("Enter Value you Want to Delete");
				int value=sc.nextInt();
				delByValue(value);
				display();
				break;
				
			case 8 :
				System.out.println("Enter Value You Want to Search :");
				int key=sc.nextInt();
				searching(key);
				display();
				break;
			case 9 :
				display();
			
				break;
			case 10:
				reverse();
				display();
				break;
			case 11 :
				x=false;
				System.out.println("Thank You :)");
				break;
				
			}
		}
		
		
	}

}
