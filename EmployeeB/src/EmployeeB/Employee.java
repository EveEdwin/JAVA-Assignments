package EmployeeB;
import java.util.*;
class Driver{
	String Emp_name, Address, MailID , mobile_no ;
	double Basicpay, DA , HRA ,PF , SCF ;
	int emp_id ;
	public static int count = 0;

	boolean mail() {
		return MailID.endsWith("@gmail.com");
	}
	boolean mob_no() {
		return (mobile_no.length() == 10 && mobile_no.charAt(0) != '0');
	}
	public void getData() {
		Scanner sc = new Scanner( System.in );
		System.out.println("Enter your name :- ");
		Emp_name = sc.next();
		System.out.println("Enter your Address :- ");
		Address = sc.next();
		System.out.println("Enter your Employee ID :- ");
		emp_id = sc.nextInt();
		do {
			System.out.println( "Enter your Email id ");
			MailID = sc.next();
			if( mail() ) break;
			else {
				System.out.println("Please enter valid email id , RETRY !!!");
			}
		}while(true);
		
		do {
			System.out.println( "Enter Mobile Number ");
			mobile_no = sc.next();
			if( mob_no() ) break;
			else {
				System.out.println("Please enter valid mobile number , RETRY !!!");
			}
		}while(true);
	}
	double gross;
	double net;
	void gross(double Basicpay) {
		this.Basicpay = Basicpay;
		DA = 0.97 * Basicpay;
		HRA = 0.10 * Basicpay;
		PF = 0.12 * Basicpay;
		SCF = 0.001 * Basicpay;
		gross = Basicpay + DA + HRA + PF + SCF;
		net = Basicpay + DA + HRA - PF + SCF;
	}
	void getSalary() {
		System.out.println("Your Basic Pay is:-" + Emp_name );
		System.out.println("Your Basic Pay is:-" + Basicpay);
		System.out.println("Your DA is:-" + DA);
		System.out.println("Your HRA is:-" + HRA);
		System.out.println("Your PF is:-" + PF);
		System.out.println("Your SCF is:-"+ SCF);
		System.out.println("Your Gross salary  is:-" + gross);
		System.out.println("Your Net Salary is:-" + net);
	}
}
class Programmer extends Driver{
	public static int count = 0;
	double basic_pay;
	Scanner sc = new Scanner(System.in);
	double getPay() {
		System.out.println("Enter the basic pay of the programmer");
		basic_pay = sc.nextDouble();
		return basic_pay;
	}
}
class Teamlead extends Driver{
	public static int count = 0;
	double basic_pay;
	Scanner sc = new Scanner(System.in);
	double getPay() {
		System.out.println("Enter the basic pay of the Team Lead");
		basic_pay = sc.nextDouble();
		return basic_pay;
	}
}
class AssistantProject extends Driver{
	public static int count = 0;
	double basic_pay;
	Scanner sc = new Scanner(System.in);
	double getPay() {
		System.out.println("Enter the basic pay of the Assistant project manager");
		basic_pay = sc.nextDouble();
		return basic_pay;
	}
}
class ProjectManager extends Driver{
	public static int count = 0;
	double basic_pay;
	Scanner sc = new Scanner(System.in);
	double getPay() {
		System.out.println("Enter the basic pay of the ProjectManager");
		basic_pay = sc.nextDouble();
		return basic_pay;
	}
}
public class Employee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		int n;
		System.out.println("Enter the no. of employee you want to print = ");
		n = sc.nextInt();
		Programmer p[] = new Programmer[n];
		Teamlead t[] = new Teamlead[n];
		AssistantProject a[] = new AssistantProject[n];
		ProjectManager m[] = new ProjectManager[n];
		do {
			System.out.println("1.Display the salary of the Programmer");
			System.out.println("2.Display the salary of the Team lead");
			System.out.println("3.Display the salary of the Assistant Project Manager");
			System.out.println("4.Display the salary of the Project Manager");
			System.out.println("5.Exit");
			choice = sc.nextInt();
			switch( choice ) {
			case 1:
				int n1;
				System.out.println("Enter the number of Programmer data you want to feed=");
				n1 = sc.nextInt();
				n1 = n1 + Programmer.count;
				for( int i = Programmer.count ;i < n1 ; i++ ) {
					p[i] = new Programmer();
					p[i].getData();
					double basic1 = p[i].getPay();
					p[i].gross(basic1);
					Driver.count++;
					Programmer.count++;
				}
				for( int i = 0 ; i < n1 ; i++ ) {
					System.out.println("*PAY SLIP");
					p[i].getSalary();
				}
				n--;
				break;
			case 2:
				int n2;
				System.out.println("Enter the number of team lead data you want to feed=");
				n2 = sc.nextInt();
				n2 = n2 + Teamlead.count;
				for( int i = Teamlead.count ;i < n2 ; i++ ) {
					t[i] = new Teamlead();
					t[i].getData();
					double basic1 = t[i].getPay();
					t[i].gross(basic1);
					Driver.count++;
					Teamlead.count++;
				}
				for( int i = 0 ; i < n2 ; i++ ) {
					System.out.println("*PAY SLIP");
					t[i].getSalary();
				}
				n--;
				break;
			case 3:
				int n3;
				System.out.println("Enter the number of Assistant Project Manager data you want to feed=");
				n3 = sc.nextInt();
				n3 = n3 + AssistantProject.count;
				for( int i = AssistantProject.count ;i < n3 ; i++ ) {
					a[i] = new AssistantProject();
					a[i].getData();
					double basic1 = a[i].getPay();
					a[i].gross(basic1);
					Driver.count++;
					AssistantProject.count++;
				}
				for( int i = 0 ; i < n3 ; i++ ) {
					System.out.println("*PAY SLIP");
					a[i].getSalary();
				}
				n--;
				break;
			case 4:
				int n4;
				System.out.println("Enter the number of Project Manager data you want to feed=");
				n4 = sc.nextInt();
				n4 = n4 + ProjectManager.count;
				for( int i = ProjectManager.count ;i < n4 ; i++ ) {
					m[i] = new ProjectManager();
					m[i].getData();
					double basic1 = m[i].getPay();
					m[i].gross(basic1);
					Driver.count++;
					ProjectManager.count++;
				}
				for( int i = 0 ; i < n4 ; i++ ) {
					System.out.println("*PAY SLIP");
					m[i].getSalary();
				}
				n--;
				break;
			case 5:
				break;
			}
	
		}while(choice!= 5);
		System.out.print("The total no. of employee data feeded" + "=" + Driver.count );
	}

}