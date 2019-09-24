package CPU;

import java.util.ArrayList;

import Memory.Memory;
import WorkFlow.Constants;

public class CU{//This class is for CU which is coordinating the communication between CPU and Memory
	// it facilitates fetching and executing the instructions from Memory
	//CU class should have function getCurrentMemory() which will check the current memory assigned
	Memory memory;
	public CU() {
		this.memory = new ArrayList<Integer>(Constants.MEMORY_WORDS);
		for (int i = 0; i < Constants.MEMORY_WORDS; i++) {
			this.memory.add(0);
		}
		System.out.println("CU initiated with a size of " + this.memory.size());
	}
	public String getValue(int address){
		return ;
	}
}
