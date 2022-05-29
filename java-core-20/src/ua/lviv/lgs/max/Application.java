package ua.lviv.lgs.max;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
	public static void main(String[] args) throws InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.execute(new Runnable() {

			Scanner sc = new Scanner(System.in);  			// Enter delay
			Scanner sc2 = new Scanner(System.in);			// Enter count of numbers	

			int delay = sc.nextInt();
			int countOfNums = sc2.nextInt();

			@Override
			public void run() {

				int fib[] = new int[countOfNums];
				if (countOfNums >= 0)
					fib[0] = 0;
				if (countOfNums >= 1)
					fib[1] = 1;
				for (int i = 2; i < countOfNums; i++)
					fib[i] = fib[i - 1] + fib[i - 2];
				for (int i = countOfNums - 1; i >= 0; i--) {
					System.out.print(fib[i] + " ");

					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		executor.shutdown();
		

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.execute(new Runnable() {
			Scanner sc1 = new Scanner(System.in);  		// Enter delay
			Scanner sc2 = new Scanner(System.in);       // Enter count of numbers	

			int delay = sc1.nextInt();
			int countOfNums = sc2.nextInt();

			@Override
			public void run() {

				int num1 = 1;
				int num0 = 1;
				int num2;

				for (int i = 0; i < countOfNums; i++) {
					num2 = num0 + num1;
					System.out.print(num2 + " ");
					num0 = num1;
					num1 = num2;

					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});

		executorService.shutdown();

	}
}