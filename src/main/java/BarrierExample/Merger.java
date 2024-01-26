package BarrierExample;
public class Merger implements Runnable{

	int[] results;

	public Merger (int[] results){
		this.results = results;
	}

	public void run(){

		int sum = 0;

		for (int i = 0; i < results.length; i++){
			sum += results[i];
		}

		System.out.println("Merger completed (sum: " + sum + ")");
	}

}
