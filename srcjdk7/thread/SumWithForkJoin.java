package thread;

import java.util.concurrent.RecursiveTask;

public class SumWithForkJoin extends RecursiveTask<Long> {
	static final int SEQUENTIAL_THRESHOLD = 10;

	int low;
	int high;
	int[] array;

	SumWithForkJoin(int[] arr, int lo, int hi) {
		array = arr;
		low = lo;
		high = hi;
	}

	protected Long compute() {
		if (high - low <= SEQUENTIAL_THRESHOLD) {
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
		} else {
			int mid = low + (high - low) / 2;
			SumWithForkJoin left = new SumWithForkJoin(array, low, mid);
			SumWithForkJoin right = new SumWithForkJoin(array, mid, high);
			left.fork();
			long rightAns = right.compute();
			long leftAns = left.join();
			return leftAns + rightAns;
		}
	}

	static long sumArray(int[] array) {
		long totalSum=0;
		long startTime=System.currentTimeMillis();
		totalSum=Globals.fjPool.invoke(new SumWithForkJoin(array, 0, array.length));
		long endTime=System.currentTimeMillis();
		System.out.println("Total sum is   " + (totalSum) );
		System.out.println("Total time taken is  " + (endTime-startTime) );
		return totalSum;

	}

	public static void main(String[] args) {
		int[] inputs = { 30, 35, 26, 24, 89, 44, 55, 88, 99, 21, 36, 56, 45, 55, 88, 96, 52, 34, 68, 789, 5682, 1235, 4568, 4123, 15236 };
		SumWithForkJoin.sumArray(inputs);

	}
}
