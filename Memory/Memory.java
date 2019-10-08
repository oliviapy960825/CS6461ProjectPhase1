package Memory;

public class Memory {
	private static int memory[] = new int[2048];
	//private static int extendedMemory[] = new int[4096];
	public Memory(){
		this.memory=new int[2048];
		
	}
	public void expandMemorySize() {
		if (this.memory.length > 0) {
			this.memory=new int[4096];
		}
		
		System.out.println("memory size has been expanded to " + memory.length);
	}
	public int getCurrentMemorySize() {
		if (this.memory.length>0) {
			return this.memory.length;
		}
		return 0;
	}
	public int fetchFromMemory(int address) {
		return this.memory[address];
	}
	public void storeIntoMemory(int address, int value) {
		if (this.memory.length>0) {
			this.memory[address]=value;
		}
	}
}
