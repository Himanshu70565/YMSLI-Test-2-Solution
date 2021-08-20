package test.thread.solution;

class Job implements Runnable {
	private int number;

	public Job() {
	}

	@Override
	public void run() {

		System.out.println("start : " + Thread.currentThread().getName());
		try {
			int randomNumber = (int) (Math.random() * 10 + 1);
			Thread.sleep(1000);
			this.number = randomNumber;
			System.out.println(Thread.currentThread().getName() + " ,number :  " + number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end : " + Thread.currentThread().getName());
	}

	public int getNumber() {
		return number;
	}
}

public class SumCalculationUsingMain {
	public static void main(String[] args) {
		Job job1 = new Job();
		Job job2 = new Job();
		Job job3 = new Job();
		Job job4 = new Job();
		Job job5 = new Job();

		Job jobArray[] = { job1, job2, job3, job4, job5 };

		Thread thread1 = new Thread(job1, "thread1");
		Thread thread2 = new Thread(job2, "thread2");
		Thread thread3 = new Thread(job3, "thread3");
		Thread thread4 = new Thread(job4, "thread4");
		Thread thread5 = new Thread(job5, "thread5");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();

		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int totalSum = 0;
		for (Job job : jobArray) {
			totalSum += job.getNumber();
		}

		System.out.println("***Total sum is : " + totalSum + " *****");
		System.out.println("currentThread: " + Thread.currentThread().getName());
	}
}
