package src;
class Node{
	int data;
	
	Node next;
	Node prev;
	Node(int data){
		this.data=data;
		
		this.next=null;
		this.prev=null;
	}
	
}
public class LL {
	static Node head=null;
	static void insertAtBeg(int data,int pos) {
		Node newnode=new Node(data);
		if(pos==0) {
		if(head==null) {
			head=newnode;
		}else {
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newnode;
		newnode.prev=temp;
		}}
		else {
		if(pos==1) {
			newnode.next=head;
			head=newnode;
			
		}
		Node temp=head;
		for(int i =0;i<pos-1;i++) {
			temp=temp.next;
			
		}
		newnode.next=temp.next;
		temp.next=newnode;
		}
	}
	static void viewLL() {
		Node temp=head;
		while(temp!=null) {
			
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
public static void main(String[] args) {

insertAtBeg(9,1);
viewLL();

}
}
