package code;

import java.util.Random;

import java.util.Scanner;

public class restaurant {
	
	public static void change(int x){
		
		System.out.printf("\nYour change is %d Baht.\n", x);
		System.out.print("+----------------------+------+\n");
		System.out.print("| Banknotes or coins   | Qty  |\n");
		System.out.print("+----------------------+------+\n");
		if (x / 1000 != 0)
			System.out.printf("| 1000 Baht banknotes  |%5d |\n", x / 1000);
		x = x % 1000;
		if (x / 500 != 0)
			System.out.printf("| 500  Baht banknotes  |%5d |\n", x / 500);
		x = x % 500;
		if (x / 100 != 0)
			System.out.printf("| 100  Baht banknotes  |%5d |\n", x / 100);
		x = x % 100;
		if (x / 50 != 0)
			System.out.printf("| 50   Baht banknotes  |%5d |\n", x / 50);
		x = x % 50;
		if (x / 20 != 0)
			System.out.printf("| 20   Baht banknotes  |%5d |\n", x / 20);
		x = x % 20;
		if (x / 10 != 0)
			System.out.printf("| 10   Baht coins      |%5d |\n", x / 10);
		x = x % 10;
		if (x / 5 != 0)
			System.out.printf("| 5    Baht coins      |%5d |\n", x / 5);
		x = x % 5;
		if (x / 2 != 0)
			System.out.printf("| 2    Baht coins      |%5d |\n", x / 2);
		x = x % 2;
		if (x / 1 != 0)
			System.out.printf("| 1    Baht coins      |%5d |\n", x / 1);
		System.out.print("+----------------------+------+\n");
		
	}
	
	public static void table(int t1 , int t2 , int t3 , int p1 , int p2 , int p3){
		
		System.out.print("+------ Menu ------+-- Qty --+-- Price --+\n");
		if (t1 != 0) {
			System.out.printf("| Pizza            |%9d|%11d|\n", t1, p1);
		}
		if (t2 != 0) {
			System.out.printf("| Chickens         |%9d|%11d|\n", t2, p2);
		}
		if (t3 != 0) {
			System.out.printf("| Coke             |%9d|%11d|\n", t3, p3);
		}
		System.out.print("+------------------+---------+-----------+\n");
		System.out.printf("| Total                      |%11d|\n",p1 + p2 + p3);
		System.out.print("+------------------+---------+-----------+");
		
	}
	
	public static void coupon(){
		Random ran = new Random();
		int r = ran.nextInt(10)+1;
		if(r==1||r==2||r==3||r==4||r==5)System.out.println("You receive 5% discount coupon.");
		else if(r==6||r==7||r==8)System.out.println("You receive 10% discount coupon");
		else if(r==9||r==10)System.out.println("You receive 20% discount coupon.");
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print(
				"--------- Welcome to SKE Restaurant ---------\n1.) Pizza\t\t250 Baht.\n2.) Chicken\t\t120 Baht.\n3.) Coke\t\t45 Baht.\n4.) Total\n5.) Exit\n");
		int c = 0, q1 = 0, q2 = 0, q3 = 0;
		int t1 = 0, t2 = 0, t3 = 0;
		int p1 = 0, p2 = 0, p3 = 0;

		while (true) {

			System.out.print("\nEnter your Choice: ");
			c = sc.nextInt();
			if (c == 5) {
				System.out.print("\nInput your Cash: ");
				int cash = sc.nextInt();
				int x = cash - (p1 + p2 + p3);
				if (x < 0) {
					System.out.print("Not enough cash.");
					break;
				} else {
					change(x);
				}
				coupon();
				System.out.print("\n========== Thank you ==========");
				break;
			}
			if (c == 1) {
				System.out.print("Enter quantity: ");
				q1 = sc.nextInt();
				t1 += q1;
				p1 = t1*250;
			}
			if (c == 2) {
				System.out.print("Enter quantity: ");
				q2 = sc.nextInt();
				t2 += q2;
				p2 = t2*120;
			}
			if (c == 3) {
				System.out.print("Enter quantity: ");
				q3 = sc.nextInt();
				t3 += q3;
				p3 = t3*45;
			}
			if (c == 4) {
				table(t1 , t2 , t3 , p1 , p2 , p3);
			}

		}

	}
}

