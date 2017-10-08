package code;

import java.util.Scanner;

/**
 * Main class for SKE Restaurarnt order taking application.
 * It displays a menu and accepts items to order.
 * When done, it prints a receipt including the order total.
 *
 * @author Napasai Sutthichutipong
 */

public class Restaurant {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void createTable(int total1 , int total2 , int total3 , int price1 , int price2 , int price3){
		
		System.out.print("+------ Menu ------+-- Qty --+-- Price --+\n");
		if (total1 != 0) {
			System.out.printf("| %-17s|%9d|%11d|\n",menu[0], total1, price1);
		}
		if (total2 != 0) {
			System.out.printf("| %-17s|%9d|%11d|\n",menu[1], total2, price2);
		}
		if (total3 != 0) {
			System.out.printf("| %-17s|%9d|%11d|\n",menu[2], total3, price3);
		}
		System.out.print("+------------------+---------+-----------+\n");
		System.out.printf("|%-28s|%11d|\n"," Total",price1 + price2 + price3);
		System.out.print("+------------------+---------+-----------+\n");
		
	}

	public static int quantity = 0;
	public static int[] total = {0,0,0};
	public static int[] price = {0,0,0}; 
	
	static String[] menu = {"Pizza","Chicken","Coke"};
	static int[] productPrice = {250,120,45};
	
	public static void getPrice(int c){
		quantity = sc.nextInt();
		total[c-1] += quantity;
		price[c-1] = total[c-1]*productPrice[c-1];
	}
	
	public static void SKERestaurant() {

		System.out.print("--------- Welcome to SKE Restaurant ---------\n"
				+ "1.) Pizza\t\t250 Baht.\n"
				+ "2.) Chicken\t\t120 Baht.\n"
				+ "3.) Coke\t\t45 Baht.\n"
				+ "4.) Total\n5.) Exit\n");
		
		int choice = 0;
		
		while (true) {

			System.out.print("\nEnter your Choice: ");
			choice = sc.nextInt();
			if (choice == 5) {
				System.out.print("\n========== Thank you ==========");
				break;
			}
			if(choice!=4)System.out.print("Enter quantity: ");
			if (choice == 1) {
				getPrice(choice);
			}
			if (choice == 2) {
				getPrice(choice);
			}
			if (choice == 3) {
				getPrice(choice);
			}
			if (choice == 4) {
				createTable(total[0] , total[1] , total[2] , price[0] , price[1] , price[2]);
			}
		}

	}
	
	public static void main(String[] args) {
		SKERestaurant();
	}
	
}
