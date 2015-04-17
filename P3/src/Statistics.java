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
	public long totalCpuTime = 0;
    public long cpuProcessing = 0;
    public long cpuWaiting = 0;
    public long totalTime = 0;
	public long largestMemoryQueue = 0;
	public long avgMemoryQueue = 0;
	public long largestCpuQueue=0;
	public long avgCpuQueue=0;
	public long largestIoQueue=0;
	public long avgIoQueue=0;
	public long avgTimeInSystem=0;
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
        System.out.println("Average throughput (processes per second):                        "+avgThroughput0);

        System.out.println();
        //TODO: add correct fields/values
        System.out.println(" Total CPU time spent processing:                                 "+cpuProcessing);
        System.out.println(" Fraction of CPU time spent processing:                           "+(cpuProcessing / totalTime));
        System.out.println(" Total CPU time spent waiting:                                    "+cpuWaiting);
        System.out.println(" Fraction of CPU time spent waiting:                              "+(cpuWaiting / totalTime));

        System.out.println();

        System.out.println("Largest occuring memory queue length:                             "+memoryQueueLargestLength);
		System.out.println("Average memory queue length:                                      "+(float)memoryQueueLengthTime/simulationLength);
		if(nofCompletedProcesses > 0) {
			System.out.println("Average # of times a process has been placed in memory queue: "+1);
			System.out.println("Average time spent waiting for memory per process:            "+
				totalTimeSpentWaitingForMemory/nofCompletedProcesses+" ms");
		}
        System.out.println("Largest occuring cpu queue length:                                ");
        System.out.println("Average cpu queue length:                                         ");
        System.out.println("Largest occuring I/O queue length:                                ");
        System.out.println("Average I/O queue length:                                         ");

        System.out.println();

        System.out.println("Average time spent in system per process:                         ");
        System.out.println("Average time spent waiting for memory per process:                ");
        System.out.println("Average time spent waiting for cpu per process:                   ");
        System.out.println("Average time spent processing per process:                        ");
        System.out.println("Average time spent waiting for I/O per process:                   ");
        System.out.println("Average time spent in I/O per process:\n                          ");








    }
}
