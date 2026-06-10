package src;
import java.util.*;
public class HospitalManagement {
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		ArrayList<Patient> patientList=new ArrayList<>();
		int patientID=100;
		
		boolean running =true;
		while(running) {
		System.out.println("********Welcome To Hospital**********");
		System.out.println("1. Admit Patient ");
		System.out.println("2. Display All Patient");
		System.out.println("3. Search Patient By ID");
		System.out.println("4. Update patient Detail");
		System.out.println("5. Discharge Patient");
		System.out.println("6. Generate Patient Bill");
		System.out.println("7. Display Total Hospital Billing");
		System.out.println("8. Exit");
		int choice=sc.nextInt();
		
		switch(choice) {
//		Admit Patient
		case 1:
			
			patientID++;

			
			System.out.println("Enter Patient Name : ");
			sc.nextLine();
			String patientName=sc.nextLine();
			
			System.out.println("Enter Patient Age :  ");
			int patientAge=sc.nextInt();
			System.out.println("Enter Patient Diagnosis");
			sc.nextLine();
			String patientDisease=sc.nextLine();
			
			System.out.println("Enter Doctor Assigned : ");
			String doctorAssigned=sc.nextLine();
			System.out.println("Enter Room Charge Per Day : ");
			double roomChargePerDay=sc.nextDouble();
			System.out.println("Enter Number Of Days Admitted : ");
			int noOfDaysAdmit=sc.nextInt();
			
			patientList.add(new Patient( patientID,patientName,patientAge,patientDisease,doctorAssigned,roomChargePerDay,noOfDaysAdmit));
			
			
			
			
			break;
			
			
		case 2 : 
//			
			System.out.println("Patient Name "+"Age"+"Disease"+"Doctor Assigned"+"Room charge"+"Days Admitted");
			for(Patient p1 : patientList) {
				System.out.println((p1.patientId)+" "+(p1.patientName)+" "+(p1.age)+" "+(p1.disease)+" "+(p1.doctorAssigned)+" "+(p1.roomChargePerDay)+" "+(p1.noOfDaysAdmit));
			}
			

			
			
			
			break;
			
//			Search By Id
		case 3 : 
			System.out.println("Enter Patient Id : ");
			int patid=sc.nextInt();
			
			for(Patient found : patientList) {

			if(patid==(found.patientId)) {
				System.out.println((found.patientId)+" "+(found.patientName)+" "+(found.age)+" "+(found.disease)+" "+(found.doctorAssigned)+" "+(found.roomChargePerDay)+" "+(found.noOfDaysAdmit));
				break;
			}
			else{
			System.out.println("Patient Not Found !!!!");	
			}
			}
			
			break;
			
//			Update Patient details 
		case 4 :
			System.out.println("Enter Patient Id : ");
			int uppatid=sc.nextInt();
			
			for(Patient found : patientList) {

			if(uppatid==(found.patientId)) {
				System.out.println((found.patientId)+" "+(found.patientName)+" "+(found.age)+" "+(found.disease)+" "+(found.doctorAssigned)+" "+(found.roomChargePerDay)+" "+(found.noOfDaysAdmit));
				
                 patientID=found.patientId;
                 patientName=found.patientName;
                 patientAge=found.age;
                 roomChargePerDay=found.roomChargePerDay;
				System.out.println("Enter New Patient Diagnosis");
				sc.nextLine();
				String upatientDisease=sc.nextLine();
				
				System.out.println("Enter New  Doctor Assigned : ");
				String udoctorAssigned=sc.nextLine();
				
				System.out.println("Enter Updated Number Of Days Admitted : ");
				int unoOfDaysAdmit=sc.nextInt();
				patientList.set(1,new Patient(upatientDisease,udoctorAssigned,unoOfDaysAdmit));
              System.out.println("Update Detail Successfully ");
              
				
			}
			else{
			System.out.println("Patient Not Found !!!!");	
			}
			}
			
			break;
		case 5 :
			System.out.println("Enter Patient Id : ");
			int rpatid=sc.nextInt();
			
			for(Patient found : patientList) {

			if(rpatid==(found.patientId)) {
				System.out.println((found.patientId)+" "+(found.patientName)+" "+(found.age)+" "+(found.disease)+" "+(found.doctorAssigned)+" "+(found.roomChargePerDay)+" "+(found.noOfDaysAdmit));
				patientList.remove(found);
				System.out.println("Patient Discharged ");
				break;
			}
			else{
			System.out.println("Patient Not Found !!!!");	
			}
			}
			break;
		case 6 :
			System.out.println("Enter Patient Id : ");
			int billpatid=sc.nextInt();
			
			for(Patient found : patientList) {

			if(billpatid==(found.patientId)) {
				System.out.println((found.patientId)+" "+(found.patientName)+" "+(found.age)+" "+(found.disease)+" "+(found.doctorAssigned)+" "+(found.roomChargePerDay)+" "+(found.noOfDaysAdmit));
				double totalbill=(found.roomChargePerDay)*(found.noOfDaysAdmit);
				System.out.println("Total Bill : "+totalbill);
				break;
			}
			else{
			System.out.println("Patient Not Found !!!!");	
			}
			}
			
			
			break;
		case 7 : 
			double	hospitalBill=0;
			System.out.println("Total Hospital Bill : ");
			for(Patient bill : patientList) {
			
			double	patientbill=bill.noOfDaysAdmit*bill.noOfDaysAdmit;
			hospitalBill=hospitalBill+patientbill;
			}
			System.out.println("Bill  :"+hospitalBill);
			
			
			
			break;
			
		case 8 :
			running=false;
			break;
		default : 
				System.out.println("Invalid Input!!!!!!!");
		}
		
	}
		sc.close();
	}
}

class Patient {
	 int patientId;
	String patientName;
	int age;
	String disease;
	String doctorAssigned;
	double roomChargePerDay;
	int noOfDaysAdmit;

	public Patient(int patientId,String patientName, int age, String disease, String doctorAssigned,
			double roomChargePerDay, int noOfDaysAdmit) {
		
		this.patientId=patientId;
		this.patientName = patientName;
		this.age = age;
		this.disease = disease;
		this.doctorAssigned = doctorAssigned;
		this.roomChargePerDay = roomChargePerDay;
		this.noOfDaysAdmit = noOfDaysAdmit;
	}
	public Patient (String disease, String doctorAssigned, int noOfDaysAdmit) {
	this.disease = disease;
	this.doctorAssigned = doctorAssigned;
	this.noOfDaysAdmit = noOfDaysAdmit;
	}

}