/**
 * Provides the Job ADT for representing times of different jobs
 * 
 * @file Job.java
 * @author Yaminah Qureshi
 * @version 1
 * @date 02/19/2018
 */
package sort;

/**
 * implements an abstract data type representing different jobs and their execution times using Comparable
 */
public class Job implements Comparable<Job>{
	private final String jobID;
	private int executionTime;
	
	/**
	 * Job ADT constructor
	 * initializes the values of the job's ID and execution time
	 * 
	 * @param theJobID the ID of the job
	 * @param theExecutionTime the processing time of the job
	 * @throws IllegalArgumentException if the value of the execution time is negative
	 */
	Job(String theJobID, int theExecutionTime){
		if (theExecutionTime < 0)
			throw new IllegalArgumentException();
		this.jobID = theJobID;
		this.executionTime = theExecutionTime;
	}
	
	/**
	 * executionTime getter 
	 * retrieves the value of the job's execution time
	 * 
	 * @return the execution time of the job
	 */
	public int getExecutionTime(){
		return this.executionTime;
	}
	
	/**
	 * executionTime setter
	 * modifies the value of the job's execution time
	 * 
	 * @param theExecutionTime the new execution time of the job
	 * @throws IllegalArgumentException if the value of the execution time is negative
	 */
	public void setExecutionTime(int theExecutionTime){
		if (theExecutionTime < 0)
			throw new IllegalArgumentException();
		this.executionTime = theExecutionTime;
	}

	/**
	 * jobID getter 
	 * retrieves the value of the job's ID
	 * 
	 * @return the ID of the job
	 */
	public String getJobID(){
		return this.jobID;
	}
	
	/**
	 * Formats job ID and execution time as string
	 * 
	 * @return the formatted jobID followed by the execution time
	 */
	public String toString() {
		return String.format("%s %d", this.jobID, this.executionTime);
	}
	
	/**
	 * compares two Jobs to determine their order
	 * determines a value based on whether the job is smaller, equal or larger than a passed job
	 * 
	 * @return a value representing the order relation of the job to a passed job
	 */
	public int compareTo(Job that)
	{
		if (this.executionTime < that.executionTime)
			return -1; //This job is less than passed job based on execution time
		if (this.executionTime > that.executionTime)
			return 1; //This job is greater than passed job based on execution time
		//job execution times are equal
		if (this.executionTime == that.executionTime && this.getJobID().compareTo(that.getJobID()) < 0)
			return -1; //This job is lexographically smaller than passed job based on job ID
		if (this.executionTime == that.executionTime && this.getJobID().compareTo(that.getJobID()) > 0)
			return 1; //This job is lexographically larger than passed job based on job ID
		return 0;
	}
}
