package Memory;

import CPUAttributes.CU;
import FrontPanel.UserInterface;
import InstructionProcessing.MachineFaultException;
public class Memory {
	//private static UserInterface userInterface;
	private static int memory[] = new int[2048];
	//private static int extendedMemory[] = new int[4096];
	private static CU cu;
	private MachineFaultException MFE;
	public Memory(){
		Memory.memory=new int[2048];
	}
	public void setCU(CU cu){
		Memory.cu=cu;
	}
	public void expandMemorySize() {
		if (Memory.memory.length > 0) {
			Memory.memory=new int[4096];
		}
		//ADD NEW CODE HERE MOVING CONTENT FROM THE ORIGINAL ARRAY AFTER EXPANDING TO 4096 
		System.out.println("memory size has been expanded to " + memory.length);
	}
	public int getCurrentMemorySize() {
		if (Memory.memory.length>0) {
			return Memory.memory.length;
		}
		return 0;
	}
	public int fetchFromMemory(int address) {
		return Memory.memory[address];
	}
	public void storeIntoMemory(int address, int value) {
		if (Memory.memory.length>0 && Memory.memory.length>address) {
			Memory.memory[address]=value;
		}
		else if(Memory.memory.length<address){
			System.out.println(MFE.IllegalMemoryAddressBeyondMemorySize.getMessage());
			cu.setMFRValue(Integer.parseInt(MFE.IllegalMemoryAddressBeyondMemorySize.getMFR(),2));
			cu.storeIntoMemory(4, Integer.parseInt(MFE.IllegalMemoryAddressBeyondMemorySize.getMFR(),2));
			cu.fetchFromMemory(1);
		}
	}
}
