package Employee;
import java.util.Scanner;

public class Employee {
    int EmpID;
    String EmpName;
    String EmpEmail;
    String EmpAddress;
    String EmpNo;
    int EmpSal;
    int EmpDA;
    int EmpHRA;
    int EmpPF;
    int EmpStaffClubFund;
    int NetSal;

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        EmpID = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Employee Name: ");
        EmpName = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        EmpSal = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Employee Email: ");
        EmpEmail = sc.nextLine();
        if (EmpEmail.contains(EmpAddress)) {
        	System.out.println("")
        }
        System.out.print("Enter Employee Address: ");
        EmpAddress = sc.nextLine();
        System.out.print("Enter Employee Number: ");
        EmpNo = sc.next();
    }

    int calculateGross() {
        EmpDA = (int)(0.97 * EmpSal);
        EmpHRA = (int)(0.10 * EmpSal);
        EmpPF = (int)(0.12 * EmpSal);
        EmpStaffClubFund = (int)(0.001 * EmpSal);
        int gross = EmpSal + EmpDA + EmpHRA;
        return gross;
    }

    int calculateNet(int gross) {
        NetSal = gross - EmpPF - EmpStaffClubFund;
        return NetSal;
    }
    void get_basicpay() {}
    
    public class Programmer extends Employee{
    	int basic;
    	void get_basicpay{
    }

    public static void main(String[] args) {
        Employee E1 = new Employee();
        E1.input();
        int gross = E1.calculateGross();
        int net = E1.calculateNet(gross);
        
        
        System.out.println("Employee Details:");
        System.out.println("ID: " + E1.EmpID);
        System.out.println("Name: " + E1.EmpName);
        System.out.println("Email: " + E1.EmpEmail);
        System.out.println("Address: " + E1.EmpAddress);
        System.out.println("Number: " + E1.EmpNo);
        System.out.println("Salary: " + E1.EmpSal);
        System.out.println("DA: " + E1.EmpDA);
        System.out.println("HRA: " + E1.EmpHRA);
        System.out.println("PF: " + E1.EmpPF);
        System.out.println("Staff Club Fund: " + E1.EmpStaffClubFund);
        System.out.println("Gross Salary: " + gross);
        System.out.println("Net Salary: " + net);
    }
}


