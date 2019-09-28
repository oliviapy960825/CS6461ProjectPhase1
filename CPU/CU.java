package CPU;

import java.util.ArrayList;

import Memory.Memory;
import WorkFlow.Constants;

public class CU{//This class is for CU which is coordinating the communication between CPU and Memory
	// it facilitates fetching and executing the instructions from Memory
	//CU class should have function getCurrentMemory() which will check the current memory assigned
	Memory memory;
	int x1;
	int x2;
	int x3;
	public CU() {
		this.memory = new ArrayList<Integer>(Constants.MEMORY_WORDS);
		for (int i = 0; i < Constants.MEMORY_WORDS; i++) {
			this.memory.add(0);
		}
		System.out.println("CU initiated with a size of " + this.memory.size());
	}
	public int fetchFromMemory(int address){
		try{
		return this.memory.getValue(address);
		}
		catch(Exception e){
		System.out.println("this memory does not exist");
		}
		return -999;
	}
	public int getCurrentMemory() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void storeInMemory(int address, int value){
		
	}
}
