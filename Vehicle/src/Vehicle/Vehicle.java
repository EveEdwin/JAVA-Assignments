package Vehicle;

import java.util.Scanner;

interface Vehicles{
	void gearChange( int gear);
	void speedUp( int speed );
	void applyBrakes( int brake );
}

class Car implements Vehicles{
	int gear ;
	int speed ;
	
	Car( int gear , int speed ){
		this.gear = gear;
		this.speed = speed;
	}
	int getSpeed() {
		return speed;
	}
	int getGear() {
		return gear;
	}
	public void gearChange(int check) {
	    int speeds[] = {0, 40, 80, 120, 160, 200};

	    if (check == 1) { 
	        if (this.gear == 5) {
	            System.out.println("Maximum gear reached!!!");
	        } 
	        else {
	            this.gear++;
	        }
	    } 
	    else { 
	        if (this.gear == 0) {
	            System.out.println("Minimum gear reached!!!");
	        } 
	        else {
	            this.gear--;
	        }
	    }
	    speed = speeds[this.gear];
	}

	
	public void speedUp( int increasedSpeed ) {
		int resultingSpeed = increasedSpeed + speed;
		if( resultingSpeed >= 200 ) {
			System.out.println("Maximum Speed Reached");
			speed = 200;
			gear = 5;
		}
		else {
			if( resultingSpeed > 0 && resultingSpeed <= 40 ) {
				speed = resultingSpeed;
				gear = 1;
			}
			else if( resultingSpeed > 40 && resultingSpeed <= 80 ) {
				speed = resultingSpeed;
				gear = 2;
			}
			else if( resultingSpeed > 80 && resultingSpeed <= 120 ) {
				speed = resultingSpeed;
				gear = 3;
			}
			else if( resultingSpeed > 120 && resultingSpeed <= 160 ) {
				speed = resultingSpeed;
				gear = 4;
			}
			else if( resultingSpeed > 160 && resultingSpeed < 200 ) {
				speed = resultingSpeed;
				gear = 5;
			}
		}
	}
	public void applyBrakes( int speedDecrease ) {
		int resultingSpeed = speed - speedDecrease;
		if( resultingSpeed <=0 ) {
			System.out.println("The vehicle is already at rest!!!");
			speed = 0;
			gear = 0;
		}
		else {
			if( resultingSpeed <= 40 ) {
				speed = resultingSpeed;
				gear = 1;
			}
			else if( resultingSpeed > 40 && resultingSpeed <= 80 ) {
				speed = resultingSpeed;
				gear = 2;
			}
			else if( resultingSpeed > 80 && resultingSpeed <= 120 ) {
				speed = resultingSpeed;
				gear = 3;
			}
			else if( resultingSpeed > 120 && resultingSpeed <= 160 ) {
				speed = resultingSpeed;
				gear = 4;
			}
			else if( resultingSpeed > 160 && resultingSpeed < 200 ) {
				speed = resultingSpeed;
				gear = 5;
			}
		}
	}
	
}
class Bike implements Vehicles{
	int gear ;
	int speed ;
	
	Bike( int gear , int speed ){
		this.gear = gear;
		this.speed = speed;
	}
	int getSpeed() {
		return speed;
	}
	int getGear() {
		return gear;
	}
	public void gearChange(int check) {
	    int[] speeds = {0, 30, 60, 90, 120, 150};

	    if (check == 1) {
	        if (this.gear == 5) {
	            System.out.println("Maximum gear reached!!!");
	        } 
	        else {
	            this.gear++;
	        }
	    }
	    else { 
	        if (this.gear == 0) {
	            System.out.println("Minimum gear reached!!!");
	        } 
	        else {
	            this.gear--;
	        }
	    }
	    speed = speeds[this.gear];
	}

	public void speedUp( int increasedSpeed ) {
		int resultingSpeed = increasedSpeed + speed;
		if( resultingSpeed >= 150 ) {
			System.out.println("Maximum Speed Reached");
			speed = 150;
			gear = 5;
		}
		else {
			if( resultingSpeed > 0 && resultingSpeed <= 30 ) {
				speed = resultingSpeed;
				gear = 1;
			}
			else if( resultingSpeed > 30 && resultingSpeed <= 60 ) {
				speed = resultingSpeed;
				gear = 2;
			}
			else if( resultingSpeed > 60 && resultingSpeed <= 90 ) {
				speed = resultingSpeed;
				gear = 3;
			}
			else if( resultingSpeed > 90 && resultingSpeed <= 120 ) {
				speed = resultingSpeed;
				gear = 4;
			}
			else if( resultingSpeed > 120 && resultingSpeed < 150 ) {
				speed = resultingSpeed;
				gear = 5;
			}
		}
	}
	public void applyBrakes( int speedDecrease ) {
		int resultingSpeed = speed - speedDecrease;
		if( resultingSpeed <=0 ) {
			System.out.println("The vehicle is already at rest!!!");
			speed = 0;
			gear = 0;
		}
		else {
			if( resultingSpeed <= 30 ) {
				speed = resultingSpeed;
				gear = 1;
			}
			else if( resultingSpeed > 30 && resultingSpeed <= 60 ) {
				speed = resultingSpeed;
				gear = 2;
			}
			else if( resultingSpeed > 60 && resultingSpeed <= 90 ) {
				speed = resultingSpeed;
				gear = 3;
			}
			else if( resultingSpeed > 90 && resultingSpeed <= 120 ) {
				speed = resultingSpeed;
				gear = 4;
			}
			else if( resultingSpeed > 120 && resultingSpeed < 150 ) {
				speed = resultingSpeed;
				gear = 5;
			}
		}
	}
	
}
class Bicycle implements Vehicles{
	int gear ;
	int speed ;
	
	Bicycle( int gear , int speed ){
		this.gear = gear;
		this.speed = speed;
	}
	int getSpeed() {
		return speed;
	}
	int getGear() {
		return gear;
	}
	public void gearChange(int check) {
	    int[] speeds = {0, 10, 20, 30, 40, 50};

	    if (check == 1) { 
	        if (this.gear == 5) {
	            System.out.println("Maximum gear reached!!!");
	        } 
	        else {
	            this.gear++;
	        }
	    } 
	    else {
	        if (this.gear == 0) {
	            System.out.println("Minimum gear reached!!!");
	        } else {
	            this.gear--;
	        }
	    }
	    speed = speeds[this.gear];
	}

	public void speedUp( int increasedSpeed ) {
		int resultingSpeed = increasedSpeed + speed;
		if( resultingSpeed >= 50 ) {
			System.out.println("Maximum Speed Reached");
			speed = 50;
			gear = 5;
		}
		else {
			if( resultingSpeed > 0 && resultingSpeed <= 10 ) {
				speed = resultingSpeed;
				gear = 1;
			}
			else if( resultingSpeed > 10 && resultingSpeed <= 20 ) {
				speed = resultingSpeed;
				gear = 2;
			}
			else if( resultingSpeed > 20 && resultingSpeed <= 30 ) {
				speed = resultingSpeed;
				gear = 3;
			}
			else if( resultingSpeed > 30 && resultingSpeed <= 40 ) {
				speed = resultingSpeed;
				gear = 4;
			}
			else if( resultingSpeed > 40 && resultingSpeed < 50 ) {
				speed = resultingSpeed;
				gear = 5;
			}
		}
	}
	public void applyBrakes( int speedDecrease ) {
		int resultingSpeed = speed - speedDecrease;
		if( resultingSpeed <=0 ) {
			System.out.println("The vehicle is already at rest!!!");
			speed = 0;
			gear = 0;
		}
		else {
			if( resultingSpeed <= 10 ) {
				speed = resultingSpeed;
				gear = 1;
			}
			else if( resultingSpeed > 10 && resultingSpeed <= 20 ) {
				speed = resultingSpeed;
				gear = 2;
			}
			else if( resultingSpeed > 20 && resultingSpeed <= 30 ) {
				speed = resultingSpeed;
				gear = 3;
			}
			else if( resultingSpeed > 30 && resultingSpeed <= 40 ) {
				speed = resultingSpeed;
				gear = 4;
			}
			else if( resultingSpeed > 40 && resultingSpeed < 50 ) {
				speed = resultingSpeed;
				gear = 5;
			}
		}
	}
	
}

public class Vehicle {

	public static void main(String[] args) {
		int choice;
		Scanner sc = new Scanner( System.in );
		do {
			System.out.println("Choose Vehicle !!!");
			System.out.println("1.Bike");
			System.out.println("2.Bicycle");
			System.out.println("3.Car");
			System.out.println("0.Exit");
			choice = sc.nextInt();
			switch( choice ) {
			case 1:
				int n1;
				Bike b = new Bike(0 , 0);
				do {
					System.out.println("Choose the operation to perform!!!");
					System.out.println("1.Increase Speed");
					System.out.println("2.Apply Brakes");
					System.out.println("3.Gear UP");
					System.out.println("4.Gear Down");
					System.out.println("5.Display Status");
					System.out.println("0.Exit");
					n1 = sc.nextInt();
					
					switch( n1 ) {
					case 1:
						System.out.println("By how much you want to increase the speed : ");
						int speed = sc.nextInt();
						b.speedUp( speed );
						System.out.println("Speed : " + b.getSpeed() + " gear : "+ b.getGear() );
						break;
					case 2:
						if( b.getSpeed() == 0 ) {
							System.out.println("The bike is already at rest!!!!!");
						}
						else {
							System.out.println("By how much you want to decrease the speed: ");
							int brake = sc.nextInt();
							b.applyBrakes( brake );
							System.out.println("Speed : " + b.getSpeed() +  " gear : "+ b.getGear() );
						}
						break;
					case 3:
						if( b.getGear() == 5 ) {
							System.out.println("Already at max gear : " + b.getGear() );
						}
						else {
							b.gearChange(1);							
							System.out.println("Speed :" + b.getSpeed() + " gear :" + b.getGear()); 
						}
						break;
					case 4:
						if( b.getGear() == 0) {
							System.out.println("Already at min gear : " + b.getGear() );
						}
						else {
							b.gearChange(0);							
							System.out.println("Speed :" + b.getSpeed() + " gear :" + b.getGear()); 
						}
						break;
					case 5:
						System.out.println("Speed : " + b.getSpeed() + " gear : "+ b.getGear() );
					case 0:
						break;
					}
				}while( n1 != 0 );
				break;
				
			case 2:
				Bicycle b1 = new Bicycle(0 , 0);
				int n2;
				do {
					System.out.println("Choose the operation to perform!!!");
					System.out.println("1.Increase Speed");
					System.out.println("2.Apply Brakes");
					System.out.println("3.Gear Up");
					System.out.println("4.Gear Down");
					System.out.println("5.Display Status");
					System.out.println("0.Exit");
					n2 = sc.nextInt();
					switch( n2 ) {
					case 1:
						System.out.println("By how much you want to increase the speed : ");
						int speed = sc.nextInt();
						b1.speedUp( speed );
						System.out.println("Speed : " + b1.getSpeed() + " gear : "+ b1.getGear() );
						break;
					case 2:
						if( b1.getSpeed() == 0 ) {
							System.out.println("The bike is already at rest!!!!!");
						}
						else {
							System.out.println("By how much you want to decrease the speed: ");
							int brake = sc.nextInt();
							b1.applyBrakes( brake );
							System.out.println("Speed : " + b1.getSpeed() + " gear : "+ b1.getGear() );
						}
						break;
					case 3:
						if( b1.getGear() == 5 ) {
							System.out.println("Already at max gear : " + b1.getGear() );
						}
						else {
							b1.gearChange(1);							
							System.out.println("Speed :" + b1.getSpeed() + " gear :" + b1.getGear()); 
						}
						break;
					case 4:
						if( b1.getGear() == 0 ) {
							System.out.println("Already at min gear : " + b1.getGear() );
						}
						else {
							b1.gearChange(0);							
							System.out.println("Speed :" + b1.getSpeed() + " gear :" + b1.getGear()); 
						}
						break;
					case 5:
						System.out.println("Speed : " + b1.getSpeed() + " gear : "+ b1.getGear() );
						break;
					case 0:
						break;
					}
				}while( n2 != 0 );
				break;
			case 3:
				Car c= new Car(0 , 0);
				int n3;
				do {
					System.out.println("Choose the operation to perform!!!");
					System.out.println("1.Increase Speed");
					System.out.println("2.Apply Brakes");
					System.out.println("3.Gear UP");
					System.out.println("4.Gear Down");
					System.out.println("5.Display Status");
					System.out.println("0.Exit");
					n3 = sc.nextInt();
					switch( n3 ) {
					case 1:
						System.out.println("By how much you want to increase the speed : ");
						int speed = sc.nextInt();
						c.speedUp( speed );
						System.out.println("Speed : " + c.getSpeed() + "  gear : "+ c.getGear() );
						break;
					case 2:
						if( c.getSpeed() == 0 ) {
							System.out.println("The bike is already at rest!!!!!");
						}
						else {
							System.out.println("By how much you want to decrease the speed: ");
							int brake = sc.nextInt();
							c.applyBrakes( brake );
							System.out.println("Speed : " + c.getSpeed() + " gear : "+ c.getGear() );
						}
						break;
					case 3:
						if( c.getGear() == 5 ) {
							System.out.println("Already at max gear : " + c.getGear() );
						}
						else {
							c.gearChange(1);							
							System.out.println("Speed :" + c.getSpeed() + " gear :" + c.getGear()); 
						}
						break;
					case 4:
						if( c.getGear() == 0 ) {
							System.out.println("Already at min gear : " + c.getGear() );
						}
						else {
							c.gearChange(0);							
							System.out.println("Speed :" + c.getSpeed() + " gear :" + c.getGear()); 
						}
						break;
					case 5:
						System.out.println("Speed : " + c.getSpeed() + " gear : "+ c.getGear() );
					case 0:
						break;
					}
				}while( n3 != 0 );
			case 0:
				break;
			}
		}while( choice != 0) ;
		System.out.println("Program executed successfully!!!");
	}

}