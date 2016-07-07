package thread;

import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<Long> {

	int low;
	int high;
	int[] array;

	Sum(int[] arr, int lo, int hi) {
		array = arr;
		low = lo;
		high = hi;
	}

	protected Long compute() {
			long sum = 0;
			for (int i = low; i < high; ++i) {
				sum += array[i];
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			return sum;
	}

	static long sumArray(int[] array) {
		long totalSum=0;
		long startTime=System.currentTimeMillis();
		Sum sum = (new Sum(array, 0, array.length));
		totalSum= sum.compute();
		long endTime=System.currentTimeMillis();
		System.out.println("Total sum is   " + (totalSum) );
		System.out.println("Total time taken is  " + (endTime-startTime) );
		return totalSum;

	}

	public static void main(String[] args) {
		int[] inputs = { 30, 35, 26, 24, 89, 44, 55, 88, 99, 21, 36, 56, 45, 55, 88, 96, 52, 34, 68, 789, 5682, 1235, 4568, 4123, 15236 };
		Sum.sumArray(inputs);

	}
}
