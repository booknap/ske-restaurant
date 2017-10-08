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
	static int quantity = 0;
	static String[] menu = { "Pizza", "Spaghetti", "Chicken", "Coke" };
	static int[] productPrice = { 250, 150, 120, 45 };
	static int[] bankAndCoin = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };
	static int[] totalQuantity = new int[menu.length];
	static int[] price = new int[menu.length];
	
	public static void printChange(int cha) {
		System.out.printf("\nYour change is %d Baht.\n", cha);
		System.out.print("+----------------------+------+\n");
		System.out.print("| Banknotes or coins   | Qty  |\n");
		System.out.print("+----------------------+------+\n");
		calculateChange(cha);
		System.out.print("+----------------------+------+\n");
	}

	public static void calculateChange(int ch) {
		for (int j = 0; j < bankAndCoin.length; j++) {
			if (ch / bankAndCoin[j] != 0) {
				System.out.printf("| %-4d Baht banknotes  |%5d |\n", bankAndCoin[j], ch / bankAndCoin[j]);
			}
			ch = ch % bankAndCoin[j];
		}
	}

	public static int calculateTotalPrice() {
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
		System.out.printf("|%-28s|%11d|\n", " Total", calculateTotalPrice());
		System.out.print("+------------------+---------+-----------+\n");
	}

	public static void getPrice(int c) {
		quantity = sc.nextInt();
		totalQuantity[c - 1] += quantity;
		price[c - 1] = totalQuantity[c - 1] * productPrice[c - 1];
	}
	
	public static void printMenu(){
		System.out.print("--- Welcome to SKE Restaurant ---\n");
		for (int x = 0; x < menu.length; x++) {
			System.out.printf("%d.) %s\t\t%d Baht.\n", x + 1, menu[x], productPrice[x]);
		}

		System.out.printf("%d.) Total\n%d.) Exit\n", menu.length + 1, menu.length + 2);
	}
	
	public static void selectMenu(){
		int choice = 0;
		while (true) {
			System.out.print("\nEnter your Choice: ");
			choice = sc.nextInt();
			if (choice == menu.length + 2) {
				System.out.print("\nInput your Cash: ");
				int cash = sc.nextInt();
				int change = cash - calculateTotalPrice();
				if (change < 0) {
					System.out.print("Not enough cash.");
					break;
				} else {
					printChange(change);
				}
				System.out.print("\n========== Thank you ==========");
				break;
			} else if (choice == menu.length + 1) {
				createTable();
			} else if (choice >= 1 && choice<=menu.length) {
				System.out.print("Enter quantity: ");
				getPrice(choice);
			}
		}
	}

	public static void main(String[] args) {
		printMenu();
		selectMenu();
	}

}
