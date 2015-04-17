/**
 * This class contains a lot of public variables that can be updated
 * by other classes during a simulation, to collect information about
 * the run.
 */
public class Statistics
{
	/** The number of processes that have exited the system */
	public long nofCompletedProcesses = 0;
	/** The number of processes that have entered the system */
	public long nofCreatedProcesses = 0;
	/** The total time that all completed processes have spent waiting for memory */
	public long totalTimeSpentWaitingForMemory = 0;
	/** The time-weighted length of the memory queue, divide this number by the total time to get average queue length */
	public long memoryQueueLengthTime = 0;
	/** The largest memory queue length that has occured */
	public long memoryQueueLargestLength = 0;

	public long processSwitches = 0;
	public long processIO = 0;

    public long totalTimeSpentWaitingForIO = 0;
    public long totalTimeSpentWaitingForCpu = 0;

    public long totalIoTime = 0; // DONE
	public long totalCpuTime = 0;//DONE
	public long totalSystemTime = totalCpuTime + totalIoTime + totalTimeSpentWaitingForMemory + totalTimeSpentWaitingForCpu + totalTimeSpentWaitingForIO;
	public long largestMemoryQueue = 0;//DONE
	public long largestCpuQueue=0; //DONE
	public long largestIoQueue=0; //DONE



	public long totCpuQueue=0;
	public long numAddedCpuQueue=0;

	public long totIoQueue=0;
	public long numAddedIoQueue=0;

	public long avgTimeWaitForMemory=0;

	public long avgTimeWaitForCpu=0;

	public long avgTimePerProcess=0;

	public long avgTimeWaitForIO=0;

	public long avgTimeInIo=0;



	/**
	 * Prints out a report summarizing all collected data about the simulation.
	 * @param simulationLength	The number of milliseconds that the simulation covered.
	 */
	public void printReport(long simulationLength) {
		System.out.println();
		System.out.println("Simulation statistics:");
		System.out.println();
		System.out.println("Number of completed processes:                                    "+nofCompletedProcesses);
		System.out.println("Number of created processes:                                      "+nofCreatedProcesses);
        System.out.println("Number of (forced) process switches:                              "+processSwitches);
        System.out.println("Number of processed I/O operations:                               "+processIO);
        //regn ut
        System.out.println("Average throughput (processes per second):                        "+(float)(nofCompletedProcesses / simulationLength));

        System.out.println();
        //TODO: add correct fields/values
        System.out.println(" Total CPU time spent processing:                                 "+totalCpuTime);
        System.out.println(" Fraction of CPU time spent processing:                           "+(float)(totalCpuTime / simulationLength));
        System.out.println(" Total CPU time spent waiting:                                    "+(simulationLength - totalCpuTime));
        System.out.println(" Fraction of CPU time spent waiting:                              "+(float)((simulationLength - totalCpuTime) / simulationLength));

        System.out.println();

        System.out.println("Largest occuring memory queue length:                             "+memoryQueueLargestLength);
		System.out.println("Average memory queue length:                                      "+(float)memoryQueueLengthTime/simulationLength);
		if(nofCompletedProcesses > 0) {
			System.out.println("Average # of times a process has been placed in memory queue: "+1);
			System.out.println("Average time spent waiting for memory per process:            "+
                    (float)totalTimeSpentWaitingForMemory/nofCompletedProcesses+" ms");
		}
        System.out.println("Largest occuring cpu queue length:                                "+largestCpuQueue);
        System.out.println("Average cpu queue length:                                         ");
        System.out.println("Largest occuring I/O queue length:                                "+largestIoQueue);
        System.out.println("Average I/O queue length:                                         ");

        System.out.println();

        System.out.println("Average time spent in system per process:                         "+(float)(totalSystemTime / nofCompletedProcesses));
        System.out.println("Average time spent waiting for memory per process:                "+(float)(totalTimeSpentWaitingForMemory / nofCompletedProcesses));
        System.out.println("Average time spent waiting for cpu per process:                   "+(float)(totalTimeSpentWaitingForCpu / nofCompletedProcesses));
        System.out.println("Average time spent processing per process:                        "+(float)(totalCpuTime / nofCompletedProcesses));
        System.out.println("Average time spent waiting for I/O per process:                   "+(float)(totalTimeSpentWaitingForIO / nofCompletedProcesses));
        System.out.println("Average time spent in I/O per process:                            "+(float)(totalIoTime / nofCompletedProcesses));








    }
}
