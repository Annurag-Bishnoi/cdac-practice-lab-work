package base;
import java.util.*;
 abstract class Payment{
	abstract void pay(int price);
}
 class UPIpayment extends Payment{
	 void pay(int price) {
		 System.out.println("Payment Done Using UPI => "+price);
	 }
 }
 class CardPayment extends Payment{
	 void pay(int price) {
		 System.out.println("Payment Done Using Card => "+price);
	 }
 }
 class CashPayment extends Payment{
	 void pay(int price) {
		 System.out.println("Payment Done Using Cash => "+price);
	 }
 }
 class OrderService{
	    void placeOrder(Payment payment, int price) {
	        System.out.println("Order started");

	        payment.pay(price);

	        System.out.println("Order completed");
	        System.out.println("----------------------");
	    }

 }
public class OopsAbstInter {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Select a method To Payment : ");
	System.out.println("1. UPI");
	System.out.println("2. Card Payment");
	System.out.println("3. Cash Payment");
	int method=sc.nextInt();
	System.out.println("Enter Amount to Pay :");
	int price = sc.nextInt();
	Payment payment =null;
	switch(method) {
	case 1 : 
		 payment=new UPIpayment();
		
		break;
	case 2 :
		payment =new CardPayment();
		
		break;
	case 3 : 
		payment =new CashPayment();
		
		break;
	default : 
		System.out.println("Invalid Input!!!");
	}
	if(payment!=null) {
	OrderService orderservice=new OrderService();
	orderservice.placeOrder(payment,price);
	}
}
}
