package ua.lviv.lgs;

import java.util.Scanner;

public class ApplicationMinimum {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Enter delay(ms) MyThread: ");
		Scanner sc = new Scanner(System.in);
		int delay1 = sc.nextInt();

		System.out.println("Enter count of numbers (MyThread): ");
		Scanner sc2 = new Scanner(System.in);
		int countOfNums1 = sc2.nextInt();

		Thread t = new MyThread(delay1, countOfNums1);

		t.run();

		System.out.println();
		t.join();

		System.out.println("Enter delay(ms) Runnable Thread: ");
		Scanner sc3 = new Scanner(System.in);
		int delay = sc3.nextInt();

		System.out.println("Enter count of numbers (Runnable Thread): ");
		Scanner sc4 = new Scanner(System.in);
		int countOfNums = sc4.nextInt();

		RunnableThread r = new RunnableThread(delay, countOfNums);

		r.run();

		System.out.println();

		r.t.join();
		sc.close();
		sc2.close();
		sc3.close();
		sc4.close();
	}
}

class MyThread extends Thread {
	int delay;
	int countOfNums;

	public MyThread(int delay, int countOfNums) {
		this.delay = delay;
		this.countOfNums = countOfNums;
	}

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
				MyThread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class RunnableThread implements Runnable {
	int delay;
	int countOfNums;
	Thread t = new Thread();

	public RunnableThread(int delay, int countOfNums) {
		this.delay = delay;
		this.countOfNums = countOfNums;
		this.t = new Thread(this);
	}

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
}
