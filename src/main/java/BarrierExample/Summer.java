package BarrierExample;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


class Summer extends Thread{

	int row;
	int[] matrixRow;
	int[] results;
	
	CyclicBarrier barrier;

	Summer(CyclicBarrier barrier, int row, int[] matrixRow, int[] results){
		
		this.barrier = barrier;
		this.row = row;
		this.matrixRow = matrixRow;
		this.results = results;
		
	}

	public void run()  {
		
		int columns = matrixRow.length;
		int sum = 0;
		
		for (int i = 0; i < columns; i++){
			sum += matrixRow[i];
		}
		
		//memorizza la somma degli elementi della riga come risultato parziale
		results[row] = sum; 
		
		System.out.println("Result for row " + row + " is : " + sum);
		
		//aspetta gli altri
		try{
			barrier.await();
		} catch (InterruptedException ex){
			ex.printStackTrace();
		} catch (BrokenBarrierException ex){
			ex.printStackTrace();
		}
	}
}