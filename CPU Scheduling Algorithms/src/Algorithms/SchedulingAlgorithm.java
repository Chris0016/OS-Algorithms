package Algorithms;

import main.Process;
import main.ProcessList;

public class SchedulingAlgorithm implements Scheduler {

	ProcessList pList;
	Process[] garnettTable;

	
	int avgWaitTime;
	int avgCompletionTime;
	boolean isPreEmptive;
	
	
	public SchedulingAlgorithm(ProcessList pList, boolean isPreEmptive) {
		this.pList = pList;
		this.isPreEmptive = isPreEmptive;
	}
	
	
	
	public void calcAvgWaitTime() {
		int currWait = 0;
		Process[] pHolder = pList.getProcessList();
		
		for(Process p : pHolder) {
			currWait += findFirstOccurrence(p) - p.arrivalTime;
		}
		
		this.avgWaitTime = (currWait / pList.getSize());
		
	}
	
	public void calcAvgCompletionTime() {
		int currWait = 0;
		Process[] pHolder = pList.getProcessList();
		
		for(Process p : pHolder) {
			currWait += findLastOccurrence(p) - p.arrivalTime;
		}
		
		this.avgWaitTime = (currWait / pList.getSize());
	}
	
	public int findFirstOccurrence(Process ps) {
		int count = 0;
		for(Process p : this.garnettTable) {
			if (p.equals(ps))
				return count;
			count++;
		}
		return -1;
	}
	
	public int findLastOccurrence(Process ps) {
		int idx = -1;
		int size =  this.garnettTable.length;
		
		for(int i = 0; i < size; i++) {
			if(garnettTable[i].equals(ps))
				idx = i;
		}
		
		return idx;
	}
	
	public  void printGarnettTable() {
		int size = garnettTable.length;
		for(int i = 0; i < size; i++) {
			System.out.println( i + " : " + garnettTable[i].name);
		}
	}
	 
	 public void printProcessList() {
		 System.out.println("Process   |  Burst Size | Arrival Time | Priority ");
		 for(Process p : garnettTable) {
			 System.out.println("   " + p.name 
					 + " | " + p.burstTime 
					 + " | " + p.arrivalTime
					 + " | " + p.priority
					 + "\n");
			 
		 }
	 }



	@Override
	public void runAlgo() {
		// TODO Auto-generated method stub
		
	}
}
