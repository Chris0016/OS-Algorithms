package main;
import java.util.ArrayList;


public class ProcessList {
	private Process[]  pList;
	private int totalBurstSize =0;
	
	private int size;
	
	public ProcessList (int size) {
		pList = new Process[size]; 
		this.size = size;
	}
	
	public void addProccesses(int[] names, int[] burstSizes, int[] arrivalTimes, int[] priorities) throws Exception{
		if (names.length != size || burstSizes.length != size || arrivalTimes.length != size || priorities.length != size)
			throw new IllegalArgumentException("Parameters are not of the same length");
		
		for(int i = 0; i < this.size; i++) {
			pList[i] = new Process(
					names[i]
					,burstSizes[i]
					,arrivalTimes[i]
					,priorities[i]
							);
		totalBurstSize += burstSizes[i];
		}
		
		
	}
	
	public int getTotalBurstSize() {
		return this.totalBurstSize;
	}
	
	public Process getProcess(int idx) {
		return this.pList[idx];
	}
	
	
	public Process[] sortByArrivalTime() {
		Process[] temp = this.pList.clone();
		Process smallest;

		System.out.println("Initial List :");
		
		
		for(int i = 0; i < size -1; i++) {
			smallest = temp[i];
			
			for(int j = i + 1 ; j < size; j++) {
				if (smallest.arrivalTime >  temp[j].arrivalTime) {	
					 	swap(temp, i, j);	    
				}
			}
		}
		return temp;
	}
	
	public void printList(Process[] pList) {
		for(Process p : pList)
			System.out.print(p.name + " ");
		System.out.println();
	}
	
	public Process[] sortByBurstTime() {
		Process[] temp = pList.clone();
		
		Process smallest;
		
		for(int i = 0; i < size -1; i++) {
			smallest = temp[i];
			
			for(int j = i + 1 ; j < size; j++) {
				if (smallest.burstTime >  temp[j].burstTime)
					swap(temp, i , j);
			}
		}
		return temp;
		
	}
	
	
	 private void swap(Process[] arr, int i, int j){
	    Process temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	

	
	
	private boolean hasProcess(Process p) {
		for(int i = 0; i < size; i++) {
			if (pList[i].name == p.name)
				return true;
		}
		return false;
		
	}
	
	public int getSize() {
		return this.size;
	}
	public Process[] getProcessList() {
		return this.pList;
	}

}
