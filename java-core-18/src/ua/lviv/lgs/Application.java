package ua.lviv.lgs;

import java.util.Scanner;

public class Application {
	public static void menu() {
		System.out.println("Enter 1 to add new object to map");
		System.out.println("Enter 2 to remove object from map by key");
		System.out.println("Enter 3 to remove object from map by value");
		System.out.println("Enter 4 to show set of keys");
		System.out.println("Enter 5 to show list of values");
		System.out.println("Enter 6 to show map");
		System.out.println("Enter 0 to exit");
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Enter capacity of map: ");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int capacity = scanner.nextInt();

		Map<Integer, String> m = new Map<Integer, String>(capacity);

		while (true) {
			menu();
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();

			switch (input) {
			case 1: {
				System.out.println("Enter a key to put in map: ");
				Scanner key = new Scanner(System.in);
				int k = key.nextInt();
				System.out.println("Done!");
				System.out.println("Enter a value to put in map: ");
				Scanner value = new Scanner(System.in);
				String v = value.next();
				m.put(k, v);
				break;
			}

			case 2: {
				System.out.println("Enter a key to remove");
				Scanner sc2 = new Scanner(System.in);
				int key = sc2.nextInt();
				m.removeByKey(key);
				break;
			}

			case 3: {
				System.out.println("Enter a value to remove");
				Scanner scValue = new Scanner(System.in);
				String value = scValue.next();
				m.removeByValue(value);
				break;
			}

			case 4: {
				m.showSetOfKeys();
				break;
			}

			case 5: {
				m.showListOfValues();
				break;
			}

			case 6: {
				m.show();
				break;
			}

			case 0: {
				System.exit(1);
			}

			}
		}
	}
}
