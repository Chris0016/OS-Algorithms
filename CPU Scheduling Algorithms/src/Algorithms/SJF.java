package Algorithms;
import main.ProcessList;
import main.Process;

public class SJF extends SchedulingAlgorithm implements Scheduler {
	
	
	public SJF(ProcessList pList, boolean isPreEmptive) {
		super(pList, isPreEmptive);
		
	}

	@Override
	public void runAlgo() {
		Process[] holder = super.pList.sortByBurstTime();
		super.garnettTable = new Process[super.pList.getTotalBurstSize()];
		int j, count;
		j = count = 0;
		
		
		for(int i = 0; i < super.garnettTable.length; i+= j) {
			
			for(j = 0; j < holder[count].burstTime; j++) {
				
				super.garnettTable[i + j] = holder[count];
				//System.out.println("At " + (i + j) + " adding " + holder[count].name);
				
			}
			
			count++;
		}
	}
}
	
