package main;

public class Process {
	public int arrivalTime;
	public int burstTime;
	public int priority;
	public int name;
	
	public Process(int name, int burstTime) {
		this.name = name;
		this.burstTime = burstTime;
		this.arrivalTime = 0;
		this.priority = 0;
	}
	
	public Process(int name, int burstTime, int arrivalTime, int priority) {
		this.name = name;
		this.burstTime = burstTime;
		this.arrivalTime = arrivalTime;
		this.priority= priority; 
	}
	
	
}
