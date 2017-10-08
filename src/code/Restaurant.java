package code;

import java.util.Scanner;

/**
 * Main class for SKE Restaurant order taking application. It displays a menu
 * and accepts items to order. When done, it prints a receipt including the
 * order total.
 *
 * @author Napasai Sutthichutipong
 */

public class Restaurant {

	public static Scanner sc = new Scanner(System.in);

	public static int calculateTotalPrice(){
		int totalPrice = 0;
		for (int i = 0; i < menu.length; i++) {
			totalPrice += price[i];
		}
		
		return totalPrice;
	}
	
	public static void createTable() {
		System.out.print("+------ Menu ------+-- Qty --+-- Price --+\n");
		for (int i = 0; i < menu.length; i++) {
			if (totalQuantity[i] != 0) {
				System.out.printf("| %-17s|%9d|%11d|\n", menu[i], totalQuantity[i], price[i]);
			}
		}
		
		System.out.print("+------------------+---------+-----------+\n");
		System.out.printf("|%-28s|%11d|\n", " Total", calculateTotalPrice() );
		System.out.print("+------------------+---------+-----------+\n");
	}
	
	static int quantity = 0;
	static String[] menu = { "Pizza", "Chicken", "Coke" };
	static int[] productPrice = { 250, 120, 45 };
	static int[] totalQuantity = new int[menu.length];
	static int[] price = new int[menu.length];

	public static void getPrice(int c) {
		quantity = sc.nextInt();
		totalQuantity[c - 1] += quantity;
		price[c - 1] = totalQuantity[c - 1] * productPrice[c - 1];
	}

	public static void main(String[] args) {
		System.out.print("--------- Welcome to SKE Restaurant ---------\n");
		for (int x = 0; x < menu.length; x++) {
			System.out.printf("%d.) %s\t\t%d Baht.\n", x + 1, menu[x], productPrice[x]);
		}
		
		System.out.printf("4.) Total\n5.) Exit\n");
		
		int choice = 0;

		while (true) {
			System.out.print("\nEnter your Choice: ");
			choice = sc.nextInt();
			if (choice == 5) {
				System.out.print("\n========== Thank you ==========");
				break;
			}
			else if (choice == 4) {
				createTable();
			}
			else if (choice == 1||choice == 2||choice == 3) {
				System.out.print("Enter quantity: ");
				getPrice(choice);
			}
		}
	}

}
