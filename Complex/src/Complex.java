
import java.util.*;

public class Complex {
	float real, imag;

	Complex(){
		real=0;
		imag=0;
	}
	public void input(){
		Scanner sc = new Scanner(System.in);
		real = sc.nextInt();
		imag = sc.nextInt();
	}
	
	Complex add(Complex c1, Complex c2) {
		Complex c3 = new Complex();
		c3.real = c1.real + c2.real;
		c3.imag = c1.imag + c2.imag;
		return c3;
	}
	Complex subtract(Complex c1, Complex c2) {
		Complex c3 = new Complex();
		c3.real = c1.real - c2.real;
		c3.imag = c1.imag - c2.imag;
		return c3;
	}
	Complex multiply(Complex c1, Complex c2) {
		Complex c3 = new Complex();
		c3.real = (c1.real*c2.real) - (c1.imag*c2.imag);
		c3.imag = (c1.real*c2.imag) + (c1.imag*c2.real);
		return c3;
	}
	Complex division(Complex c1, Complex c2) {
		Complex c3 =new Complex();
		if(c2.real==0 && c2.imag == 0) {
			System.out.println("Division by zero is not possible");
			return c3;
		}
		else {
			c3.real = ((c1.real*c2.real)+(c1.imag*c2.imag))/((c2.real*c2.real)+(c2.imag*c2.imag));
			c3.imag = (c1.real*c2.imag) - (c1.imag*c2.real)/((c2.real*c2.real)+(c2.imag*c2.imag));
			return c3;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Complex c1 = new Complex();
		Complex c2 = new Complex();
		Complex c3 = new Complex();
		int op = 0;
		do {
			
			System.out.println("Enter your choice");
			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("0. Exit");

			op = sc.nextInt();
			switch(op) {
			case 0:
				System.out.println("Thank You For Using, See You Next Time!!");
				break;
			case 1:
				System.out.println("Enter first complex number");
				c1.input();
				System.out.println("Enter second complex number");
				c2.input();
				c3 = c3.add(c1,c2);
				System.out.print("Addition of " + c1.real + "+" + c1.imag + "i" + " and " + c2.real + "+" + c2.imag + "i" +" is ");
				System.out.println(c3.real + " + " + c3.imag + "i" );
				break;
				
			case 2:
				System.out.println("Enter first complex number");
				c1.input();
				System.out.println("Enter second complex number");
				c2.input();
				c3=c3.subtract(c1,c2);
				System.out.print("Subtraction of " + c1.real + "+" + c1.imag + "i" + " and " + c2.real + "+" + c2.imag + "i" +" is ");
				System.out.println(c3.real + " + " + "("+ c3.imag + "i" + ")" );
				
				break;
			
			case 3:
				System.out.println("Enter first complex number");
				c1.input();
				System.out.println("Enter second complex number");
				c2.input();
				c3 = c3.multiply(c1,c2);
				System.out.print("Multiplication of " + c1.real + "+" + c1.imag + "i" + " and " + c2.real + "+" + c2.imag + "i" +" is ");
				System.out.println(c3.real + " + " + c3.imag + "i" );
				
				break;
				
			case 4:
				System.out.println("Enter first complex number");
				c1.input();
				System.out.println("Enter second complex number");
				c2.input();
				c3 = c3.division(c1,c2);
				System.out.print("Division of " + c1.real + "+" + c1.imag + "i" + " and " + c2.real + "+" + c2.imag + "i" +" is ");
				System.out.println(c3.real + " + " + c3.imag + "i" );
				
				break;
			}	
			
			
		} while(op!=0);
		sc.close();
	}
	
}