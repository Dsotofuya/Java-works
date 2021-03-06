package utilities;

import java.util.ArrayList;

import models.Partition;
import models.Process;

public class Utilities {

    public static String booleanToString(boolean result){
        return (result)? "Si" : "No";
    }

    public static int quitNegativeNumbers(int number){
        return (number < 0) ? 0 : number;
    }
    
    public static boolean exist(String name, ArrayList<Process> list) {
    	for (Process process : list) {
			if (process.getProcessName().equals(name)) {
				return false;
			}
		}
    	return true;
    }
    
    public static boolean existPartition(String name, ArrayList<Partition> list) {
    	for (Partition partition : list) {
			if(partition.getPartitionName().equals(name)) {
				return false;
			}
		}
    	return true;
    }
    
    public static String newPriority(int priority, int newPriority) {
    	return (priority == newPriority)? "No": newPriority + "";
    }
    
    public static int getPartition(String name, ArrayList<Partition> partitions) {
    	for (Partition partition : partitions) {
			if(partition.getPartitionName().equals(name)) {
				return partition.getSize();
			}
		}
    	return 0;
    }
    
    public static Partition searchPartition(String name, ArrayList<Partition> list) {
    	for (Partition partition : list) {
			if(partition.getPartitionName().equalsIgnoreCase(name)) {
				return partition;
			}
		}
    	return null;
    }
    
    public static Process searchProcess(String name, ArrayList<Process> list) {
    	for (Process partition : list) {
			if(partition.getProcessName().equalsIgnoreCase(name)) {
				return partition;
			}
		}
    	return null;
    }
}
