package src;
import java.util.*;
public class Queues {
	public static void main(String[] args) {
		
		Queue<Integer> q1=new LinkedList<>();
		
		q1.add(4);
		q1.add(5);
		q1.add(8);
		q1.offer(9);
		System.out.println(q1.peek());
		q1.poll();
		
		System.out.println(q1.peek());
		System.out.println(q1.poll());
		
		q1.poll();
		System.out.println(q1.peek());
		System.out.println("************************************************************************");
		
		
//		************************************PriorityQueue***********************************************
		PriorityQueue<Integer> qp=new PriorityQueue<>();
		qp.add(5);
//		qp.add(null);  Doesnt Allow Null
		qp.add(6);
		qp.add(6);
		qp.offer(4);
		qp.add(9);
		qp.poll();
		System.out.println(qp.peek());
		qp.remove();
		System.out.println(qp.peek());
		qp.remove();
		System.out.println(qp.element());
	}

}
