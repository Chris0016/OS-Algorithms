package main;
import Algorithms.*;


public class Main {

	public static void main(String[] args) {
		
		int[] arrivalTimes =  {1, 4 , 3, 2, 0 };
		int[] burstSizes =     {1, 6, 3, 2, 4 };
		int[] names =          {0, 1, 2, 3, 4 };
		int[] priorities =      {1, 2, 3, 4, 5 };
		int size  = 5;
		
		
		ProcessList pList = new ProcessList( size );
		try {
		
			pList.addProccesses(names, burstSizes, arrivalTimes, priorities);
			//FCFS fifo = new FCFS(pList, false);
			//fifo.runAlgo();
			//fifo.printGarnettTable();
			//fifo.printProcessList();
			
			SJF sjf = new SJF(pList, false);
			sjf.runAlgo();
			sjf.printGarnettTable();
			//sjf.printProcessList();
		
		}catch(Exception e) {
			
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	
	}
}
