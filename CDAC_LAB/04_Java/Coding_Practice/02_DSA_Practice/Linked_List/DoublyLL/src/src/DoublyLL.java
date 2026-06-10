package src;

import java.util.Scanner;
class Node {
	int data;
	Node next;
	Node prev;
	Node(int data){
		this.data=data;
		this.next=null;
		this.prev=null;
	}
}

public class DoublyLL {
	
	static Node head=null;
	
	static void insertAtStart(int data) {
		Node newnode=new Node(data);

		if(head!=null) {
			head.prev=newnode;
		}
		newnode.next=head;
		newnode.prev=null;
		head=newnode;
	}
	
	private static void insertAtEnd(int data) {
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
		newnode.prev=temp;
		
	}
	
	private static void insertAtPos(int data, int pos) {
		Node newnode=new Node(data);
		if(head==null) {
			System.out.println("List Is Empty");
			return;
		}
		if(pos<=0) {
			System.out.println("Invalid Input");
			return;
		}
		if(pos==1) {
			insertAtStart(data);
			return ;
		}
		Node temp=head;
		for(int i=0;i<pos-1 && temp!=null;i++) {
			temp=temp.next;
		}
		if(temp==null) {
			System.out.println("Out of Range");
			return;
		}
		if(temp.next==null) {
			insertAtEnd(data);
			return;
		}
		newnode.prev=temp;
		newnode.next=temp.next;
		temp.next.prev=newnode;
		temp.next=newnode;
		
		
	}
	
	private static void delFromStart() {
		
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		if(head.next==null) {
			head=null;
			System.out.println("Deleted Successfull");
			return;
			
		}
		
		head=head.next;
		head.prev=null;
		
	}

	private static void delFromEnd() {
		
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		if(head.next==null) {
			head=null;
			System.out.println("Deleted Successfull");
			return;
			
		}
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
			
		}
		temp.prev.next=null;
		
		
	}
	private static void delFromPos(int dpos) {
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		if(dpos<=0) {
			System.out.println("Invalid Input");
			return;
		}
	if(dpos==1) {
		delFromStart();
		return;
	}
	
	Node temp=head;
	for(int i=0;i<dpos && temp!=null;i++) {
		temp=temp.next;
	}
	if(temp==null) {
		System.out.println("Out Of Range");
		return;
	}
	if(temp.next==null) {
		delFromEnd();
		return;
	}
	
	temp.prev.next=temp.next;
	temp.next.prev=temp.prev;
	
	}



	private static void delByValue(int value) {
		
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		if(head.data==value) {
			head=head.next;
			if(head!=null) {
			head.prev=null;
			}
			return;
		}
		Node temp=head;
		while(temp!=null&& temp.data!=value) {
			temp=temp.next;
		}
		if(temp==null) {
			System.out.println("Not Found Value!!!");
			return;
		}
		
		temp.prev.next=temp.next;
		temp.next.prev=temp.prev;
		
		
		
		
	}

	private static void display() {
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

	private static void searching(int value) {
		int count =1;
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		if(head.data==value) {
			System.out.println("Found Value at stating index"+count);
			return;
		}
		Node temp=head;
		while(temp!=null&& temp.data!=value) {
			temp=temp.next;
			count ++;
		}
		if(temp==null) {
			System.out.println("Not Found");
			return;
		}
		
		else {
			System.out.println("Found At Index"+count);
		}
	}

	
	private static void reverse() {
		if (head == null) {
	        System.out.println("List is Empty, cannot reverse.");
	        return;
	    }

		Node temp = null;
	    Node current = head;

	    while (current != null) {
	        // Swap pointers
	        temp = current.prev;
	        current.prev = current.next;
	        current.next = temp;

	        current = current.prev;
	    }

	    if (temp != null) {
	        head = temp.prev; // The old tail is now the new head
	    }
	    System.out.println("List Reversed Successfully!");
	    
	}
	

	

	public static void main(String[] args) {
		
		Scanner sc= new Scanner (System.in);
		int data;
		boolean x= true;
		while(x) {
			System.out.println("==================================Doubly Linked List ================================");
			System.out.println("1. Insert at begning");
			System.out.println("2. Insert at end");
			System.out.println("3. Insert at  position");
			System.out.println("4. Delete from Begning");
			System.out.println("5. Delete From End");
			System.out.println("6. Delete From Position");
			System.out.println("7.Delete By Value");
			System.out.println("8. Search a Key");
			System.out.println("9. Display Doubly Linked List ");
			System.out.println("10. Reverse");
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
				System.out.println("Enter Value to Delete :");
				int value =sc.nextInt();
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
