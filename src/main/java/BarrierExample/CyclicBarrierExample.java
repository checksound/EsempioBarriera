package BarrierExample;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample{

	private int results[];

	public static void main(String args[]){

		int matrix[][] = 
			{ 
				{ 1 }, 
				{ 2, 2 }, 
				{ 3, 3, 3 },
				{ 4, 4, 4, 4 }, 
				{ 5, 5, 5, 5, 5 } };

		int [] results = new int[matrix.length];
		Runnable merger = new Merger(results);

		/*
		 * public CyclicBarrier(int parties,Runnable barrierAction)
		 * Creates a new CyclicBarrier that will trip when the given number
		 * of parties (threads) are waiting upon it, and which will execute 
		 * the merger task when the barrier is tripped, performed 
		 * by the last thread entering the barrier.
		 */
		CyclicBarrier barrier = new CyclicBarrier(matrix.length, merger);
		
		for (int i = 0; i < matrix.length; i++){
			Summer s = new Summer(barrier, i, matrix[i], results);
			s.start();
		}
		
	}
}