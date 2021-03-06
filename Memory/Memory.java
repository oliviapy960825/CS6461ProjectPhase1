package Memory;

import CPUAttributes.CU;
import FrontPanel.UserInterface;
import InstructionProcessing.MachineFaultException;
public class Memory {
	//private static UserInterface userInterface;
	private static int memory[] = new int[2048];
	//private static int extendedMemory[] = new int[4096];
	private static CU cu;
	private MachineFaultException IllegalMemoryToReservedLocation=MachineFaultException.IllegalMemoryToReservedLocation;
	private MachineFaultException IllegalOperationCode=MachineFaultException.IllegalOperationCode;
	private MachineFaultException IllegalTrapCode=MachineFaultException.IllegalTrapCode;
	private MachineFaultException IllegalMemoryAddressBeyondMemorySize=MachineFaultException.IllegalMemoryAddressBeyondMemorySize;
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
			System.out.println("Now the value at memory address: "+ address+" is: "+ value);
		}
		else if(Memory.memory.length<address){
			System.out.println(IllegalMemoryAddressBeyondMemorySize.getMessage());
			System.out.println(Integer.parseInt(IllegalMemoryAddressBeyondMemorySize.getMFR(),2));
			System.out.println();
			cu.setMFRValue(Integer.parseInt(IllegalMemoryAddressBeyondMemorySize.getMFR(),2));
			cu.storeIntoMemory(4, Integer.parseInt(IllegalMemoryAddressBeyondMemorySize.getMFR(),2));
			cu.fetchFromMemory(1);
		}
	}
}
